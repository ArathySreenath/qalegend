package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import qalegend.utils.PageUtility;
import qalegend.utils.WaitFunction;

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
	@FindBy(xpath = "//button[@class='btn btn-xs btn-danger delete_user_button']")
	WebElement deleteIcon;
	@FindBy(xpath = "//button[contains(text(),'Cancel')]")
	WebElement cancelConfirmationMessage;
	@FindBy(xpath = "//button[contains(text(),'OK')]")
	WebElement acceptConfirmationMessage;
	@FindBy(xpath = "//*[contains(text(),'User added successfully')]")
	WebElement successfulUserMessage;
	@FindBy(css = "label[class='error']")
	WebElement errorMessage;
	@FindAll({ @FindBy(xpath = "//table[@id='users_table']/tbody/tr") })
	List<WebElement> listOfUser;
	@FindAll({ @FindBy(xpath = "//table[@id='users_table']/tbody/tr/td") })
	List<WebElement> userDetail;
	@FindBy(xpath = "//h1[contains(text(),'View User')]")
	WebElement viewUser;
	@FindBy(xpath = "//*[contains(text(),'User deleted successfully')]")
	WebElement deleteMessage;
	@FindBy(xpath = "//*[contains(text(),'Edit')]")
	WebElement editIcon;
	@FindBy(id = "cmmsn_percent")
	WebElement salesCommisionField;
	@FindBy(xpath = "//*[contains(text(),'User updated successfully')]")
	WebElement updateMessage;
	@FindBy(xpath = "//input[@type='checkbox'and @value='active']//following-sibling::ins")
	WebElement activeCheck;
	@FindBy(className = "iCheck-helper")
	WebElement activeSelect;
	@FindBy(xpath = "//*[contains(text(),'Sorry, account is inactive')]")
	WebElement inactiveMessage;
	WaitFunction wait = new WaitFunction();

	public void CreateUser(String first_Name, String email_id, String roleName, String user_Name, String password_text,
			String confirm_Password) {
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

	public void deleteUser() throws Exception {
		deleteIcon.click();
	}

	public void cancelDeleteRequest() throws Exception {
		cancelConfirmationMessage.click();

	}

	public void acceptDeleteRequest() throws Exception {
		acceptConfirmationMessage.click();

	}

	public Boolean getErrorMessage() {
		Boolean checkpoint = false;
		if (errorMessage.getText().equalsIgnoreCase("Invalid username or User already exist")) {
				checkpoint = true;
				
			}
			return checkpoint;
		
	}

	
	public Boolean getListOfUser(String searchValue) {
		Boolean ifPresent = false;
		int rowCount = listOfUser.size();
		int colCount = userDetail.size();
		for (int row = 1; row <= rowCount; row++) {
			for (int col = 1; col <= colCount; col++) {
				WebElement tableData = driver
						.findElement(By.xpath("//table[@id='users_table']/tbody/tr[" + row + "]/td[" + col + "]"));
				if (tableData.getText().equalsIgnoreCase(searchValue)) {
					ifPresent = true;
				}
			}
		}
		return ifPresent;
	}

	


	public WebElement getViewUser() {
		return viewUser;
	}

	public void setViewUser(WebElement viewUser) {
		this.viewUser = viewUser;
	}

	public boolean getDeleteMessage() {
		wait.explicitWaitUntilVisibilityOfElement(driver, deleteMessage, 50);

		return deleteMessage.isDisplayed();
	}

	
	public void editUser(String salesField) {
		editIcon.click();
		PageUtility.enterText(salesCommisionField, salesField);
		submitButton.click();
	}

	public void inactiveUser() throws Exception {
		editIcon.click();
		PageUtility.javascriptClick(driver, activeCheck);
//		JavascriptExecutor executor = (JavascriptExecutor) driver;
//		executor.executeScript("arguments[0].click();", activeCheck);
		submitButton.click();

	}

	public boolean getUpdateMessage() {
		wait.explicitWaitUntilVisibilityOfElement(driver, updateMessage, 50);

		return updateMessage.isDisplayed();
	}


	public String getInactiveMessage() {
		wait.explicitWaitUntilVisibilityOfElement(driver, inactiveMessage, 30);
		return inactiveMessage.getText();
	}

	public void setInactiveMessage(WebElement inactiveMessage) {
		this.inactiveMessage = inactiveMessage;
	}

	public Boolean webTable(String tableId, WebDriver driver, String searchData) {
		List<WebElement> userList = driver.findElements(By.xpath("//table[@id='" + tableId + "']/tbody/tr"));
		Boolean ifPresent = false;
		int rowCount = userList.size();
		int colCount = driver.findElements(By.xpath("//table[@id='" + tableId + "']/tbody/tr/td")).size();
		for (int row = 1; row <= rowCount; row++) {
			for (int col = 1; col <= colCount; col++) {
				WebElement tableData = driver
						.findElement(By.xpath("//table[@id='users_table']/tbody/tr[" + row + "]/td[" + col + "]"));
				if (tableData.getText().equalsIgnoreCase(searchData)) {
					ifPresent = true;
					break;
				}
			}
		}
		return ifPresent;

	}

	public boolean successMessage() {
		wait.explicitWaitUntilVisibilityOfElement(driver, successfulUserMessage, 50);

		return successfulUserMessage.isDisplayed();
	}

}
