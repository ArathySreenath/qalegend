package qalegend.utils;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.DataProvider;

import constants.Constant;

public class QaDataProvider {
	@DataProvider(name = "testCase1")
	public static Object[][] dataRead() throws EncryptedDocumentException, InvalidFormatException, IOException {

		Object[][] obj = DataFile.getDataFromExcel(Constant.DATAFILEPATH,
				"invalidlogin");
		return obj;
	}
	@DataProvider(name = "testdatavalid")
	public Object[][] dataReadFunction() throws EncryptedDocumentException, InvalidFormatException, IOException {
		Object[][] obj = DataFile.getDataFromExcel(Constant.DATAFILEPATH,
				"validlogin");
		return obj;
	}
	@DataProvider(name = "Userdata")
	public Object[][] Userdata() throws EncryptedDocumentException, InvalidFormatException, IOException {
		Object[][] obj = DataFile.getDataFromExcel( Constant.DATAFILEPATH,
				"usercreation");
		return obj;
	}

	@DataProvider(name = "ExistingUserdata")
	public Object[][] dataReadFunctionexisting()
			throws EncryptedDocumentException, InvalidFormatException, IOException {
		Object[][] obj = DataFile.getDataFromExcel(Constant.DATAFILEPATH,
				"existingusername");
		return obj;
	}

	@DataProvider(name = "searchUser")
	public Object[][] searchUserData() throws EncryptedDocumentException, InvalidFormatException, IOException {
		Object[][] obj = DataFile.getDataFromExcel(Constant.DATAFILEPATH,
				"searchuser");
		return obj;
	}

	@DataProvider(name = "viewUser")
	public Object[][] viewUser() throws EncryptedDocumentException, InvalidFormatException, IOException {
		Object[][] obj = DataFile.getDataFromExcel(Constant.DATAFILEPATH, "viewUser");
		return obj;
	}

