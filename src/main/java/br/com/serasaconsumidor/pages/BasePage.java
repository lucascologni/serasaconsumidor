package br.com.serasaconsumidor.pages;

import br.com.serasaconsumidor.infrastructure.webdriver.WebDriverContract;
import br.com.serasaconsumidor.utils.Constants;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.time.Duration;

@Component
@Scope(value = "session")
public abstract class BasePage {

    @Autowired
    @Qualifier("${browser}")
    private WebDriverContract webDriverContract;

    protected void initElements() {
        PageFactory.initElements(webDriverContract.getWebDriver(), this);
    }

    protected void waitElementToBeVisible(WebElement webElement) {
        WebDriverWait wait = new WebDriverWait(webDriverContract.getWebDriver(), Duration.ofSeconds(Constants.SECONDS_TIMEOUT));
        wait.until(ExpectedConditions.visibilityOf(webElement));
    }
}