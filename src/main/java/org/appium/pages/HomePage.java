package org.appium.pages;

import java.util.List;

import org.appium.driver.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class HomePage extends NativeAppBasePage{
	
	
	@AndroidFindBy(xpath="//android.widget.TextView[@content-desc='Views'])")
	@iOSXCUITFindBy(accessibility= "views")
	private WebElement views;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@content-desc='Annimation'])")
	@iOSXCUITFindBy(accessibility= "views")
	private WebElement annimation;
	
	@AndroidFindBy(xpath="//android.widget.TextView")
	@iOSXCUITFindBy(accessibility= "views")
	private List<WebElement> menuitem;
	
	public HomePage() {
		PageFactory.initElements(DriverManager.getDriver(), this);
	}
	
	public ViewHomePageDetails clickViews() {
		click(views,"view option");
		return new ViewHomePageDetails();	
	}
	
	public void clickMenuItem(String menu) {
		menuitem.parallelStream().filter(e->e.getText().contains(menu)).findFirst().ifPresent(WebElement::click);;
	}
	

}
