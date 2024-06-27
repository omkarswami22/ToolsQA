package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AllPageObject_WebElements {
	public WebDriver driver;

	// public WebDriver driver;
	public AllPageObject_WebElements(WebDriver driver) {
		// ldriver=rdriver;
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	//
//	// Elements
	@FindBy(xpath = "//h5[text()='Elements']/parent::div/parent::div")
	public WebElement clickOnElements;
	// text box web elements
	@FindBy(xpath = "//span[text()='Text Box']")
	public WebElement textBox;
	@FindBy(xpath = "//input[@id='userName']")
	public WebElement Username;
	@FindBy(xpath = "//input[@type=\"email\"]")
	public WebElement Email;
	@FindBy(xpath = "//textarea[@placeholder=\"Current Address\"]")
	public WebElement CurrentAdress;
	@FindBy(xpath = "//textarea[@id='permanentAddress']")
	public WebElement permanentAddress;
	@FindBy(xpath = "//button[@id='submit']")
	public WebElement submit;

	// click on Check Box Elements
	@FindBy(xpath = "//span[text()='Check Box']")
	public WebElement CheckBox;
	@FindBy(xpath = "(//li//span//button)[1]")
	public WebElement ClickOnToggle;
	@FindBy(xpath = "(//button[@aria-label='Toggle'])[3]")
	public WebElement ClickOnDocumentToggle;
	@FindBy(xpath = "(//button[@class='rct-collapse rct-collapse-btn'])[4]")
	public WebElement ClickOnWorkpaceToggle;
	@FindBy(xpath = "(//span[@class='rct-checkbox'])[5]")
	public WebElement ClickOnrectToggle;

	// Radio Button
	@FindBy(xpath = "//span[text()='Radio Button']")
	public WebElement RadioButton;
	@FindBy(xpath = "//label[text()='Yes']")
	public WebElement yes;

	// Web Table
	@FindBy(xpath = "//span[text()='Web Tables']")
	public WebElement webTable;
	@FindBy(xpath = "//button[text()='Add']")
	public WebElement table;
	@FindBy(xpath = "//input[@id='firstName']")
	public WebElement FirstName;
	@FindBy(xpath = "//input[@id='lastName']")
	public WebElement lastName;
	@FindBy(xpath = "//input[@id='userEmail']")
	public WebElement emailWebTable;
	@FindBy(xpath = "//input[@id='age']")
	public WebElement age;
	@FindBy(xpath = "//input[@id='salary']")
	public WebElement salary;
	@FindBy(xpath = "//input[@id='department']")
	public WebElement department;
	@FindBy(xpath = "//button[@id='submit']")
	public WebElement SubmitTable;

	// Buttons
	@FindBy(xpath = "//li[@id='item-4']")
	public WebElement Buttons;
	@FindBy(xpath = "//button[@id='doubleClickBtn']")
	public WebElement doubleClick;
	@FindBy(xpath = "//button[@id='rightClickBtn']")
	public WebElement RightClick;
	@FindBy(xpath = "//button[text()='Click Me']")
	public WebElement NormalClick;

	// Links
	@FindBy(xpath = "//span[@class='text' and text()='Links']")
	public WebElement Links;
	@FindBy(xpath = "//div [@id='fixedban']")
	public WebElement fixedbanHide;
	@FindBy(xpath = "//a[@id='simpleLink']")
	public WebElement Home;
	@FindBy(xpath = "//a[@id='dynamicLink']")
	public WebElement HomeEs0UW;
	
	@FindBy(xpath = "//a[@id='created']")
	public WebElement Created;
	@FindBy(xpath = "//a[@id='no-content']")
	public WebElement NoContent;
	@FindBy(xpath = "//a[@id='moved']")
	public WebElement Moved;
	@FindBy(xpath = "//a[@id='bad-request']")
	public WebElement BadRequest;
	@FindBy(xpath = "//a[@id='unauthorized']")
	public WebElement Unauthorized;
	@FindBy(xpath = "//a[@id='forbidden']")
	public WebElement Forbidden;
	@FindBy(xpath = "//a[@id='invalid-url']")
	public WebElement NotFound;

	// Broken Links
	@FindBy(xpath = "//iframe[@id='google_ads_iframe_/21849154601,22343295815/Ad.Plus-Anchor_0']")
	public WebElement HideIfrmae;
	@FindBy(xpath = "//span[text()='Broken Links - Images']")
	public WebElement BrokenLinks_Images;
	@FindBy(xpath = "//a[text()='Click Here for Valid Link']")
	public WebElement clickHere;
	@FindBy(xpath = "//a[text()='Click Here for Broken Link']")
	public WebElement BrokenLink;

	// Upload and Download
	@FindBy(xpath = "//span[text()='Upload and Download']")
	public WebElement uploadAndDownload;
	@FindBy(xpath = "//input[@id='uploadFile']")
	public WebElement upload;
	@FindBy(xpath = "//a[@id='downloadButton']")
	public WebElement download;

	// Dynamic properties
	@FindBy(xpath = "//span[text()='Dynamic Properties']")
	public WebElement dynamicElement;
	@FindBy(xpath = "//button[@id='enableAfter']")
	public WebElement enable;
	@FindBy(xpath = "//button[text()='Color Change']")
	public WebElement enableColor;
	@FindBy(xpath = "//button[text()='Visible After 5 Seconds']")
	public WebElement Visible;

	// Forms
	@FindBy(xpath = "(//div[@class='icon'])[1]")
	public WebElement ArrowUpElements;
	@FindBy(xpath = "(//div[@class='icon'])[2]")
	public WebElement forms;
	@FindBy(xpath = "//span[text()='Practice Form']")
	public WebElement Practiceforms;

	// inputs

	@FindBy(xpath = "//input[@id='firstName']")
	public WebElement FName;

	@FindBy(xpath = "//input[@id='lastName']")
	public WebElement LName;

	@FindBy(xpath = "//input[@id='userEmail']")
	public WebElement email;

	@FindBy(xpath = "//label[text()='Male']")
	public WebElement gender;

	@FindBy(xpath = "//input[@id='userNumber']")
	public WebElement mobileNo;

	@FindBy(xpath = "//div[@class='react-datepicker-wrapper']")
	public WebElement dOBP;

	@FindBy(xpath = "//select[@class='react-datepicker__month-select']")
	public WebElement month;
	@FindBy(xpath = "//select[@class='react-datepicker__year-select']")
	public WebElement year;
	@FindBy(xpath = "//*[@id='dateOfBirth']/div[2]/div[2]/div/div/div[2]/div[2]/div[4]/div[3]")
	public WebElement dayForm;
	// new WebDriverWait(getWebDriver(),
	// 10).until(ExpectedConditions.elementToBeClickable(By.xpath("//label[@formcontrolname='reportingDealPermission'
	// and @ng-reflect-name='reportingDealPermission']"))).click();

	@FindBy(xpath = "//input[@id='subjectsInput']")
	// //*[@id='subjectsContainer']
	// div[@class='subjects-auto-complete__value-container
	// subjects-auto-complete__value-container--is-multi css-1hwfws3']
	public WebElement Sub;

	@FindBy(xpath = "//label[text()='Sports']")
	public WebElement hobbies;
	@FindBy(xpath = "//button[text()='Delhi']")
	public WebElement moveToElem;
	@FindBy(xpath = "(//label[text()='Select picture']//following::input)[1]")
	public WebElement picture;
	@FindBy(xpath = "//textarea[@id='currentAddress']")
	public WebElement currentAdd;
	@FindBy(xpath = "(//div[@class=' css-tlfecz-indicatorContainer'])[1]")
	public WebElement state;
	@FindBy(xpath = "//input[@id='react-select-6-input']")
	public WebElement inputState;

	@FindBy(xpath = "//div[text()='Select City']")
	public WebElement selectCity;
	@FindBy(xpath = "//input[@id='react-select-4-input']")
	public WebElement city;
	@FindBy(xpath = "//button[@id='submit']")
	public WebElement FormSubmit;
	@FindBy(xpath = "//button[@id='closeLargeModal']")
	public WebElement close;

	// Aleart frame and window

}
