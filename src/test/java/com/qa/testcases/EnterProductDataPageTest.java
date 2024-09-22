package com.qa.testcases;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.base.DriverFactory;
import com.qa.base.TestBase;
import com.qa.pages.EnterInsurantDataPage;
import com.qa.pages.EnterProductDataPage;
import com.qa.pages.EnterVehicleDataPage;
import com.qa.pages.HomePage;
import com.qa.util.CommonMethods;
import com.qa.util.ExcelOperations;

public class EnterProductDataPageTest extends TestBase{
	
	HomePage homePage = new HomePage();
	EnterVehicleDataPage enterVehicleDataPage = new EnterVehicleDataPage();
	EnterInsurantDataPage enterInsurantDataPage = new EnterInsurantDataPage();
	EnterProductDataPage enterProductDataPage = new EnterProductDataPage();
	
	HomePageTest homePageTest = new HomePageTest();
	
	@Test(enabled = true)
	public void automobile_productData_Pagetest() throws Exception {
		homePage.clickAutoMobileLink();
		//fill vehicle data page
		ExcelOperations excelUtil = new ExcelOperations("Automobile_Data");
		int row = excelUtil.getRowCount();
		Object[][] object=new Object[row][1]; 
		HashMap<String, String> testData=new HashMap<>();
		for(int i=1; i<=excelUtil.getRowCount();i++) {
			 testData = excelUtil.getTestTataInMap(i);
			object[i-1][0] = testData;
		}
		enterVehicleDataPage.enterVehicleData_automobile(testData);
		enterVehicleDataPage.clickNextButton();
		Thread.sleep(2000);
		
		//enter insurant page details
		ExcelOperations excelUtil01 = new ExcelOperations("Insurant_Data");
		int row01 = excelUtil.getRowCount();
		Object[][] object01=new Object[row01][1]; 
		HashMap<String, String> testData01=new HashMap<>();
		for(int i=1; i<=excelUtil01.getRowCount();i++) {
			 testData01 = excelUtil01.getTestTataInMap(i);
			object01[i-1][0] = testData01;
		}
		enterInsurantDataPage.enterInsurantData(testData01);
		enterInsurantDataPage.clickNextButton();
		Thread.sleep(2000);
		
		//product data page
		//header and footer validation
		homePageTest.headerTest();
		homePageTest.footerTest();
		
		//tab validation
		CommonMethods.assertFieldText(DriverFactory.getInstance().getDriver().findElement(enterVehicleDataPage.breadCrumb), "Automobile Insurance");
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(enterVehicleDataPage.enterVehicleData_tab).isDisplayed(), " Element "+enterVehicleDataPage.enterVehicleData_tab+" is not displayed on the page");
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(enterVehicleDataPage.enterVehicleData_tab).isEnabled(), " Element "+enterVehicleDataPage.enterVehicleData_tab+" is not enabled");
		CommonMethods.assertFieldText(DriverFactory.getInstance().getDriver().findElement(enterVehicleDataPage.enterProductData_tab_count), "6");
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(enterVehicleDataPage.enterInsurantData_tab).isDisplayed(), " Element "+enterVehicleDataPage.enterInsurantData_tab+" is not displayed on the page");
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(enterVehicleDataPage.enterInsurantData_tab).isEnabled(), " Element "+enterVehicleDataPage.enterInsurantData_tab+" is not enabled");
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(enterVehicleDataPage.enterProductData_tab).isDisplayed(), " Element "+enterVehicleDataPage.enterProductData_tab+" is not displayed on the page");
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(enterVehicleDataPage.enterProductData_tab).isEnabled(), " Element "+enterVehicleDataPage.enterProductData_tab+" is not enabled");
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(enterVehicleDataPage.selectPriceOption_tab).isDisplayed(), " Element "+enterVehicleDataPage.selectPriceOption_tab+" is not displayed on the page");
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(enterVehicleDataPage.selectPriceOption_tab).isEnabled(), " Element "+enterVehicleDataPage.selectPriceOption_tab+" is not enabled");
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(enterVehicleDataPage.sendQuote_tab).isDisplayed(), " Element "+enterVehicleDataPage.sendQuote_tab+" is not displayed on the page");
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(enterVehicleDataPage.sendQuote_tab).isEnabled(), " Element "+enterVehicleDataPage.sendQuote_tab+" is not enabled");
		
		//validate form elements
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(enterProductDataPage.startDateIPBox).isEnabled(), " Element "+enterProductDataPage.startDateIPBox+" is not enabled");
		List<String> insuranceSumDropdownValues = Arrays.asList("3.000.000,00","5.000.000,00","7.000.000,00","10.000.000,00");
		CommonMethods.assertDropdownContainsValues(DriverFactory.getInstance().getDriver().findElement(enterProductDataPage.insuranceSumDropdown),insuranceSumDropdownValues);
		List<String> meritRatingDropdownValues = Arrays.asList("Super Bonus","Bonus 1","Bonus 2","Bonus 3");
		CommonMethods.assertDropdownContainsValues(DriverFactory.getInstance().getDriver().findElement(enterProductDataPage.meritRatingDropdown),meritRatingDropdownValues);
		List<String> damageInsuranceDropdownValues = Arrays.asList("No Coverage","Partial Coverage","Full Coverage");
		CommonMethods.assertDropdownContainsValues(DriverFactory.getInstance().getDriver().findElement(enterProductDataPage.damageinsuranceDropdown),damageInsuranceDropdownValues);
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(enterProductDataPage.optionalProducts).isDisplayed(), " Element "+enterProductDataPage.optionalProducts+" is not enabled");
		List<String> courtesyCarDropdownValues = Arrays.asList("No","Yes");
		CommonMethods.assertDropdownContainsValues(DriverFactory.getInstance().getDriver().findElement(enterProductDataPage.courtesycarDropdown),courtesyCarDropdownValues);
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(enterProductDataPage.nextButton).isEnabled(), " Element "+enterProductDataPage.nextButton+" is not enabled");
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(enterProductDataPage.previousButton).isEnabled(), " Element "+enterProductDataPage.previousButton+" is not enabled");		
		Thread.sleep(3000);
	}
	
	@Test(enabled = true)
	public void truck_productData_Pagetest() throws Exception {
		homePage.clickTruckLink();
		//fill vehicle data page
		ExcelOperations excelUtil = new ExcelOperations("Truck_Data");
		int row = excelUtil.getRowCount();
		Object[][] object=new Object[row][1]; 
		HashMap<String, String> testData=new HashMap<>();
		for(int i=1; i<=excelUtil.getRowCount();i++) {
			 testData = excelUtil.getTestTataInMap(i);
			object[i-1][0] = testData;
		}
		enterVehicleDataPage.enterVehicleData_truck(testData);
		enterVehicleDataPage.clickNextButton();
		Thread.sleep(2000);
		
		//enter insurant page details
		ExcelOperations excelUtil01 = new ExcelOperations("Insurant_Data");
		int row01 = excelUtil.getRowCount();
		Object[][] object01=new Object[row01][1]; 
		HashMap<String, String> testData01=new HashMap<>();
		for(int i=1; i<=excelUtil01.getRowCount();i++) {
			 testData01 = excelUtil01.getTestTataInMap(i);
			object01[i-1][0] = testData01;
		}
		enterInsurantDataPage.enterInsurantData(testData01);
		enterInsurantDataPage.clickNextButton();
		Thread.sleep(2000);
		
		//product data page
		//header and footer validation
		homePageTest.headerTest();
		homePageTest.footerTest();
		
		//tab validation
		CommonMethods.assertFieldText(DriverFactory.getInstance().getDriver().findElement(enterVehicleDataPage.breadCrumb), "Truck Insurance");
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(enterVehicleDataPage.enterVehicleData_tab).isDisplayed(), " Element "+enterVehicleDataPage.enterVehicleData_tab+" is not displayed on the page");
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(enterVehicleDataPage.enterVehicleData_tab).isEnabled(), " Element "+enterVehicleDataPage.enterVehicleData_tab+" is not enabled");
		CommonMethods.assertFieldText(DriverFactory.getInstance().getDriver().findElement(enterVehicleDataPage.enterProductData_tab_count), "4");
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(enterVehicleDataPage.enterInsurantData_tab).isDisplayed(), " Element "+enterVehicleDataPage.enterInsurantData_tab+" is not displayed on the page");
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(enterVehicleDataPage.enterInsurantData_tab).isEnabled(), " Element "+enterVehicleDataPage.enterInsurantData_tab+" is not enabled");
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(enterVehicleDataPage.enterProductData_tab).isDisplayed(), " Element "+enterVehicleDataPage.enterProductData_tab+" is not displayed on the page");
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(enterVehicleDataPage.enterProductData_tab).isEnabled(), " Element "+enterVehicleDataPage.enterProductData_tab+" is not enabled");
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(enterVehicleDataPage.selectPriceOption_tab).isDisplayed(), " Element "+enterVehicleDataPage.selectPriceOption_tab+" is not displayed on the page");
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(enterVehicleDataPage.selectPriceOption_tab).isEnabled(), " Element "+enterVehicleDataPage.selectPriceOption_tab+" is not enabled");
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(enterVehicleDataPage.sendQuote_tab).isDisplayed(), " Element "+enterVehicleDataPage.sendQuote_tab+" is not displayed on the page");
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(enterVehicleDataPage.sendQuote_tab).isEnabled(), " Element "+enterVehicleDataPage.sendQuote_tab+" is not enabled");
		
		//validate form elements
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(enterProductDataPage.startDateIPBox).isEnabled(), " Element "+enterProductDataPage.startDateIPBox+" is not enabled");
		List<String> insuranceSumDropdownValues = Arrays.asList("3.000.000,00","5.000.000,00","7.000.000,00","10.000.000,00");
		CommonMethods.assertDropdownContainsValues(DriverFactory.getInstance().getDriver().findElement(enterProductDataPage.insuranceSumDropdown),insuranceSumDropdownValues);
		List<String> damageInsuranceDropdownValues = Arrays.asList("No Coverage","Partial Coverage","Full Coverage");
		CommonMethods.assertDropdownContainsValues(DriverFactory.getInstance().getDriver().findElement(enterProductDataPage.damageinsuranceDropdown),damageInsuranceDropdownValues);
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(enterProductDataPage.nextButton).isEnabled(), " Element "+enterProductDataPage.nextButton+" is not enabled");
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(enterProductDataPage.previousButton).isEnabled(), " Element "+enterProductDataPage.previousButton+" is not enabled");		
		Thread.sleep(3000);
	}
	
	@Test(enabled = true)
	public void motorCycle_productData_Pagetest() throws Exception {
		homePage.clickMotorCycleLink();
		//fill vehicle data page
		ExcelOperations excelUtil = new ExcelOperations("motorcycle_data");
		int row = excelUtil.getRowCount();
		Object[][] object=new Object[row][1]; 
		HashMap<String, String> testData=new HashMap<>();
		for(int i=1; i<=excelUtil.getRowCount();i++) {
			 testData = excelUtil.getTestTataInMap(i);
			object[i-1][0] = testData;
		}
		enterVehicleDataPage.enterVehicleData_motorcycle(testData);
		enterVehicleDataPage.clickNextButton();
		Thread.sleep(2000);
		
		//enter insurant page details
		ExcelOperations excelUtil01 = new ExcelOperations("Insurant_Data");
		int row01 = excelUtil.getRowCount();
		Object[][] object01=new Object[row01][1]; 
		HashMap<String, String> testData01=new HashMap<>();
		for(int i=1; i<=excelUtil01.getRowCount();i++) {
			 testData01 = excelUtil01.getTestTataInMap(i);
			object01[i-1][0] = testData01;
		}
		enterInsurantDataPage.enterInsurantData(testData01);
		enterInsurantDataPage.clickNextButton();
		Thread.sleep(2000);
		
		//product data page
		//header and footer validation
		homePageTest.headerTest();
		homePageTest.footerTest();
		
		//tab validation
		CommonMethods.assertFieldText(DriverFactory.getInstance().getDriver().findElement(enterVehicleDataPage.breadCrumb), "Motorcycle Insurance");
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(enterVehicleDataPage.enterVehicleData_tab).isDisplayed(), " Element "+enterVehicleDataPage.enterVehicleData_tab+" is not displayed on the page");
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(enterVehicleDataPage.enterVehicleData_tab).isEnabled(), " Element "+enterVehicleDataPage.enterVehicleData_tab+" is not enabled");
		CommonMethods.assertFieldText(DriverFactory.getInstance().getDriver().findElement(enterVehicleDataPage.enterProductData_tab_count), "4");
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(enterVehicleDataPage.enterInsurantData_tab).isDisplayed(), " Element "+enterVehicleDataPage.enterInsurantData_tab+" is not displayed on the page");
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(enterVehicleDataPage.enterInsurantData_tab).isEnabled(), " Element "+enterVehicleDataPage.enterInsurantData_tab+" is not enabled");
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(enterVehicleDataPage.enterProductData_tab).isDisplayed(), " Element "+enterVehicleDataPage.enterProductData_tab+" is not displayed on the page");
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(enterVehicleDataPage.enterProductData_tab).isEnabled(), " Element "+enterVehicleDataPage.enterProductData_tab+" is not enabled");
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(enterVehicleDataPage.selectPriceOption_tab).isDisplayed(), " Element "+enterVehicleDataPage.selectPriceOption_tab+" is not displayed on the page");
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(enterVehicleDataPage.selectPriceOption_tab).isEnabled(), " Element "+enterVehicleDataPage.selectPriceOption_tab+" is not enabled");
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(enterVehicleDataPage.sendQuote_tab).isDisplayed(), " Element "+enterVehicleDataPage.sendQuote_tab+" is not displayed on the page");
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(enterVehicleDataPage.sendQuote_tab).isEnabled(), " Element "+enterVehicleDataPage.sendQuote_tab+" is not enabled");
		
		//validate form elements
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(enterProductDataPage.startDateIPBox).isEnabled(), " Element "+enterProductDataPage.startDateIPBox+" is not enabled");
		List<String> insuranceSumDropdownValues = Arrays.asList("3.000.000,00","5.000.000,00","7.000.000,00","10.000.000,00");
		CommonMethods.assertDropdownContainsValues(DriverFactory.getInstance().getDriver().findElement(enterProductDataPage.insuranceSumDropdown),insuranceSumDropdownValues);
		List<String> damageInsuranceDropdownValues = Arrays.asList("No Coverage","Partial Coverage","Full Coverage");
		CommonMethods.assertDropdownContainsValues(DriverFactory.getInstance().getDriver().findElement(enterProductDataPage.damageinsuranceDropdown),damageInsuranceDropdownValues);
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(enterProductDataPage.nextButton).isEnabled(), " Element "+enterProductDataPage.nextButton+" is not enabled");
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(enterProductDataPage.previousButton).isEnabled(), " Element "+enterProductDataPage.previousButton+" is not enabled");		
		Thread.sleep(3000);
	}
	
	@Test(enabled = true)
	public void camper_productData_Pagetest() throws Exception {
		homePage.clickCamperLink();
		//fill vehicle data page
		ExcelOperations excelUtil = new ExcelOperations("camper_data");
		int row = excelUtil.getRowCount();
		Object[][] object=new Object[row][1]; 
		HashMap<String, String> testData=new HashMap<>();
		for(int i=1; i<=excelUtil.getRowCount();i++) {
			 testData = excelUtil.getTestTataInMap(i);
			object[i-1][0] = testData;
		}
		enterVehicleDataPage.enterVehicleData_camper(testData);
		enterVehicleDataPage.clickNextButton();
		Thread.sleep(2000);
		
		//enter insurant page details
		ExcelOperations excelUtil01 = new ExcelOperations("Insurant_Data");
		int row01 = excelUtil.getRowCount();
		Object[][] object01=new Object[row01][1]; 
		HashMap<String, String> testData01=new HashMap<>();
		for(int i=1; i<=excelUtil01.getRowCount();i++) {
			 testData01 = excelUtil01.getTestTataInMap(i);
			object01[i-1][0] = testData01;
		}
		enterInsurantDataPage.enterInsurantData(testData01);
		enterInsurantDataPage.clickNextButton();
		Thread.sleep(2000);
		
		//product data page
		//header and footer validation
		homePageTest.headerTest();
		homePageTest.footerTest();
		
		//tab validation
		CommonMethods.assertFieldText(DriverFactory.getInstance().getDriver().findElement(enterVehicleDataPage.breadCrumb), "Camper Insurance");
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(enterVehicleDataPage.enterVehicleData_tab).isDisplayed(), " Element "+enterVehicleDataPage.enterVehicleData_tab+" is not displayed on the page");
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(enterVehicleDataPage.enterVehicleData_tab).isEnabled(), " Element "+enterVehicleDataPage.enterVehicleData_tab+" is not enabled");
		CommonMethods.assertFieldText(DriverFactory.getInstance().getDriver().findElement(enterVehicleDataPage.enterProductData_tab_count), "4");
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(enterVehicleDataPage.enterInsurantData_tab).isDisplayed(), " Element "+enterVehicleDataPage.enterInsurantData_tab+" is not displayed on the page");
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(enterVehicleDataPage.enterInsurantData_tab).isEnabled(), " Element "+enterVehicleDataPage.enterInsurantData_tab+" is not enabled");
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(enterVehicleDataPage.enterProductData_tab).isDisplayed(), " Element "+enterVehicleDataPage.enterProductData_tab+" is not displayed on the page");
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(enterVehicleDataPage.enterProductData_tab).isEnabled(), " Element "+enterVehicleDataPage.enterProductData_tab+" is not enabled");
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(enterVehicleDataPage.selectPriceOption_tab).isDisplayed(), " Element "+enterVehicleDataPage.selectPriceOption_tab+" is not displayed on the page");
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(enterVehicleDataPage.selectPriceOption_tab).isEnabled(), " Element "+enterVehicleDataPage.selectPriceOption_tab+" is not enabled");
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(enterVehicleDataPage.sendQuote_tab).isDisplayed(), " Element "+enterVehicleDataPage.sendQuote_tab+" is not displayed on the page");
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(enterVehicleDataPage.sendQuote_tab).isEnabled(), " Element "+enterVehicleDataPage.sendQuote_tab+" is not enabled");
		
		//validate form elements
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(enterProductDataPage.startDateIPBox).isEnabled(), " Element "+enterProductDataPage.startDateIPBox+" is not enabled");
		List<String> insuranceSumDropdownValues = Arrays.asList("3.000.000,00","5.000.000,00","7.000.000,00","10.000.000,00");
		CommonMethods.assertDropdownContainsValues(DriverFactory.getInstance().getDriver().findElement(enterProductDataPage.insuranceSumDropdown),insuranceSumDropdownValues);
		List<String> damageInsuranceDropdownValues = Arrays.asList("No Coverage","Partial Coverage","Full Coverage");
		CommonMethods.assertDropdownContainsValues(DriverFactory.getInstance().getDriver().findElement(enterProductDataPage.damageinsuranceDropdown),damageInsuranceDropdownValues);
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(enterProductDataPage.nextButton).isEnabled(), " Element "+enterProductDataPage.nextButton+" is not enabled");
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(enterProductDataPage.previousButton).isEnabled(), " Element "+enterProductDataPage.previousButton+" is not enabled");		
		Thread.sleep(3000);
		//enter form details
		ExcelOperations excelUtil02 = new ExcelOperations("Product_Data");
		int row02 = excelUtil.getRowCount();
		Object[][] object02=new Object[row02][1]; 
		HashMap<String, String> testData02=new HashMap<>();
		for(int i=1; i<=excelUtil02.getRowCount();i++) {
			 testData02 = excelUtil02.getTestTataInMap(i);
			object02[i-1][0] = testData02;
		}
		enterProductDataPage.enterProductDataDetails(testData02);
		enterProductDataPage.clickNext();
		Thread.sleep(2000);
	}

}
