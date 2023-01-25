package org.appium.constants;



import java.util.Objects;
import lombok.Getter;

@Getter
public class FrameworkConstants {
	
	private static FrameworkConstants frameworkconstant;
	
	public static FrameworkConstants getInstance() {
		if(Objects.isNull(frameworkconstant)) {
			frameworkconstant = new FrameworkConstants();
		}
		return frameworkconstant;
	}
	
	public final String apkfilepath = System.getProperty("user.dir") + "src/test/resources/apk/ApiDemos-debug.apk";
	
	public final String configfilepath = System.getProperty("user.dir")+"/src/test/resources/config/config.properties";
	
	public final String device1datafilepath = System.getProperty("user.dir")+"/src/test/resources/testdata/device1.json";

	public final String device2datafilepath = System.getProperty("user.dir")+"/src/test/resources/testdata/device2.json";
}
