package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import qalegend.utils.PageUtility;
import qalegend.utils.WaitFunction;


public class TaxPage {
	WebDriver driver;

	public TaxPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	@FindBy(id = "name")
	private WebElement nameField;
	@FindBy(id = "amount")
	private WebElement taxRateField;
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement submitButton;
	@FindBy(xpath = "//h3[contains(text(),'All your tax rates')]//parent::div[@class='box-header']//child::div[@class='box-tools']//button")
	private WebElement addTaxRate;
	@FindBy(xpath = "//*[contains(text(),'Tax rate added successfully')]")
	private WebElement successMessage;
	@FindBy(xpath = "//*[contains(text(),'Please fill out this field.')]")
	private WebElement errorMessage;
	@FindBy(xpath = "//div[@id='tax_rates_table_filter']//child::input[@type='search']")
	private WebElement searchTaxRate;
	@FindBy(xpath = "//table[@id='tax_rates_table']//child::tbody//child::tr//child::td//child::button[contains(text(),'Edit')]")
	private 	WebElement editTaxRate;
	@FindBy(xpath = "//*[contains(text(),'Tax rate updated successfully')]")
	private WebElement successUpdateMessage;
	@FindBy(xpath = "//table[@id='tax_rates_table']//child::tbody//child::tr//child::td//child::button[contains(text(),'Delete')]")
	private WebElement deleteTaxRate;
	@FindBy(xpath = "//button[contains(text(),'OK')]")
	private WebElement acceptDeleteConfirmation;
	@FindBy(xpath = "//*[contains(text(),'Tax rate deleted successfully')]")
	private WebElement deleteMessage;
	@FindBy(xpath = "//h3[contains(text(),'Tax groups ( Combination of multiple taxes ) ')]//following-sibling::div//child::button")
	private WebElement addTaxGroup;
	@FindBy(name = "taxes[]")
	private WebElement subtaxSelect;
	@FindBy(xpath = "//*[contains(text(),'Tax group added successfully')]")
	private WebElement taxGroupSuccessMessage;
	@FindBy(xpath = "//*[contains(text(),'This tax rate belongs to some tax groups')]")
	private WebElement unableToDeleteMessage;
	WaitFunction wait = new WaitFunction();

	public void addtaxRate(String name, String taxRate) {
		addTaxRate.click();
		PageUtility.enterText(nameField, name);
		PageUtility.enterText(taxRateField, taxRate);
		submitButton.click();

	}

	public void searchTaxRate(String searchData) {
		PageUtility.enterText(searchTaxRate, searchData);
	}

	public void editTaxRate(String nameFieldData, String taxRateFieldData) {
		editTaxRate.click();
		PageUtility.enterText(nameField, nameFieldData);
		PageUtility.enterText(taxRateField, taxRateFieldData);
		submitButton.click();
	}

	public void deleteTaxRate() {
		deleteTaxRate.click();
		wait.explicitWaitUntilElementIsClickable(driver, acceptDeleteConfirmation, 30);
		acceptDeleteConfirmation.click();

	}

	public void addTaxGroup(String nameData, String subtaxData1, String subtaxData2) {
		addTaxGroup.click();
		PageUtility.enterText(nameField, nameData);
		PageUtility.dropdownSelectByValue(subtaxSelect, subtaxData1, subtaxData2);
		submitButton.click();

	}

	public String validationMessageOnLeavingBlankField(String name, String taxRate) {
		addTaxRate.click();
		PageUtility.enterText(nameField, name);
		PageUtility.enterText(taxRateField, taxRate);
		submitButton.click();
		String message = nameField.getAttribute("validationMessage");
		return message;

	}

	public String validationMessageOnLeavingTaxRateBlank(String name, String taxRate) {
		addTaxRate.click();
		PageUtility.enterText(nameField, name);
		PageUtility.enterText(taxRateField, taxRate);
		submitButton.click();
		String message = taxRateField.getAttribute("validationMessage");
		return message;

	}

	public String getSuccessMessage() {
		wait.explicitWaitUntilVisibilityOfElement(driver, successMessage, 30);
		return successMessage.getText();
	}

	public WebElement getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(WebElement errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getSuccessUpdateMessage() {
		return successUpdateMessage.getText();
	}

	public String getDeleteMessage() {
		return deleteMessage.getText();
	}

	public String getTaxGroupSuccessMessage() {
		return taxGroupSuccessMessage.getText();
	}

	public String getUnableToDeleteMessage() {
		return unableToDeleteMessage.getText();
	}

}
