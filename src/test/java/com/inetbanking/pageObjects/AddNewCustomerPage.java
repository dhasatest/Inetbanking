package com.inetbanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddNewCustomerPage {
	
	WebDriver ldriver;
	
	public AddNewCustomerPage( WebDriver rdriver){
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath="//a[text()='New Customer']")
	@CacheLookup
	WebElement lnkNewCustomer;
	
	
	@FindBy(name="name")
	@CacheLookup
	WebElement txtCustomerName;
	
	@FindBy(name="rad1")
	@CacheLookup
	WebElement rdoMale;
	
	@FindBy(id="dob" )
	@CacheLookup
	WebElement dtpDob;
	
	
	@FindBy(name="addr")
	@CacheLookup
	WebElement txtAddress;
	
	
	@FindBy(name="city")
	@CacheLookup
	WebElement txtCity;
	
	@FindBy(name="state")
	@CacheLookup
	WebElement txtState;
	
	
	@FindBy(name="pinno")
	@CacheLookup
	WebElement txtPinno;
	
	@FindBy(name="telephoneno")
	@CacheLookup
	WebElement txtTelno;
	
	@FindBy(name="emailid")
	@CacheLookup
	WebElement txtEmail;
	
	@FindBy(name="password")
	@CacheLookup
	WebElement txtEmailPwd;
	
	@FindBy(name="sub")
	@CacheLookup
	WebElement btnSubmit;
	

	@FindBy(name="res")
	@CacheLookup
	WebElement btnReset;

	@FindBy(xpath="//table[@id='customer']//td[contains(text(),'Customer ID')]/following-sibling::td")
	@CacheLookup
	WebElement newCustId;
	
	
	public void clickAddNewCustomer() {
		lnkNewCustomer.click();
		
	}
	
	public void enterCustomerName(String custName) {
		txtCustomerName.sendKeys(custName);
	}
	
	public void selectGender() {
		rdoMale.click();
	}
	
	public void enterDob(String mm, String dd, String yyyy) {
		dtpDob.sendKeys(mm);
		dtpDob.sendKeys(dd);
		dtpDob.sendKeys(yyyy);
	}
	
	public void enterAddress(String addr) {
		txtAddress.sendKeys(addr);
	}
	
	public void enterCity(String city) {
		txtCity.sendKeys(city);
	}
	
	public void enterState(String state) {
		txtState.sendKeys(state);
	}
	
	public void enterPinno(String pin) {
		txtPinno.sendKeys(pin);
	}
	
	public void enterTelno(String tel) {
		txtTelno.sendKeys(tel);
	}
	
	public void enterEmail(String email) {
		txtEmail.sendKeys(email);
	}
	
	public void enterEmailPassword(String emailpwd) {
		txtEmailPwd.sendKeys(emailpwd);
	}
	
	public void clickSubmit() {
		btnSubmit.click();
	}
	
	public void clickReset() {
		btnReset.click();
	}
	
	public String newCustId() {
		return newCustId.getText();
	}

}
