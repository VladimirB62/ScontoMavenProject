package com.telran.sconto.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.telran.sconto.steps.CustomerAccountPageSteps;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class CustomerAccountPage {

    private static By accountTitleLocator = By.cssSelector(".titleHeadLine");


    public SelenideElement accountTitleDisplayed() {
        return $(accountTitleLocator);
    }
}
