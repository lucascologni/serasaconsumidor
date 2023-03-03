package br.com.serasaconsumidor.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@Scope(value = "session")
public class LoginPage extends BasePage {

    @FindBy(id = "f-cpf")
    private WebElement cpfTextField;

    @FindBy(css = "button[type='submit']")
    private WebElement continueButton;

    @FindBy(css = "p[role='alert']")
    private WebElement cpfErrorMessage;

    @PostConstruct
    private void init() {
        initElements();
    }

    public void insertCpf(String cpf) {
        cpfTextField.sendKeys(cpf);
    }

    public void eraseCpf() {
        cpfTextField.sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT, Keys.END), Keys.BACK_SPACE);
    }

    public boolean isContinueButtonEnabled() {
        return continueButton.isEnabled();
    }

    public String getCpfErrorMessage() {
        waitElementToBeVisible(cpfErrorMessage);
        return cpfErrorMessage.getText();
    }
}