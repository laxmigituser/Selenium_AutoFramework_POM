package com.qa.pages;

import java.util.HashMap;
import java.util.List;
import org.openqa.selenium.By;
import com.qa.base.DriverFactory;
import com.qa.base.TestBase;
import com.qa.util.CommonMethods;

public class EnterVehicleDataPage extends TestBase{
	
	public By breadCrumb = By.xpath("//div[@class='breadcrumbs']//a[text()='Home']/following-sibling :: span");
	
	//navigation tabs
	public By enterVehicleData_tab = By.xpath("//nav[@name='Insurance Navigation']//a[text()='Enter Vehicle Data']");
	public By enterVehicleData_tab_count = By.xpath("//nav[@name='Insurance Navigation']//a[text()='Enter Vehicle Data']//span");
	public By enterInsurantData_tab = By.xpath("//nav[@name='Insurance Navigation']//a[text()='Enter Insurant Data']");
	public By enterInsurantData_tab_count = By.xpath("//nav[@name='Insurance Navigation']//a[text()='Enter Insurant Data']//span");
	public By enterProductData_tab = By.xpath("//nav[@name='Insurance Navigation']//a[text()='Enter Product Data']");
	public By enterProductData_tab_count = By.xpath("//nav[@name='Insurance Navigation']//a[text()='Enter Product Data']//span");
	public By selectPriceOption_tab = By.xpath("//nav[@name='Insurance Navigation']//a[text()='Select Price Option']");
	public By selectPriceOption_tab_count = By.xpath("//nav[@name='Insurance Navigation']//a[text()='Select Price Option']//span");
	public By sendQuote_tab = By.xpath("//nav[@name='Insurance Navigation']//a[text()='Send Quote']");
	public By sendQuote_tab_count = By.xpath("//nav[@name='Insurance Navigation']//a[text()='Send Quote']//span");

	//Automobile
	public By make_dropdown = By.xpath("//div//label[contains(text(),'Make')]/following-sibling :: select[@id='make']");	
	public By enginePerformanceIPBox = By.xpath("//div//label[contains(text(),'Engine Performance [kW]')]/following-sibling :: input[@id='engineperformance']");
	public By dateOfManufactureIPBox = By.xpath("//div//label[contains(text(),'Date of Manufacture')]/following-sibling :: input[@id='dateofmanufacture']");
	public By numberOfSeatsDropDown = By.xpath("//div//label[contains(text(),'Number of Seats')]/following-sibling :: select[@id='numberofseats']");
	public By fuelTypeDropDown = By.xpath("//div//label[contains(text(),'Fuel Type')]/following-sibling :: select[@id='fuel']");
	public By listPrice = By.xpath("//div//label[contains(text(),'List Price [$]')]/following-sibling :: input[@id='listprice']");
	public By annualmileageIPBox = By.xpath("//div//label[contains(text(),'Annual Mileage [mi]')]/following-sibling :: input[@id='annualmileage']");
	public By licensePlateNoIPBox = By.xpath("//div//label[contains(text(),'License Plate Number')]/following-sibling :: input[@id='licenseplatenumber']");
	
	//Truck - has above 8 fields and additional 2 fields
	public By payload = By.xpath("//div//label[contains(text(),'Payload [kg]')]/following-sibling :: input[@id='payload']");
	public By totalWeight = By.xpath("//div//label[contains(text(),'Total Weight [kg]')]/following-sibling :: input[@id='totalweight']");
	
	//Motorcycle - make_dropdown, enginePerformanceIPBox, dateOfManufactureIPBox, listPrice, annualmileageIPBox
	public By model_dropdown = By.xpath("//div//label[text()='Model']/following-sibling :: select[@id='model']");
	public By cylinder_capacity = By.xpath("//div//label[text()='Cylinder Capacity [ccm]']/following-sibling :: input[@id='cylindercapacity']");
	public By numberOfSeatsDropDown_motorcycle = By.xpath("//div//label[contains(text(),'Number of Seats')]/following-sibling :: select[@id='numberofseatsmotorcycle']");

	//camper - make_dropdown, enginePerformanceIPBox, dateOfManufactureIPBox, fuelTypeDropDown,payload,totalWeight,listPrice,annualmileageIPBox,licensePlateNoIPBox 
	public By right_hand_drive_yes_radioBtn = By.xpath("//label[text()='Right Hand Drive']/following-sibling :: p//label[text()='Yes']");
	public By right_hand_drive_no_radioBtn = By.xpath("//label[text()='Right Hand Drive']/following-sibling :: p//label[text()='No']");

	public By nextButton = By.xpath("//button[@id='nextenterinsurantdata']");
	
	
	public String getPageTitle() {
		return DriverFactory.getInstance().getDriver().getTitle().trim();
	}
	public void clickNextButton() {
		DriverFactory.getInstance().getDriver().findElement(nextButton).click();
	}
	
