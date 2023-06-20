package pages;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import qalegend.utils.PageUtility;

public class Expense {
	WebDriver driver;

	public Expense(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	@FindBy(xpath = "//select[@name='location_id']")
	private WebElement businessLocation;

	@FindBy(id = "final_total")
	private WebElement expenseAmount;
	@FindBy(xpath = "//div[@class='form-control file-caption  kv-fileinput-caption']")
	private WebElement uploadFile;
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement save;
	@FindBy(xpath = "//*[contains(text(),'Expense added successfully')]")
	private WebElement successMessage;

	public void addExpense(String locationIndex, String amount) throws Exception {
		PageUtility.dropdownSelectByVisibleText(businessLocation, locationIndex);
		PageUtility.enterText(expenseAmount, amount);
		PageUtility.clickFunction(uploadFile);
		PageUtility.mediumDelay();
		StringSelection str = new StringSelection("C:\\Users\\arath\\Desktop\\Assertion.docx");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
		Robot rb = new Robot();
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_V);
		rb.keyRelease(KeyEvent.VK_CONTROL);
		rb.keyRelease(KeyEvent.VK_V);
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		PageUtility.actionClickElement(save, driver);

	}

	public String getSuccessMessage() {
		return successMessage.getText();
	}
}
