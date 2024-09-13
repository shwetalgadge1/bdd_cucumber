package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ExtentReportUtil {
    private ExtentReports extent;
    private ExtentTest test;

    public ExtentReportUtil() {
        // Create an ExtentSparkReporter instance and attach it to ExtentReports
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("ExtentReport.html");
        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
        
        // Set system information
        extent.setSystemInfo("Tester", "Shwetal");
        extent.setSystemInfo("Environment", "Automation Exercise Website");
        extent.setSystemInfo("Tools", "Selenium, Cucumber, Extent Reports");
    }

    // Create a test case in the Extent report
    public ExtentTest createTest(String testName) {
        test = extent.createTest(testName);
        return test;
    }

    // Method to capture a screenshot
    public void captureScreenshot(WebDriver driver, String screenshotName) {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File src = ts.getScreenshotAs(OutputType.FILE);
        try {
            Files.copy(src.toPath(), Paths.get(screenshotName + ".png"));
            test.addScreenCaptureFromPath(screenshotName + ".png");  // Attach screenshot to the test
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Flush the report after tests are executed
    public void flushReport() {
        extent.flush();
    }
}
