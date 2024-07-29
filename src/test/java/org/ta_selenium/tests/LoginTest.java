package org.ta_selenium.tests;

import org.ta_selenium.pages.LoginPage;
import org.ta_selenium.pages.ProfilePage;
import org.testng.annotations.Test;
import org.testng.Assert;

public class LoginTest extends BaseTest {

    @Test(groups = {"login"})
    public void testSuccessfulLogin() {
        test.info("Go To DemoQa Books");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.goToLoginBookStore();
        test.info("Can go to login form");
        loginPage.compileForm("TestAutomation", "*Ta_Java0");
        test.info("Can compile the login form");
        loginPage.clickLoginBtn();
        Assert.assertTrue(loginPage.isValueUserLabelDisplayed());
        test.info("Can click on login button");
        String userName = loginPage.getActualUserName();
        Assert.assertEquals(userName, "TestAutomation", "There is a problem with userName");
        test.info("After Login Username is correctly displayed in account label");
        test.pass("SuccessfulLogin");
    }
    @Test(groups = {"login"})
    public void testUnsuccessfulLogin(){
        test.info("Go To DemoQa Books with invalid credetials");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.goToLoginBookStore();
        test.info("Can go to login form");
        loginPage.compileForm("TestAutomation", "Ta_Java");
        test.info("Can compile the login form");
        loginPage.clickLoginBtn();
        Assert.assertTrue(loginPage.isInvalidLoginLabelDisplayed());
        test.info("Invalid Login Label is correctly displayed");
        test.pass("UnSuccessfulLogin");
    }
    @Test(groups = {"login"})
    public void testIsPossibleToLogout(){
        test.info("Go To DemoQa Books and Logout");
        String expectedUrl = "https://demoqa.com/profile";
        LoginPage loginPage = new LoginPage(driver);
        loginPage.goToLoginBookStore();
        test.info("Can go to login form");
        loginPage.compileForm("TestAutomation", "*Ta_Java0");
        test.info("Can compile the login form");
        loginPage.clickLoginBtn();
        Assert.assertTrue(loginPage.isValueUserLabelDisplayed());
        test.info("After Login Username is correctly displayed in account label");
        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.clickProfileTab();
        test.info("Click on Profile Tab");
        Assert.assertTrue(profilePage.isNoRowsLabelDisplayed());
        test.info("No Rows Label is Displayed in Profile");
        String actualUrl = profilePage.getActualUrl();
        Assert.assertEquals(actualUrl, expectedUrl);
        test.info("Expected Profile Url is correctly display");
        test.pass("SuccessfullLogout");
    }
}
