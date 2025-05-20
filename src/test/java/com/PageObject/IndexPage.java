package com.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IndexPage {
	
	// create object of WebDriver
	WebDriver ldriver;
	
	// create Constructor
	public IndexPage(WebDriver rdriver){
		ldriver = rdriver;
		
	// we need to call init method of PageFactory
		PageFactory.initElements(rdriver, this);
	}
	
	// we need to find WebElement
	@FindBy(linkText="Sign in")
	WebElement sigIn;
	
	// we need to perform Action
	public void clickOnSignIn() {
		sigIn.click();
	}

}
