package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import qalegend.utils.PageUtility;
import qalegend.utils.WaitFunction;

public class RolePage {
	WebDriver driver;

	public RolePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	@FindBy(linkText = "Add")
	private WebElement addLink;
	@FindBy(id = "name")
	private WebElement roleName;
	@FindBy(xpath = "//h4[contains(text(),'User')]//parent::div//following-sibling::div[@class='col-md-2']//child::div//child::label//child::div//child::ins")
	private WebElement selectAllUsers;
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement submitButton;
	@FindBy(xpath = "//*[contains(text(),'Role added successfully')]")
	private WebElement roleAddedMessage;
	@FindBy(xpath = "//input[@type='search']")
	private WebElement search;
	@FindBy(linkText = "Edit")
	private WebElement editLink;
	@FindBy(xpath = "//*[contains(text(),'Role updated successfully')]")
	private WebElement roleUpdatedMessage;
	@FindBy(xpath = "//button[contains(text(),'Delete')]")
	private WebElement deleteLink;
	@FindBy(xpath = "//button[contains(text(),'Cancel')]")
	private WebElement cancelDeleteLink;
	@FindBy(xpath = "//button[contains(text(),'OK')]")
	private WebElement acceptDeleteLink;
	@FindBy(xpath = "//table/tbody/tr[1]/td[1]")
	private WebElement verifyDelete;
	@FindBy(xpath = "//*[contains(text(),'Role deleted successfully')]")
	private WebElement roleDeletedMessage;
	@FindBy(xpath = "//*[contains(text(),'No matching records found')]")
	private WebElement noRecordFoundMessage;

	public void addRole(String roleNameData) {
		addLink.click();
		PageUtility.enterText(roleName, roleNameData);
		selectAllUsers.click();
		submitButton.click();
	}

	public void searchRole(String searchData) {
		PageUtility.enterText(search, searchData);
	}

	public void editRole(String roleNameData) {
		editLink.click();
		PageUtility.enterText(roleName, roleNameData);
		submitButton.click();
	}

	public void cancelDeleteConfirmation() {
		deleteLink.click();
		cancelDeleteLink.click();

	}

	public void deleteRole() {
		deleteLink.click();
		WaitFunction wait=new WaitFunction();
		wait.explicitWaitUntilVisibilityOfElement(driver, acceptDeleteLink, 30);
		acceptDeleteLink.click();

	}

	public String getRoleAddedMessage() {
		return roleAddedMessage.getText();
	}

	public String getRoleUpdatedMessage() {
		return roleUpdatedMessage.getText();
	}

	public String getVerifyDelete() {
		return verifyDelete.getText();
	}

	

	public String getRoleDeletedMessage() {
		return roleDeletedMessage.getText();
	}

	public String getNoRecordFoundMessage() {
		return noRecordFoundMessage.getText();
	}

}
