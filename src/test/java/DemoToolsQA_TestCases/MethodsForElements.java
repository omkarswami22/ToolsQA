package DemoToolsQA_TestCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.testng.asserts.SoftAssert;

import pageObjects.AllPageObject_WebElements;
import utilities.Generics_Methods;
import utilities.ReadConfig;

public class MethodsForElements extends BaseClass {

	// Read config file
	ReadConfig readconfig = new ReadConfig();
	Generics_Methods genericMethod = new Generics_Methods(driver);
	AllPageObject_WebElements PageElements = new AllPageObject_WebElements(driver);
	SoftAssert softAssert = new SoftAssert();

	public void ActionsOnTextBox() throws InterruptedException, IOException {

		genericMethod.clickOnWebElement(PageElements.clickOnElements);
		// check text box inputs
		try {
			genericMethod.clickOnWebElement(PageElements.textBox);
			softAssert.assertTrue(PageElements.textBox.isDisplayed(), " Verifying Text Box is Display ");
		} catch (Exception e) {
			e.getMessage();
		}
		genericMethod.sendKeysToWebElement(PageElements.Username, readconfig.UserName());
		genericMethod.sendKeysToWebElement(PageElements.Email, readconfig.EmailR());
		genericMethod.sendKeysToWebElement(PageElements.CurrentAdress, readconfig.Current_Adress());
		genericMethod.sendKeysToWebElement(PageElements.permanentAddress, readconfig.PermanentAddress());
		genericMethod.scrollIntoView(PageElements.submit);
		// ((JavascriptExecutor)
		// driver).executeScript("arguments[0].scrollIntoView(true);",
		// PageElements.submit);
		genericMethod.clickOnWebElement(PageElements.submit);

//		Actions act = new Actions(driver);
//		act.moveToElement(PageElements.submit);
//		genericMethod.ClickOnWebElement(PageElements.submit);

		softAssert.assertAll();

	}

	public void ActionsCheckBox() {

		// click on Check Box
		genericMethod.clickOnWebElement(PageElements.CheckBox);
		genericMethod.clickOnWebElement(PageElements.ClickOnToggle);
		genericMethod.clickOnWebElement(PageElements.ClickOnDocumentToggle);
		genericMethod.scrollIntoView(PageElements.ClickOnWorkpaceToggle);
		genericMethod.clickOnWebElement(PageElements.ClickOnWorkpaceToggle);
		genericMethod.clickOnWebElement(PageElements.ClickOnrectToggle);
	}

	public void ActionsRadioButton() {

		// click On Radio Button
		genericMethod.clickOnWebElement(PageElements.RadioButton);
		genericMethod.clickOnWebElement(PageElements.yes);
	}

	public void ActionsOnWebTables() {

		// WebTables
		genericMethod.clickOnWebElement(PageElements.webTable);
		genericMethod.clickOnWebElement(PageElements.table);
		genericMethod.sendKeysToWebElement(PageElements.FirstName, readconfig.FirstName());
		genericMethod.sendKeysToWebElement(PageElements.lastName, readconfig.LastName());
		genericMethod.sendKeysToWebElement(PageElements.emailWebTable, readconfig.EamilForWebTable());
		genericMethod.sendKeysToWebElement(PageElements.age, readconfig.Age());
		genericMethod.sendKeysToWebElement(PageElements.salary, readconfig.Salary());
		genericMethod.sendKeysToWebElement(PageElements.department, readconfig.Department());
		genericMethod.clickOnWebElement(PageElements.SubmitTable);
	}

	public void ActionsOnButton() {

		// Buttons
		genericMethod.clickOnWebElement(PageElements.Buttons);
		genericMethod.doubleClick(driver, PageElements.doubleClick);
		genericMethod.scrollIntoView(PageElements.RightClick);
		genericMethod.rightClick(driver, PageElements.RightClick);
		genericMethod.scrollIntoView(PageElements.NormalClick);
		genericMethod.clickOnWebElement(PageElements.NormalClick);
	}