	@DataProvider(name = "cancelDeleteUser")
	public Object[][] cancelDeleteUser() throws EncryptedDocumentException, InvalidFormatException, IOException {
		Object[][] obj = DataFile.getDataFromExcel(Constant.DATAFILEPATH,
				"cancelDeleteUser");
		return obj;
	}
	@DataProvider(name = "acceptDeleteRequest")
	public Object[][] acceptDeleteRequest() throws EncryptedDocumentException, InvalidFormatException, IOException {
		Object[][] obj = DataFile.getDataFromExcel(Constant.DATAFILEPATH,
				"acceptDeleteReq");
		return obj;
	}
	@DataProvider(name = "editUserCase")
	public Object[][] editUser() throws EncryptedDocumentException, InvalidFormatException, IOException {
		Object[][] obj = DataFile.getDataFromExcel(Constant.DATAFILEPATH,
				"editUser");
		return obj;
	}
	@DataProvider(name = "inactiveUser")
	public Object[][] inactiveUser()
			throws EncryptedDocumentException, InvalidFormatException, IOException {
		Object[][] obj = DataFile.getDataFromExcel(Constant.DATAFILEPATH,
				"inactiveUser");
		return obj;
	}
	@DataProvider(name = "taxRateCreation")
	public Object[][] taxRateCreation()
			throws EncryptedDocumentException, InvalidFormatException, IOException {
		Object[][] obj = DataFile.getDataFromExcel(Constant.DATAFILEPATH,
				"taxRateCreation");
		return obj;
	}
	@DataProvider(name = "invalidNameTaxRate")
	public Object[][] invalidNameTaxRate()
			throws EncryptedDocumentException, InvalidFormatException, IOException {
		Object[][] obj = DataFile.getDataFromExcel(Constant.DATAFILEPATH,
				"invalidTaxRate");
		return obj;
	}
	@DataProvider(name = "invalidTaxRate")
	public Object[][] invalidTaxRate()
			throws EncryptedDocumentException, InvalidFormatException, IOException {
		Object[][] obj = DataFile.getDataFromExcel(Constant.DATAFILEPATH,
				"invalidTaxRateField");
		return obj;
	}
	@DataProvider(name = "editTaxRate")
	public Object[][] editTaxRate()
			throws EncryptedDocumentException, InvalidFormatException, IOException {
		Object[][] obj = DataFile.getDataFromExcel(Constant.DATAFILEPATH,
				"editTaxRate");
		return obj;
	}
	@DataProvider(name = "deleteTaxRate")
	public Object[][] deleteTaxRate()
			throws EncryptedDocumentException, InvalidFormatException, IOException {
		Object[][] obj = DataFile.getDataFromExcel(Constant.DATAFILEPATH,
				"deleteTaxRate");
		return obj;
	}
	@DataProvider(name = "addTaxGroup")
	public Object[][] addTaxGroup()
			throws EncryptedDocumentException, InvalidFormatException, IOException {
		Object[][] obj = DataFile.getDataFromExcel(Constant.DATAFILEPATH,
				"addTaxGroup");
		return obj;
	}
	@DataProvider(name = "testcase17")
	public Object[][] deleteTax()
			throws EncryptedDocumentException, InvalidFormatException, IOException {
		Object[][] obj = DataFile.getDataFromExcel(Constant.DATAFILEPATH,
				"testcase17");
		return obj;
	}
	@DataProvider(name = "testcase18")
	public Object[][] addRole()
			throws EncryptedDocumentException, InvalidFormatException, IOException {
		Object[][] obj = DataFile.getDataFromExcel(Constant.DATAFILEPATH,
				"addRole");
		return obj;
	}
	@DataProvider(name = "testCase19")
	public Object[][] updateRole()
			throws EncryptedDocumentException, InvalidFormatException, IOException {
		Object[][] obj = DataFile.getDataFromExcel(Constant.DATAFILEPATH,
				"updateRole");
		return obj;
	}
	@DataProvider(name = "testCase20")
	public Object[][] searchRole()
			throws EncryptedDocumentException, InvalidFormatException, IOException {
		Object[][] obj = DataFile.getDataFromExcel(Constant.DATAFILEPATH,
				"searchRole");
		return obj;
	}
	@DataProvider(name = "testcase21")
	public Object[][] cancelDeleteRole()
			throws EncryptedDocumentException, InvalidFormatException, IOException {
		Object[][] obj = DataFile.getDataFromExcel(Constant.DATAFILEPATH,
				"cancelRoleDelete");
		return obj;
	}
	@DataProvider(name = "testcase22")
	public Object[][] acceptDeleteRole()
			throws EncryptedDocumentException, InvalidFormatException, IOException {
		Object[][] obj = DataFile.getDataFromExcel(Constant.DATAFILEPATH,
				"acceptRoleDelete");
		return obj;
	}
	@DataProvider(name = "testcase23")
	public Object[][] accountCreation()
			throws EncryptedDocumentException, InvalidFormatException, IOException {
		Object[][] obj = DataFile.getDataFromExcel(Constant.DATAFILEPATH,
				"accountCreation");
		return obj;
	}
	@DataProvider(name = "testcase24")
	public Object[][] fundTransfer()
			throws EncryptedDocumentException, InvalidFormatException, IOException {
		Object[][] obj = DataFile.getDataFromExcel(Constant.DATAFILEPATH,
				"FundTransfer");
		return obj;
	}
	@DataProvider(name = "testcase25")
	public Object[][] balanceData()
			throws EncryptedDocumentException, InvalidFormatException, IOException {
		Object[][] obj = DataFile.getDataFromExcel(Constant.DATAFILEPATH,
				"verifyBalance");
		return obj;
	}
	@DataProvider(name = "testCase26")
	public Object[][] balanceAfterDeposit()
			throws EncryptedDocumentException, InvalidFormatException, IOException {
		Object[][] obj = DataFile.getDataFromExcel(Constant.DATAFILEPATH,
				"balanceAfterDeposit");
		return obj;
	}
	@DataProvider(name = "testCase27")
	public Object[][] editAccounts()
			throws EncryptedDocumentException, InvalidFormatException, IOException {
		Object[][] obj = DataFile.getDataFromExcel(Constant.DATAFILEPATH,
				"editAccount");
		return obj;
	}
	@DataProvider(name = "testCase28")
	public Object[][] cancelCloseAccount()
			throws EncryptedDocumentException, InvalidFormatException, IOException {
		Object[][] obj = DataFile.getDataFromExcel(Constant.DATAFILEPATH,
				"cancelCloseAccount");
		return obj;
	}


	@DataProvider(name = "testCase29")
	public Object[][] deleteCloseAccount()
			throws EncryptedDocumentException, InvalidFormatException, IOException {
		Object[][] obj = DataFile.getDataFromExcel(Constant.DATAFILEPATH,
				"deleteCloseAccount");
		return obj;
	}


	@DataProvider(name = "testCase30")
	public Object[][] closeAccountDisplay()
			throws EncryptedDocumentException, InvalidFormatException, IOException {
		Object[][] obj = DataFile.getDataFromExcel(Constant.DATAFILEPATH,
				"closeAccountDisplay");
		return obj;
	}


}
