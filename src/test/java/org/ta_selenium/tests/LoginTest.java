package org.ta_selenium.tests;

import org.ta_selenium.pages.LoginPage;
import org.ta_selenium.pages.ProfilePage;
import org.testng.annotations.Test;
import org.testng.Assert;

public class LoginTest extends BaseTest {

    @Test(groups = {"login"})
    public void testSuccessfulLogin() {
        test.info("Navigating to DemoQa Books");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.goToLoginBookStore();
        Assert.assertTrue(loginPage.isUserFormDisplayed());
        test.info("Login form is displayed");
        loginPage.compileForm("TestAutomation", "*Ta_Java0");
        test.info("Filled the login form");
        loginPage.clickLoginBtn();
        Assert.assertTrue(loginPage.isValueUserLabelDisplayed());
        test.info("Login button clicked");
        String userName = loginPage.getActualUserName();
        Assert.assertEquals(userName, "TestAutomation", "There is a problem with userName");
        test.info("Username is correctly displayed after login");
        test.pass("Successful login");
    }
    @Test(groups = {"login"})
    public void testUnsuccessfulLogin(){
        test.info("Navigating to DemoQa Books with invalid credentials");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.goToLoginBookStore();
        test.info("Login form is displayed");
        loginPage.compileForm("TestAutomation", "Ta_Java");
        test.info("Filled the login form with invalid credentials");
        loginPage.clickLoginBtn();
        Assert.assertTrue(loginPage.isInvalidLoginLabelDisplayed());
        test.info("Invalid Login Label is correctly displayed");
        test.pass("UnSuccessful Login");
    }
    @Test(groups = {"login"})
    public void testLogout(){
        test.info("Navigating to DemoQa Books and logging out");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.goToLoginBookStore();
        test.info("Login form is displayed");
        loginPage.compileForm("TestAutomation", "*Ta_Java0");
        test.info("Filled the login form");
        loginPage.clickLoginBtn();
        Assert.assertTrue(loginPage.isValueUserLabelDisplayed());
        test.info("Username is correctly displayed after login");
        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.clickProfileTab();
        test.info("Clicked on Profile Tab");
        Assert.assertTrue(profilePage.isLogOutBtnDisplayed());
        test.info("Logout button is displayed");
        profilePage.clickLogOutBtn();
        test.info("Clicked on logout button");
        Assert.assertTrue(loginPage.isUserFormDisplayed());
        String actualUrl = loginPage.getActualUrl();
        Assert.assertEquals(actualUrl, "https://demoqa.com/login");
        test.info("User is redirected to the login page");
        test.pass("Successfull Logout");
    }
}
