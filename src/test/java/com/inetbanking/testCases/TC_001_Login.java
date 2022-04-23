package com.inetbanking.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.inetbanking.pageObjects.LoginPage;


public class TC_001_Login extends BaseClass{

	
	
	@Test
	public void  loginTest() {
		
		LoginPage lg = new LoginPage(driver);
		logger.info("Entering Username and Password");
		lg.enterUsername(username);
		lg.enterPassword(password);
		logger.info("Click Submit Button");
		lg.clickLogin();
				
		logger.info("Verifing the page tile ");
		Assert.assertEquals(driver.getTitle(), pgTile);				

	}	

	
}
