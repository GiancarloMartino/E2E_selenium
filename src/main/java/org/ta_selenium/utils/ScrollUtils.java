package org.ta_selenium.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.ta_selenium.interfaces.ScrollAction;
public class ScrollUtils {
    private ScrollUtils(){
        //for this use case this constructor can be empty
    }
    public static void scrollIntoView(WebDriver driver, WebElement element) {
        ScrollAction scrollAction = (d, e) ->
                ((JavascriptExecutor) d).executeScript("arguments[0].scrollIntoView();", e);
        scrollAction.execute(driver, element);
    }
}
