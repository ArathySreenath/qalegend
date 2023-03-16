package common.functions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class BrowserLaunch {
	public static WebDriver driver;

	@Parameters("browserName")
	@BeforeMethod(alwaysRun = true)
	public void urlLaunch(String browserName) {
		switch (browserName) {
		case "chrome":
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			System.setProperty("webdriver.chrome.driver", "C://SeleniumDrivers//chromedriver.exe");
			driver = new ChromeDriver(options);
			break;
		case "firefox":
			System.setProperty("webdriver.gecko.driver", "C://SeleniumDrivers//geckodriver.exe");
			driver = new FirefoxDriver();
			break;
		case "edge":
			System.setProperty("webdriver.edge.driver", "C://SeleniumDrivers//msedgedriver.exe");
			driver = new EdgeDriver();
			break;
		default:
			System.out.println("Invalid browser");
			break;
		}

		driver.get("https://qalegend.com/billing/public/login");
		driver.manage().window().maximize();

	}
}
