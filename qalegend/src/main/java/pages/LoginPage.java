package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import qalegend.utils.PageUtility;

public class LoginPage {
	WebDriver driver;

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	@FindBy(id="username")
	WebElement user;
	@FindBy(id="password")
	WebElement password;
	@FindBy(css="button[type='submit']")
	WebElement submit;
	public void doLogin(String uname,String pwd) {
		PageUtility.enterText(user, uname);
		PageUtility.enterText(password, pwd);
//		user.sendKeys(uname);
//		password.sendKeys(pwd);
		submit.click();
		
	}
}
