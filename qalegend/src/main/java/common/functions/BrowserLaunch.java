package common.functions;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import constants.Constant;
import qalegend.utils.Screenshot;
import qalegend.utils.WaitFunction;

public class BrowserLaunch {
	public WebDriver driver;
	public Properties property;

	@Parameters("browserName")
	@BeforeMethod(alwaysRun = true)
	public void urlLaunch( @Optional("chrome")String browserName) throws Exception {
		property = new Properties();
		FileInputStream input = new FileInputStream(System.getProperty("user.dir") + Constant.CONFIGfILE);
		property.load(input);
		if(browserName.equals("chrome")) {

			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			System.setProperty(Constant.CHROMEDRIVER, property.getProperty("chromefilePath"));
			driver = new ChromeDriver(options);
		}
		else if(browserName.equals("firefox")) {
			System.setProperty(Constant.FRIREFOXDRIVER, property.getProperty("firefoxfilePath"));
			driver = new FirefoxDriver();
		}
			
		else if(browserName.equals("edge")) {
			System.setProperty(Constant.EDGEDRIVER, property.getProperty("edgefilePath"));
			driver = new EdgeDriver();
		}
		else {
			System.out.println("No browser specified");
			
			
		}
		WaitFunction wait = new WaitFunction();
		wait.implicitWaitforElement(driver, 30);
		driver.get(property.getProperty("url"));
		driver.manage().window().maximize();

	}

	@AfterMethod
	public void tearDown(ITestResult Result) throws Exception {
		if (Result.getStatus() == ITestResult.FAILURE) {
		System.out.println("tear" + driver);
		Screenshot screenshotCapture = new Screenshot();
		screenshotCapture.takeScreenshot(driver);
		}

		driver.close();
	}
}
