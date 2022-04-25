package com.inetbanking.testCases;

import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.AddNewCustomerPage;
import com.inetbanking.pageObjects.LoginPage;
import com.inetbanking.utilities.XLUtility;

public class TC_003_AddNewCustomer extends BaseClass{
	 
	
	@Test(dataProvider="newcustdata")
	public void addNewCustomer(String name, String gender, String dob, String address,
							   String city, String state, String pin, String mobile, 
							   String email, String emailpwd) throws InterruptedException {
		
		LoginPage lp = new LoginPage(driver);
		lp.enterUsername("mngr399908");
		lp.enterPassword("ajyhajA");
		lp.clickLogin();

		AddNewCustomerPage addcust = new AddNewCustomerPage(driver);
		
		addcust.clickAddNewCustomer();
		
	
		WebElement iframe = driver.findElement(By.id("google_ads_iframe_/24132379/INTERSTITIAL_DemoGuru99_0"));
		if(iframe.isDisplayed()) {
		driver.switchTo().frame("google_ads_iframe_/24132379/INTERSTITIAL_DemoGuru99_0");
		driver.switchTo().frame("ad_iframe");
		driver.findElement(By.id("dismiss-button")).click();
		driver.switchTo().defaultContent();
	
		}
	
		
		
		addcust.enterCustomerName(name);
		addcust.selectGender();
		
		addcust.enterDob("21", "04", "1985");

		addcust.enterAddress(address);
		addcust.enterCity(city);
		addcust.enterState(state);
		addcust.enterPinno(pin);
		addcust.enterTelno(mobile);
		addcust.enterEmail(RandomStringUtils.randomAlphabetic(8)+email+"@gmail.com");
		addcust.enterEmailPassword(emailpwd);
		addcust.clickSubmit();
		
		//
		
		if (driver.getPageSource().contains("Customer Registered Successfully")) {
		Assert.assertTrue(true);
		}
		else {
			Assert.assertTrue(false);	
		}
		System.out.println("Customer ID : "+ addcust.newCustId());		
		Thread.sleep(3000);
	}
	
	@DataProvider(name = "newcustdata")
	String[][] addNewCustomerData() throws IOException{
		XLUtility xl = new XLUtility(System.getProperty("user.dir")+"/src/test/java/com/inetbanking/testData/Book.xlsx");
		
		int rows = xl.getRowCount("NewCustomer");
		int cols = xl.getColumnCount("NewCustomer", 1);
		String[][] custData = new String[rows][cols];
		
		for(int r=1; r<=rows; r++) {
			for(int c=0; c<cols; c++ ) {
				custData[r-1][c] = xl.getCellData("NewCustomer", r, c);
				
			}
			
		}
		
		return custData;
		
	}

}
