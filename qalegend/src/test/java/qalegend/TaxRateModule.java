package qalegend;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import common.functions.BrowserLaunch;
import constants.Constant;
import pages.DashboardPage;
import pages.TaxPage;
import qalegend.utils.QaDataProvider;
import qalegend.utils.WaitFunction;

public class TaxRateModule extends BrowserLaunch {
	LoginTestCase login = new LoginTestCase();
	SoftAssert check = new SoftAssert();
	WaitFunction wait = new WaitFunction();

	@Test(testName = "TestCase11", dataProviderClass = QaDataProvider.class, dataProvider = "taxRateCreation")
	public void verifyTaxRateCreationOnEnteringValidData(String username, String password, String nameData,
			String taxRateData) {
		DashboardPage dashboard = new DashboardPage(driver);
		TaxPage tax = new TaxPage(driver);
		login.verifyLoginWithValidUsernameAndValidPassword(username, password);
		dashboard.navigateToTaxRate();
		tax.addtaxRate(nameData, taxRateData);
		check.assertEquals(tax.getSuccessMessage(), Constant.TAXRATE_ADDED_SUCCESSFULLY);
		check.assertAll();

	}

	@Test(testName = "TestCase12", dataProviderClass = QaDataProvider.class, dataProvider = "invalidNameTaxRate")
	public void verifyUserIsUnableToAddTaxRateOnLeavingNameFieldBlank(String username, String password, String nameData,
			String taxRateData) {
		DashboardPage dashboard = new DashboardPage(driver);
		TaxPage tax = new TaxPage(driver);
		login.verifyLoginWithValidUsernameAndValidPassword(username, password);
		dashboard.navigateToTaxRate();
		check.assertEquals(tax.validationMessageOnLeavingBlankField(nameData, taxRateData),
				Constant.PLEASE_FILL_OUT_THIS_FIELD);
		check.assertAll();
	}

	@Test(testName = "TestCase13", dataProviderClass = QaDataProvider.class, dataProvider = "invalidTaxRate")
	public void verifyUserIsUnableToAddTaxRateOnLeavingTaxRateFieldBlank(String username, String password,
			String nameData, String taxRateData) {
		DashboardPage dashboard = new DashboardPage(driver);
		TaxPage tax = new TaxPage(driver);
		login.verifyLoginWithValidUsernameAndValidPassword(username, password);
		dashboard.navigateToTaxRate();
		check.assertEquals(tax.validationMessageOnLeavingTaxRateBlank(nameData, taxRateData),
				Constant.PLEASE_FILL_OUT_THIS_FIELD);
		check.assertAll();

	}

	@Test(testName = "TestCase14", dataProviderClass = QaDataProvider.class, dataProvider = "editTaxRate")
	public void verifyUserIsAbleToEditTaxRateSuccessfully(String username, String password, String search,
			String nameData, String taxRateData) {
		DashboardPage dashboard = new DashboardPage(driver);
		TaxPage tax = new TaxPage(driver);
		login.verifyLoginWithValidUsernameAndValidPassword(username, password);
		dashboard.navigateToTaxRate();
		tax.searchTaxRate(search);
		tax.editTaxRate(nameData, taxRateData);
		check.assertEquals(tax.getSuccessUpdateMessage(), Constant.TAXRATE_UPDATED_SUCCESSFULLY);
		check.assertAll();

	}

	@Test(testName = "TestCase15", dataProviderClass = QaDataProvider.class, dataProvider = "deleteTaxRate")
	public void verifyUserIsAbleToDeleteTaxRateSuccessfully(String username, String password, String search) {
		DashboardPage dashboard = new DashboardPage(driver);
		TaxPage tax = new TaxPage(driver);
		login.verifyLoginWithValidUsernameAndValidPassword(username, password);
		dashboard.navigateToTaxRate();
		tax.searchTaxRate(search);
		tax.deleteTaxRate();
		check.assertEquals(tax.getDeleteMessage(), Constant.TAXRATE_DELETED_SUCCESSFULLY);
		check.assertAll();

	}

	@Test(testName = "TestCase16", dataProviderClass = QaDataProvider.class, dataProvider = "addTaxGroup")
	public void verifyUserIsAbleToAddTaxGroupSuccessfully(String username, String password, String name, String subtax1,
			String subtax2) {
		DashboardPage dashboard = new DashboardPage(driver);
		TaxPage tax = new TaxPage(driver);
		login.verifyLoginWithValidUsernameAndValidPassword(username, password);
		dashboard.navigateToTaxRate();
		tax.addTaxGroup(name, subtax1, subtax2);
		check.assertEquals(tax.getTaxGroupSuccessMessage(), Constant.TAXGROUP_ADDED_SUCCESSFULLY);
		check.assertAll();

	}

	@Test(testName = "TestCase17", dataProviderClass = QaDataProvider.class, dataProvider = "testcase17")
	public void verifyTaxRateUsedInTaxGroupCannotBeDeleted(String username, String password, String taxRateName) {
		DashboardPage dashboard = new DashboardPage(driver);
		TaxPage tax = new TaxPage(driver);
		login.verifyLoginWithValidUsernameAndValidPassword(username, password);
		dashboard.navigateToTaxRate();
		tax.searchTaxRate(taxRateName);
		tax.deleteTaxRate();
		check.assertEquals(tax.getUnableToDeleteMessage(), Constant.TAXRATE_BELONGS_TO_SOME_TAXGROUP);
		check.assertAll();

	}
}
