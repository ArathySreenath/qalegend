package qalegend.utils;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import common.functions.BrowserLaunch;

public class Listener extends BrowserLaunch implements ITestListener {
	
	public void onTestStart(ITestResult result) {
		
	}
	
	public void onTestSuccess(ITestResult result) {
		try {
			Screenshot.takeScreenshot();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
	}
	
	public void onTestFailure(ITestResult result) {
		
		try {
			Screenshot.takeScreenshot();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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