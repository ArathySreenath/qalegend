package common.functions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class BrowserLaunch {
	public static WebDriver driver;

	@BeforeMethod(alwaysRun = true)
	public void urlLaunch() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		System.setProperty("webdriver.chrome.driver", "C://SeleniumDrivers//chromedriver.exe");
		driver = new ChromeDriver(options);
		driver.get("https://qalegend.com/billing/public/login");
		driver.manage().window().maximize();

	}
}
