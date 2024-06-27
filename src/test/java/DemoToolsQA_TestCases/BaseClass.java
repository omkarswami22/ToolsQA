//package DemoToolsQA_TestCases;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.AfterSuite;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.BeforeSuite;
//import org.testng.asserts.SoftAssert;
//
//import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.ExtentTest;
//import com.aventstack.extentreports.reporter.ExtentSparkReporter;
//import com.aventstack.extentreports.reporter.configuration.Theme;
//
//import toolsQA_Utilities.ReadConfig;
//
//public class BaseClass {
//    ReadConfig readconfig = new ReadConfig();
//
//    ExtentReports extent;
//    ExtentTest test;
//    ExtentSparkReporter sparkReporter;
//
//    public WebDriver driver;
//
//    @BeforeClass
//    public void SetUp() {
//    	 // Initialize Extent Reports
//        sparkReporter = new ExtentSparkReporter("extentReport.html");
//        sparkReporter.config().setDocumentTitle("Automation Report");
//        sparkReporter.config().setReportName("Functional Testing");
//        sparkReporter.config().setTheme(Theme.STANDARD);
//
//        extent = new ExtentReports();
//        extent.attachReporter(sparkReporter);
//        extent.setSystemInfo("Host Name", "LocalHost");
//        extent.setSystemInfo("Environment", "QA");
//        extent.setSystemInfo("User Name", "Your Name");
//        driver = new FirefoxDriver();
//        driver.get(readconfig.geturl());
//        driver.manage().window().maximize();
//
//        // Verify page title
//        SoftAssert softAssert = new SoftAssert();
//        String ActualTitle = driver.getTitle();
//        String ExpectedTitle = "DEMOQA";
//        softAssert.assertEquals(ExpectedTitle, ActualTitle, "Page Title Matched");
//
//        String ActualURL = driver.getCurrentUrl();
//        String ExpectedURL = "https://demoqa.com/";
//        softAssert.assertEquals(ExpectedURL, ActualURL, "Current URL Matched");
//
//        softAssert.assertAll();
//    }
//
//    @AfterClass
//    public void tearDown() {
//        if (driver != null) {
//            driver.quit();
//        }
//        extent.flush();
//
//    }
//
//    
//}

package DemoToolsQA_TestCases;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import pageObjects.AllPageObject_WebElements;
import utilities.Generics_Methods;
import utilities.ReadConfig;


public class BaseClass {
	static ReadConfig readconfig = new ReadConfig();

//	static ExtentReports extent;
//    ExtentTest test;
//    static ExtentSparkReporter sparkReporter;
	static ExtentReports extent;
	public static ExtentTest test;
	ExtentReporter sparkReporter;
	public static Logger log;
    static Generics_Methods generics;


	public static WebDriver driver; // driver = new ChromeDriver();

	@BeforeClass
	public static void SetUp() {

		extent = new ExtentReports();
		ExtentHtmlReporter spark = new ExtentHtmlReporter(
				"C:/Users/omkar.swami/eclipse-workspace/demo2/New folder/testReport.html");
		extent.attachReporter(spark);

		// Initialize Extent Reports
		spark.config().setDocumentTitle("Automation Report");
		spark.config().setReportName("Functional Testing");
		extent.setSystemInfo("Host Name", "LocalHost");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("User Name", "Omkar Swami");

		ReadConfig readconfig = new ReadConfig();

		Generics_Methods geMethod = new Generics_Methods(driver);
        driver = geMethod.launchBrowserAndUrl();
		driver.get(readconfig.geturl());

//		driver = new FirefoxDriver();
//		driver.get(readconfig.geturl());
//		driver.manage().window().maximize();
		// verify page title
		SoftAssert softAssert = new SoftAssert();
		String ActualTitle = driver.getTitle();
		String ExpectedTitle = "DEMOQA";
		softAssert.assertEquals(ExpectedTitle, ActualTitle, " Page Title Matched ");
		String ActualURL = driver.getCurrentUrl();
		String ExpectedURL = "https://demoqa.com/";
		softAssert.assertEquals(ExpectedURL, ActualURL, " current URL Matched  ");
		softAssert.assertAll();
		
		// Start ExtentTest
        test = extent.createTest("setUp");
        test.log(Status.INFO, "Initialized WebDriver and navigated to URL");
	}

	@AfterMethod
//	public void getResult(ITestResult result) {
//		if (result.getStatus() == ITestResult.FAILURE) {
//			test.log(Status.FAIL, "Test Case Failed is " + result.getName());
//			test.log(Status.FAIL, "Test Case Failed is " + result.getThrowable());
//		} else if (result.getStatus() == ITestResult.SUCCESS) {
//			test.log(Status.PASS, "Test Case Passed is " + result.getName());
//		} else if (result.getStatus() == ITestResult.SKIP) {
//			test.log(Status.SKIP, "Test Case Skipped is " + result.getName());
//		}
//	}
	
	// or 
//	   public void afterEachTest(ITestResult result) throws IOException {
//        if (result.getStatus() == ITestResult.FAILURE) {
//            test.log(Status.FAIL, "Test Case Failed: " + result.getName());
//            test.log(Status.FAIL, "Failure Reason: " + result.getThrowable());
//            // Capture screenshot on failure
//            String screenshotPath = Generics_Methods.captureScreenshot(driver, result.getName());
//            test.addScreenCaptureFromPath(screenshotPath);
//        } else if (result.getStatus() == ITestResult.SUCCESS) {
//            test.log(Status.PASS, "Test Case Passed: " + result.getName());
//            String screenshotPath = Generics_Methods.captureScreenshot(driver, result.getName());
//            test.addScreenCaptureFromPath(screenshotPath);
//        } else if (result.getStatus() == ITestResult.SKIP) {
//            test.log(Status.SKIP, "Test Case Skipped: " + result.getName());
//        }
//    }
//	
	public void afterEachTest(ITestResult result) throws IOException {
        if (result.getStatus() == ITestResult.FAILURE) {
            test.log(Status.FAIL, "Test Case Failed: " + result.getName());
            test.log(Status.FAIL, "Failure Reason: " + result.getThrowable());
            // Capture screenshot on failure
            String screenshotPath = Generics_Methods.captureFullscreenScreenshot(driver, result.getName());
            if (screenshotPath != null) {
                test.addScreenCaptureFromPath(screenshotPath);
            } else {
                System.err.println("Failed to capture screenshot for failed test: " + result.getName());
            }
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            test.log(Status.PASS, "Test Case Passed: " + result.getName());
            String screenshotPath = Generics_Methods.captureFullscreenScreenshot(driver, result.getName());
            if (screenshotPath != null) {
                test.addScreenCaptureFromPath(screenshotPath);
            } else {
                System.err.println("Failed to capture screenshot for passed test: " + result.getName());
            }
        } else if (result.getStatus() == ITestResult.SKIP) {
            test.log(Status.SKIP, "Test Case Skipped: " + result.getName());
        }
    }
	

	@AfterClass
	public void tearDown() {
		 driver.quit();
		extent.flush();
	}

}
