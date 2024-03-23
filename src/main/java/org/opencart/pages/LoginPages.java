package org.opencart.pages;

import BrowserUtils.Actions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class LoginPages extends Actions {

    private WebDriver driver;
    private By myAccount= By.xpath("//span[contains(text(),'My Account')]");
    private By register=By.xpath("//a[contains(text(),'Register')]");
    private By login =By.xpath("//a[contains(text(),'Login')]");

    private By username=By.xpath("//input[@id='input-email']");
    private By password= By.xpath("//input[@id='input-password']");
    private By submit=By.xpath("//input[@type='submit']");

    private By errorMsg=By.xpath("//div[@class='alert alert-danger alert-dismissible']");

    private By forgorPassword=By.xpath("//div[@class='form-group']//a[contains(text(),'Forgotten Password')]");

    private By categoriesLocator=By.xpath("//ul[@class='nav navbar-nav']/li");

    public LoginPages(WebDriver driver){
        super(driver);
        this.driver=driver;
        }

        public void doLogin(String usernametxt,String passwotxt){
            enterUsername(usernametxt);
            enterPassword(passwotxt);
        }
        public void enterUsername(String input){
            Actions.type(username,input);
        }

    public void enterPassword(String input){
        Actions.type(password,input);
    }
    public void clickSubmit(){
        Actions.click(submit);
    }

    public void clickLogin(){
        Actions.click(login);
    }

    public PasswordResetPage clickForgotPassword(){
        Actions.click(forgorPassword);
       return new PasswordResetPage(driver);
    }
    public void clickAccount(){
        Actions.click(myAccount);
    }

    public String getErrorMsg(){
       return Actions.getText(errorMsg);
    }


    public boolean validateHeaderCategories(List<String> categories) {
       List<WebElement> expectedCategory=Actions.getList(categoriesLocator);
       List<String> epectedList=new ArrayList<>();
       expectedCategory.forEach(n->epectedList.add(n.getText()));
       boolean containsall=false;
       try{
           if(epectedList.retainAll(categories)){
               containsall=true;
               return  containsall;
           }

       }catch(Exception u){
           return false;
       }
       return containsall;
    }

    public int getMainCatCount() {
        int count=Actions.getList(categoriesLocator).size();
        return Actions.getList(categoriesLocator).size();
    }
}
