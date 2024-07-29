package org.ta_selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.ta_selenium.utils.ScrollUtils;

public class ProfilePage extends BasePage{

    @FindBy(xpath = "//*[@id=\"app\"]/descendant::span[@class=\"-pageInfo\"]")
    private WebElement paginator;

    @FindBy(xpath = "//div[6]/descendant::span[contains(text(),\"Profile\")]")
    private WebElement profileTab;

    @FindBy(xpath = "//button[@id=\"submit\" and contains(text(),\"Log out\")]")
    private WebElement logoutBtn;

    @FindBy(xpath = "//button[@id=\"submit\" and contains(text(),\"Delete All Books\")]")
    private WebElement deleteAllBooksBtn;

    @FindBy(xpath = "//*[@id=\"app\"]/descendant::div[contains(text(),\"No rows found\")]")
    private WebElement noRowsLabel;

    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    public void clickProfileTab() {
        ScrollUtils.scrollIntoView(driver, paginator);
        profileTab.click();
    }
    public Boolean isNoRowsLabelDisplayed(){
        wait.waitForElementToBeVisible(noRowsLabel);
        return noRowsLabel.isDisplayed();
    }
}
