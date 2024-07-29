package org.ta_selenium.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {
    private static final ExtentReports extentReports = new ExtentReports();
    private static boolean isInitialized = false;

    private ExtentReportManager(){
        //for this use case this constructor can be empty
    }

    public static synchronized ExtentReports getExtentReports() {
        if (!isInitialized) {
            initializeExtentReports();
        }
        return extentReports;
    }

    private static void initializeExtentReports() {
        ExtentSparkReporter reporter = new ExtentSparkReporter("./extent-reports/extent-report.html");
        reporter.config().setReportName("Automation Test Report");
        extentReports.attachReporter(reporter);
        isInitialized = true;
    }
}