package com.qa.pages;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.qa.base.DriverFactory;
import com.qa.base.TestBase;

public class HomePage extends TestBase{
	
	//header elements
	public By tricentics_Logo = By.xpath("//div[@class='top-header']//img[@alt='Tricentis Logo']");
	public By tricentics_Title = By.xpath("//div[@class='top-header']//a//h1[text()='Vehicle Insurance Application']");
	public By tricentics_Title_Description = By.xpath("//div[@class='top-header']//a//small[text()='This is a sample application, Version 1.0.1']");	
	public By visit_support_Button =  By.xpath("//a[@id='nav_automobile']");
	public By search_support_IPBox =  By.xpath("//div[@class='top-header']//form//input[@id='search_form']");
	public By search_support_Button =  By.xpath("//div[@class='top-header']//form//button[@id='search_button']");
	
	//bottom header elements	
	public By autoMobile_link =  By.xpath("//a[@id='nav_automobile']");
	public By truck_link =  By.xpath("//a[@id='nav_truck']");
	public By motorCycle_link =  By.xpath("//a[@id='nav_motorcycle']");
	public By camper_link =  By.xpath("//a[@id='nav_camper']");
	public By request_demo_link =  By.xpath("//div[@class='bottom-header']//a[text()='Request Demo']");
	
	//slider section
	public By allSlides = By.xpath("//div[@class='hero-slider']//ul//li");
	public By activeSlide = By.xpath("//div[@class='hero-slider']//ul//li[@class='flex-active-slide']");
	public By car_image = By.xpath("//div[@class='hero-slider']//ul//li[@data-bg-image='images/slider_car.png']");
	public By truck_image = By.xpath("//div[@class='hero-slider']//ul//li[@data-bg-image='images/slider_truck.png']");
	public By bike_image = By.xpath("//div[@class='hero-slider']//ul//li[@data-bg-image='images/slider_bike.png']");
	public By camper_image = By.xpath("//div[@class='hero-slider']//ul//li[@data-bg-image='images/slider_camper.jpg']");
	public By sliderCardHeader = By.xpath("//div[@class='hero-slider']//ul//li//h2[text()='Get your ']//strong");
	public By sliderCardDescription = By.xpath("//div[@class='hero-slider']//ul//li//p[text()='Well, the best way to get to know new software is to use an example to try it out. This sample application has been designed to give you the opportunity to get acquainted with the functional beauty and strength of Tricentis Tosca Testsuite.']");
	public By getQuoteCardButton = By.xpath("//div[@class='hero-slider']//ul//li//a[text()='Get a quote']");

	//welcome block
	public By welcom_container = By.xpath("//div[@class='fullwidth-block greet-section']");
	public By welcom_container_header = By.xpath("//div[@class='fullwidth-block greet-section']//h2[text()='Welcome Aboard!']");
	public By welcom_container_header_desc = By.xpath("//div[@class='fullwidth-block greet-section']//h2[text()='Welcome Aboard!']/following-sibling::small[text()='...and take not only your insurance application testing to the next level']");
	public By feature1_img = By.xpath("//div[@class='fullwidth-block greet-section']//div[@class='feature']//img[contains(@src,'app_icon_24@2x.png')]");
	public By feature1_title = By.xpath("//div[@class='fullwidth-block greet-section']//div[@class='feature']//h3[contains(text(),'Got You Covered')]");
	public By feature1_desc = By.xpath("//div[@class='fullwidth-block greet-section']//div[@class='feature']//p[text()='Optimize your test by minimizing the number of test cases while achieving the highest possible risk coverage.']");
	public By feature2_img = By.xpath("//div[@class='fullwidth-block greet-section']//div[@class='feature']//img[contains(@src,'app_icon_car@2x.png')]");
	public By feature2_title = By.xpath("//div[@class='fullwidth-block greet-section']//div[@class='feature']//h3[text()='No More Search and Destroy']");
	public By feature2_desc = By.xpath("//div[@class='fullwidth-block greet-section']//div[@class='feature']//p[text()='Use a fully integrated set of capabilities for the design, generation, provisioning and management of test data.']");
	public By feature3_img = By.xpath("//div[@class='fullwidth-block greet-section']//div[@class='feature']//img[contains(@src,'app_icon_relax@2x.png')]");
	public By feature3_title = By.xpath("//div[@class='fullwidth-block greet-section']//div[@class='feature']//h3[text()='Relax and Automate']");
	public By feature3_desc = By.xpath("//div[@class='fullwidth-block greet-section']//div[@class='feature']//p[text()='Go beyond script based test automation, using a more powerful, robust and scalable model based approach.']");
	public By feature4_img = By.xpath("//div[@class='fullwidth-block greet-section']//div[@class='feature']//img[contains(@src,'app_icon_people@2x.png')]");
	public By feature4_title = By.xpath("//div[@class='fullwidth-block greet-section']//div[@class='feature']//h3[contains(text(),'Play Solo')]");
	public By feature4_desc = By.xpath("//div[@class='fullwidth-block greet-section']//div[@class='feature']//p[text()='Mimic actions and the behavior of missing services by our orchestrated service virtualization solution.']");
	public By welcome_block_footer_text = By.xpath("//main[@class='main-content']//p[contains(text(),'just an infinitesimal excerpt of our numerous capabilities.')]");
	public By read_more_link = By.xpath("//main[@class='main-content']//a//b[text()='Read more']");
	