	public void enterVehicleData_automobile(HashMap<String, String> testData) throws Exception {
		CommonMethods.selectValueFromDropDown(DriverFactory.getInstance().getDriver().findElement(make_dropdown), testData.get("Make"));
		DriverFactory.getInstance().getDriver().findElement(enginePerformanceIPBox).sendKeys(testData.get("Engine_Performance"));
		DriverFactory.getInstance().getDriver().findElement(dateOfManufactureIPBox).sendKeys(testData.get("Date_Of_Manufacture"));
		CommonMethods.selectValueFromDropDown(DriverFactory.getInstance().getDriver().findElement(numberOfSeatsDropDown), testData.get("No_Of_Seats"));
		CommonMethods.selectValueFromDropDown(DriverFactory.getInstance().getDriver().findElement(fuelTypeDropDown), testData.get("Fuel_Type"));
		DriverFactory.getInstance().getDriver().findElement(listPrice).sendKeys(testData.get("List_Price"));
		DriverFactory.getInstance().getDriver().findElement(licensePlateNoIPBox).sendKeys(testData.get("License_Plate_No"));
		DriverFactory.getInstance().getDriver().findElement(annualmileageIPBox).sendKeys(testData.get("Annual_Mileage"));	
	}
	
	public void enterVehicleData_truck(HashMap<String, String> testData) throws Exception {
		CommonMethods.selectValueFromDropDown(DriverFactory.getInstance().getDriver().findElement(make_dropdown), testData.get("Make"));
		DriverFactory.getInstance().getDriver().findElement(enginePerformanceIPBox).sendKeys(testData.get("Engine_Performance"));
		DriverFactory.getInstance().getDriver().findElement(dateOfManufactureIPBox).sendKeys(testData.get("Date_Of_Manufacture"));
		CommonMethods.selectValueFromDropDown(DriverFactory.getInstance().getDriver().findElement(numberOfSeatsDropDown), testData.get("No_Of_Seats"));
		CommonMethods.selectValueFromDropDown(DriverFactory.getInstance().getDriver().findElement(fuelTypeDropDown), testData.get("Fuel_Type"));
		DriverFactory.getInstance().getDriver().findElement(payload).sendKeys(testData.get("Payload"));
		DriverFactory.getInstance().getDriver().findElement(totalWeight).sendKeys(testData.get("Weight"));
		DriverFactory.getInstance().getDriver().findElement(listPrice).sendKeys(testData.get("List_Price"));
		DriverFactory.getInstance().getDriver().findElement(licensePlateNoIPBox).sendKeys(testData.get("License_Plate_No"));
		DriverFactory.getInstance().getDriver().findElement(annualmileageIPBox).sendKeys(testData.get("Annual_Mileage"));	
	}
	
	public void enterVehicleData_motorcycle(HashMap<String, String> testData) throws Exception {
		CommonMethods.selectValueFromDropDown(DriverFactory.getInstance().getDriver().findElement(make_dropdown), testData.get("Make"));
		CommonMethods.selectValueFromDropDown(DriverFactory.getInstance().getDriver().findElement(model_dropdown), testData.get("Model"));
		DriverFactory.getInstance().getDriver().findElement(enginePerformanceIPBox).sendKeys(testData.get("Engine_Performance"));
		DriverFactory.getInstance().getDriver().findElement(dateOfManufactureIPBox).sendKeys(testData.get("Date_Of_Manufacture"));
		CommonMethods.selectValueFromDropDown(DriverFactory.getInstance().getDriver().findElement(numberOfSeatsDropDown_motorcycle), testData.get("No_Of_Seats"));
		DriverFactory.getInstance().getDriver().findElement(listPrice).sendKeys(testData.get("List_Price"));
		DriverFactory.getInstance().getDriver().findElement(annualmileageIPBox).sendKeys(testData.get("Annual_Mileage"));
		DriverFactory.getInstance().getDriver().findElement(cylinder_capacity).sendKeys(testData.get("cylinder_capacity"));
	}
	
	public void enterVehicleData_camper(HashMap<String, String> testData) throws Exception {
		CommonMethods.selectValueFromDropDown(DriverFactory.getInstance().getDriver().findElement(make_dropdown), testData.get("Make"));
		DriverFactory.getInstance().getDriver().findElement(enginePerformanceIPBox).sendKeys(testData.get("Engine_Performance"));
		DriverFactory.getInstance().getDriver().findElement(dateOfManufactureIPBox).sendKeys(testData.get("Date_Of_Manufacture"));
		CommonMethods.selectValueFromDropDown(DriverFactory.getInstance().getDriver().findElement(numberOfSeatsDropDown), testData.get("No_Of_Seats"));
		DriverFactory.getInstance().getDriver().findElement(right_hand_drive_yes_radioBtn).click();
		CommonMethods.selectValueFromDropDown(DriverFactory.getInstance().getDriver().findElement(fuelTypeDropDown), testData.get("Fuel_Type"));
		DriverFactory.getInstance().getDriver().findElement(payload).sendKeys(testData.get("payload"));
		DriverFactory.getInstance().getDriver().findElement(totalWeight).sendKeys(testData.get("weight"));	
		DriverFactory.getInstance().getDriver().findElement(listPrice).sendKeys(testData.get("List_Price"));
		DriverFactory.getInstance().getDriver().findElement(annualmileageIPBox).sendKeys(testData.get("Annual_Mileage"));
		DriverFactory.getInstance().getDriver().findElement(licensePlateNoIPBox).sendKeys(testData.get("license"));
	}
	
	
	
	

}
