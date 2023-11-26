package com.jk.kits.java.base;

import com.jk.kits.java.util.DriverManager;
import com.jk.kits.java.util.PropertyReader;
import com.jk.kits.java.util.Log;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class baseTest extends DriverManager {
    public WebDriver driver;
    PropertyReader pr = new PropertyReader();

    public baseTest() {

        this.driver = super.getDriver();
    }
@BeforeMethod(alwaysRun = true)

    public void setUp() {
        try {

            if (PropertyReader.readItem("browser").equals("chrome")) {
                Log.info("Found chrome as Browser");
                driver = new ChromeDriver();
                driver.manage().window().maximize();

            } else {
                try {
                    throw new Exception("Browser or Browser Driver is not supported yet.");
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.getMessage();
                    e.printStackTrace();
                    Log.error("Browser Launch Failure: ", e);
                }
            }
        } catch (Exception e) {
            Log.error("Chrome Launch Failure: ", e);

        }
    }


    @AfterMethod(alwaysRun = true)
    public void teardown() {
        Log.info("Closing Webdriver Windows");
        driver.quit( );


    }

}