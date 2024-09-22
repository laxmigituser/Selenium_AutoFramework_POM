package com.qa.base;

import org.openqa.selenium.WebDriver;

/*
 * browserfactory class will create the browser instance, using this driverfactory class, we will make the driver thread safe.
 * Reason for making thread safe browser instance - since we will do parallel execution, we need to make sure threads communicate with 
 * corresponding browser instance only.
 * we will use ThreadLocal class here.
 * ThreadLocal class belongs to java.lang used for threading
 * ThreadLocal allows us to create variable that can only be used by same thread
 * using threadlocal each thread maintain its own copy of data, it uses hashmap(ThreadLocalMap) for storing thread info.
 */
public class DriverFactory {
	//Design pattern - best practice for system architecture
	// singleton - only one instance exist, providing global access to the instance using getInstance() 
	
	// private constructor to restrict users from creating object of this class
	private DriverFactory() {
		
	}
	
	private static DriverFactory instance = new DriverFactory();
	//this method will return instance of current class, we need Cz we created the private constructor. so obj can not be created directly
	public static DriverFactory getInstance() {
		return instance;
	}
	
	ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	
	public WebDriver getDriver() {
		return driver.get();
	}
	
	//for setting driver into thread local
	public void setDriver(WebDriver driverParam) {
		driver.set(driverParam);
	}
	
	//close current driver instance
	public void closebrowser() {
		driver.get().close();
		driver.remove();
	}
	
}
