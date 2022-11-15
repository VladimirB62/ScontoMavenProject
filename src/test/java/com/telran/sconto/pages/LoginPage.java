package com.telran.sconto.pages;

import com.codeborne.selenide.Conditional;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.telran.sconto.utils.PropertiesLoader;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.files.DownloadActions.click;

public class LoginPage {

    public static By loginTitleLocator = By.cssSelector(".existingAccount__headline");
    public static By emailInputLocator = By.id("loginEmail");
    private static String validEmail = PropertiesLoader.loadProperty("valid.email");
    public static By passwordInputLocator= By.id("loginPassword");
    private static String validPassword = PropertiesLoader.loadProperty("valid.password");
    public static By loginButtonLocator= By.id("login-submit");

    public SelenideElement loginPageTitleDisplayed() {
        return $(loginTitleLocator);
    }

    public void validLoginInput() {
        $(emailInputLocator).setValue(validEmail);
        $(passwordInputLocator).setValue(validPassword);
    }

    public void clickOnLoginButton() {
        $(loginButtonLocator).click();
    }

    public void wrongEmailInput(String email, String password) {
        $(emailInputLocator).setValue(email);
        $(passwordInputLocator).setValue(password);
    }

    private static By wrongEmailMessageLocator = By.id("loginEmail-error");

    public <T> SelenideElement emailErrorDisplayed() {
        return $(wrongEmailMessageLocator);
    }

    public void withEmptyPasswordFieldLogin() {
        $(emailInputLocator).setValue(validEmail);
        $(passwordInputLocator).setValue("");
    }

    private static By loginPasswordErrorLocator = By.id("loginPassword-error");

    public SelenideElement validPasswordDemandAppeared() {
        return $(loginPasswordErrorLocator);
    }
}
