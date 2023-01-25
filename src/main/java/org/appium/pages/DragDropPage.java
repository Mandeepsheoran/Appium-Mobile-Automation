package org.appium.pages;

import org.appium.driver.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class DragDropPage extends NativeAppBasePage{
	
	@AndroidFindBy(id="io.appium.android.apis:id/drag_dot_1")
	private WebElement dragsource;
	
	@AndroidFindBy(id="io.appium.android.apis:id/drag_dot_2")
	private WebElement dragdest;
	
	@AndroidFindBy(id="io.appium.android.apis:id/drag_result_text")
	private WebElement droppedmsg;
	
	public DragDropPage() {
		PageFactory.initElements(DriverManager.getDriver(), this);
	}
	
	public  DragDropPage performDragDrop() {
		dragAndDrop(dragsource,dragdest);
		return this;
	}
	
	public String getDroppedMsg() {
		return getText(droppedmsg);
	}

}
