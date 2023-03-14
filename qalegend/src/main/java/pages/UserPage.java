package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import qalegend.utils.PageUtility;
import qalegend.utils.Wait;

public class UserPage {
	WebDriver driver;

	public UserPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	@FindBy(linkText = "Add")
	WebElement AddLink;
	@FindBy(id = "first_name")
	WebElement firstName;
	@FindBy(id = "email")
	WebElement email;
	@FindBy(id = "role")
	WebElement role;
	@FindBy(id = "username")
	WebElement userName;
	@FindBy(id = "password")
	WebElement password;
	@FindBy(name = "confirm_password")
	WebElement confirmPassword;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement submitButton;
	@FindBy(xpath = "//input[@type='search']")
	WebElement search;
	@FindBy(xpath = "//*[contains(text(),'View')]")
	WebElement view;
	Wait wait = new Wait();

	public void CreateUser(String first_Name, String email_id, String roleName, String user_Name, String password_text,
			String confirm_Password) {
		wait.implicitWaitforElement(driver, 50);
		AddLink.click();
		PageUtility.enterText(firstName, first_Name);
		PageUtility.enterText(email, email_id);
		Select select = new Select(role);
		select.selectByVisibleText(roleName);
		PageUtility.enterText(userName, user_Name);
		PageUtility.enterText(password, password_text);
		PageUtility.enterText(confirmPassword, confirm_Password);
		submitButton.click();

	}

	public void searchUser(String searchValue) {

		PageUtility.enterText(search, searchValue);
	}

	public void viewUser() {
		view.click();
	}

}
