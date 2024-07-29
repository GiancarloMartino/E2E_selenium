package org.ta_selenium.tests;
import org.ta_selenium.pages.LoginPage;
import org.ta_selenium.pages.ProfilePage;
import org.testng.annotations.Test;
import org.testng.Assert;
import java.util.List;

public class ProfileTest extends BaseTest  {

    @Test(groups = {"login"})
    public void testNobooksInProfileSection(){
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
        test.info("No Rows Label is Displayed in Profile: No books associated to the user");
        String actualUrl = profilePage.getActualUrl();
        Assert.assertEquals(actualUrl, expectedUrl);
        test.info("Expected Profile Url is correctly display");
        test.pass("SuccessfullLogout");
    }

    @Test(groups = {"api"})
    public void testExpectedBooksInProfileSection(){
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
        profilePage.centralizeBooksTable();
        List<String> expectedBookTitles = List.of("Git Pocket Guide", "Programming JavaScript Applications", "You Don't Know JS");
        List<String> actualBookTitles = profilePage.getAllBookTitles();
        test.info(" Get All Titles Displayed");
        Assert.assertEquals(actualBookTitles, expectedBookTitles, "The book titles DO NOT match the expected list");
        test.info("The books titles match the expected List");
        test.pass("The texts associated with the user are correctly displayed in the table.");
    }

    @Test(groups = {"api"})
    public void testIsPossibleDeleteOneRandomBookFromUI(){
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
        test.pass("ciao");
    }

    @Test(groups = {"api"})
    public void testIsPossibleDeleteAllBooksFromUI(){
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
        profilePage.centralizeBooksTable();
        profilePage.deleteAllBooksInUserProfile();
        test.info("Click on Delete All Books Button");
        Assert.assertTrue(profilePage.isDeleteModalDisplayed());
        profilePage.confirmDeleteInModal();
        test.info("click Ok on delete confirmation");
        profilePage.acceptAlert();
        test.info("Accept Alert");
        Assert.assertTrue(profilePage.isNoRowsLabelDisplayed());
        test.info("No Rows Label is Displayed in Profile: No books associated to the user");
        test.pass("The texts associated with the user are correctly removed from the table.");
    }
}
