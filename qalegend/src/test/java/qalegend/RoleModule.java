package qalegend;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import common.functions.BrowserLaunch;
import constants.Constant;
import pages.DashboardPage;
import pages.LoginPage;
import pages.RolePage;
import pages.TaxPage;
import qalegend.utils.QaDataProvider;
import qalegend.utils.WaitFunction;

public class RoleModule extends BrowserLaunch {
	SoftAssert check = new SoftAssert();
	WaitFunction wait = new WaitFunction();

	@Test(testName = "TestCase18", dataProvider = "testcase18", dataProviderClass = QaDataProvider.class)
	public void verifyAddRoleFunction(String username, String password,String roleName) {
		
		DashboardPage dashboard = new DashboardPage(driver);
		LoginPage login = new LoginPage(driver);
		login.doLogin(username, password);
		dashboard.endTourClick();
		dashboard.navigateToRolePage();
		RolePage role = new RolePage(driver);
		role.addRole(roleName);
		check.assertEquals(role.getRoleAddedMessage(), Constant.ROLE_ADDED_SUCCESSFULLY);
		check.assertAll();

	}

	@Test(testName = "TestCase19", dataProvider = "testCase19", dataProviderClass = QaDataProvider.class)
	public void verifyEditRoleFunction(String username, String password, String searchData, String updateField) {
		DashboardPage dashboard = new DashboardPage(driver);
		LoginPage login = new LoginPage(driver);
		login.doLogin(username, password);
		dashboard.endTourClick();
		dashboard.navigateToRolePage();
		RolePage role = new RolePage(driver);
		role.searchRole(searchData);
		role.editRole(updateField);
		check.assertEquals(role.getRoleUpdatedMessage(), Constant.ROLE_UPDATED_SUCCESSFULLY);
		check.assertAll();

	}
	@Test(testName = "testCase20", dataProvider = "testCase20",groups="smokeTest", dataProviderClass = QaDataProvider.class)
	public void verifyValidationMessageShownOnSearchingANonExistingRoleName(String username, String password, String searchData) {
		DashboardPage dashboard = new DashboardPage(driver);
		LoginPage login = new LoginPage(driver);
		login.doLogin(username, password);	
		dashboard.endTourClick();
		dashboard.navigateToRolePage();
		RolePage role = new RolePage(driver);
		role.searchRole(searchData);
		check.assertEquals(role.getNoRecordFoundMessage(), Constant.NO_MATCHING_RECORD);
		check.assertAll();

	}

	@Test(testName = "TestCase21", dataProvider = "testcase21",groups="smokeTest", dataProviderClass = QaDataProvider.class)
	public void verifyUserIsNotAbleToDeleteRoleIfConfirmationMessageIsCancelled(String username, String password,
			String searchData) {
		DashboardPage dashboard = new DashboardPage(driver);
		LoginPage login = new LoginPage(driver);
		login.doLogin(username, password);	
		dashboard.endTourClick();
		dashboard.navigateToRolePage();
		RolePage role = new RolePage(driver);
		role.searchRole(searchData);
		role.cancelDeleteConfirmation();
		role.searchRole(searchData);
		check.assertEquals(role.getVerifyDelete(), searchData);
		check.assertAll();

	}
	@Test(testName = "TestCase22", dataProvider = "testcase22", dataProviderClass = QaDataProvider.class)
	public void verifyUserIsAbleToDeleteRoleOnAcceptingConfirmationMessage(String username, String password,
			String searchData) {
		DashboardPage dashboard = new DashboardPage(driver);
		LoginPage login = new LoginPage(driver);
		login.doLogin(username, password);
		dashboard.endTourClick();
		dashboard.navigateToRolePage();
		RolePage role = new RolePage(driver);
		role.searchRole(searchData);
		role.deleteRole();
		check.assertEquals(role.getRoleDeletedMessage(), Constant.ROLE_DELETED_SUCCESSFULLY);
		check.assertAll();

	}

}
