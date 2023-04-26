package qalegend.utils;

import java.time.Duration;
import java.util.function.Function;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitFunction {
	WebDriver driver;

	public void implicitWaitforElement(WebDriver driver, long time) {
		this.driver = driver;
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
	}

	public void explicitWaitUntilVisibilityOfElement(WebDriver driver, WebElement element, long time) {
		this.driver = driver;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	public void explicitWaitUntilElementIsClickable(WebDriver driver, WebElement element, long time) {
		this.driver = driver;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void fluentWaitFunction(WebDriver driver, long time, long pollTime, final WebElement element) {
		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(time))
				.pollingEvery(Duration.ofMillis(pollTime)).ignoring(NoSuchElementException.class);

		fluentWait.until(ExpectedConditions.elementToBeClickable(element));
		
	}
}
