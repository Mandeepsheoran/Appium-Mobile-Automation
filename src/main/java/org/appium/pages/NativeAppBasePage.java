package org.appium.pages;

import java.time.Duration;

import org.appium.driver.DriverManager;
import org.appium.reports.ExtentLogger;
import org.appium.reports.ExtentManager;
import org.appium.reports.ExtentReport;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;

public class NativeAppBasePage {
	
	protected String getText(WebElement element) {
		return element.getText();
	}
	
	protected void explicitWait(WebElement element) {
		new WebDriverWait(DriverManager.getDriver(),Duration.ofSeconds(5))
		            .withMessage(()-> "Some problem while finding the element")
		            .pollingEvery(Duration.ofSeconds(1))
		            .until(e->element.isDisplayed());
	}
	
	protected void click(WebElement element, String elementname) {
	//	explicitWait(element);
		element.click();
		System.out.println(elementname + " is clicked successfully.");
		ExtentLogger.pass(elementname  + " is clicked successfully.");
	}
	
	protected void click(By by, String elementname) {
		click(DriverManager.getDriver().findElement(by),elementname);	
		ExtentLogger.pass(elementname  + " is clicked successfully.");
	}
	
	protected void click(String locatortype, String value, String elementname) {
		if(locatortype.equals("xpath")) {
			click(By.xpath(value),elementname);
			ExtentLogger.pass(elementname  + " is clicked successfully.");
		} else if(locatortype.equals("id")) {
			click(By.id(value),elementname);
			ExtentLogger.pass(elementname  + " is clicked successfully.");
		}
	}
	
	protected static void dragAndDrop(WebElement source, WebElement target) {
		new AndroidTouchAction((PerformsTouchActions) DriverManager.getDriver())
            .longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(source)))
            .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(5)))
            .moveTo(ElementOption.element(target))
            .release()
            .perform();  
		ExtentLogger.pass("Element is selected and dropped successfully to destination.");
	}
	
	protected static void swipe(WebElement source, WebElement target) {
		new AndroidTouchAction((PerformsTouchActions) DriverManager.getDriver())
            .longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(source)))
            .moveTo(ElementOption.element(target))
            .release()
            .perform();      
		ExtentLogger.pass("Swipe action is performed.");
	}
	
	protected static void tap(WebElement ele) {
		new AndroidTouchAction((PerformsTouchActions) DriverManager.getDriver())
        .tap(TapOptions.tapOptions().withElement(ElementOption.element(ele)))
        .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(5)))
        .perform();
		ExtentLogger.pass("Tap action is performed on element.");
	}
	
	protected static void tapUsingCoordinates(int x, int y) {
		new AndroidTouchAction((PerformsTouchActions) DriverManager.getDriver())
        .tap(PointOption.point(x,y))
        .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(5)))
        .perform();
		ExtentLogger.pass("Tap action is performed on element using provided coordinates.");
	}
	
	protected static void longPress(WebElement names) {
		new AndroidTouchAction((PerformsTouchActions) DriverManager.getDriver())
        .longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(names)))
        .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(5)))
        .perform();
	}

	
}
