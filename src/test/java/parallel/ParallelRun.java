package parallel;

import io.cucumber.junit.Cucumber;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.junit.runner.RunWith;
import org.testng.annotations.DataProvider;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/parallel",
        glue = {"parallel"},
        plugin = {"pretty","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:","rerun:target/parallelfailedrerun.txt"},//"html:target/cucumber-reports-nigel",
        monochrome=true,
        publish = false)
public class ParallelRun extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
    //"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
    //                    "timeline:test-output-thread/"

}

