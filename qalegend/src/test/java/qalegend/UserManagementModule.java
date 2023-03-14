package qalegend;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import common.functions.BrowserLaunch;
import pages.DashboardPage;
import pages.LoginPage;
import pages.UserPage;
import qalegend.utils.DataFile;
import qalegend.utils.Wait;

public class UserManagementModule extends BrowserLaunch {
	Wait waitForLoad = new Wait();
	SoftAssert check = new SoftAssert();
	

	@Test(testName = "TestCase3", priority = 1, dataProvider = "Userdata", groups = "sanityTest")
	public void verifyUserCreationWithValidData(String login_userid, String login_password, String first_name,
			String email, String roleName, String uname, String passwordData, String confirmPassword)
			throws InterruptedException {
		LoginTestCase login = new LoginTestCase();
		DashboardPage dashboard = new DashboardPage(driver);
		UserPage user = new UserPage(driver);
		login.verifyLoginWithValidUsernameAndValidPassword(login_userid, login_password);
		dashboard.navigateToUserPage();
		
		user.CreateUser(first_name, email, roleName, uname, passwordData, confirmPassword);
		WebElement successMessage = driver.findElement(By.xpath("//*[contains(text(),'User added successfully')]"));
		waitForLoad.explicitWaitUntilVisibilityOfElement(driver, successMessage, 50);
		Boolean present = driver.findElement(By.xpath("//*[contains(text(),'User added successfully')]")).isDisplayed();
		check.assertTrue(present);
		check.assertAll();

	}

	@Test(testName = "TestCase4", priority = 2, dataProvider = "ExistingUserdata", groups = "smokeTest")
	public void verifyErrorMessageOnEnteringExistingUsernameInUserCreationPage(String login_userid,
			String login_password, String first_name, String email, String roleName, String uname, String passwordData,
			String confirmPassword) throws InterruptedException {

		LoginTestCase login = new LoginTestCase();
		login.verifyLoginWithValidUsernameAndValidPassword(login_userid, login_password);
		DashboardPage dashboardObject = new DashboardPage(driver);
		dashboardObject.navigateToUserPage();
		UserPage user = new UserPage(driver);
		user.CreateUser(first_name, email, roleName, uname, passwordData, confirmPassword);
		waitForLoad.implicitWaitforElement(driver, 40);
		List<WebElement> validationMessage = driver.findElements(By.xpath("//label[@class='error']"));
		Boolean checkpoint = false;
		for (WebElement message : validationMessage) {
			if (message.getText().equalsIgnoreCase("Invalid username or User already exist")) {
				checkpoint = true;
			}
		}
		check.assertTrue(checkpoint);
		check.assertAll();

	}

	@Test(testName = "TestCase5", dataProvider = "searchUser")
	public void searchUser(String login_user, String login_password, String searchValue) {
		LoginTestCase login = new LoginTestCase();
		DashboardPage dashboard = new DashboardPage(driver);
		UserPage user = new UserPage(driver);
		login.verifyLoginWithValidUsernameAndValidPassword(login_user, login_password);
		dashboard.navigateToUserPage();
		user.searchUser(searchValue);
		Boolean ifPresent = false;
		List<WebElement> userList = driver.findElements(By.xpath("//table[@id='users_table']/tbody/tr"));
		int rowCount = userList.size();
		int colCount = driver.findElements(By.xpath("//table[@id='users_table']/tbody/tr/td")).size();
		for (int row = 1; row <= rowCount; row++) {
			for (int col = 1; col <= colCount; col++) {
				WebElement tableData = driver
						.findElement(By.xpath("//table[@id='users_table']/tbody/tr[" + row + "]/td[" + col + "]"));
				if (tableData.getText().equalsIgnoreCase(searchValue)) {
					ifPresent = true;
				}
			}
		}
		check.assertTrue(ifPresent);
		check.assertAll();
	}
@Test(testName="TestCase6",dataProvider="viewUser")
public void verifyViewUserFunctionality(String login_user,String login_password,String searchValue) {
	LoginTestCase login = new LoginTestCase();
	DashboardPage dashboard = new DashboardPage(driver);
	UserPage user = new UserPage(driver);
	login.verifyLoginWithValidUsernameAndValidPassword(login_user, login_password);
	dashboard.navigateToUserPage();
	user.searchUser(searchValue);
	user.viewUser();
Boolean viewPage=driver.findElement(By.xpath("//h1[contains(text(),'View User')]")).isDisplayed();
check.assertTrue(viewPage);
check.assertAll();
}
	@DataProvider(name = "Userdata")
	public Object[][] dataReadFunction() throws EncryptedDocumentException, InvalidFormatException, IOException {
		Object[][] obj = DataFile.getDataFromExcel(
				"C:\\Users\\arath\\eclipse-workspace\\qalegend\\src\\main\\resources\\Data\\Logindata.xlsx",
				"usercreation");
		return obj;
	}

	@DataProvider(name = "ExistingUserdata")
	public Object[][] dataReadFunctionexisting()
			throws EncryptedDocumentException, InvalidFormatException, IOException {
		Object[][] obj = DataFile.getDataFromExcel(
				"C:\\Users\\arath\\eclipse-workspace\\qalegend\\src\\main\\resources\\Data\\Logindata.xlsx",
				"existingusername");
		return obj;
	}

	@DataProvider(name = "searchUser")
	public Object[][] searchUserData() throws EncryptedDocumentException, InvalidFormatException, IOException {
		Object[][] obj = DataFile.getDataFromExcel(
				"C:\\Users\\arath\\eclipse-workspace\\qalegend\\src\\main\\resources\\Data\\Logindata.xlsx",
				"searchuser");
		return obj;
	}

	@DataProvider(name = "viewUser")
	public Object[][] viewUser() throws EncryptedDocumentException, InvalidFormatException, IOException {
		Object[][] obj = DataFile.getDataFromExcel(
				"C:\\Users\\arath\\eclipse-workspace\\qalegend\\src\\main\\resources\\Data\\Logindata.xlsx",
				"viewUser");
		return obj;
	}

}
