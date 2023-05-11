package qalegend.utils;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {
	WebDriver driver;


	public static void enterText(WebElement element, String data) {
		element.clear();
		element.sendKeys(data);
	}

	public static void clickFunction(WebElement element) {
		element.click();
		
	}

	public static void dropdownSelect(WebElement element, String subtax1, String subtax2) {
		Select select = new Select(element);
		select.selectByVisibleText(subtax1);
		select.selectByVisibleText(subtax2);

	}

	public static void dropdown(WebElement element, String value,WebDriver driver) {
		Select select = new Select(element);
//		WaitFunction waitFor=new WaitFunction();
//		waitFor.implicitWaitforElement(driver, 30);

		select.selectByVisibleText(value);

	}

	public static void javascriptClick(WebDriver driver, WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
	}

	public static void mediumDelay() throws InterruptedException
	{
		Thread.sleep(2000);
	}

	
}