package retryAnalyser;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer {
	private static final int maxTry = 3;
	private int count = 0;

	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		if (!result.isSuccess ()) {
	           if (count < maxTry) {
	               count++;
	               result.setStatus(result.FAILURE);
	               return true;
	           }else {
	        	   result.setStatus(result.FAILURE);
	           }
	       }else {
	    	   result.setStatus(result.SUCCESS);
	       }
	       return false;
	}


}


