package org.opencart.stepdefs;

import io.cucumber.java.en.Then;
import org.opencart.pages.PasswordResetPage;
import org.testng.Assert;
import qa.factory.DriverFactory;

public class PasswordResetStepdefs  {


    @Then("User verify the forgot password page {string}")
    public void userVerifyTheForgotPasswordPage(String title) {
        PasswordResetPage paswordReset =new PasswordResetPage(DriverFactory.getDriver());
        String pageTitle=paswordReset.getPageTittle();
        Assert.assertEquals(pageTitle,title);
    }
}
