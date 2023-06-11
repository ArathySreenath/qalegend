package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import qalegend.utils.PageUtility;
import qalegend.utils.WaitFunction;

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
		submit.click();
		
		
	}
	public boolean invalidLogin() {
	boolean userNameDisplay=user.isDisplayed();
	return userNameDisplay;
	
	}
	
		
	}

