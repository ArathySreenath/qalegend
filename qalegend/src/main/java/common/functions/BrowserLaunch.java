package common.functions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import constants.Constant;
import qalegend.utils.Screenshot;
import qalegend.utils.WaitFunction;

public class BrowserLaunch {
	public WebDriver driver;
	public  Properties property;

	@Parameters("browserName")
	@BeforeMethod(alwaysRun = true)
	public void urlLaunch(String browserName) throws Exception {
		property = new Properties();
		FileInputStream input = new FileInputStream(System.getProperty("user.dir") + Constant.CONFIGfILE);
		property.load(input);
		switch (browserName) {

		case "chrome":
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			System.setProperty(Constant.CHROMEDRIVER, property.getProperty("chromefilePath"));
			driver = new ChromeDriver(options);
			break;
		case "firefox":
			System.setProperty(Constant.FRIREFOXDRIVER, property.getProperty("firefoxfilePath"));
			driver = new FirefoxDriver();
			break;
		case "edge":
			System.setProperty(Constant.EDGEDRIVER, property.getProperty("edgefilePath"));
			driver = new EdgeDriver();
			break;
		default:
			System.out.println("Invalid browser");
			break;
		}
		WaitFunction wait = new WaitFunction();
		wait.implicitWaitforElement(driver, 30);
		driver.get(property.getProperty("url"));
		driver.manage().window().maximize();

	}

	@AfterMethod
	public void tearDown() throws Exception {
		WaitFunction wait = new WaitFunction();
		wait.implicitWaitforElement(driver, 40);
//		Screenshot.takeScreenshot();
		driver.close();
	}
}
