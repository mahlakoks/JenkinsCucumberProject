package org.shoeportal.pages;

import BrowserUtils.Actions;
import org.apache.commons.math3.ode.events.Action;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SigninPage extends Actions {

   public static WebDriver driver;

   public static By username= By.xpath("//input[@id='usr']");
   public static By password = By.xpath("//input[@id='pwd']");

   public static By submit= By.xpath("//input[@value='Login']");
   public static By registerHere=By.xpath("//button[@id='NewRegistration']");

   public static By errmgs=By.xpath("//span[@class='error']");

    public SigninPage(WebDriver driver) {
        super(driver);
        this.driver=driver;
    }

    public static String checkPageTile(String tittle){
        return Actions.getPageTitle();
    }

    public static void doLogin(String user,String pass){
       Actions.type(username,user);
        Actions.type(password,pass);

    }

    public static void cliclLogin(){
        Actions.click(submit);
    }

    public static String getErrorMsg(){
      return  Actions.getText(errmgs);
    }
/*
    public static RegistrationPage clickRegister(){
        Actions.click(registerHere);
        return new RegistrationPage(driver);
    }


    You tried 3 times already !!! - start from beginning

    Both Username and Password field are required



*/


}
