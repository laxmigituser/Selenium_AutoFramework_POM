package com.qa.testcases;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.base.DriverFactory;
import com.qa.base.TestBase;
import com.qa.pages.EnterInsurantDataPage;
import com.qa.pages.EnterVehicleDataPage;
import com.qa.pages.HomePage;
import com.qa.util.CommonMethods;
import com.qa.util.ExcelOperations;

public class EnterInsurantDataPageTest extends TestBase{
	
	HomePage homePage = new HomePage();
	HomePageTest homePageTest = new HomePageTest();
	EnterVehicleDataPage enterVehicleDataPage = new EnterVehicleDataPage();
	EnterInsurantDataPage enterInsurantDataPage = new EnterInsurantDataPage();
	
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
	@Test(dataProvider = "Automobile_Data",enabled = true)
	public void autoMobile_enterInsurantDataPage_test(Object obj) throws Exception {
		//navigate to insurant data page
		homePage.clickAutoMobileLink();
		HashMap<String, String> testData =(HashMap<String, String>) obj;
		enterVehicleDataPage.enterVehicleData_automobile(testData);
		enterVehicleDataPage.clickNextButton();
		//verify header and footer elements
		Assert.assertEquals(enterVehicleDataPage.getPageTitle(),"Enter Insurant Data");
		homePageTest.headerTest();
		homePageTest.footerTest();
		//validate navigation tab
		CommonMethods.assertFieldText(DriverFactory.getInstance().getDriver().findElement(enterVehicleDataPage.breadCrumb), "Automobile Insurance");
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(enterVehicleDataPage.enterVehicleData_tab).isDisplayed(), " Element "+enterVehicleDataPage.enterVehicleData_tab+" is not displayed on the page");
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(enterVehicleDataPage.enterVehicleData_tab).isEnabled(), " Element "+enterVehicleDataPage.enterVehicleData_tab+" is not enabled");
		CommonMethods.assertFieldText(DriverFactory.getInstance().getDriver().findElement(enterVehicleDataPage.enterInsurantData_tab_count), "7");
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(enterVehicleDataPage.enterInsurantData_tab).isDisplayed(), " Element "+enterVehicleDataPage.enterInsurantData_tab+" is not displayed on the page");
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(enterVehicleDataPage.enterInsurantData_tab).isEnabled(), " Element "+enterVehicleDataPage.enterInsurantData_tab+" is not enabled");
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(enterVehicleDataPage.enterProductData_tab).isDisplayed(), " Element "+enterVehicleDataPage.enterProductData_tab+" is not displayed on the page");
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(enterVehicleDataPage.enterProductData_tab).isEnabled(), " Element "+enterVehicleDataPage.enterProductData_tab+" is not enabled");
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(enterVehicleDataPage.selectPriceOption_tab).isDisplayed(), " Element "+enterVehicleDataPage.selectPriceOption_tab+" is not displayed on the page");
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(enterVehicleDataPage.selectPriceOption_tab).isEnabled(), " Element "+enterVehicleDataPage.selectPriceOption_tab+" is not enabled");
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(enterVehicleDataPage.sendQuote_tab).isDisplayed(), " Element "+enterVehicleDataPage.sendQuote_tab+" is not displayed on the page");
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(enterVehicleDataPage.sendQuote_tab).isEnabled(), " Element "+enterVehicleDataPage.sendQuote_tab+" is not enabled");
		//validate form elements
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(enterInsurantDataPage.firstNameIPBox).isEnabled(), " Element "+enterInsurantDataPage.firstNameIPBox+" is not enabled");
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(enterInsurantDataPage.lastNameIPBox).isEnabled(), " Element "+enterInsurantDataPage.lastNameIPBox+" is not enabled");
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(enterInsurantDataPage.dateOfBirthIPBox).isEnabled(), " Element "+enterInsurantDataPage.dateOfBirthIPBox+" is not enabled");
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(enterInsurantDataPage.maleRadioBtn).isEnabled(), " Element "+enterInsurantDataPage.maleRadioBtn+" is not enabled");
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(enterInsurantDataPage.femaleRadioBtn).isEnabled(), " Element "+enterInsurantDataPage.femaleRadioBtn+" is not enabled");
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(enterInsurantDataPage.streetAddressIPBox).isEnabled(), " Element "+enterInsurantDataPage.streetAddressIPBox+" is not enabled");
		List<String> countryDropdownValues = Arrays.asList("Brazil","Austria","Benin","China");
		CommonMethods.assertDropdownContainsValues(DriverFactory.getInstance().getDriver().findElement(enterInsurantDataPage.countryDropdown),countryDropdownValues);
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(enterInsurantDataPage.zipCodeIPBox).isEnabled(), " Element "+enterInsurantDataPage.zipCodeIPBox+" is not enabled");
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(enterInsurantDataPage.cityIPBox).isEnabled(), " Element "+enterInsurantDataPage.cityIPBox+" is not enabled");
		List<String> occupationDropdownValues = Arrays.asList("Employee","Farmer","Public Official","Unemployed");
		CommonMethods.assertDropdownContainsValues(DriverFactory.getInstance().getDriver().findElement(enterInsurantDataPage.occupationDropdown),occupationDropdownValues);
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(enterInsurantDataPage.websiteIPBox).isEnabled(), " Element "+enterInsurantDataPage.websiteIPBox+" is not enabled");
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(enterInsurantDataPage.pictureIPBox).isEnabled(), " Element "+enterInsurantDataPage.pictureIPBox+" is not enabled");		
		Thread.sleep(3000);
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
	@Test(dataProvider = "Truck_Data",enabled = true)
	public void truck_enterInsurantDataPage_test(Object obj) throws Exception {
		//navigate to insurant data page
		homePage.clickTruckLink();
		HashMap<String, String> testData =(HashMap<String, String>) obj;
		enterVehicleDataPage.enterVehicleData_truck(testData);
		enterVehicleDataPage.clickNextButton();
		//verify header and footer elements
		Assert.assertEquals(enterVehicleDataPage.getPageTitle(),"Enter Insurant Data");
		homePageTest.headerTest();
		homePageTest.footerTest();
		//validate navigation tab
		CommonMethods.assertFieldText(DriverFactory.getInstance().getDriver().findElement(enterVehicleDataPage.breadCrumb), "Truck Insurance");
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(enterVehicleDataPage.enterVehicleData_tab).isDisplayed(), " Element "+enterVehicleDataPage.enterVehicleData_tab+" is not displayed on the page");
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(enterVehicleDataPage.enterVehicleData_tab).isEnabled(), " Element "+enterVehicleDataPage.enterVehicleData_tab+" is not enabled");
		CommonMethods.assertFieldText(DriverFactory.getInstance().getDriver().findElement(enterVehicleDataPage.enterInsurantData_tab_count), "7");
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(enterVehicleDataPage.enterInsurantData_tab).isDisplayed(), " Element "+enterVehicleDataPage.enterInsurantData_tab+" is not displayed on the page");
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(enterVehicleDataPage.enterInsurantData_tab).isEnabled(), " Element "+enterVehicleDataPage.enterInsurantData_tab+" is not enabled");
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(enterVehicleDataPage.enterProductData_tab).isDisplayed(), " Element "+enterVehicleDataPage.enterProductData_tab+" is not displayed on the page");
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(enterVehicleDataPage.enterProductData_tab).isEnabled(), " Element "+enterVehicleDataPage.enterProductData_tab+" is not enabled");
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(enterVehicleDataPage.selectPriceOption_tab).isDisplayed(), " Element "+enterVehicleDataPage.selectPriceOption_tab+" is not displayed on the page");
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(enterVehicleDataPage.selectPriceOption_tab).isEnabled(), " Element "+enterVehicleDataPage.selectPriceOption_tab+" is not enabled");
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(enterVehicleDataPage.sendQuote_tab).isDisplayed(), " Element "+enterVehicleDataPage.sendQuote_tab+" is not displayed on the page");
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(enterVehicleDataPage.sendQuote_tab).isEnabled(), " Element "+enterVehicleDataPage.sendQuote_tab+" is not enabled");
		//validate form elements
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(enterInsurantDataPage.firstNameIPBox).isEnabled(), " Element "+enterInsurantDataPage.firstNameIPBox+" is not enabled");
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(enterInsurantDataPage.lastNameIPBox).isEnabled(), " Element "+enterInsurantDataPage.lastNameIPBox+" is not enabled");
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(enterInsurantDataPage.dateOfBirthIPBox).isEnabled(), " Element "+enterInsurantDataPage.dateOfBirthIPBox+" is not enabled");
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(enterInsurantDataPage.maleRadioBtn).isEnabled(), " Element "+enterInsurantDataPage.maleRadioBtn+" is not enabled");
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(enterInsurantDataPage.femaleRadioBtn).isEnabled(), " Element "+enterInsurantDataPage.femaleRadioBtn+" is not enabled");
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(enterInsurantDataPage.streetAddressIPBox).isEnabled(), " Element "+enterInsurantDataPage.streetAddressIPBox+" is not enabled");
		List<String> countryDropdownValues = Arrays.asList("Brazil","Austria","Benin","China");
		CommonMethods.assertDropdownContainsValues(DriverFactory.getInstance().getDriver().findElement(enterInsurantDataPage.countryDropdown),countryDropdownValues);
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(enterInsurantDataPage.zipCodeIPBox).isEnabled(), " Element "+enterInsurantDataPage.zipCodeIPBox+" is not enabled");
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(enterInsurantDataPage.cityIPBox).isEnabled(), " Element "+enterInsurantDataPage.cityIPBox+" is not enabled");
		List<String> occupationDropdownValues = Arrays.asList("Employee","Farmer","Public Official","Unemployed");
		CommonMethods.assertDropdownContainsValues(DriverFactory.getInstance().getDriver().findElement(enterInsurantDataPage.occupationDropdown),occupationDropdownValues);
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(enterInsurantDataPage.websiteIPBox).isEnabled(), " Element "+enterInsurantDataPage.websiteIPBox+" is not enabled");
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(enterInsurantDataPage.pictureIPBox).isEnabled(), " Element "+enterInsurantDataPage.pictureIPBox+" is not enabled");		
		Thread.sleep(3000);
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
	@Test(dataProvider = "motorcycle_Data",enabled = true)
	public void motorcycle_enterInsurantDataPage_test(Object obj) throws Exception {
		//navigate to insurant data page
		homePage.clickMotorCycleLink();
		HashMap<String, String> testData =(HashMap<String, String>) obj;
		enterVehicleDataPage.enterVehicleData_motorcycle(testData);
		enterVehicleDataPage.clickNextButton();
		//verify header and footer elements
		Assert.assertEquals(enterVehicleDataPage.getPageTitle(),"Enter Insurant Data");
		homePageTest.headerTest();
		homePageTest.footerTest();
		//validate navigation tab
		CommonMethods.assertFieldText(DriverFactory.getInstance().getDriver().findElement(enterVehicleDataPage.breadCrumb), "Motorcycle Insurance");
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(enterVehicleDataPage.enterVehicleData_tab).isDisplayed(), " Element "+enterVehicleDataPage.enterVehicleData_tab+" is not displayed on the page");
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(enterVehicleDataPage.enterVehicleData_tab).isEnabled(), " Element "+enterVehicleDataPage.enterVehicleData_tab+" is not enabled");
		CommonMethods.assertFieldText(DriverFactory.getInstance().getDriver().findElement(enterVehicleDataPage.enterInsurantData_tab_count), "7");
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(enterVehicleDataPage.enterInsurantData_tab).isDisplayed(), " Element "+enterVehicleDataPage.enterInsurantData_tab+" is not displayed on the page");
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(enterVehicleDataPage.enterInsurantData_tab).isEnabled(), " Element "+enterVehicleDataPage.enterInsurantData_tab+" is not enabled");
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(enterVehicleDataPage.enterProductData_tab).isDisplayed(), " Element "+enterVehicleDataPage.enterProductData_tab+" is not displayed on the page");
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(enterVehicleDataPage.enterProductData_tab).isEnabled(), " Element "+enterVehicleDataPage.enterProductData_tab+" is not enabled");
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(enterVehicleDataPage.selectPriceOption_tab).isDisplayed(), " Element "+enterVehicleDataPage.selectPriceOption_tab+" is not displayed on the page");
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(enterVehicleDataPage.selectPriceOption_tab).isEnabled(), " Element "+enterVehicleDataPage.selectPriceOption_tab+" is not enabled");
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(enterVehicleDataPage.sendQuote_tab).isDisplayed(), " Element "+enterVehicleDataPage.sendQuote_tab+" is not displayed on the page");
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(enterVehicleDataPage.sendQuote_tab).isEnabled(), " Element "+enterVehicleDataPage.sendQuote_tab+" is not enabled");
		//validate form elements
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(enterInsurantDataPage.firstNameIPBox).isEnabled(), " Element "+enterInsurantDataPage.firstNameIPBox+" is not enabled");
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(enterInsurantDataPage.lastNameIPBox).isEnabled(), " Element "+enterInsurantDataPage.lastNameIPBox+" is not enabled");
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(enterInsurantDataPage.dateOfBirthIPBox).isEnabled(), " Element "+enterInsurantDataPage.dateOfBirthIPBox+" is not enabled");
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(enterInsurantDataPage.maleRadioBtn).isEnabled(), " Element "+enterInsurantDataPage.maleRadioBtn+" is not enabled");
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(enterInsurantDataPage.femaleRadioBtn).isEnabled(), " Element "+enterInsurantDataPage.femaleRadioBtn+" is not enabled");
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(enterInsurantDataPage.streetAddressIPBox).isEnabled(), " Element "+enterInsurantDataPage.streetAddressIPBox+" is not enabled");
		List<String> countryDropdownValues = Arrays.asList("Brazil","Austria","Benin","China");
		CommonMethods.assertDropdownContainsValues(DriverFactory.getInstance().getDriver().findElement(enterInsurantDataPage.countryDropdown),countryDropdownValues);
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(enterInsurantDataPage.zipCodeIPBox).isEnabled(), " Element "+enterInsurantDataPage.zipCodeIPBox+" is not enabled");
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(enterInsurantDataPage.cityIPBox).isEnabled(), " Element "+enterInsurantDataPage.cityIPBox+" is not enabled");
		List<String> occupationDropdownValues = Arrays.asList("Employee","Farmer","Public Official","Unemployed");
		CommonMethods.assertDropdownContainsValues(DriverFactory.getInstance().getDriver().findElement(enterInsurantDataPage.occupationDropdown),occupationDropdownValues);
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(enterInsurantDataPage.websiteIPBox).isEnabled(), " Element "+enterInsurantDataPage.websiteIPBox+" is not enabled");
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(enterInsurantDataPage.pictureIPBox).isEnabled(), " Element "+enterInsurantDataPage.pictureIPBox+" is not enabled");		
		Thread.sleep(3000);
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
	@Test(dataProvider = "Camper_Data",enabled = true)
	public void camper_enterInsurantDataPage_test(Object obj) throws Exception {
		//navigate to insurant data page
		homePage.clickCamperLink();
		HashMap<String, String> testData =(HashMap<String, String>) obj;
		enterVehicleDataPage.enterVehicleData_camper(testData);
		enterVehicleDataPage.clickNextButton();
		//verify header and footer elements
		Assert.assertEquals(enterVehicleDataPage.getPageTitle(),"Enter Insurant Data");
		homePageTest.headerTest();
		homePageTest.footerTest();
		//validate navigation tab
		CommonMethods.assertFieldText(DriverFactory.getInstance().getDriver().findElement(enterVehicleDataPage.breadCrumb), "Camper Insurance");
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(enterVehicleDataPage.enterVehicleData_tab).isDisplayed(), " Element "+enterVehicleDataPage.enterVehicleData_tab+" is not displayed on the page");
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(enterVehicleDataPage.enterVehicleData_tab).isEnabled(), " Element "+enterVehicleDataPage.enterVehicleData_tab+" is not enabled");
		CommonMethods.assertFieldText(DriverFactory.getInstance().getDriver().findElement(enterVehicleDataPage.enterInsurantData_tab_count), "7");
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(enterVehicleDataPage.enterInsurantData_tab).isDisplayed(), " Element "+enterVehicleDataPage.enterInsurantData_tab+" is not displayed on the page");
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(enterVehicleDataPage.enterInsurantData_tab).isEnabled(), " Element "+enterVehicleDataPage.enterInsurantData_tab+" is not enabled");
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(enterVehicleDataPage.enterProductData_tab).isDisplayed(), " Element "+enterVehicleDataPage.enterProductData_tab+" is not displayed on the page");
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(enterVehicleDataPage.enterProductData_tab).isEnabled(), " Element "+enterVehicleDataPage.enterProductData_tab+" is not enabled");
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(enterVehicleDataPage.selectPriceOption_tab).isDisplayed(), " Element "+enterVehicleDataPage.selectPriceOption_tab+" is not displayed on the page");
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(enterVehicleDataPage.selectPriceOption_tab).isEnabled(), " Element "+enterVehicleDataPage.selectPriceOption_tab+" is not enabled");
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(enterVehicleDataPage.sendQuote_tab).isDisplayed(), " Element "+enterVehicleDataPage.sendQuote_tab+" is not displayed on the page");
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(enterVehicleDataPage.sendQuote_tab).isEnabled(), " Element "+enterVehicleDataPage.sendQuote_tab+" is not enabled");
		//validate form elements
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(enterInsurantDataPage.firstNameIPBox).isEnabled(), " Element "+enterInsurantDataPage.firstNameIPBox+" is not enabled");
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(enterInsurantDataPage.lastNameIPBox).isEnabled(), " Element "+enterInsurantDataPage.lastNameIPBox+" is not enabled");
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(enterInsurantDataPage.dateOfBirthIPBox).isEnabled(), " Element "+enterInsurantDataPage.dateOfBirthIPBox+" is not enabled");
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(enterInsurantDataPage.maleRadioBtn).isEnabled(), " Element "+enterInsurantDataPage.maleRadioBtn+" is not enabled");
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(enterInsurantDataPage.femaleRadioBtn).isEnabled(), " Element "+enterInsurantDataPage.femaleRadioBtn+" is not enabled");
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(enterInsurantDataPage.streetAddressIPBox).isEnabled(), " Element "+enterInsurantDataPage.streetAddressIPBox+" is not enabled");
		List<String> countryDropdownValues = Arrays.asList("Brazil","Austria","Benin","China");
		CommonMethods.assertDropdownContainsValues(DriverFactory.getInstance().getDriver().findElement(enterInsurantDataPage.countryDropdown),countryDropdownValues);
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(enterInsurantDataPage.zipCodeIPBox).isEnabled(), " Element "+enterInsurantDataPage.zipCodeIPBox+" is not enabled");
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(enterInsurantDataPage.cityIPBox).isEnabled(), " Element "+enterInsurantDataPage.cityIPBox+" is not enabled");
		List<String> occupationDropdownValues = Arrays.asList("Employee","Farmer","Public Official","Unemployed");
		CommonMethods.assertDropdownContainsValues(DriverFactory.getInstance().getDriver().findElement(enterInsurantDataPage.occupationDropdown),occupationDropdownValues);
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(enterInsurantDataPage.websiteIPBox).isEnabled(), " Element "+enterInsurantDataPage.websiteIPBox+" is not enabled");
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(enterInsurantDataPage.pictureIPBox).isEnabled(), " Element "+enterInsurantDataPage.pictureIPBox+" is not enabled");		
		Thread.sleep(3000);
		
		//enter insurant details
		ExcelOperations excelUtil = new ExcelOperations("Insurant_Data");
		int row = excelUtil.getRowCount();
		Object[][] object=new Object[row][1]; // 1 cz we will pass hashmap
		HashMap<String, String> testData01=new HashMap<>();
		for(int i=1; i<=excelUtil.getRowCount();i++) {
			 testData01 = excelUtil.getTestTataInMap(i);
			object[i-1][0] = testData01;
		}
		System.out.println("Printing hashmap:"+testData01);
		enterInsurantDataPage.enterInsurantData(testData01);
	}
	
	
	
}
