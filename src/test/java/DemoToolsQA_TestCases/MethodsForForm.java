package DemoToolsQA_TestCases;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import pageObjects.AllPageObject_WebElements;
import utilities.Generics_Methods;
import utilities.ReadConfig;

public class MethodsForForm extends BaseClass {

	// Read config file
	ReadConfig readconfig = new ReadConfig();
	Generics_Methods genericMethod = new Generics_Methods(driver);
	AllPageObject_WebElements PageElements = new AllPageObject_WebElements(driver);
	SoftAssert softAssert = new SoftAssert();

	public void ActionsOnForm() throws InterruptedException, IOException {

		genericMethod.clickOnWebElement(PageElements.ArrowUpElements);

		// Forms inputs
		genericMethod.clickOnWebElement(PageElements.forms);
		try {
			softAssert.assertTrue(PageElements.forms.isDisplayed(), "Verifying Forms is display ");
			// System.out.println("Verifying Forms is display ");
		} catch (Exception e) {
			e.getMessage();
		}
		genericMethod.clickOnWebElement(PageElements.Practiceforms);
		genericMethod.sendKeysToWebElement(PageElements.FName, readconfig.firstN());
		genericMethod.sendKeysToWebElement(PageElements.LName, readconfig.lastN());
		genericMethod.sendKeysToWebElement(PageElements.email, readconfig.Email());
		 ((JavascriptExecutor)
		 driver).executeScript("arguments[0].style.visibility='hidden';",
		 PageElements.HideIfrmae);
		genericMethod.scrollIntoView(PageElements.gender);
		genericMethod.clickOnWebElement(PageElements.gender);
		genericMethod.sendKeysToWebElement(PageElements.mobileNo, readconfig.MoNo());
		genericMethod.scrollIntoView(PageElements.dOBP);
		genericMethod.clickOnWebElement(PageElements.dOBP);

		// select month
		Select Sm = new Select(PageElements.month);
		Sm.selectByValue("3");
		Thread.sleep(2000);

		// Year
		Select Sm1 = new Select(PageElements.year);
		Sm1.selectByValue("1998");
		Thread.sleep(2000);

		// Day
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("arguments[0].scrollIntoView(true);", PageElements.dayForm);
//		genericMethod.ClickOnWebElement(PageElements.dayForm);
		genericMethod.clickOnWebElement(PageElements.dayForm);

		// Subject

		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(PageElements.Sub));
			genericMethod.sendKeysToWebElement(PageElements.Sub, readconfig.Subject());
			genericMethod.sendKeysKeyboard(PageElements.Sub, Keys.ENTER);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		// Selaect Hobbie
		genericMethod.clickOnWebElement(PageElements.hobbies);
		try {
			softAssert.assertTrue(PageElements.hobbies.isDisplayed(), "Verifying is selected Hobbie ");
			// System.out.println("Verifying is selected Hobbie ");
		} catch (Exception e) {
			e.getMessage();
		}

		// Picture path
		genericMethod.sendKeysToWebElement(PageElements.picture, readconfig.Path());
		// current address
		genericMethod.sendKeysToWebElement(PageElements.currentAdd, readconfig.CurrentAdd());
		// state select
//		try {
//			JavascriptExecutor js = (JavascriptExecutor) driver;
//			js.executeScript("arguments[0].scrollIntoView(true);", PageElements.state);
//			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//			wait.until(ExpectedConditions.elementToBeClickable(PageElements.state));
//			genericMethod.sendkeysWebElement(PageElements.state, readconfig.State());
//			genericMethod.sendKeysKeyboard(PageElements.inputState, Keys.ENTER);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			System.out.println(e.getMessage());
//		}
//
//		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
//		wait1.until(ExpectedConditions.elementToBeClickable(PageElements.selectCity));
//		genericMethod.ClickOnWebElement(PageElements.selectCity);
//		genericMethod.sendKeysKeyboard(PageElements.selectCity, Keys.ENTER);

//
//		genericMethod.sendkeysWebElement(PageElements.city, readconfig.City());
//		genericMethod.sendKeysKeyboard(PageElements.city, Keys.ENTER);

		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("arguments[0].scrollIntoView(true);", PageElements.FormSubmit);
		genericMethod.clickOnWebElement(PageElements.FormSubmit);
		genericMethod.clickOnWebElement(PageElements.close);

		// genericMethod.ClickOnWebElement(PageElements.state);
//		genericMethod.sendkeysWebElement(PageElements.state, readconfig.State());
//		genericMethod.sendKeysKeyboard(PageElements.state, Keys.ENTER);

	}

}
