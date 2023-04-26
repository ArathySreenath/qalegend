package qalegend;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import common.functions.BrowserLaunch;
import constants.Constant;
import pages.AccountsPage;
import pages.DashboardPage;
import pages.TaxPage;
import qalegend.utils.QaDataProvider;
import qalegend.utils.WaitFunction;

public class PaymentAccountModule extends BrowserLaunch {
	LoginTestCase login = new LoginTestCase();
	SoftAssert check = new SoftAssert();
	WaitFunction wait = new WaitFunction();

	@Test(testName = "TestCase23", dataProviderClass = QaDataProvider.class, dataProvider = "testcase23")
	public void verifyUserIsAbleToAddAccountSuccessfully(String username, String password, String nameData,
			String accNum, String openBalance) {
		DashboardPage dashboard = new DashboardPage(driver);
		AccountsPage accounts = new AccountsPage(driver);
		login.verifyLoginWithValidUsernameAndValidPassword(username, password);
		dashboard.navigateToAccounts();
		accounts.addAccount(nameData, accNum, openBalance);
		check.assertEquals(accounts.getSuccessMessage(), Constant.ACCOUNT_CREATION_MESSAGE);
		check.assertAll();

	}

	@Test(testName = "TestCase24", dataProviderClass = QaDataProvider.class, dataProvider = "testcase24")
	public void verifyUserIsAbleToTransferFundSuccessfully(String username, String password, String searchData,
			String transferTo, String amount, String date) throws Exception {
		DashboardPage dashboard = new DashboardPage(driver);
		AccountsPage accounts = new AccountsPage(driver);
		login.verifyLoginWithValidUsernameAndValidPassword(username, password);
		dashboard.navigateToAccounts();
		accounts.fundTransfer(searchData, transferTo, amount, date);
		check.assertEquals(accounts.getFundTransferMessage(), Constant.FUND_TRANSFERRED_MESSAGE);
		check.assertAll();

	}

	@Test(testName = "TestCase25", dataProviderClass = QaDataProvider.class, dataProvider = "testcase25")
	public void verifyBalanceShownInPaymentAccountsPageIsCorrect(String username, String password, String nameData,
			String accNum, String openBalance, String searchData, String transferTo, String amount, String date,
			String balance) throws Exception {
		DashboardPage dashboard = new DashboardPage(driver);
		AccountsPage accounts = new AccountsPage(driver);
		login.verifyLoginWithValidUsernameAndValidPassword(username, password);
		dashboard.navigateToAccounts();
		accounts.addAccount(nameData, accNum, openBalance);
		accounts.fundTransfer(searchData, transferTo, amount, date);
		accounts.search(searchData);
		check.assertEquals(accounts.getBalance(), balance);
		check.assertAll();

	}

	@Test(testName = "testCase26", dataProviderClass = QaDataProvider.class, dataProvider = "testCase26")
	public void verifyBalanceIncreasesWithDeposits(String username, String password, String searchData, String amount,
			String transferFrom, String date, String balance) throws Exception {
		DashboardPage dashboard = new DashboardPage(driver);
		AccountsPage accounts = new AccountsPage(driver);
		login.verifyLoginWithValidUsernameAndValidPassword(username, password);
		dashboard.navigateToAccounts();
		accounts.search(searchData);
		accounts.deposit(amount, transferFrom, date);
		accounts.search(searchData);
		check.assertEquals(accounts.getBalance(), balance);
		check.assertAll();

	}

	@Test(testName = "testCase27", dataProviderClass = QaDataProvider.class, dataProvider = "testCase27")
	public void verifyAccountCanBeEditedSuccessfully(String username, String password, String searchData, String name) {
		DashboardPage dashboard = new DashboardPage(driver);
		AccountsPage accounts = new AccountsPage(driver);
		login.verifyLoginWithValidUsernameAndValidPassword(username, password);
		dashboard.navigateToAccounts();
		accounts.search(searchData);
		accounts.editAccount(name);
		check.assertEquals(accounts.getAccountUpdateMessage(), Constant.ACCOUNT_UPDATED_MESSAGE);
		check.assertAll();

	}

	@Test(testName = "testCase28", dataProviderClass = QaDataProvider.class, dataProvider = "testCase28")
	public void verifyUserIsNotAbleToCloseAccountOnCancellingConfirmationPopUp(String username, String password,
			String searchData) {
		DashboardPage dashboard = new DashboardPage(driver);
		AccountsPage accounts = new AccountsPage(driver);
		login.verifyLoginWithValidUsernameAndValidPassword(username, password);
		dashboard.navigateToAccounts();
		accounts.search(searchData);
		accounts.cancelCloseAccount();
		accounts.search(searchData);
		check.assertEquals(accounts.getAccountNameVerify(), searchData);
		check.assertAll();

	}

	@Test(testName = "testCase29", dataProviderClass = QaDataProvider.class, dataProvider = "testCase29")
	public void verifyUserIsAbleToCloseAccountOnAcceptingConfirmationPopUp(String username, String password,
			String searchData) {
		DashboardPage dashboard = new DashboardPage(driver);
		AccountsPage accounts = new AccountsPage(driver);
		login.verifyLoginWithValidUsernameAndValidPassword(username, password);
		dashboard.navigateToAccounts();
		accounts.search(searchData);
		accounts.acceptCloseAccount();

		check.assertEquals(accounts.getAccountCloseMessage(), Constant.ACCOUNT_CLOSED_MESSAGE);
		check.assertAll();

	}

	@Test(testName = "testCase30", dataProviderClass = QaDataProvider.class, dataProvider = "testCase30")
	public void verifyClosedAccountsAreNotDisplayedForFundTransferTOAccountDropdown(String username, String password,
			String searchData, String closeAccount) {
		DashboardPage dashboard = new DashboardPage(driver);
		AccountsPage accounts = new AccountsPage(driver);
		login.verifyLoginWithValidUsernameAndValidPassword(username, password);
		dashboard.navigateToAccounts();
		accounts.search(searchData);
		boolean ifPresent = accounts.checkIfCloseAccountDisplayed(closeAccount);
		check.assertFalse(ifPresent);
		check.assertAll();

	}

}
