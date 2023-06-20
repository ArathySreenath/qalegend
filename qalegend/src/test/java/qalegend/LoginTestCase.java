package qalegend;

import java.io.File;
import java.io.IOException;
import qalegend.utils.*;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import common.functions.BrowserLaunch;
import constants.Constant;
import pages.DashboardPage;
import pages.LoginPage;
import retryAnalyser.Retry;

public class LoginTestCase extends BrowserLaunch {

	@Test(testName = "TestCase1", dataProvider = "testCase1", dataProviderClass = QaDataProvider.class )
	public void verifyLoginWithValidUsernameAndInvalidPassword(String uname, String password) {

		LoginPage login = new LoginPage(driver);
		login.doLogin(uname, password);
		SoftAssert verify = new SoftAssert();
		verify.assertTrue(login.invalidLogin());
		verify.assertAll();

	}

	@Test(retryAnalyzer = Retry.class, testName = "TestCase2", dataProvider = "testdatavalid", dataProviderClass = QaDataProvider.class)

	public void verifyLoginWithValidUsernameAndValidPassword(String uname, String password) {

		LoginPage login = new LoginPage(driver);
		DashboardPage dashboard=new DashboardPage(driver);
		login.doLogin(uname, password);
		SoftAssert verify = new SoftAssert();
		verify.assertTrue(dashboard.validLogin());
		dashboard.endTourClick();

	}


}
