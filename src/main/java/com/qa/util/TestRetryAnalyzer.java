package com.qa.util;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.qa.base.PropertiesOperation;

public class TestRetryAnalyzer implements IRetryAnalyzer{

		int counter = 1;
		int retryMaxLimit=0;
		
		public void getRetryCount() {
			try {
				retryMaxLimit = Integer.valueOf(PropertiesOperation.getPropertyValueByKey("retryCount"));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		@Override
		public boolean retry(ITestResult result) {
			getRetryCount();
			if(counter<retryMaxLimit) {
				counter++;
				System.out.println("retry count is: "+counter);
				return true;
			}
			return false;
		}
}
