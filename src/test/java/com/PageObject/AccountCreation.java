package com.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountCreation {
	
	WebDriver ldriver;
	public AccountCreation(WebDriver rdriver) {
		ldriver = rdriver;
		
		PageFactory.initElements(rdriver, this);
	}
	
	// Find Element
	@FindBy(id="id_gender1")
	WebElement titleMr;
	
	@FindBy(id="customer_firstname")
	WebElement custFirstName;
	
	@FindBy(id="customer_lastname")
	WebElement custLastName;
	
	@FindBy(id="passwd")
	WebElement password;
	
	@FindBy(id="submitAccount")
	WebElement register;
	
	// perform Action
	public void selecttitleMr() {
		titleMr.click();
	}
	public void enterCustomerfirstName(String fname) {
		custFirstName.sendKeys(fname);
	}
	public void enterCustomerlastName(String lname) {
		custLastName.sendKeys(lname);
	}
	public void enterPassword(String pwd) {
		password.sendKeys(pwd);
	}
	public void clickonRegistor() {
		register.click();
	}
	
}	
