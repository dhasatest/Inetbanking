package com.inetbanking.utilities;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Reporting{
	ExtentReports extent; 
	ExtentTest test;
	
	@BeforeSuite
	protected void startReport() {
		ExtentSparkReporter reporter = new ExtentSparkReporter(".//InetBankingTestReport.Html");
		 extent = new ExtentReports();
		extent.attachReporter(reporter);
	}
	
	@AfterSuite
	protected void stopReport() {
		extent.flush();
	}
	
	@BeforeClass
	void createTest(String testName, String author, String category) {
		test = extent.createTest(testName);
		test.assignAuthor(author);
		test.assignCategory(category);
	}
	
/*	void testReport(String status, String description) {
		
		switch (status) {
		case "pass":
			test.pass(description);
			break;
		case "fail":
			test.fail(description);
			break;
		default:
			System.err.println("Status is not defined");
			break;
		}
	}*/

}
