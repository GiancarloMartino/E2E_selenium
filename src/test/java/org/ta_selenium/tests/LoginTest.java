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
        Assert.assertTrue(loginPage.isUserFormDisplayed());
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
        Assert.assertTrue(profilePage.isLogOutBtnDisplayed());
        test.info("LogOut Button is displayed");
        profilePage.clickLogOutBtn();
        test.info("LogOut Button has clicked");
        Assert.assertTrue(loginPage.isUserFormDisplayed());
        String actualUrl = loginPage.getActualUrl();
        Assert.assertEquals(actualUrl, "https://demoqa.com/login");
        test.info("User is on Login page");
        test.pass("SuccessfullLogout");
    }
}
