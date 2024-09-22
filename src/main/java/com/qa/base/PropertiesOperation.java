package com.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesOperation {

	static Properties prop = new Properties();
	
	public static String getPropertyValueByKey(String key) throws Exception {
		
		FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\Config.properties");
		prop.load(ip);
		String value = prop.get(key).toString();
		if(value.isEmpty()) {
			throw new Exception("value not specified for key: "+key);
		}
		return value;
	}
}
