package com.inetbanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver ldriver;
	
	 public LoginPage(WebDriver rdriver) {
		ldriver = rdriver;
		
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(name="uid")
	
	WebElement txtUserName;
	
	@FindBy(name="password")
	
	WebElement txtPassword;
	
	@FindBy(name="btnLogin")
	
	WebElement btnLogin;
	
	@FindBy(xpath="//a[text()='Log out']")
	WebElement lnkLogout;
	
	public void enterUsername(String uname) {
		txtUserName.sendKeys(uname);
	}
	
	public void enterPassword(String pwd) {
		txtPassword.sendKeys(pwd);
	}
	
	public void clickLogin() {
		btnLogin.click();
	}
	
	public void clickLogout() {
		lnkLogout.click();
	}
}
