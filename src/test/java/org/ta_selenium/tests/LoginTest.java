package org.ta_selenium.tests;

import org.ta_selenium.pages.LoginPage;
import org.testng.annotations.Test;
import org.testng.Assert;

public class LoginTest extends BaseTest {

    @Test
    public void testSuccessfulLogin() {

        test.info("Go To DemoQa Books");
        String expectedUrl = "https://demoqa.com/profile";
        LoginPage loginPage = new LoginPage(driver);
        loginPage.goToLoginBookStore();
        test.info("Can go to login form");
        loginPage.compileForm("TestAutomation", "*Ta_Java0");
        test.info("Can compile the login form");
        loginPage.clickLoginBtn();
        test.info("Can click on login button");
        String actualUrl = loginPage.getActualUrl();
        Assert.assertEquals(actualUrl, expectedUrl, "The profile page URL is incorrect");
        test.pass("SuccessfulLogin");
    }
}
