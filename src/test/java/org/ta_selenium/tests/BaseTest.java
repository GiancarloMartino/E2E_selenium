package org.ta_selenium.tests;

import org.ta_selenium.utils.ApiController;
import org.ta_selenium.utils.DriverFactory;
import org.ta_selenium.utils.ExtentReportManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.testng.ITestResult;
import org.testng.ITestContext;
import java.lang.reflect.Method;

public class BaseTest {
    protected WebDriver driver;
    protected ExtentReports extent;
    protected ExtentTest test;
    protected ApiController apiController;

    @BeforeSuite
    public void setUp() {
        extent = ExtentReportManager.getExtentReports();
    }

    @BeforeMethod
    public void setUpTest(Method method, ITestContext context) {
        test = extent.createTest(method.getName());
        driver = DriverFactory.getChrDriver();

        for (String group : context.getAllTestMethods()[0].getGroups()) {
            if (group.equals("api")) {
                apiController = new ApiController();
                apiController.addBooks();
            }
        }
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
        if (apiController != null) {
            try {
                apiController.deleteBooks();
            } catch (Exception e) {
                test.info("Error during cleanup: " + e.getMessage());
            }
        }
    }
    @AfterSuite
    public void tearDown(){
        extent.flush();
    }
}
