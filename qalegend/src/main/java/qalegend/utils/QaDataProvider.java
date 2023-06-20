package qalegend.utils;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.DataProvider;

import constants.Constant;

public class QaDataProvider {
	@DataProvider(name = "testCase1")
	public static Object[][] dataRead() throws EncryptedDocumentException, InvalidFormatException, IOException {

		Object[][] obj = DataReader.getDataFromExcel(Constant.DATAREADERPATH,
				"invalidlogin");
		return obj;
	}
	@DataProvider(name = "testdatavalid")
	public Object[][] dataReadFunction() throws EncryptedDocumentException, InvalidFormatException, IOException {
		Object[][] obj = DataReader.getDataFromExcel(Constant.DATAREADERPATH,
				"validlogin");
		return obj;
	}
	@DataProvider(name = "Userdata")
	public Object[][] Userdata() throws EncryptedDocumentException, InvalidFormatException, IOException {
		Object[][] obj = DataReader.getDataFromExcel( Constant.DATAREADERPATH,
				"usercreation");
		return obj;
	}

	@DataProvider(name = "ExistingUserdata")
	public Object[][] dataReadFunctionexisting()
			throws EncryptedDocumentException, InvalidFormatException, IOException {
		Object[][] obj = DataReader.getDataFromExcel(Constant.DATAREADERPATH,
				"existingusername");
		return obj;
	}

	@DataProvider(name = "searchUser")
	public Object[][] searchUserData() throws EncryptedDocumentException, InvalidFormatException, IOException {
		Object[][] obj = DataReader.getDataFromExcel(Constant.DATAREADERPATH,
				"searchuser");
		return obj;
	}

	@DataProvider(name = "viewUser")
	public Object[][] viewUser() throws EncryptedDocumentException, InvalidFormatException, IOException {
		Object[][] obj = DataReader.getDataFromExcel(Constant.DATAREADERPATH, "viewUser");
		return obj;
	}

