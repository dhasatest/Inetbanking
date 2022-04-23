package com.inetbanking.testCases;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.AddNewCustomerPage;
import com.inetbanking.pageObjects.LoginPage;

public class TC_003_AddNewCustomer extends BaseClass{
	
	@Test()
	public void addNewCustomer() throws InterruptedException {
		
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
	
		
		
		addcust.enterCustomerName("Dhasarathan");
		addcust.selectGender();
		
		addcust.enterDob("21", "04", "1985");

		addcust.enterAddress("Anupparpalayam");
		addcust.enterCity("Tirupur");
		addcust.enterState("TamilNadu");
		addcust.enterPinno("641652");
		addcust.enterTelno("04218963256");
		addcust.enterEmail(RandomStringUtils.randomAlphabetic(8)+"@gmail.com");
		addcust.clickSubmit();
		
		//
	/*	
		if (driver.getPageSource().contains("Customer Registered Successfully")) {
		Assert.assertTrue(true);
		}
		else {
			Assert.assertTrue(false);	
		}*/
				
		Thread.sleep(3000);
	}
	
	

}
