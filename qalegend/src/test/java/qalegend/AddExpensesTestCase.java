package qalegend;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import common.functions.BrowserLaunch;
import constants.Constant;
import pages.DashboardPage;
import pages.Expense;
import pages.LoginPage;
import qalegend.utils.QaDataProvider;

public class AddExpensesTestCase extends BrowserLaunch {
	LoginPage login;
	DashboardPage dashboard;
	Expense expense;
	
	@Test(testName = "TestCase31", dataProviderClass = QaDataProvider.class, dataProvider = "testCase31")

	public void verifyIfUserIsAbleToAddExpensSuccessfully(String uname,String password,String location,String amount) throws Exception {
		login = new LoginPage(driver);
		login.doLogin(uname, password);
		 dashboard = new DashboardPage(driver);
		dashboard.endTourClick();
		dashboard.navigateToAddExpensePage();
		expense=new Expense(driver);
		expense.addExpense(location,  amount);
	SoftAssert  verify=new SoftAssert();
	verify.assertEquals(expense.getSuccessMessage(), Constant.ADD_EXPENSE_SUCCESSFULLY);
	verify.assertAll();
		
	}

}
