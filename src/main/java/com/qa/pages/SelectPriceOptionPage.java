package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.DriverFactory;
import com.qa.base.TestBase;

public class SelectPriceOptionPage extends TestBase{
	
	public By priceTable = By.xpath("//table[@id='priceTable']");
	public By viewQuoteLink = By.xpath("//div[@id='quote-container']//div[text()='View Quote']/preceding :: a[@id='viewquote']");
	public By downloadQuoteLink = By.xpath("//div[@id='quote-container']//div[text()='Download Quote']/preceding :: a[@id='downloadquote']");
	public By next_Button = By.xpath("//button[@id='nextsendquote']");
	public By previous_Button = By.xpath("//button[@id='preventerproductdata']");

	//to get price based on plan
	public String getPriceForSelectedOptions(String plan) {
		String dataXpath = "//table[@id='priceTable']//tr[1]//td[@data-label='"+plan+"']/span";
		String planValue = DriverFactory.getInstance().getDriver().findElement(By.xpath(dataXpath)).getText();
		return planValue;
	}
	public void selectRadioBasedOnText(String plan) {
		String dataXpath = "//table[@id='priceTable']//tfoot//input[@value='"+plan+"']/parent :: label";
		DriverFactory.getInstance().getDriver().findElement(By.xpath(dataXpath)).click();
	}
	public void clickNext() {
		JavascriptExecutor js= (JavascriptExecutor)DriverFactory.getInstance().getDriver();
		js.executeScript("arguments[0].click();", next_Button);
	}
	public void clickPrevious() {
		JavascriptExecutor js= (JavascriptExecutor)DriverFactory.getInstance().getDriver();
		js.executeScript("arguments[0].click();", previous_Button);
	}
	

}
