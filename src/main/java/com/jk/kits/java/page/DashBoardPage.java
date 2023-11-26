package com.jk.kits.java.page;

import com.jk.kits.java.base.basePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class DashBoardPage extends basePage {

        WebDriver driver;

        public DashBoardPage(WebDriver driver){
            super(driver);
            this.driver = driver;
        }

        By userName  = By.cssSelector("[data-qa='lufexuloga']");

        // Page Action
        public String loggedInUserName(){
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            waitForElementToAppear(userName);
            return driver.findElement(userName).getText();
        }

}

