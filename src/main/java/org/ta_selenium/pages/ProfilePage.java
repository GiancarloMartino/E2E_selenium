package org.ta_selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.By;
import org.ta_selenium.utils.ScrollUtils;
import org.ta_selenium.utils.WaitUtils;

import java.util.List;
import java.util.stream.Collectors;

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

    @FindBy(xpath = "//div[@class=\"modal-content\"]")
    private WebElement dialog;

    @FindBy(xpath = "//div[@class=\"modal-content\"]/descendant::button[@id='closeSmallModal-ok']")
    private WebElement okModalBtn;

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

    public Boolean isLogOutBtnDisplayed(){
        wait.waitForElementToBeVisible(logoutBtn);
        return logoutBtn.isDisplayed();
    }

    public void clickLogOutBtn(){
        ScrollUtils.scrollIntoView(driver, logoutBtn);
        logoutBtn.click();
    }

    public void centralizeBooksTable(){
        ScrollUtils.scrollIntoView(driver, deleteAllBooksBtn);
    }

    public List<String> getAllBookTitles() {
        List<WebElement> titleElements = driver.findElements(By.xpath("//div[@class='rt-tr-group']/descendant::a"));
        return titleElements.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    public void deleteAllBooksInUserProfile(){
        ScrollUtils.scrollIntoView(driver, deleteAllBooksBtn);
        deleteAllBooksBtn.click();
    }

    public Boolean isDeleteModalDisplayed(){
        wait.waitForElementToBeVisible(dialog);
        return dialog.isDisplayed();
    }

    public void confirmDeleteInModal(){
        okModalBtn.click();
    }

    public void acceptAlert(){
        wait.clickOnAlert();
    }
}
