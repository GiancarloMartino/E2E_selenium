package org.ta_selenium.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverFactory {
    public static WebDriver getChrDriver() {
        WebDriverManager.chromedriver().create();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-cache");
        options.addArguments("--disable-infobars");
        options.addArguments("--incognito");
        return new ChromeDriver(options);
    }
}