package com.jk.kits.java.page;

import com.jk.kits.java.base.basePage;
import com.jk.kits.java.util.PropertyReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends basePage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    By username = By.id("login-username");
    By password = By.id("login-password");
    By signInBtn = By.id("js-login-btn");


    public void openUrl() {
        driver.get("https://app.vwo.com");
    }

    public void loginwithcreds() {
        driver.findElement(username).sendKeys(PropertyReader.readItem("username"));
        driver.findElement(password).sendKeys(PropertyReader.readItem("password"));
        driver.findElement(signInBtn).click();
    }

    public DashBoardPage afterLogin() {
        return new DashBoardPage(driver);
    }





}
