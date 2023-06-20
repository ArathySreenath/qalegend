package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import qalegend.utils.PageUtility;
import qalegend.utils.WaitFunction;



public class AccountsPage {
	WebDriver driver;

	public AccountsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	@FindBy(xpath = "//button[@class='btn btn-primary btn-modal pull-right']")
	private WebElement addLink;
	@FindBy(id = "name")
	private WebElement accountName;
	@FindBy(id = "account_number")
	private WebElement accountNumber;
	@FindBy(id = "opening_balance")
	private WebElement openingBalance;
	@FindBy(xpath = "//button[contains(text(),'Submit')]")
	private WebElement submit;
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement save;
	@FindBy(xpath = "//*[contains(text(),'Account created successfully')]")
	private WebElement successMessage;
	@FindBy(xpath = "//input[@type='search']")
	private WebElement search;
	@FindBy(xpath = "//button[contains(text(),'Fund Transfer')]")
	private WebElement fundTransferLink;
	@FindBy(xpath = "//button[contains(text(),'Edit')]")
	private WebElement editButton;
	@FindBy(xpath = "//button[contains(text(),'Deposit')]")
	private WebElement depositLink;
	@FindBy(xpath = "//button[@class='btn btn-xs btn-danger close_account']")
	private WebElement closeLink;
	@FindBy(name = "to_account")
	private WebElement transferToAccount;
	@FindBy(name = "amount")
	private WebElement amount;
	@FindBy(name = "operation_date")
	private WebElement date;
	@FindBy(xpath = "//*[contains(text(),'Fund transfered successfully')]")
	private WebElement fundTransferMessage;
	@FindBy(xpath = "//*[contains(text(),'Account updated successfully')]")
	private WebElement accountUpdateMessage;
	@FindBy(xpath = "//*[contains(text(),'Account closed successfully')]")
	private WebElement accountCloseMessage;
	@FindBy(xpath = "//table/tbody/tr/td[4]")
	private WebElement balance;
	@FindBy(xpath = "//table/tbody/tr/td[1]")
	private WebElement searchName;
	@FindBy(xpath = "//button[@class='btn btn-primary']")
	private WebElement submitFundTransfer;
	@FindBy(name = "from_account")
	private WebElement fromAccount;
	@FindBy(xpath = "//button[contains(text(),'Cancel')]")
	private WebElement cancelCloseButton;
	@FindBy(xpath = "//button[contains(text(),'OK')]")
	private WebElement acceptCloseButton;
	@FindBy(xpath = "//table/tbody/tr/td[1]")
	private WebElement accountNameVerify;
	WaitFunction wait = new WaitFunction();

	public void addAccount(String accountNameData, String accountNumberData, String openingBalanceData) {
		addLink.click();
		PageUtility.enterText(accountName, accountNameData);
		wait.explicitWaitUntilVisibilityOfElement(driver, accountNumber, 20);
		PageUtility.enterText(accountNumber, accountNumberData);
		PageUtility.enterText(openingBalance, openingBalanceData);
		save.click();
		wait.explicitWaitUntilVisibilityOfElement(driver, successMessage, 20);
	}

	public void fundTransfer(String searchData, String transferToAccountName, String amountData, String dateOfTransfer)
			throws Exception {
		searchAcc(searchData);
		fundTransferLink.click();
		wait.explicitWaitUntilVisibilityOfElement(driver, transferToAccount, 30);
		PageUtility.dropdownSelectByVisibleText(transferToAccount, transferToAccountName);
		PageUtility.enterText(amount, amountData);
		PageUtility.enterText(date, dateOfTransfer);
		wait.explicitWaitUntilVisibilityOfElement(driver, submit, 40);
		submit.click();

	}

	public void deposit(String amountData, String fromAccountName, String dateOfTransfer) {
		depositLink.click();
		PageUtility.enterText(amount, amountData);
		PageUtility.dropdownSelectByVisibleText(fromAccount, fromAccountName);
		PageUtility.enterText(date, dateOfTransfer);
		submit.click();

	}

	public void searchAcc(String searchData) throws Exception {
		driver.navigate().refresh();
		PageUtility.enterText(search, searchData);
		PageUtility.mediumDelay();

	}

	public void editAccount(String name) {
		editButton.click();
		PageUtility.enterText(accountName, name);
		save.click();

	}

	public void cancelCloseAccount() {
		closeLink.click();
		cancelCloseButton.click();

	}

	public void acceptCloseAccount() {
		closeLink.click();
		wait.explicitWaitUntilVisibilityOfElement(driver, acceptCloseButton, 30);
		acceptCloseButton.click();

	}

	public boolean checkIfCloseAccountDisplayed(String nameData) {
		fundTransferLink.click();
		Select dropdownCheck = new Select(transferToAccount);
		List<WebElement> options = dropdownCheck.getOptions();
		boolean present = false;
		for (int i = 0; i < options.size(); i++) {
			if (options.get(i).getText().equals(nameData)) {
				present = true;
				break;
			}
		}
		return present;
	}

	public String getSuccessMessage() {
		return successMessage.getText();
	}

	public String getFundTransferMessage() {
		return fundTransferMessage.getText();
	}

	public String getBalance() {
		wait.explicitWaitUntilElementIsClickable(driver, balance, 40);
		String balanceAmount = balance.getText();

		StringBuilder balanceBuilder = new StringBuilder(balanceAmount);
		balanceBuilder.deleteCharAt(1);
		String correctedBalance = balanceBuilder.substring(0, 4);
		return correctedBalance;
	}

	

	public String getAccountUpdateMessage() {
		return accountUpdateMessage.getText();
	}

	public String getAccountNameVerify() {
		return accountNameVerify.getText();
	}

	public String getAccountCloseMessage() {
		return accountCloseMessage.getText();
	}

}
