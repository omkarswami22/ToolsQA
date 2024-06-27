package utilities;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import javax.imageio.ImageIO;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

public class Generics_Methods {

	public static WebDriver driver;
	ReadConfig readconfig = new ReadConfig();

	public Generics_Methods(WebDriver driver) {
		this.driver = driver;
	}

	
    private static final String SCREENSHOT_FOLDER = "C:/Users/omkar.swami/eclipse-workspace/demo2/Screenshots/";

    public static String captureFullscreenScreenshot(WebDriver driver, String screenshotName) {
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String screenshotPath = SCREENSHOT_FOLDER + screenshotName + "_" + timestamp + ".png";

        try {
            Robot robot = new Robot();
            Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
            BufferedImage image = robot.createScreenCapture(screenRect);

            File screenshotFile = new File(screenshotPath);
            ImageIO.write(image, "png", screenshotFile);

            System.out.println("Fullscreen snip captured and saved: " + screenshotFile.getAbsolutePath());

            return screenshotPath;
        } catch (AWTException e) {
            System.err.println("AWTException occurred while capturing screenshot: " + e.getMessage());
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("IOException occurred while capturing screenshot: " + e.getMessage());
            e.printStackTrace();
        }

        return null;
    }

//	private static final String SCREENSHOT_FOLDER = "C:/Users/omkar.swami/eclipse-workspace/Demo1/Screenshots/";
//
//	public static String captureScreenshot(WebDriver driver, String screenshotName) {
//		String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
//		String screenshotPath = SCREENSHOT_FOLDER + screenshotName + "_" + timestamp + ".png";
//
//		try {
//			File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//			Path destinationPath = Paths.get(screenshotPath);
//			Files.copy(screenshotFile.toPath(), destinationPath);
//			return screenshotPath;
//		} catch (IOException e) {
//			System.out.println("Failed to capture screenshot: " + e.getMessage());
//			return null;
//		}
//	}

//	// Add a Sequential Number:
//	private static int screenshotCount = 1;
//
//	public static String captureScreenshot(WebDriver driver, String type, String testName) {
//		String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
//		String screenshotName = type + "_" + testName + "_" + timestamp + "_" + screenshotCount + ".png";
//		screenshotCount++;
//
//		// Rest of the method implementation...
//	}
////Include Browser or Platform Information:
//
//	public static String captureScreenshot(WebDriver driver, String type, String testName, String browserName) {
//		String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
//		String screenshotName = type + "_" + testName + "_" + browserName + "_" + timestamp + ".png";
//
//		// Rest of the method implementation...
//	}
//// Use a UUID (Universally Unique Identifier):
//
//	public static String captureScreenshot(WebDriver driver, String type, String testName) {
//		String uuid = UUID.randomUUID().toString();
//		String screenshotName = type + "_" + testName + "_" + uuid + ".png";
//
//		// Rest of the method implementation...
//	}

	// Method to launch the browser and URL
	public WebDriver launchBrowserAndUrl() {
		String browserName = readconfig.BrowserName().toLowerCase().trim(); // Normalize browser name
		System.out.println("Browser Name: " + browserName); // Logging

		switch (browserName) {
		case "firefox":
			driver = new FirefoxDriver();
			break;
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "edge":
			driver = new EdgeDriver();
			break;
		default:
			throw new IllegalArgumentException("Browser " + browserName + " not supported");
		}
		driver.manage().window().maximize();
		driver.get(readconfig.geturl());
		return driver;
	}

	// Method to close the browser
	public void closeBrowser() throws IOException {
		driver.close();
	}

	// Method to navigate back in the current tab
	public void currentTabBackward(WebDriver driver) throws IOException {
		driver.navigate().back();
	}

	// Method to click on a web element with a specified wait time
	public void clickingOnWebElement1(WebDriver driver, WebElement element, long waitTimeInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTimeInSeconds));
		wait.until(ExpectedConditions.elementToBeClickable(element)).click();
	}

	// Method to click on a web element
	public void clickOnWebElement(WebElement element) {
		element.click();
	}

	// Method to perform a double click action on a web element
	public void doubleClick(WebDriver driver, WebElement element) {
		Actions actions = new Actions(driver);
		actions.doubleClick(element).perform();
	}

	// Method to perform a right-click action on a web element
	public void rightClick(WebDriver driver, WebElement element) {
		Actions actions = new Actions(driver);
		actions.contextClick(element).perform();
	}

	// Method to send keys to a web element
	public void sendKeysToWebElement(WebElement element, String text) {
		element.sendKeys(text);
	}

	// Method to verify the title of the current page
	public void verifyTitle(WebDriver driver) {
		SoftAssert softAssert = new SoftAssert();
		String actualTitle = driver.getTitle();
		String expectedTitle = "DEMOQA";
		softAssert.assertEquals(expectedTitle, actualTitle, "Expected title does not match actual title.");
	}

	// Method to switch to a new window and perform actions, then switch back to the
	// original window
	public void newWindow(WebDriver driver) throws InterruptedException {
		String winHandleBefore = driver.getWindowHandle();
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		driver.close();
		driver.switchTo().window(winHandleBefore);
	}

	// Method to select an option from a dropdown list by visible text
	public void selectDropdown(WebElement element, String text) {
		try {
			Select select = new Select(element);
			select.selectByVisibleText(text);
		} catch (Exception e) {
			// Handle exception if needed
		}
	}

	// Method to wait for a web element to be clickable for a specified time
	public WebElement waitForElement(WebElement element, long waitTimeSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTimeSeconds));
		return wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	// Method to send keys to a web element using JavaScript
	public void sendKeysJavaScript(WebElement element, String text) {
		try {
			WebElement ele = waitForElement(element, 20);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].value='" + text + "';", element);
		} catch (Exception e) {
			// Handle exception if needed
		}
	}

	// Method to accept an alert
	public void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	// Method to perform a mouse hover and click action on a web element
	public void mouseHoverAndClickOnElement(WebElement element) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element).click().build().perform();
	}

	// Method to send a key event to a web element
	public void sendKeysKeyboard(WebElement element, Keys key) {
		element.sendKeys(key);
	}

	// Method to scroll into view of a web element
	public void scrollIntoView(WebElement element) {
		if (driver instanceof JavascriptExecutor) {
			JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
			jsExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
		} else {
			throw new IllegalStateException("This driver does not support JavaScript execution");
		}
	}

	// Method to change the visibility of an element
	public void changeVisibility(WebElement element, boolean isVisible) {
		if (driver instanceof JavascriptExecutor) {
			JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
			String visibility = isVisible ? "visible" : "hidden";
			jsExecutor.executeScript("arguments[0].style.visibility='" + visibility + "';", element);
		} else {
			throw new IllegalStateException("This driver does not support JavaScript execution");
		}
	}
}

