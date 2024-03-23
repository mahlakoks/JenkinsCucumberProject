package org.opencart.pages;

import BrowserUtils.Actions;
import org.openqa.selenium.WebDriver;

public class PasswordResetPage extends Actions {
    private WebDriver driver;

    public PasswordResetPage(WebDriver driver){
        super(driver);
        this.driver=driver;
    }

    public String getPageTittle() {
        return Actions.getPageTitle();
    }

}
