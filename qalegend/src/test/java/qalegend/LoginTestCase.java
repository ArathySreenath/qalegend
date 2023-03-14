package qalegend;

import java.io.IOException;
import java.time.Duration;
import java.util.function.Function;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import common.functions.BrowserLaunch;
import pages.LoginPage;
import qalegend.utils.DataFile;

public class LoginTestCase extends BrowserLaunch {

	@Test(testName = "TestCase1", priority = 1, dataProvider = "testdata",groups="sanityTest")
	public void verifyLoginWithValidUsernameAndInvalidPassword(String uname, String password) {
		LoginPage login=new LoginPage(driver);
		login.doLogin(uname, password);
		String expectedUrl = "https://qalegend.com/billing/public/login";
		String actualUrl = driver.getCurrentUrl();
		SoftAssert verify = new SoftAssert();
		verify.assertEquals(actualUrl, expectedUrl);
		verify.assertAll();
		
	}

	@Test(testName = "TestCase2", priority = 2, dataProvider = "testdatavalid",groups={"smokeTest","sanityTest"})

	public void verifyLoginWithValidUsernameAndValidPassword(String uname, String password) {
		LoginPage login=new LoginPage(driver);
		login.doLogin(uname, password);
		System.out.println(uname+"   "+password);
		String expectedUrl = "https://qalegend.com/billing/public/home";
		String actualUrl = driver.getCurrentUrl();
		SoftAssert verify = new SoftAssert();
		verify.assertEquals(actualUrl, expectedUrl);
		verify.assertAll();
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(50))
				.pollingEvery(Duration.ofMillis(5)).ignoring(NoSuchElementException.class);
		WebElement buttonClick=wait.until(new Function<WebDriver,WebElement>(){
			
		public WebElement apply(WebDriver driver)
		{
		return driver.findElement(By.xpath("//button[contains(text(),'End tour')]"));
		}
	});
		buttonClick.click();
	}

	@DataProvider(name = "testdata")
	public Object[][] dataRead() throws EncryptedDocumentException, InvalidFormatException, IOException {
		Object[][] obj = DataFile.getDataFromExcel(
				"C:\\Users\\arath\\eclipse-workspace\\qalegend\\src\\main\\resources\\Data\\Logindata.xlsx",
				"invalidlogin");
		return obj;
	}

	@DataProvider(name = "testdatavalid")
	public Object[][] dataReadFunction() throws EncryptedDocumentException, InvalidFormatException, IOException {
		Object[][] obj = DataFile.getDataFromExcel(
				"C:\\Users\\arath\\eclipse-workspace\\qalegend\\src\\main\\resources\\Data\\Logindata.xlsx",
				"validlogin");
		return obj;
	}
}
