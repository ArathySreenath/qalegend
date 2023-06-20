package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import qalegend.utils.PageUtility;
import qalegend.utils.WaitFunction;

public class DashboardPage {
	WebDriver driver;

	public DashboardPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	@FindBy(linkText = "User Management")
	private WebElement userManagementLink;
	@FindBy(linkText = "Users")
	private WebElement userLink;
	@FindBy(linkText = "Roles")
	private WebElement roleLink;
	@FindBy(xpath = "//a[contains(text(),'Sign Out')]")
	private WebElement signOut;
	@FindBy(xpath = "//a[@class='dropdown-toggle']")
	private WebElement loggedInUserName;
	@FindBy(xpath = "//*[contains(text(),'Home')]")
	private WebElement homeLink;
	@FindBy(linkText="Settings")
	private WebElement settingsLink;
	@FindBy(linkText="Tax Rates")
	private WebElement taxRateLink;
	@FindBy(linkText="Payment Accounts")
	private WebElement paymentAccountsLink;
	@FindBy(linkText="List Accounts")
	private WebElement listAccountsLink;
	@FindBy(xpath="//button[contains(text(),'End tour')]")
	private WebElement endTour;
	@FindBy(xpath="//h1[contains(text(),'Welcome')]")
	private WebElement welcomeText;
	@FindBy(xpath="//section[contains(@class,'content-header')]/h1")
	private WebElement welcome;
	@FindBy(linkText="Expenses")
	WebElement expenses;
	@FindBy(linkText = "Add Expenses")
	WebElement addExpense;
	WaitFunction wait = new WaitFunction();

	
	
	public boolean validLogin() {
		boolean welcomeDisplay=welcomeText.isDisplayed();
		return welcomeDisplay;
	}
	
	public void endTourClick(){
		wait.fluentWaitFunction(driver, 50, 5, endTour);
		endTour.click();
	}
	
	public void navigateToUserPage() {
		driver.navigate().refresh();
//		wait.explicitWaitUntilElementIsClickable(driver, userManagementLink, 30);
		userManagementLink.click();
		userLink.click();
	}
	public void navigateToRolePage() {
		wait.implicitWaitforElement(driver, 50);
		userManagementLink.click();
		roleLink.click();
	}

	public void navigateToHome() {
		driver.navigate().refresh();
		wait.explicitWaitUntilVisibilityOfElement(driver, homeLink, 30);
		PageUtility.javascriptClick(driver, homeLink);

	}
	public void navigateToTaxRate()
	{
		PageUtility.clickFunction(settingsLink);
		PageUtility.clickFunction(taxRateLink);
	}
	public void navigateToAccounts()
	{
		PageUtility.clickFunction(paymentAccountsLink);
		PageUtility.clickFunction(listAccountsLink);
	}
	public void navigateToAddExpensePage() {
		PageUtility.clickFunction(expenses);
		PageUtility.clickFunction(addExpense);
	}

	public void logoutFunction() throws Exception {
		wait.explicitWaitUntilVisibilityOfElement(driver, loggedInUserName, 30);
		PageUtility.javascriptClick(driver, loggedInUserName);
//		JavascriptExecutor executor = (JavascriptExecutor) driver;
//		executor.executeScript("arguments[0].click();", loggedInUserName);
		wait.explicitWaitUntilVisibilityOfElement(driver, signOut, 40);
		PageUtility.clickFunction(signOut);

	}
}
