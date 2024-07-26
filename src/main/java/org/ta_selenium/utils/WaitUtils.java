package org.ta_selenium.utils;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtils {

    private final WebDriverWait wait;

    public WaitUtils(WebDriver driver) {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void clickAndWaitForPageLoad(WebElement element) {
        element.click();
        waitForPageLoad();
        waitForAjaxComplete();
    }

    public void waitForPageLoad() {
        wait.until(ExpectedConditions.jsReturnsValue("return document.readyState == 'complete'"));
        wait.until(ExpectedConditions.jsReturnsValue("return document.visibilityState == 'visible'"));
    }

    private void waitForAjaxComplete() {
        wait.until(ExpectedConditions.jsReturnsValue("return window.jQuery ? window.jQuery.active == 0 : true"));
    }

    public void waitForElementToBeVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForElementToBeClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
}