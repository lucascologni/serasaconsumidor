package br.com.serasaconsumidor.infrastructure.webdriver;

import br.com.serasaconsumidor.utils.Constants;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
@Qualifier("firefox")
public class FirefoxWebDriver extends WebDriverBase implements WebDriverContract {

    @Override
    public WebDriver createWebDriver() {

        if (webDriver.get() == null) {

            DriverManagerType driverManagerType = DriverManagerType.valueOf(resourcesProperties.getWebDriverType().toUpperCase());

            webDriverManager = createWebDriverManager(driverManagerType);
            webDriverManager.capabilities(getFirefoxOptions());

            webDriver.set(webDriverManager.create());
        }

        return webDriver.get();
    }

    private FirefoxOptions getFirefoxOptions() {

        FirefoxOptions firefoxOptions = new FirefoxOptions();

        String[] firefoxArguments = Constants.FIREFOX_ARGUMENTS;

        firefoxOptions.setHeadless(resourcesProperties.isHeadless());
        firefoxOptions.addArguments(firefoxArguments);

        return firefoxOptions;
    }
}