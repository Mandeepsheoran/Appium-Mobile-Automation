package org.appium.driver;

import java.util.Map;
import org.appium.constants.FrameworkConstants;
import org.openqa.selenium.WebDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AndroidMobileCapabilityType;

public class SauceLabImpl implements IDriver{

	public WebDriver getDriver(Map<String, String> map) {
		UiAutomator2Options options = new UiAutomator2Options()
			       .setDeviceName("Android Emulator")
			       .setApp(FrameworkConstants.getInstance().apkfilepath)
			       .setPlatformName("Android");	
		options.setCapability("username", "mandeepsheoran_HMkLhW");
		options.setCapability("access_key", "hDswhU9eB6bza1oMBtPy");
		options.setCapability("app", "bs://0b49595c1bc4162972a9cc5efcbfadaad8d0b487");
		map.forEach((k,v) -> options.setCapability(k, v));
		options.asMap().forEach((k,v)-> System.out.println(k + " : " + v));   // For Debug purpose
		options.setCapability("project", "First Appium Project");
		options.setCapability("build", "DT_01");
		options.setCapability("name", "Browserstack Test");	
		options.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "io.appium.android.apis");
		options.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".ApiDemos");
		//Yet to implement SauceLab Integration
		return null;
	}
}

