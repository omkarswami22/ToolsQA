package DemoToolsQA_TestCases;

import java.io.IOException;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

public class TestCasesForDemoQA extends BaseClass {

	@Test(priority = 0)
	public void TextBox() throws InterruptedException, IOException {
		test = extent.createTest("verify ActionsOnTextBox");
		// Actions on Elements
		MethodsForElements Act = new MethodsForElements();
		Act.ActionsOnTextBox();
		test.log(Status.INFO, "verifyed ActionsOnTextBox sucssecfuly");
	}

	@Test(priority = 1)
	public void ActionsCheckBox() throws InterruptedException, IOException {
		test = extent.createTest("verify ActionsCheckBox");
		// Actions on Elements
		MethodsForElements Act = new MethodsForElements();
		Act.ActionsCheckBox();
		test.log(Status.INFO, "verifyed ActionsCheckBox sucssecfuly");
	}

	@Test(priority = 2)
	public void ActionsRadioButton() throws InterruptedException, IOException {
		test = extent.createTest("verify ActionsRadioButton");

		// Actions on Elements
		MethodsForElements Act = new MethodsForElements();
		Act.ActionsRadioButton();
		test.log(Status.INFO, "verifyed ActionsRadioButton sucssecfuly");
	}

	@Test(priority = 3)
	public void ActionsOnWebTables() throws InterruptedException, IOException {
		test = extent.createTest("verify ActionsOnWebTables");
		// Actions on Elements
		MethodsForElements Act = new MethodsForElements();
		Act.ActionsOnWebTables();
		test.log(Status.INFO, "verifyed ActionsOnWebTables sucssecfuly");

	}

	@Test(priority = 4)
	public void ActionsOnButton() throws InterruptedException, IOException {
		test = extent.createTest("verify ActionsOnButton");

		// Actions on Elements
		MethodsForElements Act = new MethodsForElements();
		Act.ActionsOnButton();
		test.log(Status.INFO, "verifyed ActionsOnButton sucssecfuly");
	}

	@Test(priority = 5)
	public void ActionsOnLinks() throws InterruptedException, IOException {
		test = extent.createTest("verify ActionsOnLinks");

		// Actions on Elements
		MethodsForElements Act = new MethodsForElements();
		Act.ActionsOnLinks();
		test.log(Status.INFO, "verifyed ActionsOnLinks sucssecfuly");
	}

	@Test(priority = 6)
	public void ActionsOnBrokenLinks() throws InterruptedException, IOException {
		test = extent.createTest("verify ActionsOnBrokenLinks");
		// Actions on Elements
		MethodsForElements Act = new MethodsForElements();
		Act.ActionsOnBrokenLinks();
		Act.ActionsOnUploadAndDownload();
		Act.ActionsOnDynamicProperties();
		test.log(Status.INFO, "verifyed ActionsOnBrokenLinks sucssecfuly");

	}

	@Test(priority = 7)
	public void Form() throws InterruptedException, IOException {
		test = extent.createTest("verify ActionsOnForm");
		// Actions on Elements
		MethodsForForm Form = new MethodsForForm();
		Form.ActionsOnForm();
		test.log(Status.INFO, "verifyed MethodsForForm sucssecfuly");

	}

}
