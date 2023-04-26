package pages;

import java.util.List;

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
	WebElement addLink;
	@FindBy(id = "name")
	WebElement accountName;
	@FindBy(id = "account_number")
	WebElement accountNumber;
	@FindBy(id = "opening_balance")
	WebElement openingBalance;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement submit;
	@FindBy(xpath = "//*[contains(text(),'Account created successfully')]")
	WebElement successMessage;
	@FindBy(xpath = "//input[@type='search']")
	WebElement search;
	@FindBy(xpath = "//button[contains(text(),'Fund Transfer')]")
	WebElement fundTransferLink;
	@FindBy(xpath = "//button[contains(text(),'Edit')]")
	WebElement editButton;
	@FindBy(xpath = "//button[contains(text(),'Deposit')]")
	WebElement depositLink;
	@FindBy(xpath = "//button[@class='btn btn-xs btn-danger close_account']")
	WebElement closeLink;
	@FindBy(name = "to_account")
	WebElement transferToAccount;
	@FindBy(name = "amount")
	WebElement amount;
	@FindBy(name = "operation_date")
	WebElement date;
	@FindBy(xpath = "//*[contains(text(),'Fund transfered successfully')]")
	WebElement fundTransferMessage;
	@FindBy(xpath = "//*[contains(text(),'Account updated successfully')]")
	WebElement accountUpdateMessage;
	@FindBy(xpath = "//*[contains(text(),'Account closed successfully')]")
	WebElement accountCloseMessage;
	@FindBy(xpath = "//table/tbody/tr/td[4]")
	WebElement balance;
	@FindBy(xpath = "//button[@class='btn btn-primary']")
	WebElement submitFundTransfer;
	@FindBy(name = "from_account")
	WebElement fromAccount;
	@FindBy(xpath = "//button[contains(text(),'Cancel')]")
	WebElement cancelCloseButton;
	@FindBy(xpath = "//button[contains(text(),'OK')]")
	WebElement acceptCloseButton;
	@FindBy(xpath = "//table[@id='other_account_table']/tbody/tr/td[1]")
	WebElement accountNameVerify;
	WaitFunction wait = new WaitFunction();

	public void addAccount(String accountNameData, String accountNumberData, String openingBalanceData) {
		addLink.click();
		PageUtility.enterText(accountName, accountNameData);
		PageUtility.enterText(accountNumber, accountNumberData);
		PageUtility.enterText(openingBalance, openingBalanceData);
		submit.click();
	}

	public void fundTransfer(String searchData, String transferToAccountName, String amountData, String dateOfTransfer)
			throws Exception {
		driver.navigate().refresh();
		PageUtility.enterText(search, searchData);
		fundTransferLink.click();
		wait.explicitWaitUntilVisibilityOfElement(driver, transferToAccount, 30);
		PageUtility.dropdown(transferToAccount, transferToAccountName, driver);
		PageUtility.enterText(amount, amountData);
		PageUtility.enterText(date, dateOfTransfer);
		submit.click();

	}

	public void deposit(String amountData, String fromAccountName, String dateOfTransfer) {
		depositLink.click();
		PageUtility.enterText(amount, amountData);
		PageUtility.dropdown(fromAccount, fromAccountName, driver);
		PageUtility.enterText(date, dateOfTransfer);
		submit.click();

	}

	public void search(String searchData) {
		driver.navigate().refresh();
		PageUtility.enterText(search, searchData);

	}

	public void editAccount(String name) {
		editButton.click();
		PageUtility.enterText(accountName, name);
		submit.click();

	}

	public void cancelCloseAccount() {
		closeLink.click();
		cancelCloseButton.click();

	}

	public void acceptCloseAccount() {
		closeLink.click();
		acceptCloseButton.click();

	}

	public boolean checkIfCloseAccountDisplayed(String nameData) {
		fundTransferLink.click();
		Select dropdownCheck = new Select(transferToAccount);
		List<WebElement> options = dropdownCheck.getOptions();
		boolean present = true;
		for (int i = 0; i < options.size(); i++) {
			if (options.get(i).getText().equals(nameData)) {
				present = false;
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

	public StringBuilder getBalance() {
		String balanceAmount = balance.getText();
		StringBuilder balanceBuilder = new StringBuilder(balanceAmount);
		balanceBuilder.deleteCharAt(1);
		balanceBuilder.substring(0, 4);
		return balanceBuilder;
	}

	public void setBalance(WebElement balance) {
		this.balance = balance;
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