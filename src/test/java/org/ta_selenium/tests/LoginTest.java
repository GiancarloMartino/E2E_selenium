package org.ta_selenium.tests;

import org.ta_selenium.pages.LoginPage;
import org.testng.annotations.Test;
import org.testng.Assert;

public class LoginTest extends BaseTest {

    @Test
    public void testSuccessfulLogin() {
        String expectedUrl = "https://demoqa.com/profile";
        LoginPage loginPage = new LoginPage(driver);
        loginPage.goToLoginBookStore();
        loginPage.compileForm("TestAutomation", "*Ta_Java0");
        loginPage.clickLoginBtn();
        String actualUrl = loginPage.getActualUrl();
        Assert.assertEquals(actualUrl, expectedUrl, "The profile page URL is incorrect");
    }
}
