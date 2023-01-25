package org.appium.mobiletest;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.appium.constants.FrameworkConstants;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataProviderTest {

	@Test(dataProvider = "getDataFromJson")
	public static void getDataFromDataProvider(Map<String,String> map) {
		System.out.println(map.get("username"));
		System.out.println(map.get("password"));
	}
	
	
	@DataProvider
	public Object[][] getDataFromJson() throws  IOException{		
		Map<String, String> map1 =new ObjectMapper().readValue(new File(FrameworkConstants.getInstance().device1datafilepath), HashMap.class);
		Map<String, String> map2 =new ObjectMapper().readValue(new File(FrameworkConstants.getInstance().device2datafilepath), HashMap.class);
		List<Map<String,String>> list = new ArrayList<>();
		list.add(map1);
		list.add(map2);
		return (Object[][]) list.toArray();
	}
	
	@DataProvider
	public Object[][] getData1(){		
		return new Object[][] {
			{"mandeep", "Test@123"},
			{"monika", "Machine@123"},
			{"Kaju", "India@123"}
		};		
	}
	
	@DataProvider
	public Object[] getData2() {
		Map<String, String> map = new HashMap<>();
		map.put("username", "mandeep");
		map.put("password", "Test@123");

		Map<String, String> map1 = new HashMap<>();
		map1.put("username", "monika");
		map1.put("password", "Machine@123");
		
		Map<String, String> map2 = new HashMap<>();
		map2.put("username", "kaju");
		map2.put("password", "India@123");
		
		List<Map<String,String>> list = new ArrayList<>();
		list.add(map);
		list.add(map1);
		list.add(map2);
		return list.toArray();
	}
}
