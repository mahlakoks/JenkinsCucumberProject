package org.shoeportal.pages;

import BrowserUtils.Actions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends Actions {

   private static By hamburgerMenu = By.xpath("//input[@type='checkbox']");
   private static By signIn=By.xpath("//li[contains(text(),'Sign In Portal')]");

   private static WebDriver driver;

   public HomePage(WebDriver driver){
       super(driver);
       this.driver=driver;
   }

   public static SigninPage naviagteToSingnIn(){
       Actions.click(hamburgerMenu);
       Actions.click(signIn);
       return new SigninPage(driver);
   }

   public static void clickHumburgerMenu(){
       Actions.click(hamburgerMenu);
   }

   public static SigninPage clickSignIn(){
       Actions.click(signIn);
       return new SigninPage(driver);
   }

    public static String getUrl() {
       return Actions.getUrl();
    }


}
