package br.com.serasaconsumidor.infrastructure.webdriver;

import br.com.serasaconsumidor.utils.Constants;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
@Qualifier("edge")
public class EdgeWebDriver extends WebDriverBase implements WebDriverContract {

    @Override
    public WebDriver createWebDriver() {

        if (webDriver.get() == null) {

            DriverManagerType driverManagerType = DriverManagerType.valueOf(resourcesProperties.getWebDriverType().toUpperCase());

            webDriverManager = createWebDriverManager(driverManagerType);
            webDriverManager.capabilities(getEdgeOptions());

            webDriver.set(webDriverManager.create());
        }

        return webDriver.get();
    }

    private EdgeOptions getEdgeOptions() {

        EdgeOptions edgeOptions = new EdgeOptions();

        String[] edgeArguments = Constants.EDGE_ARGUMENTS;

        edgeOptions.setHeadless(resourcesProperties.isHeadless());
        edgeOptions.addArguments(edgeArguments);

        return edgeOptions;
    }
}