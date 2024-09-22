package com.qa.util;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.qa.base.DriverFactory;
import com.qa.base.ExtentFactory;
import com.qa.base.ExtentReportSetUp;
import com.qa.base.PropertiesOperation;

public class CustomListener implements ITestListener{
	
	static ExtentReports report;
	static ExtentTest test;

	public void onTestStart(ITestResult result) {
		//before each TC
		test = report.createTest(result.getMethod().getMethodName());
		ExtentFactory.getInstance().setExtent(test);
	}

	public void onTestSuccess(ITestResult result) {
		ExtentFactory.getInstance().getExtent().log(Status.PASS, "Test case: "+ result.getMethod().getMethodName()+" is passed");
		ExtentFactory.getInstance().removeExtentObject();
	}

	public void onTestFailure(ITestResult result) {
		
		HashMap<String, String> testDataHM  = (HashMap<String, String>) result.getTestContext().getAttribute("testDataMap");
		
		ExtentFactory.getInstance().getExtent().log(Status.FAIL, "Test case: "+ result.getMethod().getMethodName()+" is failed");
		ExtentFactory.getInstance().getExtent().log(Status.FAIL, result.getThrowable());
		//code for screenshot
		File src=((TakesScreenshot)DriverFactory.getInstance().getDriver()).getScreenshotAs(OutputType.FILE);
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyy HH-mm-ss");
		Date date = new Date();
		String actualdate = format.format(date);
		String sspath = System.getProperty("user.dir")+
				"/Reports/screenshots/"+actualdate+".jpeg";
		File dest = new File(sspath);
		try {
			FileUtils.copyFile(src,dest);
		} catch (IOException e) {
			e.printStackTrace();
		}
		//add ss to report
		ExtentFactory.getInstance().getExtent().addScreenCaptureFromPath(sspath, "TC Failure ss");
		ExtentFactory.getInstance().removeExtentObject();
		
		//JIRA defect creation 
		String automaticJIRAcreation="";
		try {
			automaticJIRAcreation = PropertiesOperation.getPropertyValueByKey("automatic_Issue_Creation_In_JIRA");
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		if(automaticJIRAcreation.trim().equalsIgnoreCase("ON")) {
			String issueS = "Automation Test Failed - "+result.getMethod().getMethodName();
			String issueD = "Test Data used here : "+testDataHM+" Exception details are : "+result.getThrowable().toString();
			String issueNumber = null;
			try {
				issueNumber = new JiraOperations().createJiraIssue("QDPM", issueS, issueD, "10000", "5", "QDPM", "SIT", "5f782c4b95fe8e0069705791");
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			try {
				new JiraOperations().addAttachmentToJiraIssue(issueNumber, sspath);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void onTestSkipped(ITestResult result) {
		ExtentFactory.getInstance().getExtent().log(Status.SKIP, "Test case: "+ result.getMethod().getMethodName()+" is skipped");			
		ExtentFactory.getInstance().removeExtentObject();
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
		
	}

	public void onStart(ITestContext context) {
		//setup the extent object
		try {
			report = ExtentReportSetUp.setUpExtentReport();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public void onFinish(ITestContext context) {
		//close extent object
		report.flush();
		
	}

}
