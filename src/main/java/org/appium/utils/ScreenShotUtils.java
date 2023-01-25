package org.appium.utils;

import org.appium.driver.DriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class ScreenShotUtils {
	
	private ScreenShotUtils() {}
	
	public static String getBase64Image() {
		return ((TakesScreenshot)DriverManager.getDriver()).getScreenshotAs(OutputType.BASE64);
	}

}
