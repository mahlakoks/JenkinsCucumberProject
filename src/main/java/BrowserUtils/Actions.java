package BrowserUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Actions {
    private static WebDriver driver;

    public Actions(WebDriver driver){
        this.driver=driver;
    }

    public static WebElement getWebElement(By elem){
        return driver.findElement(elem);
    }

    public static void type(By elem,String test){
        getWebElement(elem).sendKeys(test);
    }

    public static void click(By submit) {

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        getWebElement(submit).click();
    }

    public static String getText(By errorMsg) {
       return getWebElement(errorMsg).getText();
    }

    public static String getTextByAttribute(By errorMsg,String atrribute) {
        return getWebElement(errorMsg).getAttribute("atrribute");
    }

    protected static String getPageTitle() {
        return driver.getTitle();
    }

    protected static String getUrl() {
        return driver.getCurrentUrl();
    }

    protected static List<WebElement> getList(By elem) {
        return driver.findElements(elem);
    }
}
