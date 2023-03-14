package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import qalegend.utils.PageUtility;
import qalegend.utils.Wait;

public class DashboardPage {
WebDriver driver;
public DashboardPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
	this.driver = driver;
}
@FindBy(linkText="User Management") WebElement UserManagementLink;
@FindBy(linkText="Users") WebElement UserLink;
Wait wait=new Wait();
public void navigateToUserPage()
{ wait.implicitWaitforElement(driver,50);
	UserManagementLink.click();
UserLink.click();
	}

}