	//Insurance block
	public By insurance_block_header = By.xpath("//main[@class='main-content']//div[@class='fullwidth-block']//h2[text()='Our Insane Insurance Offer']");
	public By insurance_block_subtitle = By.xpath("//main[@class='main-content']//div[@class='fullwidth-block']//small[text()='Scrutinize our motives, and get your quote now!']");
	public By insurance_block_automobile_link = By.xpath("//main[@class='main-content']//div[@class='fullwidth-block']//a[@id='offer_automobile']");
	public By insurance_block_automobile = By.xpath("//main[@class='main-content']//div[@class='fullwidth-block']//a[@id='offer_automobile']//img[contains(@src,'photo_car@2x.png')]/following :: h3[text()='Automobile']");
	public By insurance_block_camper_link = By.xpath("//main[@class='main-content']//div[@class='fullwidth-block']//a[@id='offer_camper']");
	public By insurance_block_camper = By.xpath("//main[@class='main-content']//div[@class='fullwidth-block']//a[@id='offer_camper']//img[contains(@src,'photo_camper@2x.png')]/following :: h3[text()='Camper']");
	public By insurance_block_truck_link = By.xpath("//main[@class='main-content']//div[@class='fullwidth-block']//a[@id='offer_truck']");
	public By insurance_block_truck = By.xpath("//main[@class='main-content']//div[@class='fullwidth-block']//a[@id='offer_truck']//img[contains(@src,'photo_truck@2x.png')]/following :: h3[text()='Truck']");
	public By insurance_block_motorcycle_link = By.xpath("//main[@class='main-content']//div[@class='fullwidth-block']//a[@id='offer_motorcycle']");
	public By insurance_block_motorcycle = By.xpath("//main[@class='main-content']//div[@class='fullwidth-block']//a[@id='offer_motorcycle']//img[contains(@src,'photo_bike@2x.png')]/following :: h3[text()='Motorcycle']");

	//footer
	public By about_link = By.xpath("//div[@class='bottom-footer']//a[@id='tricentis_about']");
	public By products_link = By.xpath("//div[@class='bottom-footer']//a[@id='tricentis_products']");
	public By events_link = By.xpath("//div[@class='bottom-footer']//a[text()='Events & Webinars']");
	public By resources_link = By.xpath("//div[@class='bottom-footer']//a[text()='Resources']");
	public By services_link = By.xpath("//div[@class='bottom-footer']//a[text()='Services']");
	public By facebook_link = By.xpath("//div[@class='bottom-footer']//a[@id='nav_facebook']//i[@class='fa fa-facebook']");
	public By twitter_link = By.xpath("//div[@class='bottom-footer']//a[@id='nav_twitter']//i[@class='fa fa-twitter']");
	public By google_link = By.xpath("//div[@class='bottom-footer']//a[@id='nav_google']//i[@class='fa fa-google-plus']");	
	public By copyright_text = By.xpath("//div[@class='bottom-footer']//div[text()='Copyright 2021 by Tricentis GmbH. All rights reserved.']");
	
	
	public void clickAutoMobileLink() {
		DriverFactory.getInstance().getDriver().findElement(autoMobile_link).click();
	}
	public void clickTruckLink() {
		DriverFactory.getInstance().getDriver().findElement(truck_link).click();
	}
	public void clickMotorCycleLink() {
		DriverFactory.getInstance().getDriver().findElement(motorCycle_link).click();
	}
	public void clickCamperLink() {
		DriverFactory.getInstance().getDriver().findElement(camper_link).click();
	}

}
