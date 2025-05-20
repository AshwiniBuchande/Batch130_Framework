package com.TestCases;
import com.PageObject.MyAccount;

import com.PageObject.RegisteredUseraccount;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.PageObject.AccountCreation;
import com.PageObject.AddressPage;
import com.PageObject.IndexPage;

public class TC_MyAccount extends BaseClass {
	
	@Test(enabled=false)
	public void TC_VerifyRegisterionAndLogin() {
		String url = "http://www.automationpractice.pl/index.php";
		driver.get(url);
		logger.info("url opened");
		
		IndexPage ip = new IndexPage(driver);
		ip.clickOnSignIn();
		logger.info("clicked on Sign in button"); 
		 
		MyAccount ma = new MyAccount(driver);
		ma.enterEmailId("vjpat@gmail.com");
		ma.clickSubmit();
		logger.info("Account Created");
		
		AccountCreation ac = new AccountCreation(driver);
		ac.selecttitleMr();
		ac.enterCustomerfirstName("Vijay");
		ac.enterCustomerlastName("Jain");
		ac.enterPassword("vj123");
		ac.clickonRegistor();
		logger.info("Profile Created");
		
		AddressPage ap = new AddressPage(driver);
			ap.clickonAddressBtn();
			ap.enterCompanyName("abcd");
			ap.enterAddress("Kothrud");
			ap.entercity("Pune");
			ap.enterState("Alaska");
			ap.enterzipcode("00000");
			ap.enterphone1("9090909090");
			ap.enterphone2("8080808080");
			ap.myAddress("office");
			ap.clickSaveAddress();
			logger.info("User address details added");
			
			RegisteredUseraccount ra = new RegisteredUseraccount(driver);
			String userName = ra.getUserName();
			Assert.assertEquals("Vijay Jain", userName);
			logger.info("Account verified"); 
	}

	@Test 
	public void verifyLogin() throws IOException {
		String url = "http://www.automationpractice.pl/index.php";
		driver.get(url);
		logger.info("url opened");
		
	
	logger.info("Verified login test for already Register User");
	
	IndexPage ip = new IndexPage(driver);
	ip.clickOnSignIn();
	logger.info("clicked on sign in button"); 
	
	MyAccount ma = new MyAccount(driver);
	ma.enterRegEmailAddress("vjpat@gmail.com");
	logger.info("Enter Registered User Email");
	ma.enterRegPassword("vj123");
	logger.info("Enter Registered User Password");
	ma.loginsubmit();
	logger.info("Click on sign in");
	
	RegisteredUseraccount ra = new RegisteredUseraccount(driver);
	String Username = ra.getUserName();
	if(Username.equalsIgnoreCase("Vijay Jain"))
	{
		logger.info("User Verification is - Pass");
		Assert.assertTrue(true);
	}else
	{
		logger.info("User Verification is - failed");
		captureScreenShots(driver,"VerifyLogin");
		Assert.assertTrue(false);
	}
	}
}