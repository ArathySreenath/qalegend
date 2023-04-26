package qalegend.utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import common.functions.BrowserLaunch;
import constants.Constant;

public class Screenshot extends BrowserLaunch{
	public  static void takeScreenshot(WebDriver driver ) throws IOException {
		TakesScreenshot screenshot=(TakesScreenshot)driver;
		File file=screenshot.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File(System.getProperty("user.dir")+Constant.SCREENSHOTPATH+timestamp()+".png"));
		
	}
	public  static String timestamp()
	{
		Date date=new Date();
		SimpleDateFormat dateFormat=new SimpleDateFormat("dd-MM-yyyy_hh-mm-ss");
System.out.println(dateFormat.format(date));
		return dateFormat.format(date).toString();
	}

}
