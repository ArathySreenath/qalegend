package qalegend.utils;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.model.Test;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import common.functions.BrowserLaunch;
import constants.Constant;
import reports.ExtentReport;

public class Listener extends BrowserLaunch implements ITestListener {

	// TODO Auto-generated method stub
    public void onTestStart(ITestResult result) {
    	

	}

	public void onTestSuccess(ITestResult result) {
		System.out.println(result.getMethod().getMethodName());

	}

	public void onTestFailure(ITestResult result) {


	}

	public void onTestSkipped(ITestResult result) {


	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	public void onStart(ITestContext context,String browserName) {

		
		

		 
		 
		 

}

	public void onFinish(Method m,ITestContext context) {

	}

}