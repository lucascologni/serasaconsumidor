package br.com.serasaconsumidor.acceptance.steps.ui.login;

import br.com.serasaconsumidor.factories.ConsumerFactory;
import br.com.serasaconsumidor.models.Consumer;
import br.com.serasaconsumidor.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;

public class LoginSteps {

    @Autowired
    private LoginPage loginPage;

    @Given("that a consumer inserts a valid CPF")
    public void thatAConsumerInsertsAValidCpf() {
        Consumer consumer = ConsumerFactory.getConsumerWithValidCpf();

        loginPage.insertCpf(consumer.getCpf());
    }

    @When("consumer erases the inserted cpf")
    public void consumerErasesTheInsertedCpf() {
        loginPage.eraseCpf();
    }

    @When("consumer inserts an invalid CPF")
    public void consumerInsertsAnInvalidCpf() {
        Consumer consumer = ConsumerFactory.getConsumerWithInvalidCpf();

        loginPage.insertCpf(consumer.getCpf());
    }

    @When("consumer inserts a valid CPF")
    public void consumerInsertsAnValidCpf() {
        Consumer consumer = ConsumerFactory.getConsumerWithValidCpf();

        loginPage.insertCpf(consumer.getCpf());
    }

    @Then("a mandatory CPF message is displayed")
    public void aMandatoryCpfMessageIsDisplayed() {
        Assert.assertEquals(loginPage.getCpfErrorMessage(), "Informe o seu CPF");
    }

    @Then("an invalid CPF message is displayed")
    public void anInvalidCpfMessageIsDisplayed() {
        Assert.assertEquals(loginPage.getCpfErrorMessage(), "CPF inválido");
    }

    @Then("the Continue button is enabled")
    public void theContinueButtonIsEnabled() {
        Assert.assertTrue(loginPage.isContinueButtonEnabled());
    }

    @Then("the Continue button is disabled")
    public void theContinueButtonIsDisabled() {
        Assert.assertFalse(loginPage.isContinueButtonEnabled());
    }
}