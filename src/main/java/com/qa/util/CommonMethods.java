package com.qa.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.qa.base.DriverFactory;
import com.qa.base.TestBase;

public class CommonMethods {
	
	public static void assertFieldText(WebElement element, String text) {
		String actualText = element.getText();
		Assert.assertTrue(actualText.equals(text), "Expected text is: "+text+" but found "+actualText);
	}
	
	public static List<String> getDropDownOptionsAsList(WebElement element) {
		Select s= new Select(element);
		List<WebElement> options = s.getOptions();
		List<String> testValues=new ArrayList<String>();
		 for(WebElement e:options) {
			 testValues.add(e.getText().trim());
		 }
		 return testValues;
	}
	
	public static void assertDropdownContainsValues(WebElement dropdown, List<String> values) {
		List<String> actualValues = getDropDownOptionsAsList(dropdown);
		for(String s:values) {
			Assert.assertTrue(actualValues.contains(s), "Dropdown option "+s+" not found in dropdown "+dropdown);
		}
	}
	
	
	public static void selectValueFromDropDown(WebElement element, String value) throws Exception {
		Select s =new Select(element);
		try {
			s.selectByVisibleText(value);
		}catch(Exception e) {
			throw new Exception("value not present in dropdown "+element+" with text "+value);
		}
		
	}
	
	public static void selectRadioButtonValue(List<WebElement> elements, String value) {
		for(WebElement el:elements) {
			if(el.getText().equalsIgnoreCase(value)) {
				el.click();
				break;
			}
		}
	}
	
	public static void selectCheckboxValues(List<WebElement> elements, String values) {
		String[] split = values.split(",");
		List<String> asList = Arrays.asList(split);
		for(WebElement el:elements) {
			if(asList.contains(el.getText())) {
				el.click();
			}
		}
	}

}
