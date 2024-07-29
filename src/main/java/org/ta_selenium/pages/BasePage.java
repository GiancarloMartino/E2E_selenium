package org.ta_selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.ta_selenium.utils.WaitUtils;

public class BasePage {
    protected WaitUtils wait;
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WaitUtils(driver);
        PageFactory.initElements(driver, this);
    }
    public String getActualUrl(){
        return  driver.getCurrentUrl();
    }
}
