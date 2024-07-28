package org.ta_selenium.tests;

import org.ta_selenium.utils.DriverFactory;
import org.ta_selenium.utils.ExtentReportManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.testng.ITestResult;

import java.lang.reflect.Method;

public class BaseTest {
    protected WebDriver driver;
    protected ExtentReports extent;
    protected ExtentTest test;

    @BeforeSuite
    public void setUp() {
        extent = ExtentReportManager.getExtentReports();
    }

    @BeforeMethod
    public void setUpTest(Method method) {
        test = extent.createTest(method.getName());
        driver = DriverFactory.getChrDriver();
    }

    @AfterMethod
    public void tearDownTest(ITestResult result) {
        if (driver != null) {
            driver.quit();
        }
        if (result.getStatus() == ITestResult.FAILURE) {
            test.fail(result.getThrowable());
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            test.pass("Test passed");
        }
    }
    @AfterSuite
    public void tearDown(){
        extent.flush();
    }
}
