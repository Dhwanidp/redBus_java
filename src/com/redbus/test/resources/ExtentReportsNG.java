package com.redbus.test.resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportsNG {
	
	 public static ExtentReports htmlreport() {
	    	
	    	String path = System.getProperty("user.dir")+"//reports//index.html";
	    	ExtentSparkReporter reporter = new ExtentSparkReporter(path);
	    	reporter.config().setReportName("Redbus Automation");
	    	reporter.config().setDocumentTitle("Test Result");
	    	
	    	ExtentReports extent = new ExtentReports();
	    	extent.attachReporter(reporter);
	    	extent.setSystemInfo("Redbus", "E2E_Automation");
	    	return extent;
	 }
}
