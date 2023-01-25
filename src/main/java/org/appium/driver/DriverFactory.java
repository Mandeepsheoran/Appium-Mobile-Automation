package org.appium.driver;

import java.util.Map;
import org.openqa.selenium.WebDriver;

public class DriverFactory {

	private DriverFactory() {
	}

	WebDriver driver;

	public static WebDriver getInstance(RunMode runmode, Map<String, String> map)  {
		WebDriver driver = null;
		if (runmode.equals(RunMode.LOCAL)) {
			driver = new LocalDriverImpl().getDriver(map);
		} else if (runmode.equals(RunMode.SAUCELABS)) {
			driver = new BrowserstackImpl().getDriver(map);
		} else if (runmode.equals(RunMode.BROWSERSTACK)) {
			driver = new SauceLabImpl().getDriver(map);
		} else if (runmode.equals(RunMode.KOBITON)) {
			driver = new SauceLabImpl().getDriver(map);
		} else if (runmode.equals(RunMode.PERFECTO)) {
			driver = new SauceLabImpl().getDriver(map);
		}
		return driver;
	}

}
