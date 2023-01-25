package org.appium.mobiletest;

import java.lang.reflect.Method;
import java.util.Map;

import org.appium.driver.Driver;
import org.appium.reports.ExtentReport;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseTest {

	@BeforeMethod
	public static void setUpTest(Method m, Object[] testdata) {
		Map<String, String> map=(Map<String, String>) testdata[0];
		Driver.initDriver(map);
	}

	@AfterMethod
	public static void tearDownTest() {
		Driver.quitDriver();
	}

}
