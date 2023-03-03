package br.com.serasaconsumidor.infrastructure.webdriver;

import br.com.serasaconsumidor.utils.Constants;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
@Qualifier("chrome")
public class ChromeWebDriver extends WebDriverBase implements WebDriverContract {

    @Override
    public WebDriver createWebDriver() {

        if (webDriver.get() == null) {

            DriverManagerType driverManagerType = DriverManagerType.valueOf(resourcesProperties.getWebDriverType().toUpperCase());

            webDriverManager = createWebDriverManager(driverManagerType);
            webDriverManager.capabilities(getChromeOptions());

            webDriver.set(webDriverManager.create());
        }

        return webDriver.get();
    }

    private ChromeOptions getChromeOptions() {

        ChromeOptions chromeOptions = new ChromeOptions();

        String[] chromeArguments = Constants.CHROME_ARGUMENTS;

        chromeOptions.setHeadless(resourcesProperties.isHeadless());
        chromeOptions.addArguments(chromeArguments);

        return chromeOptions;
    }
}