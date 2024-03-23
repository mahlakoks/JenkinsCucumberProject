package parallel;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.opencart.pages.LoginPages;
import org.opencart.pages.PasswordResetPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import qa.factory.DriverFactory;

public class LoginStepdefs {

    //https://naveenautomationlabs.com/opencart/

    private WebDriver driver;
    private LoginPages loginPage;

    private PasswordResetPage paswordReset;

/*
    @Before
    public void setup() {

        DriverFactory driverFactory = new DriverFactory();
        driver = driverFactory.init_driver("firefox");

    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();

        }
    }*/

    @Given("I am on the OpenCrat login page")
    public void iAmOnTheOpenCratLoginPage() {
        driver=DriverFactory.getDriver();
        DriverFactory.getDriver().get("https://naveenautomationlabs.com/opencart/");
        loginPage=new LoginPages(driver);
        loginPage.clickAccount();
        loginPage.clickLogin();
    }

    @Given("I Have entered a valid username and password")
    public void iHaveEnteredAValidUsernameAndPassword() {
        loginPage.doLogin("qatestertest@gmail.com","Test@123");
    }

    @When("I click on the login button")
    public void iClickOnTheLoginButton() {
        loginPage.clickSubmit();
    }

    @Then("I should be logged in successfully")
    public void iShouldBeLoggedInSuccessfully() {

    }

    @Then("I should  see an error message indicating {}")
    public void iShouldSeeAnErrorMessageIndicating(String errMessage) {
        String error=loginPage.getErrorMsg();
        System.out.println("  testing :="+error);


         String one="Warning: No match for E-Mail Address and/or Password.";
        boolean evaluation=false;
        String two ="Warning: Your account has exceeded allowed number of login attempts. Please try again in 1 hour.";
      if(error.equalsIgnoreCase(one)|| error.equalsIgnoreCase(two))
        {
            evaluation=true;
        }

        Assert.assertTrue(evaluation);
    }

    @Given("I Have entered a valid {string}and {string}")
    public void iHaveEnteredAValidAnd(String username, String password) {
        loginPage.doLogin(username,password);
    }


    @Then("I should be redirected to the password reset page with title {string}")
    public void iShouldBeRedirectedToThePasswordResetPageWithtitle(String title) {
        String pageTitle=paswordReset.getPageTittle();
        Assert.assertEquals(pageTitle,title);
    }

    @Given("I click on ForgottenPassword Link")
    public void iClickOnForgottenPasswordLink() {
        paswordReset=loginPage.clickForgotPassword();
    }

    @Given("I Have entered a invalid {} and {}")
    public void iHaveEnteredAInvalidAnd(String username, String password) {
        loginPage.doLogin(username,password);
    }
}

