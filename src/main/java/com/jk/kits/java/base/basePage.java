package com.jk.kits.java.base;

import com.jk.kits.java.util.waitForHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class basePage {

    protected WebDriver driver;

    public basePage(WebDriver driver)
    {
        this.driver=driver;
    }

    public void goToUrl(String url)
    {
        driver.get(url);
    }

    public void waitForElementToAppear(By elementLocation)
    {
        new waitForHelper(driver).presenceOfTheElement(elementLocation);
    }

    public void waitForTime()

    {
        new waitForHelper(driver).implicitWait();
    }

    public void writeText(By elementLocation, String text)
    {
        driver.findElement(elementLocation).clear();
        driver.findElement(elementLocation).sendKeys(text);

    }

    public String readText(By elementLocation){
        return driver.findElement(elementLocation).getText( );
    }

    public void moveToElement(By elementLocation) {

        new Actions(driver).moveToElement(driver.findElement(elementLocation)).build().perform();
    }


}
