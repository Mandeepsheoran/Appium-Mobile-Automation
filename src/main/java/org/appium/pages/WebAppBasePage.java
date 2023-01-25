package org.appium.pages;

import org.appium.driver.DriverManager;
import org.appium.reports.ExtentLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class WebAppBasePage {
	
	protected static void click(WebElement element, String elementname) {
		element.click();
		ExtentLogger.pass(elementname + " is clicked succesfully");
	}

	protected String getText(WebElement element) {
		return element.getText();
	}
	
	protected static void jsExecuteClick(By by, String elementname) {
		JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
		js.executeScript("arguments[0].click();");
		ExtentLogger.pass(elementname + " is clicked succesfully");
	}
	
	protected static void actionClassClick(By by, String elementname) {
		Actions action = new Actions(DriverManager.getDriver());
		action.moveToElement(DriverManager.getDriver().findElement(by)).perform();;
		ExtentLogger.pass(elementname + " is clicked succesfully");
	}
	
	protected static void sendkeys(By by, String text, String elementname) {
		DriverManager.getDriver().findElement(by).sendKeys(text);
		ExtentLogger.pass(text + " is entered succesfully in "+ elementname);
	}
	
	protected String getPageTitle() {
		return DriverManager.getDriver().getTitle();
	}
	
	protected static void navigateToURL(String url) throws InterruptedException {
		DriverManager.getDriver().navigate().to(url);
		Thread.sleep(3000);
	}

}
