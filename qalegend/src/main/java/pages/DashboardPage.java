package pages;

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
	WebElement userManagementLink;
	@FindBy(linkText = "Users")
	WebElement userLink;
	@FindBy(linkText = "Roles")
	WebElement roleLink;
	@FindBy(xpath = "//a[contains(text(),'Sign Out')]")
	WebElement signOut;
	@FindBy(xpath = "//a[@class='dropdown-toggle']")
	WebElement loggedInUserName;
	@FindBy(xpath = "//*[contains(text(),'Home')]")
	WebElement homeLink;
	@FindBy(linkText="Settings")
	WebElement settingsLink;
	@FindBy(linkText="Tax Rates")
	WebElement taxRateLink;
	@FindBy(linkText="Payment Accounts")
	WebElement paymentAccountsLink;
	@FindBy(linkText="List Accounts")
	WebElement listAccountsLink;
	
	WaitFunction wait = new WaitFunction();

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

	public void logoutFunction() throws Exception {
		wait.explicitWaitUntilVisibilityOfElement(driver, loggedInUserName, 30);
		PageUtility.javascriptClick(driver, loggedInUserName);
//		JavascriptExecutor executor = (JavascriptExecutor) driver;
//		executor.executeScript("arguments[0].click();", loggedInUserName);
		wait.explicitWaitUntilVisibilityOfElement(driver, signOut, 40);
		PageUtility.clickFunction(signOut);

	}
}
