package org.ta_selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.ta_selenium.utils.ScrollUtils;

public class LoginPage extends BasePage {
    @FindBy(xpath = "//div[6]/descendant::span[contains(text(),\"Login\")]")
    private WebElement loginTab;

    @FindBy(id = "userForm")
    private WebElement userForm;

    @FindBy(id = "userName")
    private WebElement usernameInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(id = "login")
    private WebElement loginButton;

    @FindBy(id = "userName-value")
    private WebElement valueUserLabel;

    @FindBy(id = "name")
    private WebElement invalidLoginLabel;

    public LoginPage(WebDriver driver) {
        super(driver);
    }
    public void goToLoginBookStore(){
        driver.get("https://demoqa.com/books");
        ScrollUtils.scrollIntoView(driver, loginTab);
        wait.waitForElementToBeClickable(loginTab);
        wait.clickAndWaitForPageLoad(loginTab);
        wait.waitForElementToBeVisible(userForm);
    }
    public void clickLoginBtn(){
        ScrollUtils.scrollIntoView(driver, loginButton);
        wait.clickAndWaitForPageLoad(loginButton);
    }
    public void compileForm(String username, String password) {
        wait.waitForElementToBeVisible(usernameInput);
        wait.waitForElementToBeClickable(loginButton);
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
    }
    public Boolean isValueUserLabelDisplayed(){
        wait.waitForElementToBeVisible(valueUserLabel);
        return valueUserLabel.isDisplayed();
    }
    public Boolean isUserFormDisplayed(){
        wait.waitForElementToBeVisible(userForm);
        return userForm.isDisplayed();
    }

    public String getActualUserName(){
        return valueUserLabel.getText();
    }
    public Boolean isInvalidLoginLabelDisplayed(){
        wait.waitForElementToBeVisible(invalidLoginLabel);
        return invalidLoginLabel.isDisplayed();
    }
}