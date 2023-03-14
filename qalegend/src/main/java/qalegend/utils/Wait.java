package qalegend.utils;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Wait {
 WebDriver driver;
public void implicitWaitforElement(WebDriver driver,long time) {
	this.driver=driver;
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
}
public void explicitWaitUntilVisibilityOfElement(WebDriver driver,WebElement element,long time) {
	this.driver=driver;
	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(time));
	wait.until(ExpectedConditions.visibilityOf(element));
}
}
