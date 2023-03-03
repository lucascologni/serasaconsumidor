package br.com.serasaconsumidor.acceptance.steps.ui;

import br.com.serasaconsumidor.infrastructure.ioc.SpringContextConfiguration;
import br.com.serasaconsumidor.infrastructure.properties.ResourceProperties;
import br.com.serasaconsumidor.infrastructure.webdriver.WebDriverContract;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.spring.CucumberContextConfiguration;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = {SpringContextConfiguration.class})
public class Hooks {

    @Autowired
    @Qualifier("${browser}")
    private WebDriverContract webDriverContract;

    @Autowired
    private ResourceProperties resourceProperties;

    @Before
    public void openWebSite() {
        WebDriver webDriver = webDriverContract.getWebDriver();

        webDriver.manage().window().maximize();
        webDriver.get(resourceProperties.getUrl());
    }

    @After
    public void closeWebSite() {
        webDriverContract.quitWebDriver();
    }
}