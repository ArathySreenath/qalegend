package qalegend;

import java.io.IOException;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import common.functions.BrowserLaunch;
import constants.Constant;
import pages.DashboardPage;
import pages.LoginPage;
import pages.UserPage;
import qalegend.utils.QaDataProvider;
import qalegend.utils.Screenshot;
import qalegend.utils.WaitFunction;

public class UserManagementModule extends BrowserLaunch {
	WaitFunction waitForLoad = new WaitFunction();
	SoftAssert check = new SoftAssert();

	@Test(testName = "TestCase3", dataProvider = "Userdata", dataProviderClass = QaDataProvider.class, groups = "sanityTest")
	public void verifyUserCreationWithValidData(String login_userid, String login_password, String first_name,
			String email, String roleName, String uname, String passwordData, String confirmPassword)
			throws InterruptedException, IOException {
		LoginPage login = new LoginPage(driver);
		DashboardPage dashboard = new DashboardPage(driver);
		UserPage user = new UserPage(driver);
		login.doLogin(login_userid, login_password);
		dashboard.navigateToUserPage();
		user.CreateUser(first_name, email, roleName, uname, passwordData, confirmPassword);
		check.assertTrue(user.successMessage());
		check.assertAll();

	}

	@Test(testName = "TestCase4", priority = 2, dataProvider = "ExistingUserdata", dataProviderClass = QaDataProvider.class)
	public void verifyErrorMessageOnEnteringExistingUsernameInUserCreationPage(String login_userid,
			String login_password, String first_name, String email, String roleName, String uname, String passwordData,
			String confirmPassword) throws InterruptedException {

		LoginPage login = new LoginPage(driver);
		login.doLogin(login_userid, login_password);
		DashboardPage dashboardObject = new DashboardPage(driver);
		dashboardObject.navigateToUserPage();
		UserPage user = new UserPage(driver);
		user.CreateUser(first_name, email, roleName, uname, passwordData, confirmPassword);
		check.assertTrue(user.getErrorMessage());
		check.assertAll();

	}

	@Test(testName = "TestCase5", dataProvider = "searchUser", groups = "regression", dataProviderClass = QaDataProvider.class)
	public void verifySearchUserFunctionality(String login_user, String login_password, String searchValue) {
		LoginPage login = new LoginPage(driver);
		login.doLogin(login_user, login_password);
		DashboardPage dashboard = new DashboardPage(driver);
		UserPage user = new UserPage(driver);
		dashboard.navigateToUserPage();
		user.searchUser(searchValue);
		check.assertTrue(user.getListOfUser(searchValue));
		check.assertAll();

	}

	@Test(testName = "TestCase6", dataProvider = "viewUser", groups = "regression", dataProviderClass = QaDataProvider.class)
	public void verifyViewUserFunctionality(String login_user, String login_password, String searchValue) {
		LoginPage login = new LoginPage(driver);
		login.doLogin(login_user, login_password);
		DashboardPage dashboard = new DashboardPage(driver);
		UserPage user = new UserPage(driver);
		dashboard.navigateToUserPage();
		user.searchUser(searchValue);
		user.viewUser();
		Boolean viewPage = user.getViewUser().isDisplayed();
		check.assertTrue(viewPage);
		check.assertAll();
	}

	@Test(testName = "TestCase7", dataProvider = "cancelDeleteUser", groups = "regression", dataProviderClass = QaDataProvider.class)
	public void verifyUserNotDeletedOnClickingCancelOfConfirmationMessage(String login_user, String login_password,
			String searchValue) throws Exception {
		LoginPage login = new LoginPage(driver);
		login.doLogin(login_user, login_password);
		DashboardPage dashboard = new DashboardPage(driver);
		UserPage user = new UserPage(driver);
		dashboard.navigateToUserPage();
		user.searchUser(searchValue);
		user.deleteUser();
		user.cancelDeleteRequest();
		check.assertTrue(user.getListOfUser(searchValue));
		check.assertAll();

	}

	@Test(testName = "TestCase8", dataProvider = "acceptDeleteRequest", dataProviderClass = QaDataProvider.class)
	public void verifyUserDeletedOnAcceptingConfirmationMessage(String login_user, String login_password,
			String searchValue) throws Exception {
		LoginPage login = new LoginPage(driver);
		login.doLogin(login_user, login_password);
		DashboardPage dashboard = new DashboardPage(driver);
		UserPage user = new UserPage(driver);
		dashboard.navigateToUserPage();
		user.searchUser(searchValue);
		user.deleteUser();
		user.acceptDeleteRequest();
		check.assertTrue(user.getDeleteMessage());
		check.assertAll();

	}

//
	@Test(testName = "TestCase9", dataProvider = "editUserCase", dataProviderClass = QaDataProvider.class)
	public void verifyEditUserFunction(String login_user, String login_password, String searchValue,
			String salesComissionPercentage) throws Exception {
		LoginPage login = new LoginPage(driver);
		login.doLogin(login_user, login_password);
		DashboardPage dashboard = new DashboardPage(driver);
		UserPage user = new UserPage(driver);
		dashboard.navigateToUserPage();
		user.searchUser(searchValue);
		user.editUser(salesComissionPercentage);
		check.assertTrue(user.getUpdateMessage());
		check.assertAll();

	}

	@Test(testName = "TestCase10", dataProvider = "inactiveUser", dataProviderClass = QaDataProvider.class)
	public void verifyInactiveUserCase(String login_user, String login_password, String searchValue, String new_id,
			String new_pwd) throws Exception {
		LoginPage login = new LoginPage(driver);

		login.doLogin(login_user, login_password);
		DashboardPage dashboard = new DashboardPage(driver);
		UserPage user = new UserPage(driver);
		dashboard.navigateToUserPage();
		user.searchUser(searchValue);
		user.inactiveUser();
		dashboard.navigateToHome();
		dashboard.logoutFunction();
		login.doLogin(new_id, new_pwd);
		check.assertEquals(user.getInactiveMessage(), Constant.INACTIVE_USER);
		check.assertAll();

	}
}