//package toolsQA_Utilities;
//
//import java.io.IOException;
//import java.time.Duration;
//
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.Keys;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.Select;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.asserts.SoftAssert;
//
//public class Generics_Methods {
//
//	public static WebDriver driver;
//	ReadConfig readconfig = new ReadConfig();
//	public Generics_Methods(WebDriver driver) {
//        this.driver = driver;
//    }
//	// Method to launch the Edge browser with improved readability
//	public void launchFireFoxBrowserAndUrl(boolean name) {
//		// Set the path to the FirefoxDriver driver and navigate to the URL
//		driver = new FirefoxDriver();
//		driver.get(readconfig.geturl());
//		driver.manage().window().maximize();
//	}
//
//	// close browser
//	public void closeBrowser() throws IOException {
//		driver.close();
//	}
//
//	public void CurrentTabBackward(WebDriver driver) throws IOException {
//		driver.navigate().back();
//	}
//
//	// For Click Action
//	public void clickingOnWebElement1(WebDriver driver, WebElement element, long waitTimeInSeconds) {
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTimeInSeconds));
//		wait.until(ExpectedConditions.elementToBeClickable(element)).click();
//	}
//
//	public void ClickOnWebElement(WebElement element) {
//		element.click();
//	}
//
//	// Double Click
//	public void DoubleClick(WebDriver driver, WebElement element) {
//		Actions act1 = new Actions(driver);
//		act1.doubleClick(element).perform();
//	}
//
//	// Right Click
//	public void rightClick(WebDriver driver, WebElement element) {
//		Actions act2 = new Actions(driver);
//		act2.contextClick(element).perform();
//	}
//
//	// For SendKeys Action
//	public void sendkeysWebElement(WebElement element, String text) {
//		// element.click();
//		// element.clear();
//		element.sendKeys(text);
//	}
//
//	// verify title
//	public void VerifyTitle(WebDriver driver) {
//		// verify title
//		SoftAssert softAssert = new SoftAssert();
//		String ActualTitle = driver.getTitle();
//		String ExpectedTitle = "DEMOQA";
//		softAssert.assertEquals(ExpectedTitle, ActualTitle, "ExpectedTitle Match");
//
//	}
//
//	// Switch to new window and perform action on it back to orignal page
//	public void NewWindow(WebDriver driver) throws InterruptedException {
//		// Perform the click operation that opens new window
//		String winHandleBefore = driver.getWindowHandle();
//		// Switch to new window opened
//		for (String winHandle : driver.getWindowHandles()) {
//			driver.switchTo().window(winHandle);
//		}
//		// Perform the actions on new window
//		driver.close();
//		driver.switchTo().window(winHandleBefore);// Again I want to start code this old window
//	}
//
//	// For Dropdownlist
//	public void selectDropdown(WebElement element, String text) {
//		try {
//			Select select = new Select(element);
//			select.selectByVisibleText(text);
//		} catch (Exception e) {
//		}
//	}
//
//	// This method appears to wait for a web element to be clickable for a specified
//	// time
//	public WebElement waitForElement(WebElement elementName, long waitTimeSeconds) {
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTimeSeconds));
//		return wait.until(ExpectedConditions.elementToBeClickable(elementName));
//	}
//
//	public void senKeysJavaScript(WebElement element, String text) {
//
//		try {
//			WebElement ele = waitForElement(element, 20);
//			JavascriptExecutor js = ((JavascriptExecutor) driver);
//			js.executeScript("arguments[0].value='" + text + "';", element);
//
//		} catch (Exception e) {
//
//		}
//	}
//
//	public void acceptAlert(WebDriver driver) {
//		driver.switchTo().alert().accept();
//	}
//
////MouseHoverAndClick
//
//	public void mouseHoverAndClickOnElement(WebElement element) {
//		Actions action = new Actions(driver);
//		action.moveToElement(element).click().build().perform();
//	}
//
//	public void sendKeysKeyboard(WebElement element, Keys enter) {
//		element.sendKeys(Keys.ENTER);
//	}
//
//	public void scrollIntoView(WebElement element) {
//		if (driver instanceof JavascriptExecutor) {
//			JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
//			jsExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
//		} else {
//			throw new IllegalStateException("This driver does not support JavaScript execution");
//		}
//	}
//
//	// Method to change the visibility of an element
//	public void changeVisibility(WebElement element, boolean isVisible) {
//		if (driver instanceof JavascriptExecutor) {
//			JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
//			String visibility = isVisible ? "visible" : "hidden";
//			jsExecutor.executeScript("arguments[0].style.visibility='" + visibility + "';", element);
//		} else {
//			throw new IllegalStateException("This driver does not support JavaScript execution");
//		}
//	}
//}
