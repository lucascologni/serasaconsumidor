package br.com.serasaconsumidor.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@Scope(value = "session")
public class HomePage extends BasePage {

    @FindBy(css = "button[data-gtm-name='Entrar']")
    private WebElement loginButton;

    @PostConstruct
    private void init() {
        initElements();
    }

    public void clickLoginButton() {
        loginButton.click();
    }
}