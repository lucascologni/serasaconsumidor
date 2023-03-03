package br.com.serasaconsumidor.infrastructure.webdriver;

import br.com.serasaconsumidor.infrastructure.properties.ResourceProperties;
import br.com.serasaconsumidor.infrastructure.properties.SystemArchitecture;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public abstract class WebDriverBase implements WebDriverContract {

    @Autowired
    protected ResourceProperties resourcesProperties;

    protected WebDriverManager webDriverManager;

    protected ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();

    @Override
    public WebDriver getWebDriver() {

        if (null == webDriver.get()) {
            webDriver.set(createWebDriver());
        }

        return webDriver.get();
    }

    @Override
    public boolean is64bitsWebDriver() {
        return SystemArchitecture.is64bits();
    }

    @Override
    public void quitWebDriver() {

        if (null != webDriver.get()) {

            try {
                webDriver.get().quit();
                webDriver.remove();

            } catch (Exception e) {
                System.out.println("Erro ao finalizar webdriver - " + e.getMessage());
            }
        }
    }

    protected WebDriverManager createWebDriverManager(DriverManagerType driverManagerType) {

        if (!is64bitsWebDriver())
            WebDriverManager.getInstance(driverManagerType).arch32().setup();
        else
            WebDriverManager.getInstance(driverManagerType).setup();

        return WebDriverManager.getInstance(driverManagerType);
    }
}