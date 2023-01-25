package org.appium.reports;

import java.util.Objects;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class ExtentReport {
	
	private ExtentReport() {}

	private static ExtentReports extent;
	
	public static void initReport() { 
		if(Objects.isNull(extent)) {
		extent = new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter(System.getProperty("user.dir") + "src/test/resources/reports/index.html");
		spark.config().setTheme(Theme.DARK);
		spark.config().setDocumentTitle("Appium Extent Report");
		spark.config().setReportName("Mobile Automation");
		extent.attachReporter(spark);
		}
	}
	
	public static void tearDownReport() {
		if(Objects.nonNull(extent)) {
		extent.flush();
		ExtentManager.unload();
		}
	}
	
	public static void createExtentTest(String methodname) {
		ExtentTest test = extent.createTest(methodname);
		ExtentManager.setExtentTest(test);
	}
}