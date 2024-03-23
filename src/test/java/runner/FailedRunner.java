package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

        import io.cucumber.testng.AbstractTestNGCucumberTests;
        import io.cucumber.testng.CucumberOptions;
        import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = "@target/failedrerun.txt",
        glue = {"org.opencart.stepdefs","org.AceOnlineShoePortal.stepdefs","AppHooks"},
        plugin = {"pretty","rerun:target/failedrerun.txt"},//Resun failed test cases//"html:target/cucumber-reports-nigel",
        monochrome=true,
        publish = true)

public class FailedRunner extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = false)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}