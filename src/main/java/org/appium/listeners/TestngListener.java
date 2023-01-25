package org.appium.listeners;

import org.appium.reports.ExtentLogger;
import org.appium.reports.ExtentReport;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestngListener implements ITestListener, ISuiteListener {

	public void onTestStart(ITestResult result) {
		ExtentReport.createExtentTest(result.getName());
	}

	public void onTestSuccess(ITestResult result) {
		ExtentLogger.pass(result.getName() + " is passed.");
	}

	public void onTestFailure(ITestResult result) {
		ExtentLogger.fail(result.getName() + " is failed.");
	}

	public void onTestSkipped(ITestResult result) {
		ExtentLogger.skip(result.getName() + " is skipped.");
	}

	public void onStart(ISuite suite) {
		ExtentReport.initReport();
	}

	public void onFinish(ISuite suite) {
		ExtentReport.tearDownReport();
	}
}
