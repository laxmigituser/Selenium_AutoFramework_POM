package com.qa.pages;

import java.util.HashMap;

import org.openqa.selenium.By;
import com.qa.base.DriverFactory;
import com.qa.base.TestBase;
import com.qa.util.CommonMethods;

public class EnterProductDataPage extends TestBase{
	
	//Automobile
	public By startDateIPBox = By.xpath("//label[text()='Start Date']/following-sibling::input");	
	public By insuranceSumDropdown = By.xpath("//label[text()='Insurance Sum [$]']/following-sibling::select");
	public By meritRatingDropdown = By.xpath("//label[text()='Merit Rating']/following-sibling::select");
	public By damageinsuranceDropdown = By.xpath("//label[text()='Damage Insurance']/following-sibling::select");
	public By courtesycarDropdown = By.xpath("//label[text()='Courtesy Car']/following-sibling::select");
	public By optionalProducts = By.xpath("//label[text()='Optional Products']/following-sibling :: p//label");
	
	//Truck, Motor cycle, camper - startDateIPBox, insuranceSumDropdown, damageinsuranceDropdown, optionalProducts
		
	public By nextButton = By.xpath("//button[@name='Next (Select Price Option)']");
	public By previousButton = By.xpath("//button[@id='preventerinsurancedata']");
	
	public void clickNext() {
		DriverFactory.getInstance().getDriver().findElement(nextButton).click();
	}
	public void selectOptionalProducts(String productName) {
		String loc = "//label[text()='Optional Products']/following-sibling :: p//label[text()='"+productName+"']";
		DriverFactory.getInstance().getDriver().findElement(By.xpath(loc)).click();
	}
	public void enterProductDataDetails_automobile(HashMap<String, String> testData) throws Exception {
		DriverFactory.getInstance().getDriver().findElement(startDateIPBox).sendKeys(testData.get("Start_Date"));
		CommonMethods.selectValueFromDropDown(DriverFactory.getInstance().getDriver().findElement(insuranceSumDropdown), testData.get("Insurance_Sum"));
		CommonMethods.selectValueFromDropDown(DriverFactory.getInstance().getDriver().findElement(meritRatingDropdown), testData.get("Merit_Rating"));
		CommonMethods.selectValueFromDropDown(DriverFactory.getInstance().getDriver().findElement(damageinsuranceDropdown), testData.get("Damage_Insurance"));
		CommonMethods.selectValueFromDropDown(DriverFactory.getInstance().getDriver().findElement(courtesycarDropdown), testData.get("Courtesy_Car"));
		selectOptionalProducts(testData.get("Optional_Product"));
	}
	
	public void enterProductDataDetails(HashMap<String, String> testData) throws Exception {
		DriverFactory.getInstance().getDriver().findElement(startDateIPBox).sendKeys(testData.get("Start_Date"));
		CommonMethods.selectValueFromDropDown(DriverFactory.getInstance().getDriver().findElement(insuranceSumDropdown), testData.get("Insurance_Sum"));
		CommonMethods.selectValueFromDropDown(DriverFactory.getInstance().getDriver().findElement(damageinsuranceDropdown), testData.get("Damage_Insurance"));
		selectOptionalProducts(testData.get("Optional_Product"));
	}

}
