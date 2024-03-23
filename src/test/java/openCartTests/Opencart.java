package openCartTests;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.opencart.pages.LoginPages;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import qa.factory.DriverFactory;

public class Opencart {

    //https://naveenautomationlabs.com/opencart/

    private WebDriver driver;
    private LoginPages loginPage;
private  DriverFactory driverFactory;
    @BeforeClass
    public void setup() {

        driverFactory = new DriverFactory();
        driver = driverFactory.init_driver("firefox");

    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();

        }
    }

    @Test(priority=1)
    public void iAmOnTheOpenCratLoginPage() {
        DriverFactory.getDriver().get("https://naveenautomationlabs.com/opencart/");
        loginPage=new LoginPages(driver);
        loginPage.clickAccount();
    }

    @Test(priority=2)
    public void iHaveEnteredAValidUsernameAndPassword() {
        loginPage.clickLogin();
        loginPage.doLogin("qatestertest@gmail.com","Test@123");
    }

    @Test(priority=3)
    public void iClickOnTheLoginButton() {

    }

    @Test(priority=3)
    public void iShouldBeLoggedInSuccessfully() {
    }
}

