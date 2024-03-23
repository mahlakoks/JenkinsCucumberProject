package AppHooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import qa.factory.DriverFactory;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.ResourceBundle;

public class AppHooks {

    private WebDriver driver;
    private  DriverFactory driverFactory;
    private String browser;

    // excecution order Before 0-->1-->2  After  2-->1-->0
    @Before(order=0)
    public void setup() {
        ResourceBundle resource= ResourceBundle.getBundle("configuration");
         browser=resource.getString("browser");


    }


    @Before(order=1)
    public void launchBrowser(){
        driverFactory = new DriverFactory();
        driver = driverFactory.init_driver(browser);


        Properties properties = new Properties();
        try (FileInputStream fis = new FileInputStream("C:\\NigelTechHub\\CucumberBDD\\src\\test\\resources\\extent.properties")) {
            properties.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
/*
        // Display current properties
        System.out.println("Current Properties:");
        properties.forEach((key, value) -> System.out.println(key + " : " + value));
        String hjj=System.getProperty("os.name");
        // Update properties

        properties.setProperty("systeminfo.os", System.getProperty("os.name"));
        properties.setProperty("user",  System.getProperty("user.name"));

        Capabilities capabilities = ((FirefoxDriver) driver).getCapabilities(); // Change to FirefoxDriver if using Firefox
        String browserVersion = capabilities.getBrowserVersion();

        System.out.println("Browser Version: " + browserVersion);
        properties.setProperty("browser.version", browserVersion);
       // properties.setProperty("browser", browser+" Version := "+browserVersion);


        // Save updated properties back to extent.properties file
        try (FileOutputStream fos = new FileOutputStream("C:\\NigelTechHub\\CucumberBDD\\src\\test\\resources\\extent.properties")) {
            properties.store(fos, "Updated extent.properties file");
            System.out.println("Properties updated successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Display updated properties
        System.out.println("Updated Properties:");
        properties.forEach((key, value) -> System.out.println(key + " : " + value));*/

    }

    @After(order=0)
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }}

    @After(order=1)
    public void tearDown(Scenario scenario){
System.out.println(" Senario status :="+scenario.isFailed());
        if(scenario.isFailed()){
            String screenshotname=scenario.getName().replaceAll(" ","_");
            //Use byte to support CICD intergration
            byte[] sourcePath=((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(sourcePath,"image/png",screenshotname);
        }

    }

}
