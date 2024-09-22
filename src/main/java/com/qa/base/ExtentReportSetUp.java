package com.qa.base;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportSetUp {

	static ExtentReports extent;

	public static ExtentReports setUpExtentReport() throws Exception {
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyy HH-mm-ss");
		Date date = new Date();
		String actualdate = format.format(date);
		String reportpath = System.getProperty("user.dir") + "/Reports/ExecutionReport_" + actualdate + ".html";

		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportpath);
		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);

		sparkReporter.config().setDocumentTitle("DocumentTitle");
		sparkReporter.config().setTheme(Theme.DARK);
		sparkReporter.config().setReportName("ReportName");
		
		extent.setSystemInfo("Executed on Environment: ", PropertiesOperation.getPropertyValueByKey("url"));
		extent.setSystemInfo("Executed on Browser: ", PropertiesOperation.getPropertyValueByKey("browser"));
		extent.setSystemInfo("Executed on OS: ", System.getProperty("os.name"));
		extent.setSystemInfo("Executed By User: ", System.getProperty("user.name"));

		return extent;

	}
}
