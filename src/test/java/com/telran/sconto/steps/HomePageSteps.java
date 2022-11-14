package com.telran.sconto.steps;

import com.telran.sconto.pages.HomePage;
import io.cucumber.java8.En;

import static com.codeborne.selenide.Selenide.open;
import static com.telran.sconto.pages.HomePage.baseURL;

public class HomePageSteps implements En {

    HomePage home;

    public HomePageSteps() {
        Given("Navigate to Home page",() ->{
            //System.setProperty("selenide.browser","FireFox");
            home = open(baseURL,HomePage.class);
            home.acceptCookies();
        });

        When("Click on Anmelden icon",() ->{
            home.clickOnLoginButton();
        });

        When("Click on Mein Konto icon",() ->{
            home.clickOnMyAccountIcon();
        });
    }
}
