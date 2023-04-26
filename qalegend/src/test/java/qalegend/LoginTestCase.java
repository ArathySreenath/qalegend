package qalegend;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import common.functions.BrowserLaunch;
import constants.Constant;
import pages.LoginPage;
import qalegend.utils.QaDataProvider;
import qalegend.utils.WaitFunction;
import retryAnalyser.Retry;

public class LoginTestCase extends BrowserLaunch {

	@Test(testName = "TestCase1", dataProvider = "testCase1", dataProviderClass = QaDataProvider.class, groups = "sanityTest")
	public void verifyLoginWithValidUsernameAndInvalidPassword(String uname, String password) {

		LoginPage login = new LoginPage(driver);
		login.doLogin(uname, password);
		SoftAssert verify = new SoftAssert();
		verify.assertTrue(login.invalidLogin());
		verify.assertAll();

	}

	@Test(retryAnalyzer = Retry.class, testName = "TestCase2", dataProvider = "testdatavalid", dataProviderClass = QaDataProvider.class, groups = {
			"smokeTest", "sanityTest" })

	public void verifyLoginWithValidUsernameAndValidPassword(String uname, String password) {

		LoginPage login = new LoginPage(driver);
		login.doLogin(uname, password);
		SoftAssert verify = new SoftAssert();
		verify.assertTrue(login.validLogin());
		login.endTourClick();

	}

}
