package com.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;


public class TestBase {
	
	BrowserFactory browser = new BrowserFactory();
	
	
	@BeforeMethod
//	@BeforeClass
	public void launchApplication() throws Exception {
		//create browser instance
		WebDriver driverInstance = browser.createBrowserInstance(PropertiesOperation.getPropertyValueByKey("browser"));
		//setting it to thread local for threadsafe
		DriverFactory.getInstance().setDriver(driverInstance);
		//accessing thread safe browser
		WebDriver driver = DriverFactory.getInstance().getDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MICROSECONDS);
		driver.get(PropertiesOperation.getPropertyValueByKey("url"));
	}
	
	@AfterMethod
//	@AfterClass
	public void tearDown() {
		DriverFactory.getInstance().closebrowser();
	}
	
	
	
	
	
	
	
		
	
	

}
