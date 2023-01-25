package org.appium.driver;

import java.util.Map;
import org.appium.utils.PropertyUtils;
import org.openqa.selenium.WebDriver;

public final class Driver {

	private Driver() {
	}

	public static void initDriver(Map<String, String> map)  {
		if(DriverManager.getDriver()==null) {
		String modevalue = PropertyUtils.getValue("mode");
		WebDriver driver = DriverFactory.getInstance(RunMode.valueOf(modevalue.toUpperCase()),map);
		DriverManager.setDriver(driver);
		}
	}

	public static void quitDriver() {
		if(DriverManager.getDriver()!=null){
		DriverManager.getDriver().quit();
		DriverManager.unload();
		}
	}

}