	@DataProvider(name = "cancelDeleteUser")
	public Object[][] cancelDeleteUser() throws EncryptedDocumentException, InvalidFormatException, IOException {
		Object[][] obj = DataReader.getDataFromExcel(Constant.DATAREADERPATH,
				"cancelDeleteUser");
		return obj;
	}
	@DataProvider(name = "acceptDeleteRequest")
	public Object[][] acceptDeleteRequest() throws EncryptedDocumentException, InvalidFormatException, IOException {
		Object[][] obj = DataReader.getDataFromExcel(Constant.DATAREADERPATH,
				"acceptDeleteReq");
		return obj;
	}
	@DataProvider(name = "editUserCase")
	public Object[][] editUser() throws EncryptedDocumentException, InvalidFormatException, IOException {
		Object[][] obj = DataReader.getDataFromExcel(Constant.DATAREADERPATH,
				"editUser");
		return obj;
	}
	@DataProvider(name = "inactiveUser")
	public Object[][] inactiveUser()
			throws EncryptedDocumentException, InvalidFormatException, IOException {
		Object[][] obj = DataReader.getDataFromExcel(Constant.DATAREADERPATH,
				"inactiveUser");
		return obj;
	}
	@DataProvider(name = "taxRateCreation")
	public Object[][] taxRateCreation()
			throws EncryptedDocumentException, InvalidFormatException, IOException {
		Object[][] obj = DataReader.getDataFromExcel(Constant.DATAREADERPATH,
				"taxRateCreation");
		return obj;
	}
	@DataProvider(name = "invalidNameTaxRate")
	public Object[][] invalidNameTaxRate()
			throws EncryptedDocumentException, InvalidFormatException, IOException {
		Object[][] obj = DataReader.getDataFromExcel(Constant.DATAREADERPATH,
				"invalidTaxRate");
		return obj;
	}
	@DataProvider(name = "invalidTaxRate")
	public Object[][] invalidTaxRate()
			throws EncryptedDocumentException, InvalidFormatException, IOException {
		Object[][] obj = DataReader.getDataFromExcel(Constant.DATAREADERPATH,
				"invalidTaxRateField");
		return obj;
	}
	@DataProvider(name = "editTaxRate")
	public Object[][] editTaxRate()
			throws EncryptedDocumentException, InvalidFormatException, IOException {
		Object[][] obj = DataReader.getDataFromExcel(Constant.DATAREADERPATH,
				"editTaxRate");
		return obj;
	}
	@DataProvider(name = "deleteTaxRate")
	public Object[][] deleteTaxRate()
			throws EncryptedDocumentException, InvalidFormatException, IOException {
		Object[][] obj = DataReader.getDataFromExcel(Constant.DATAREADERPATH,
				"deleteTaxRate");
		return obj;
	}
	@DataProvider(name = "addTaxGroup")
	public Object[][] addTaxGroup()
			throws EncryptedDocumentException, InvalidFormatException, IOException {
		Object[][] obj = DataReader.getDataFromExcel(Constant.DATAREADERPATH,
				"addTaxGroup");
		return obj;
	}
	@DataProvider(name = "testcase17")
	public Object[][] deleteTax()
			throws EncryptedDocumentException, InvalidFormatException, IOException {
		Object[][] obj = DataReader.getDataFromExcel(Constant.DATAREADERPATH,
				"testcase17");
		return obj;
	}
	@DataProvider(name = "testcase18")
	public Object[][] addRole()
			throws EncryptedDocumentException, InvalidFormatException, IOException {
		Object[][] obj = DataReader.getDataFromExcel(Constant.DATAREADERPATH,
				"addRole");
		return obj;
	}
	@DataProvider(name = "testCase19")
	public Object[][] updateRole()
			throws EncryptedDocumentException, InvalidFormatException, IOException {
		Object[][] obj = DataReader.getDataFromExcel(Constant.DATAREADERPATH,
				"updateRole");
		return obj;
	}
	@DataProvider(name = "testCase20")
	public Object[][] searchRole()
			throws EncryptedDocumentException, InvalidFormatException, IOException {
		Object[][] obj = DataReader.getDataFromExcel(Constant.DATAREADERPATH,
				"searchRole");
		return obj;
	}
	@DataProvider(name = "testcase21")
	public Object[][] cancelDeleteRole()
			throws EncryptedDocumentException, InvalidFormatException, IOException {
		Object[][] obj = DataReader.getDataFromExcel(Constant.DATAREADERPATH,
				"cancelRoleDelete");
		return obj;
	}
	@DataProvider(name = "testcase22")
	public Object[][] acceptDeleteRole()
			throws EncryptedDocumentException, InvalidFormatException, IOException {
		Object[][] obj = DataReader.getDataFromExcel(Constant.DATAREADERPATH,
				"acceptRoleDelete");
		return obj;
	}
	@DataProvider(name = "testcase23")
	public Object[][] accountCreation()
			throws EncryptedDocumentException, InvalidFormatException, IOException {
		Object[][] obj = DataReader.getDataFromExcel(Constant.DATAREADERPATH,
				"accountCreation");
		return obj;
	}
	@DataProvider(name = "testcase24")
	public Object[][] fundTransfer()
			throws EncryptedDocumentException, InvalidFormatException, IOException {
		Object[][] obj = DataReader.getDataFromExcel(Constant.DATAREADERPATH,
				"FundTransfer");
		return obj;
	}
	@DataProvider(name = "testcase25")
	public Object[][] balanceData()
			throws EncryptedDocumentException, InvalidFormatException, IOException {
		Object[][] obj = DataReader.getDataFromExcel(Constant.DATAREADERPATH,
				"verifyBalance");
		return obj;
	}
	@DataProvider(name = "testCase26")
	public Object[][] balanceAfterDeposit()
			throws EncryptedDocumentException, InvalidFormatException, IOException {
		Object[][] obj = DataReader.getDataFromExcel(Constant.DATAREADERPATH,
				"balanceAfterDeposit");
		return obj;
	}
	@DataProvider(name = "testCase27")
	public Object[][] editAccounts()
			throws EncryptedDocumentException, InvalidFormatException, IOException {
		Object[][] obj = DataReader.getDataFromExcel(Constant.DATAREADERPATH,
				"editAccount");
		return obj;
	}
	@DataProvider(name = "testCase28")
	public Object[][] cancelCloseAccount()
			throws EncryptedDocumentException, InvalidFormatException, IOException {
		Object[][] obj = DataReader.getDataFromExcel(Constant.DATAREADERPATH,
				"cancelCloseAccount");
		return obj;
	}


	@DataProvider(name = "testCase29")
	public Object[][] deleteCloseAccount()
			throws EncryptedDocumentException, InvalidFormatException, IOException {
		Object[][] obj = DataReader.getDataFromExcel(Constant.DATAREADERPATH,
				"deleteCloseAccount");
		return obj;
	}
	
	@DataProvider(name = "testCase31")
	public Object[][] fileUpload() throws EncryptedDocumentException, InvalidFormatException, IOException {
		Object[][] obj = DataReader.getDataFromExcel(Constant.DATAREADERPATH,
				"testCase31");
		return obj;
	}


	@DataProvider(name = "testCase30")
	public Object[][] closeAccountDisplay()
			throws EncryptedDocumentException, InvalidFormatException, IOException {
		Object[][] obj = DataReader.getDataFromExcel(Constant.DATAREADERPATH,
				"closeAccountDisplay");
		return obj;
	}
	
	
	
	
}
