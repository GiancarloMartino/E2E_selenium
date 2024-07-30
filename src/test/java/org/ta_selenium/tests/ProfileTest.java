package org.ta_selenium.tests;
import org.ta_selenium.pages.LoginPage;
import org.ta_selenium.pages.ProfilePage;
import org.testng.annotations.Test;
import org.testng.Assert;
import java.util.List;

public class ProfileTest extends BaseTest  {

    @Test(groups = {"login"})
    public void testNobooksInProfileSection(){
        test.info("Navigating to DemoQa Books and logging out");
        String expectedUrl = "https://demoqa.com/profile";
        LoginPage loginPage = new LoginPage(driver);
        loginPage.goToLoginBookStore();
        test.info("Navigated to login form");
        loginPage.compileForm("TestAutomation", "*Ta_Java0");
        test.info("Filled the login form");
        loginPage.clickLoginBtn();
        Assert.assertTrue(loginPage.isValueUserLabelDisplayed());
        test.info("Username is displayed correctly after login");
        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.clickProfileTab();
        test.info("Clicked on Profile Tab");
        Assert.assertTrue(profilePage.isNoRowsLabelDisplayed());
        test.info("No Rows Label is displayed in Profile: No books associated with the user");
        String actualUrl = profilePage.getActualUrl();
        Assert.assertEquals(actualUrl, expectedUrl);
        test.info("Expected Profile URL is displayed correctly");
        test.pass("Successful Check on Profile Tab");
    }

    @Test(groups = {"api"})
    public void testExpectedBooksInProfileSection(){
        test.info("Navigating to DemoQa Books and logging out");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.goToLoginBookStore();
        test.info("Navigated to login form");
        loginPage.compileForm("TestAutomation", "*Ta_Java0");
        test.info("Filled the login form");
        loginPage.clickLoginBtn();
        Assert.assertTrue(loginPage.isValueUserLabelDisplayed());
        test.info("Username is displayed correctly after login");
        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.clickProfileTab();
        test.info("Clicked on Profile Tab");
        profilePage.centralizeBooksTable();
        List<String> expectedBookTitles = List.of("Git Pocket Guide", "Programming JavaScript Applications", "You Don't Know JS");
        List<String> actualBookTitles = profilePage.getAllBookTitles();
        test.info("Retrieved all displayed titles");
        Assert.assertEquals(actualBookTitles, expectedBookTitles, "The book titles DO NOT match the expected list");
        test.info("The books titles match the expected List");
        test.pass("The books associated with the user are displayed correctly in the table");
    }

    @Test(groups = {"api"})
    public void testIsPossibleDeleteOneRandomBookFromUI(){
        test.info("Navigating to DemoQa Books and logging out");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.goToLoginBookStore();
        test.info("Navigated to login form");
        loginPage.compileForm("TestAutomation", "*Ta_Java0");
        test.info("Filled the login form");
        loginPage.clickLoginBtn();
        Assert.assertTrue(loginPage.isValueUserLabelDisplayed());
        test.info("Username is displayed correctly after login");
        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.clickProfileTab();
        test.info("Clicked on Profile Tab");
        String booksDeleted = profilePage.deleteRandomBook();
        test.info("Selected a random title and removed it from UI");
        List<String> actualBookTitles = profilePage.getAllBookTitles();
        Assert.assertFalse(actualBookTitles.contains(booksDeleted));
        test.info("Expected list after deletion is displayed");
        test.pass("Successfully deleted a random book title");
    }

    @Test(groups = {"api"})
    public void testIsPossibleDeleteAllBooksFromUI(){
        test.info("Navigating to DemoQa Books and logging out");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.goToLoginBookStore();
        test.info("Navigated to login form");
        loginPage.compileForm("TestAutomation", "*Ta_Java0");
        test.info("Filled the login form");
        loginPage.clickLoginBtn();
        Assert.assertTrue(loginPage.isValueUserLabelDisplayed());
        test.info("Username is displayed correctly after login");
        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.clickProfileTab();
        test.info("Clicked on Profile Tab");
        profilePage.centralizeBooksTable();
        profilePage.deleteAllBooksInUserProfile();
        test.info("Clicked on Delete All Books button");
        Assert.assertTrue(profilePage.isDeleteModalDisplayed());
        profilePage.confirmDeleteInModal();
        test.info("Confirmed deletion in modal");
        profilePage.acceptAlert();
        test.info("Accepted alert");
        Assert.assertTrue(profilePage.isNoRowsLabelDisplayed());
        test.info("No Rows Label is displayed in Profile: No books associated with the user");
        test.pass("Successfully removed all books associated with the user from the table");
    }
}
