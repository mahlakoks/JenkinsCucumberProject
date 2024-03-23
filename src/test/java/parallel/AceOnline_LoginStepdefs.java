package parallel;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.shoeportal.pages.HomePage;
import org.shoeportal.pages.SigninPage;
import org.testng.Assert;
import qa.factory.DriverFactory;

public class AceOnline_LoginStepdefs {

    private WebDriver driver;
    private HomePage home;
    private SigninPage sp;


   /* @BeforeClass
    public void setup() {

        DriverFactory driverFactory = new DriverFactory();
        driver = driverFactory.init_driver("firefox");

    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();

        }
    }*/

    @Given("User lunch the browser and navigate to SignIN page")
    public void userLunchTheBrowserAndNavigateToSignINPage() {
        driver=DriverFactory.getDriver();
        driver.get("https://anupdamoda.github.io/AceOnlineShoePortal/index.html");
        HomePage home=new HomePage(driver);
        HomePage.naviagteToSingnIn();
    }

    @Then("Verify the url contains  {string}")
    public void verifyTheUrlContains(String url) {
        String currentUrl=HomePage.getUrl();
        Assert.assertEquals(currentUrl,url);
    }

    @Given("User enter valid username {string} and password {string}")
    public void userEnterValidUsernameAndPassword(String username, String password) {
        sp=new SigninPage(driver);
        SigninPage.doLogin(username,password);

    }

    @And("User click Login button")
    public void userClickLoginButton() {
        SigninPage.cliclLogin();

    }

    @Then("Verify the page title is {string}")
    public void verifyThePageTitleIs(String tittle) {
        SigninPage.checkPageTile(tittle);

    }

    @Given("User enter valid {} and {}")
    public void userEnterValidAnd(String username, String password) {
        SigninPage.doLogin(username,password);
    }

    @Then("Verify error message {}")
    public void verifyErrorMessage(String errmsg) {
        String error=SigninPage.getErrorMsg();
        Assert.assertEquals(error,errmsg);
    }
}
