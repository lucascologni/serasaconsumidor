package br.com.serasaconsumidor.infrastructure.webdriver;

import org.openqa.selenium.WebDriver;

public interface WebDriverContract {

    WebDriver createWebDriver();
    WebDriver getWebDriver();
    boolean is64bitsWebDriver();
    void quitWebDriver();
}