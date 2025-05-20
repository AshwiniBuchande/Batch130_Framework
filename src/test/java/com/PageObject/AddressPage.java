package com.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddressPage {
	
	WebDriver ldriver;
	
	public AddressPage (WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	// find WebElement
	@FindBy(xpath="//span[text()='Add my first address']")
	WebElement firstAddress;
	
	@FindBy(id="company")
	WebElement companyName;
	
	@FindBy(id="address1")
	WebElement address1;
	
	@FindBy(id="city")
	WebElement cityName;
	
	@FindBy(id="id_state")
	WebElement stateName;
	
	@FindBy(id="postcode")
	WebElement zipcode;
	
	@FindBy(id="phone")
	WebElement homephone;
	
	@FindBy(id="phone_mobile")
	WebElement phoneMob;
	
	@FindBy(id="alias")
	WebElement myaddress;
	
	@FindBy(id="submitAddress")
	WebElement saveBtn;
	
	//perform Action
	public void clickonAddressBtn() {
		firstAddress.click();
	}
	public void enterCompanyName(String company) {
		companyName.sendKeys(company);
	}
	public void enterAddress(String add) {
		address1.sendKeys(add);
	}
	public void entercity(String City) {
		cityName.sendKeys(City );
	}
	public void enterState(String state) {
		Select obj = new Select(stateName);
		obj.selectByVisibleText(state);
	}
	public void enterzipcode(String Zip) {
		zipcode.sendKeys(Zip);
	}
	public void enterphone1(String phn1) {
		homephone.sendKeys(phn1);
	}
	public void enterphone2(String phn2) {
		phoneMob.sendKeys(phn2);
	}
	public void myAddress(String myAdd) {
		myaddress.sendKeys(myAdd);
	}
	public void clickSaveAddress() {
		saveBtn.click();	
		}
	
	
	
}
