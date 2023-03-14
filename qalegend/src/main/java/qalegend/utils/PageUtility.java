package qalegend.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageUtility {
	WebDriver driver;
	public static void enterText(WebElement element,String data) {
		element.clear();
		element.sendKeys(data);
	}

}
