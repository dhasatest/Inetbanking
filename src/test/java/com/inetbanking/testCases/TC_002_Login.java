package com.inetbanking.testCases;



import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.LoginPage;
import com.inetbanking.utilities.XLUtility;

public class TC_002_Login extends BaseClass{

	
	
	@Test(dataProvider="loginData")
	public void  loginTest(String user, String pass) {
		
		LoginPage lg = new LoginPage(driver);
		logger.info("Entering Username and Password");
		lg.enterUsername(user);
		lg.enterPassword(pass);
		logger.info("Click Submit Button");
		lg.clickLogin();
		
		if (isAlertPresent()) {
			
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			logger.warn("Loging failed");
			Assert.assertTrue(false);
			
		}
		else {
			
			Assert.assertTrue(true);
			logger.info("Login Pass");
			lg.clickLogout();
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
		}							

	}	
	
	public boolean isAlertPresent(){
		try {
		driver.switchTo().alert();
		return true;
		}catch (NoAlertPresentException e) {
			
		return false;	
		}
		
	}
	
	@DataProvider(name="loginData")
	public String[][] loginDataProvider() throws IOException{
			XLUtility xl = new XLUtility(System.getProperty("user.dir")+"/src/test/java/com/inetbanking/testData/Book.xlsx");
			int rows = xl.getRowCount("Sheet1");
			int cols = xl.getColumnCount("Sheet1", 1);
			
			String credentials[][] = new String[rows][cols];
			for(int r=1; r<=rows; r++) {
				for(int c=0; c<cols; c++) {
					credentials[r-1][c]= xl.getCellData("Sheet1", r, c);
				}
			}
			return credentials;
			
	
	}
	
	
	
}
