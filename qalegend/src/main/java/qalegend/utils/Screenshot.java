package qalegend.utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import constants.Constant;

public class Screenshot {
//	WebDriver driver;
//	public Screenshot(WebDriver driver) {
//		this.driver=driver;
//	}
	
	public void takeScreenshot(WebDriver driver,String fileName) throws IOException {
	
			System.out.println("screen "+driver);
			TakesScreenshot screenshot = (TakesScreenshot) driver;
			File file = screenshot.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(file,new File(System.getProperty("user.dir") + Constant.SCREENSHOTPATH +fileName+ timestamp() + ".png"));
		

	}

	public static String timestamp() {
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy_hh-mm-ss");
		System.out.println(dateFormat.format(date));
		return dateFormat.format(date).toString();
	}

}
