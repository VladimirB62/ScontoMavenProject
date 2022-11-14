package com.telran.sconto.steps;

import com.telran.sconto.pages.LoginPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java8.En;

import java.util.List;
import java.util.Map;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.page;
import static io.cucumber.core.internal.com.fasterxml.jackson.databind.type.LogicalType.Map;

public class LoginPageSteps implements En {

    LoginPage login;
    public LoginPageSteps() {
        Then("Login Page displayed", () -> {
            login = page(LoginPage.class);
            login.loginPageTitleDisplayed().should(exist);
            login.loginPageTitleDisplayed().shouldHave(text("Anmelden"));
        });

        When("Enter the valid credentials",() ->{
            login.validLoginInput();
        });

        And("Click Anmelden button",() ->{
            login.clickOnLoginIcon();
        });

        When("Enter the wrong email and a valid password",(DataTable table) ->{
            List<Map<String,String>> dataTable = table.asMaps();

            String email = dataTable.get(0).get("email");
            String password = dataTable.get(0).get("password");

            login.wrongEmailInput(email,password);
        });

        Then("Email Error message displayed",() ->{
            login.emailErrorDisplayed().shouldHave(text("geben Sie"));
        });
    }
}
