package com.jk.kits.java.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class waitForHelper {

    public WebDriver driver;

    public waitForHelper(WebDriver driver)
    {
        this.driver=driver;
    }

    public void implicitWait()
    {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public WebElement presenceOfTheElement(final By elementIdentifier) {
        WebElement firstResult = null;
        int attempts = 0;
        while (attempts < 5) { // Try a certain number of attempts
            try {
                firstResult = driver.findElement(elementIdentifier);
                break; // If found, break out of the loop
            } catch (NoSuchElementException e) {
                // If element not found, wait briefly and try again
                try {
                    Thread.sleep(1000); // Adjust the sleep duration as needed
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
            attempts++;
        }
        return firstResult;
    }
}
