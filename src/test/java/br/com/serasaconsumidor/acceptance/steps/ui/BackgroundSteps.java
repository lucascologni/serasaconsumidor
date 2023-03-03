package br.com.serasaconsumidor.acceptance.steps.ui;

import br.com.serasaconsumidor.pages.HomePage;
import io.cucumber.java.en.Given;
import org.springframework.beans.factory.annotation.Autowired;

public class BackgroundSteps {

    @Autowired
    private HomePage homePage;

    @Given("that a consumer access the login page")
    public void thatAConsumerAccessTheLoginPage() {
        homePage.clickLoginButton();
    }
}