	public void ActionsOnLinks() {

		// Links
		genericMethod.clickOnWebElement(PageElements.Links);
		genericMethod.changeVisibility(PageElements.fixedbanHide, false);
		genericMethod.scrollIntoView(PageElements.Home);

		genericMethod.clickOnWebElement(PageElements.Home);
		try {
			genericMethod.newWindow(driver);
		} catch (InterruptedException e) {
			e.getMessage();
		}
		genericMethod.clickOnWebElement(PageElements.HomeEs0UW);
		try {
			genericMethod.newWindow(driver);
		} catch (InterruptedException e) {
			e.getMessage();
		}
		genericMethod.scrollIntoView(PageElements.Created);
		genericMethod.clickOnWebElement(PageElements.Created);
		genericMethod.clickOnWebElement(PageElements.NoContent);
		genericMethod.clickOnWebElement(PageElements.Moved);
		genericMethod.clickOnWebElement(PageElements.Unauthorized);
		genericMethod.scrollIntoView(PageElements.NotFound);
		genericMethod.clickOnWebElement(PageElements.Forbidden);
		genericMethod.clickOnWebElement(PageElements.NotFound);
	}

	public void ActionsOnBrokenLinks() {

		// Broken Links
		genericMethod.changeVisibility(PageElements.HideIfrmae, false);
		genericMethod.clickOnWebElement(PageElements.BrokenLinks_Images);
		genericMethod.changeVisibility(PageElements.HideIfrmae, false);
//		((JavascriptExecutor) driver).executeScript("arguments[0].style.visibility='hidden';",
//				PageElements.fixedbanHide);

		try {
			genericMethod.scrollIntoView(PageElements.clickHere);
			genericMethod.clickOnWebElement(PageElements.clickHere);
			genericMethod.currentTabBackward(driver);
		} catch (IOException e) {
			e.getMessage();
		}
		genericMethod.clickOnWebElement(PageElements.BrokenLink);
		try {
			genericMethod.currentTabBackward(driver);
		} catch (IOException e) {
			e.getMessage();
		}

	}

	public void ActionsOnUploadAndDownload() {

		// Upload And Download
		genericMethod.scrollIntoView(PageElements.uploadAndDownload);
		genericMethod.clickOnWebElement(PageElements.uploadAndDownload);
		genericMethod.clickOnWebElement(PageElements.download);
		// genericMethod.ClickOnWebElement(PageElements.upload);
		genericMethod.sendKeysToWebElement(PageElements.upload, readconfig.upload());
	}

	public void ActionsOnDynamicProperties() {
		
		genericMethod.scrollIntoView(PageElements.dynamicElement);
		genericMethod.clickOnWebElement(PageElements.dynamicElement);

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		try {
			genericMethod.clickOnWebElement(PageElements.textBox);
			softAssert.assertTrue(PageElements.enable.isEnabled(), " Verifying is Enabled after 5sec  ");
			softAssert.assertTrue(PageElements.enableColor.isEnabled(), " Verifying is Enabled ");
			softAssert.assertTrue(PageElements.Visible.isEnabled(), " Verifying is Display emement ");
			softAssert.assertAll();

		} catch (Exception e) {
			e.getMessage();
		}
//		boolean a = PageElements.enable.isEnabled();
//		System.out.println(a + " Will enable 5 seconds");
//		boolean b = PageElements.enableColor.isEnabled();
//		System.out.println(b + " Color Change");
//		boolean c = PageElements.Visible.isDisplayed();
//		System.out.println(c + " Visible After 5 Seconds");
		// ((JavascriptExecutor)
		// driver).executeScript("arguments[0].scrollIntoView(true);",
		// PageElements.Home);
		// ((JavascriptExecutor)
		// driver).executeScript("arguments[0].style.visibility='hidden';",
		// PageElements.fixedbanHide);
	}

}
