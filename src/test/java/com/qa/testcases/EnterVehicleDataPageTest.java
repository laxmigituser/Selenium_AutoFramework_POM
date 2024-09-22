package com.qa.testcases;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.qa.base.DriverFactory;
import com.qa.base.ExtentFactory;
import com.qa.base.TestBase;
import com.qa.pages.EnterVehicleDataPage;
import com.qa.pages.HomePage;
import com.qa.util.CommonMethods;
import com.qa.util.ExcelOperations;

public class EnterVehicleDataPageTest extends TestBase{
	
	HomePage homePage=new HomePage();
	EnterVehicleDataPage enterVehicleDataPage = new EnterVehicleDataPage();
	HomePageTest homePageTest = new HomePageTest();
	
	@Test(enabled = true)
	public void autoMobile_enterVehicleDataPage_test() throws InterruptedException {
		homePage.clickAutoMobileLink();
		Assert.assertEquals(enterVehicleDataPage.getPageTitle(),"Enter Vehicle Data");
		homePageTest.headerTest();
		homePageTest.footerTest();
		CommonMethods.assertFieldText(DriverFactory.getInstance().getDriver().findElement(enterVehicleDataPage.breadCrumb), "Automobile Insurance");
		//validate navigation tab
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(enterVehicleDataPage.enterVehicleData_tab).isDisplayed(), " Element "+enterVehicleDataPage.enterVehicleData_tab+" is not displayed on the page");
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(enterVehicleDataPage.enterVehicleData_tab).isEnabled(), " Element "+enterVehicleDataPage.enterVehicleData_tab+" is not enabled");
		CommonMethods.assertFieldText(DriverFactory.getInstance().getDriver().findElement(enterVehicleDataPage.enterVehicleData_tab_count), "7");
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(enterVehicleDataPage.enterInsurantData_tab).isDisplayed(), " Element "+enterVehicleDataPage.enterInsurantData_tab+" is not displayed on the page");
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(enterVehicleDataPage.enterInsurantData_tab).isEnabled(), " Element "+enterVehicleDataPage.enterInsurantData_tab+" is not enabled");
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(enterVehicleDataPage.enterProductData_tab).isDisplayed(), " Element "+enterVehicleDataPage.enterProductData_tab+" is not displayed on the page");
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(enterVehicleDataPage.enterProductData_tab).isEnabled(), " Element "+enterVehicleDataPage.enterProductData_tab+" is not enabled");
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(enterVehicleDataPage.selectPriceOption_tab).isDisplayed(), " Element "+enterVehicleDataPage.selectPriceOption_tab+" is not displayed on the page");
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(enterVehicleDataPage.selectPriceOption_tab).isEnabled(), " Element "+enterVehicleDataPage.selectPriceOption_tab+" is not enabled");
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(enterVehicleDataPage.sendQuote_tab).isDisplayed(), " Element "+enterVehicleDataPage.sendQuote_tab+" is not displayed on the page");
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(enterVehicleDataPage.sendQuote_tab).isEnabled(), " Element "+enterVehicleDataPage.sendQuote_tab+" is not enabled");
		//validate elements on form
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(enterVehicleDataPage.make_dropdown).isDisplayed(), " Element "+enterVehicleDataPage.make_dropdown+" is not displayed on the page");
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(enterVehicleDataPage.enginePerformanceIPBox).isDisplayed(), " Element "+enterVehicleDataPage.enginePerformanceIPBox+" is not displayed on the page");
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(enterVehicleDataPage.dateOfManufactureIPBox).isDisplayed(), " Element "+enterVehicleDataPage.dateOfManufactureIPBox+" is not displayed on the page");
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(enterVehicleDataPage.numberOfSeatsDropDown).isDisplayed(), " Element "+enterVehicleDataPage.numberOfSeatsDropDown+" is not displayed on the page");
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(enterVehicleDataPage.fuelTypeDropDown).isDisplayed(), " Element "+enterVehicleDataPage.fuelTypeDropDown+" is not displayed on the page");
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(enterVehicleDataPage.listPrice).isDisplayed(), " Element "+enterVehicleDataPage.listPrice+" is not displayed on the page");
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(enterVehicleDataPage.annualmileageIPBox).isDisplayed(), " Element "+enterVehicleDataPage.annualmileageIPBox+" is not displayed on the page");
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(enterVehicleDataPage.licensePlateNoIPBox).isDisplayed(), " Element "+enterVehicleDataPage.licensePlateNoIPBox+" is not displayed on the page");
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(enterVehicleDataPage.nextButton).isDisplayed(), " Element "+enterVehicleDataPage.nextButton+" is not displayed on the page");

		List<String> makeDropdownValues = Arrays.asList("Audi","BMW","Ford","Honda");
		CommonMethods.assertDropdownContainsValues(DriverFactory.getInstance().getDriver().findElement(enterVehicleDataPage.make_dropdown),makeDropdownValues);
		List<String> seatDropdownValues = Arrays.asList("1","2","3","4","5","6","7","8","9");
		CommonMethods.assertDropdownContainsValues(DriverFactory.getInstance().getDriver().findElement(enterVehicleDataPage.numberOfSeatsDropDown),seatDropdownValues);
		List<String> fuelTypeDropdownValues = Arrays.asList("Petrol","Gas","Diesel","Other","Electric Power");
		CommonMethods.assertDropdownContainsValues(DriverFactory.getInstance().getDriver().findElement(enterVehicleDataPage.fuelTypeDropDown),fuelTypeDropdownValues);
		
	}
	
	@Test(enabled = true)
	public void truck_enterVehicleDataPage_test() throws InterruptedException {
		homePage.clickTruckLink();
		Assert.assertEquals(enterVehicleDataPage.getPageTitle(),"Enter Vehicle Data");
		homePageTest.headerTest();
		homePageTest.footerTest();
		CommonMethods.assertFieldText(DriverFactory.getInstance().getDriver().findElement(enterVehicleDataPage.breadCrumb), "Truck Insurance");
		//validate navigation tab
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(enterVehicleDataPage.enterVehicleData_tab).isDisplayed(), " Element "+enterVehicleDataPage.enterVehicleData_tab+" is not displayed on the page");
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(enterVehicleDataPage.enterVehicleData_tab).isEnabled(), " Element "+enterVehicleDataPage.enterVehicleData_tab+" is not enabled");
		CommonMethods.assertFieldText(DriverFactory.getInstance().getDriver().findElement(enterVehicleDataPage.enterVehicleData_tab_count), "9");
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(enterVehicleDataPage.enterInsurantData_tab).isDisplayed(), " Element "+enterVehicleDataPage.enterInsurantData_tab+" is not displayed on the page");
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(enterVehicleDataPage.enterInsurantData_tab).isEnabled(), " Element "+enterVehicleDataPage.enterInsurantData_tab+" is not enabled");
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(enterVehicleDataPage.enterProductData_tab).isDisplayed(), " Element "+enterVehicleDataPage.enterProductData_tab+" is not displayed on the page");
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(enterVehicleDataPage.enterProductData_tab).isEnabled(), " Element "+enterVehicleDataPage.enterProductData_tab+" is not enabled");
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(enterVehicleDataPage.selectPriceOption_tab).isDisplayed(), " Element "+enterVehicleDataPage.selectPriceOption_tab+" is not displayed on the page");
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(enterVehicleDataPage.selectPriceOption_tab).isEnabled(), " Element "+enterVehicleDataPage.selectPriceOption_tab+" is not enabled");
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(enterVehicleDataPage.sendQuote_tab).isDisplayed(), " Element "+enterVehicleDataPage.sendQuote_tab+" is not displayed on the page");
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(enterVehicleDataPage.sendQuote_tab).isEnabled(), " Element "+enterVehicleDataPage.sendQuote_tab+" is not enabled");
		//validate elements on form
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(enterVehicleDataPage.make_dropdown).isDisplayed(), " Element "+enterVehicleDataPage.make_dropdown+" is not displayed on the page");
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(enterVehicleDataPage.enginePerformanceIPBox).isDisplayed(), " Element "+enterVehicleDataPage.enginePerformanceIPBox+" is not displayed on the page");
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(enterVehicleDataPage.dateOfManufactureIPBox).isDisplayed(), " Element "+enterVehicleDataPage.dateOfManufactureIPBox+" is not displayed on the page");
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(enterVehicleDataPage.numberOfSeatsDropDown).isDisplayed(), " Element "+enterVehicleDataPage.numberOfSeatsDropDown+" is not displayed on the page");
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(enterVehicleDataPage.fuelTypeDropDown).isDisplayed(), " Element "+enterVehicleDataPage.fuelTypeDropDown+" is not displayed on the page");
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(enterVehicleDataPage.listPrice).isDisplayed(), " Element "+enterVehicleDataPage.listPrice+" is not displayed on the page");
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(enterVehicleDataPage.annualmileageIPBox).isDisplayed(), " Element "+enterVehicleDataPage.annualmileageIPBox+" is not displayed on the page");
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(enterVehicleDataPage.licensePlateNoIPBox).isDisplayed(), " Element "+enterVehicleDataPage.licensePlateNoIPBox+" is not displayed on the page");
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(enterVehicleDataPage.payload).isDisplayed(), " Element "+enterVehicleDataPage.payload+" is not displayed on the page");
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(enterVehicleDataPage.totalWeight).isDisplayed(), " Element "+enterVehicleDataPage.totalWeight+" is not displayed on the page");
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(enterVehicleDataPage.nextButton).isDisplayed(), " Element "+enterVehicleDataPage.nextButton+" is not displayed on the page");

		List<String> makeDropdownValues = Arrays.asList("Audi","BMW","Ford","Honda");
		CommonMethods.assertDropdownContainsValues(DriverFactory.getInstance().getDriver().findElement(enterVehicleDataPage.make_dropdown),makeDropdownValues);
		List<String> seatDropdownValues = Arrays.asList("1","2","3","4","5","6","7","8","9");
		CommonMethods.assertDropdownContainsValues(DriverFactory.getInstance().getDriver().findElement(enterVehicleDataPage.numberOfSeatsDropDown),seatDropdownValues);
		List<String> fuelTypeDropdownValues = Arrays.asList("Petrol","Gas","Diesel","Other","Electric Power");
		CommonMethods.assertDropdownContainsValues(DriverFactory.getInstance().getDriver().findElement(enterVehicleDataPage.fuelTypeDropDown),fuelTypeDropdownValues);
		
	}
	
	@Test(enabled = true)
	public void motorCycle_enterVehicleDataPage_test() throws InterruptedException {
		homePage.clickMotorCycleLink();
		Assert.assertEquals(enterVehicleDataPage.getPageTitle(),"Enter Vehicle Data");
		homePageTest.headerTest();
		homePageTest.footerTest();
		CommonMethods.assertFieldText(DriverFactory.getInstance().getDriver().findElement(enterVehicleDataPage.breadCrumb), "Motorcycle Insurance");
		//validate navigation tab
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(enterVehicleDataPage.enterVehicleData_tab).isDisplayed(), " Element "+enterVehicleDataPage.enterVehicleData_tab+" is not displayed on the page");
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(enterVehicleDataPage.enterVehicleData_tab).isEnabled(), " Element "+enterVehicleDataPage.enterVehicleData_tab+" is not enabled");
		CommonMethods.assertFieldText(DriverFactory.getInstance().getDriver().findElement(enterVehicleDataPage.enterVehicleData_tab_count), "8");
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(enterVehicleDataPage.enterInsurantData_tab).isDisplayed(), " Element "+enterVehicleDataPage.enterInsurantData_tab+" is not displayed on the page");
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(enterVehicleDataPage.enterInsurantData_tab).isEnabled(), " Element "+enterVehicleDataPage.enterInsurantData_tab+" is not enabled");
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(enterVehicleDataPage.enterProductData_tab).isDisplayed(), " Element "+enterVehicleDataPage.enterProductData_tab+" is not displayed on the page");
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(enterVehicleDataPage.enterProductData_tab).isEnabled(), " Element "+enterVehicleDataPage.enterProductData_tab+" is not enabled");
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(enterVehicleDataPage.selectPriceOption_tab).isDisplayed(), " Element "+enterVehicleDataPage.selectPriceOption_tab+" is not displayed on the page");
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(enterVehicleDataPage.selectPriceOption_tab).isEnabled(), " Element "+enterVehicleDataPage.selectPriceOption_tab+" is not enabled");
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(enterVehicleDataPage.sendQuote_tab).isDisplayed(), " Element "+enterVehicleDataPage.sendQuote_tab+" is not displayed on the page");
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(enterVehicleDataPage.sendQuote_tab).isEnabled(), " Element "+enterVehicleDataPage.sendQuote_tab+" is not enabled");
		//validate elements on form
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(enterVehicleDataPage.make_dropdown).isDisplayed(), " Element "+enterVehicleDataPage.make_dropdown+" is not displayed on the page");
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(enterVehicleDataPage.enginePerformanceIPBox).isDisplayed(), " Element "+enterVehicleDataPage.enginePerformanceIPBox+" is not displayed on the page");
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(enterVehicleDataPage.dateOfManufactureIPBox).isDisplayed(), " Element "+enterVehicleDataPage.dateOfManufactureIPBox+" is not displayed on the page");
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(enterVehicleDataPage.numberOfSeatsDropDown_motorcycle).isDisplayed(), " Element "+enterVehicleDataPage.numberOfSeatsDropDown_motorcycle+" is not displayed on the page");
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(enterVehicleDataPage.cylinder_capacity).isDisplayed(), " Element "+enterVehicleDataPage.fuelTypeDropDown+" is not displayed on the page");
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(enterVehicleDataPage.listPrice).isDisplayed(), " Element "+enterVehicleDataPage.listPrice+" is not displayed on the page");
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(enterVehicleDataPage.annualmileageIPBox).isDisplayed(), " Element "+enterVehicleDataPage.annualmileageIPBox+" is not displayed on the page");
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(enterVehicleDataPage.model_dropdown).isDisplayed(), " Element "+enterVehicleDataPage.licensePlateNoIPBox+" is not displayed on the page");
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(enterVehicleDataPage.nextButton).isDisplayed(), " Element "+enterVehicleDataPage.nextButton+" is not displayed on the page");

		List<String> makeDropdownValues = Arrays.asList("Audi","BMW","Ford","Honda");
		CommonMethods.assertDropdownContainsValues(DriverFactory.getInstance().getDriver().findElement(enterVehicleDataPage.make_dropdown),makeDropdownValues);
		List<String> seatDropdownValues = Arrays.asList("1","2","3");
		CommonMethods.assertDropdownContainsValues(DriverFactory.getInstance().getDriver().findElement(enterVehicleDataPage.numberOfSeatsDropDown_motorcycle),seatDropdownValues);
		List<String> modelDropdownValues = Arrays.asList("Scooter","Moped","Motorcycle","Three-Wheeler");
		CommonMethods.assertDropdownContainsValues(DriverFactory.getInstance().getDriver().findElement(enterVehicleDataPage.model_dropdown),modelDropdownValues);	
	}
	
	@Test(enabled = true)
	public void camper_enterVehicleDataPage_test() throws InterruptedException {
		homePage.clickCamperLink();
		Assert.assertEquals(enterVehicleDataPage.getPageTitle(),"Enter Vehicle Data");
		homePageTest.headerTest();
		homePageTest.footerTest();
		CommonMethods.assertFieldText(DriverFactory.getInstance().getDriver().findElement(enterVehicleDataPage.breadCrumb), "Camper Insurance");
		//validate navigation tab
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(enterVehicleDataPage.enterVehicleData_tab).isDisplayed(), " Element "+enterVehicleDataPage.enterVehicleData_tab+" is not displayed on the page");
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(enterVehicleDataPage.enterVehicleData_tab).isEnabled(), " Element "+enterVehicleDataPage.enterVehicleData_tab+" is not enabled");
		CommonMethods.assertFieldText(DriverFactory.getInstance().getDriver().findElement(enterVehicleDataPage.enterVehicleData_tab_count), "9");
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(enterVehicleDataPage.enterInsurantData_tab).isDisplayed(), " Element "+enterVehicleDataPage.enterInsurantData_tab+" is not displayed on the page");
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(enterVehicleDataPage.enterInsurantData_tab).isEnabled(), " Element "+enterVehicleDataPage.enterInsurantData_tab+" is not enabled");
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(enterVehicleDataPage.enterProductData_tab).isDisplayed(), " Element "+enterVehicleDataPage.enterProductData_tab+" is not displayed on the page");
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(enterVehicleDataPage.enterProductData_tab).isEnabled(), " Element "+enterVehicleDataPage.enterProductData_tab+" is not enabled");
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(enterVehicleDataPage.selectPriceOption_tab).isDisplayed(), " Element "+enterVehicleDataPage.selectPriceOption_tab+" is not displayed on the page");
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(enterVehicleDataPage.selectPriceOption_tab).isEnabled(), " Element "+enterVehicleDataPage.selectPriceOption_tab+" is not enabled");
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(enterVehicleDataPage.sendQuote_tab).isDisplayed(), " Element "+enterVehicleDataPage.sendQuote_tab+" is not displayed on the page");
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(enterVehicleDataPage.sendQuote_tab).isEnabled(), " Element "+enterVehicleDataPage.sendQuote_tab+" is not enabled");
		//validate elements on form
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(enterVehicleDataPage.make_dropdown).isDisplayed(), " Element "+enterVehicleDataPage.make_dropdown+" is not displayed on the page");
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(enterVehicleDataPage.enginePerformanceIPBox).isDisplayed(), " Element "+enterVehicleDataPage.enginePerformanceIPBox+" is not displayed on the page");
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(enterVehicleDataPage.dateOfManufactureIPBox).isDisplayed(), " Element "+enterVehicleDataPage.dateOfManufactureIPBox+" is not displayed on the page");
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(enterVehicleDataPage.fuelTypeDropDown).isDisplayed(), " Element "+enterVehicleDataPage.fuelTypeDropDown+" is not displayed on the page");
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(enterVehicleDataPage.payload).isDisplayed(), " Element "+enterVehicleDataPage.payload+" is not displayed on the page");
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(enterVehicleDataPage.totalWeight).isDisplayed(), " Element "+enterVehicleDataPage.totalWeight+" is not displayed on the page");
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(enterVehicleDataPage.listPrice).isDisplayed(), " Element "+enterVehicleDataPage.listPrice+" is not displayed on the page");
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(enterVehicleDataPage.annualmileageIPBox).isDisplayed(), " Element "+enterVehicleDataPage.annualmileageIPBox+" is not displayed on the page");
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(enterVehicleDataPage.licensePlateNoIPBox).isDisplayed(), " Element "+enterVehicleDataPage.licensePlateNoIPBox+" is not displayed on the page");
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(enterVehicleDataPage.right_hand_drive_yes_radioBtn).isDisplayed(), " Element "+enterVehicleDataPage.right_hand_drive_yes_radioBtn+" is not displayed on the page");
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(enterVehicleDataPage.right_hand_drive_no_radioBtn).isDisplayed(), " Element "+enterVehicleDataPage.right_hand_drive_no_radioBtn+" is not displayed on the page");

		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(enterVehicleDataPage.nextButton).isDisplayed(), " Element "+enterVehicleDataPage.nextButton+" is not displayed on the page");

		List<String> makeDropdownValues = Arrays.asList("Audi","BMW","Ford","Honda");
		CommonMethods.assertDropdownContainsValues(DriverFactory.getInstance().getDriver().findElement(enterVehicleDataPage.make_dropdown),makeDropdownValues);
		List<String> seatDropdownValues = Arrays.asList("1","2","3");
		CommonMethods.assertDropdownContainsValues(DriverFactory.getInstance().getDriver().findElement(enterVehicleDataPage.numberOfSeatsDropDown),seatDropdownValues);
		List<String> fuelTypeDropdownValues = Arrays.asList("Petrol","Gas","Other","Diesel","Electric Power");
		CommonMethods.assertDropdownContainsValues(DriverFactory.getInstance().getDriver().findElement(enterVehicleDataPage.fuelTypeDropDown),fuelTypeDropdownValues);
		
	}

	@DataProvider(name = "Automobile_Data")
	public Object[][] getTestdata() throws Exception{
		ExcelOperations excelUtil = new ExcelOperations("Automobile_Data");
		int row = excelUtil.getRowCount();
		Object[][] obj=new Object[row][1]; // 1 cz we will pass hashmap
		for(int i=1; i<=excelUtil.getRowCount();i++) {
			HashMap<String, String> testData = excelUtil.getTestTataInMap(i);
			obj[i-1][0] = testData;
		}		
		return obj;
	}
	@Test(dataProvider = "Automobile_Data")
	public void enterAutomobileDataTest(Object obj,ITestContext context) throws Exception {
		homePage.clickAutoMobileLink();
		HashMap<String, String> testData =(HashMap<String, String>) obj;
		context.setAttribute("testDataMap", testData);
		enterVehicleDataPage.enterVehicleData_automobile(testData);
		Thread.sleep(5000);
	}
	@DataProvider(name = "Truck_Data")
	public Object[][] getTruckdata() throws Exception{
		ExcelOperations excelUtil = new ExcelOperations("Truck_Data");
		int row = excelUtil.getRowCount();
		Object[][] obj=new Object[row][1]; // 1 cz we will pass hashmap
		for(int i=1; i<=excelUtil.getRowCount();i++) {
			HashMap<String, String> testData = excelUtil.getTestTataInMap(i);
			obj[i-1][0] = testData;
		}		
		return obj;
	}
	@Test(dataProvider = "Truck_Data")
	public void enterTruckDataTest(Object obj,ITestContext context) throws Exception {
		homePage.clickTruckLink();
		HashMap<String, String> testData =(HashMap<String, String>) obj;
		context.setAttribute("testDataMap", testData);
		enterVehicleDataPage.enterVehicleData_truck(testData);
		Thread.sleep(5000);
	}
	@DataProvider(name = "motorcycle_Data")
	public Object[][] getMotorCycledata() throws Exception{
		ExcelOperations excelUtil = new ExcelOperations("motorcycle_data");
		int row = excelUtil.getRowCount();
		Object[][] obj=new Object[row][1]; // 1 cz we will pass hashmap
		for(int i=1; i<=excelUtil.getRowCount();i++) {
			HashMap<String, String> testData = excelUtil.getTestTataInMap(i);
			obj[i-1][0] = testData;
		}		
		return obj;
	}
	@Test(dataProvider = "motorcycle_Data")
	public void enterMotorCycleDataTest(Object obj,ITestContext context) throws Exception {
		homePage.clickMotorCycleLink();
		HashMap<String, String> testData =(HashMap<String, String>) obj;
		context.setAttribute("testDataMap", testData);
		enterVehicleDataPage.enterVehicleData_motorcycle(testData);
		Thread.sleep(5000);
	}
	
	@DataProvider(name = "Camper_Data")
	public Object[][] getCamperdata() throws Exception{
		ExcelOperations excelUtil = new ExcelOperations("camper_data");
		int row = excelUtil.getRowCount();
		Object[][] obj=new Object[row][1]; // 1 cz we will pass hashmap
		for(int i=1; i<=excelUtil.getRowCount();i++) {
			HashMap<String, String> testData = excelUtil.getTestTataInMap(i);
			obj[i-1][0] = testData;
		}		
		return obj;
	}
	@Test(dataProvider = "Camper_Data")
	public void enterCamperDataTest(Object obj,ITestContext context) throws Exception {
		homePage.clickCamperLink();
		HashMap<String, String> testData =(HashMap<String, String>) obj;
		context.setAttribute("testDataMap", testData);
		enterVehicleDataPage.enterVehicleData_camper(testData);
		Thread.sleep(5000);
	}
}
