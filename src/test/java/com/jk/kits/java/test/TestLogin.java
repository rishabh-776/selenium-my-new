package com.jk.kits.java.test;

import com.jk.kits.java.base.baseTest;
import com.jk.kits.java.page.DashBoardPage;
import com.jk.kits.java.page.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestLogin extends baseTest {
@Test(priority = 1)

    public void loginVwo()
    {
        LoginPage login = new LoginPage(driver);
        login.openUrl();
        login.loginwithcreds();
    }
    @Test(priority = 2)
    public void loginDashboard()
    {
        LoginPage login = new LoginPage(driver);
        login.openUrl();
        login.loginwithcreds();
        DashBoardPage dash = login.afterLogin();
        Assert.assertEquals(dash.loggedInUserName(),"rish gan");

    }


}
