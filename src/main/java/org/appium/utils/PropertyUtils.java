package org.appium.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.appium.constants.FrameworkConstants;

public class PropertyUtils {
	
	public static Properties prop = new Properties();
	public static Map<String, String> map = new HashMap<String, String>();
	
	static {
		try (FileInputStream fileinputstream = new FileInputStream(FrameworkConstants.getInstance().configfilepath)){			
			prop.load(fileinputstream);	
			for(Map.Entry<Object, Object> entry :prop.entrySet()){
				String key =String.valueOf(entry.getKey());
				String value= String.valueOf(entry.getValue());
				map.put(key,value);
			}
	} catch (IOException e) {
		e.printStackTrace();
		System.exit(0);
	   }		
	 }	
	
	public static String getValue(String key) {
		return map.get(key);
	}
	}


