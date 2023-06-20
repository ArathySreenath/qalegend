package qalegend.utils;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {

	public static void enterText(WebElement element, String data) {
		element.clear();
		element.sendKeys(data);
	}

	public static void clickFunction(WebElement element) {
		element.click();

	}

	public static void dropdownSelectByValue(WebElement element, String... subtax) {
		Select select = new Select(element);
		
		for (String options : subtax) {
			select.selectByValue(options);
		}

	}
	public static void dropdownSelectByIndex(WebElement element, int index) {
		Select select = new Select(element);
		
			select.selectByIndex(index);
		

	}


	public static void dropdownSelectByVisibleText(WebElement element, String text) {
		Select select = new Select(element);
		select.selectByVisibleText(text);

	}

	public static void javascriptClick(WebDriver driver, WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
	}

	public static void mediumDelay() throws InterruptedException {
		Thread.sleep(2000);
	}

	public static void clearElement(WebElement element) {
		element.clear();
	}

	public static boolean isDisplay(WebElement element) {
		boolean status = element.isDisplayed();
		return status;
	}

	public static String getElementText(WebElement element) {
		return element.getText();
	}

	public static void actionClickElement(WebElement element, WebDriver driver) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element).click().perform();
	}

	public static void doubleClick(WebElement element, WebDriver driver) {
		Actions actions = new Actions(driver);
		actions.doubleClick(element).perform();
	}

	public static void rightClick(WebElement element, WebDriver driver) {
		Actions actions = new Actions(driver);
		actions.contextClick(element).perform();
	}

	public static Boolean isElementDisplayed(WebElement element) {
		return element.isDisplayed();
	}


	public static boolean isSelected(WebElement element) {
		return element.isSelected();
	}

	public static void alertHandlingaccept(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	
	
	public static boolean isElementEnabled(WebElement element) {
		return element.isEnabled();
	}

}