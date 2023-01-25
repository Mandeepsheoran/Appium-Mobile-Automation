package org.appium.pages;

import org.appium.driver.DriverManager;
import org.openqa.selenium.By;

public class ViewHomePageDetails {
	
	private String dragdropmenu = "//android.widget.TextView[contains(@text, '%replaceable%')])";
	
	public void clickDetailsMenu(String menuname) {
		String newxpath = dragdropmenu.replace("%replaceable%",menuname );
		DriverManager.getDriver().findElement(By.xpath(newxpath)).click();
	}

}
