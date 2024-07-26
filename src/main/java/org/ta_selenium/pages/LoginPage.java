package org.ta_selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.ta_selenium.utils.WaitUtils;

public class LoginPage extends BasePage {
    WaitUtils wait = new WaitUtils(driver);

    @FindBy(xpath = "//span[contains(text(),\"Login\")]")
    private WebElement loginTab;

    @FindBy(id = "userName")
    private WebElement usernameInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(id = "login")
    private WebElement loginButton;

    @FindBy(id = "userName-value")
    private WebElement valueUser;

    public LoginPage(WebDriver driver) {
        super(driver);
    }
    public void goToLoginBookStore(){
        driver.get("https://demoqa.com/books");
        wait.waitForElementToBeClickable(loginTab);
        wait.clickAndWaitForPageLoad(loginTab);
    }
    public void clickLoginBtn(){
        wait.clickAndWaitForPageLoad(loginButton);
        wait.waitForElementToBeVisible(valueUser);
    }
    public void compileForm(String username, String password) {
        wait.waitForElementToBeVisible(usernameInput);
        wait.waitForElementToBeClickable(loginButton);
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
    }
    public String getActualUrl(){
        return  driver.getCurrentUrl();
    }
}