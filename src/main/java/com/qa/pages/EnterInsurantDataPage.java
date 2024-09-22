package com.qa.pages;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.DriverFactory;
import com.qa.base.TestBase;
import com.qa.util.CommonMethods;

public class EnterInsurantDataPage extends TestBase{
	
	//Automobile, truck 
	public By firstNameIPBox = By.xpath("//form[@id='insurance-form']//div//label[text()='First Name']/following-sibling :: input");
	public By lastNameIPBox = By.xpath("//form[@id='insurance-form']//div//label[text()='Last Name']/following-sibling :: input");
	public By dateOfBirthIPBox = By.xpath("//form[@id='insurance-form']//div//label[text()='Date of Birth']/following-sibling :: input");
	public By maleRadioBtn = By.xpath("//form[@id='insurance-form']//div//label[text()='Gender']");
	public By femaleRadioBtn = By.xpath("//form[@id='insurance-form']//div//label[text()='Gender']/following :: input[@id='genderfemale']");
	public By streetAddressIPBox = By.xpath("//form[@id='insurance-form']//div//label[text()='Street Address']/following-sibling :: input");
	public By countryDropdown = By.xpath("//form[@id='insurance-form']//div//label[text()='Country']/following-sibling :: select");
	public By zipCodeIPBox = By.xpath("//form[@id='insurance-form']//div//label[text()='Zip Code']/following-sibling :: input");
	public By cityIPBox = By.xpath("//form[@id='insurance-form']//div//label[text()='City']/following-sibling :: input");	
	public By occupationDropdown = By.xpath("//form[@id='insurance-form']//div//label[text()='Occupation']/following-sibling :: select");
	public By websiteIPBox = By.xpath("//form[@id='insurance-form']//div//label[text()='Website']/following :: input");
	public By pictureIPBox = By.xpath("//form[@id='insurance-form']//div//label[text()='Picture']/following :: input[@id='picture']");
	public By previousBtn = By.xpath("//button[@id='preventervehicledata']");
	public By nextBtn = By.xpath("//button[@id='nextenterproductdata']");

	
	
	public void clickNextButton() {
		DriverFactory.getInstance().getDriver().findElement(nextBtn).click();
	}
	public void clickPreviousButton() {
		DriverFactory.getInstance().getDriver().findElement(previousBtn).click();
	}
	public void selectHobbiesBox(String hobbies) {
		String loc = "//form[@id='insurance-form']//div//label[text()='Hobbies']/following :: p[@class='group']//label[text()=' "+hobbies+"']";
		DriverFactory.getInstance().getDriver().findElement(By.xpath(loc)).click();
	}
	
	public void enterInsurantData(HashMap<String, String> testData) throws Exception {
		DriverFactory.getInstance().getDriver().findElement(firstNameIPBox).sendKeys(testData.get("First_Name"));
		DriverFactory.getInstance().getDriver().findElement(lastNameIPBox).sendKeys(testData.get("Last_Name"));
		DriverFactory.getInstance().getDriver().findElement(dateOfBirthIPBox).sendKeys(testData.get("DOB"));
		DriverFactory.getInstance().getDriver().findElement(maleRadioBtn).click();
		DriverFactory.getInstance().getDriver().findElement(streetAddressIPBox).sendKeys(testData.get("Street_Address"));	
		CommonMethods.selectValueFromDropDown(DriverFactory.getInstance().getDriver().findElement(countryDropdown), testData.get("Country"));
		DriverFactory.getInstance().getDriver().findElement(zipCodeIPBox).sendKeys(testData.get("zipcode"));
		DriverFactory.getInstance().getDriver().findElement(cityIPBox).sendKeys(testData.get("city"));
		CommonMethods.selectValueFromDropDown(DriverFactory.getInstance().getDriver().findElement(occupationDropdown), testData.get("Occupation"));
		selectHobbiesBox(testData.get("Hobby"));
		DriverFactory.getInstance().getDriver().findElement(websiteIPBox).sendKeys(testData.get("website"));
		Thread.sleep(3000);
	}
	
}
