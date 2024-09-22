//package com.qa.testcases;
//
//import java.util.HashMap;
//import java.awt.*;
//import java.util.concurrent.TimeUnit;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.Assert;
//import org.testng.ITestContext;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.DataProvider;
//import org.testng.annotations.Test;
//
//import com.aventstack.extentreports.Status;
//import com.qa.base.ExtentFactory;
//import com.qa.base.TestBase;
//import com.qa.pages.EnterInsuranceDataPage;
//import com.qa.pages.EnterInsurantDataPage;
//import com.qa.pages.EnterProductDataPage;
//import com.qa.pages.EnterVehicleDataPage;
//import com.qa.pages.HomePage;
//import com.qa.pages.SelectPriceOptionPage;
//import com.qa.util.ExcelOperations;
//
////import io.github.bonigarcia.wdm.WebDriverManager;
//
//public class EndToEndTest extends TestBase{
//	ExcelOperations excelUtil;
//	HomePage homePage = new HomePage();
//	EnterVehicleDataPage evDataPage = new EnterVehicleDataPage();
//	EnterInsurantDataPage eiDataPage = new EnterInsurantDataPage();
//	EnterProductDataPage epDataPage = new EnterProductDataPage();
//	SelectPriceOptionPage spOptionPage = new SelectPriceOptionPage();
//	
//	public EndToEndTest() throws Exception {
//		//super(); // initialize properties file in testbase class
//		excelUtil = new ExcelOperations("InsurancePremium");
//	}
//	
//	
//	@DataProvider(name = "vehData")
//	public Object[][] getTestdata(){
//		int row = excelUtil.getRowCount();
//		Object[][] obj=new Object[row][1]; // 1 cz we will pass hashmap
//		for(int i=1; i<=excelUtil.getRowCount();i++) {
//			HashMap<String, String> testData = excelUtil.getTestTataInMap(i);
//			obj[i-1][0] = testData;
//		}		
//		return obj;
//	}
//	
//	@Test(dataProvider = "vehData")
//	public void insuranceCalculate(Object obj, ITestContext context) throws Exception {
//		HashMap<String, String> testData =(HashMap<String, String>) obj;
//		context.setAttribute("testDataMap", testData);
//		System.out.println("Test Data is: "+testData);
//		ExtentFactory.getInstance().getExtent().log(Status.INFO, testData.toString());
//		homePage.clickMotorCycleLink();
//		evDataPage.enterVehicleData(testData);
//		eiDataPage.enterInsurancedata(testData);
//		epDataPage.enterProductData(testData);
//		
//		String expectedSilverPrice = testData.get("PriceValidation_Silver");
//		String actualValue = spOptionPage.getPriceForSelectedOptions("Silver");
//		Assert.assertEquals(actualValue, expectedSilverPrice,"Pricing not matching");
//		
//		spOptionPage.selectRadioBasedOnText("Silver");
//		spOptionPage.clickNext();
//		Thread.sleep(3000);
//	}
//
//
//}
