package qalegend.utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Parameters;

import common.functions.BrowserLaunch;
import constants.Constant;


public class Listener extends BrowserLaunch implements ITestListener {
	
		// TODO Auto-generated method stub
	
	public void onTestStart(ITestResult result) {
		
//		System.out.println("start "+driver);
		System.out.println("x="+x);
	}
	
	public void onTestSuccess(ITestResult result) {
		System.out.println("success "+driver);

	}
	
	public void onTestFailure(ITestResult result) {
		
		
	}
	
	public void onTestSkipped(ITestResult result) {
		
	}
	
	public void onTestFaileButWithinSuccessPercentage(ITestResult result) {
		
	}
	
	public void onStart(ITestContext context) {
		
	}
	
	public void onFinish(ITestContext context) {
		
	}

}