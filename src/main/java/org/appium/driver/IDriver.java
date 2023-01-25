package org.appium.driver;

import java.net.MalformedURLException;
import java.util.Map;

import org.openqa.selenium.WebDriver;

public interface IDriver {
	
	public WebDriver getDriver(Map<String, String> map) throws MalformedURLException;

}
