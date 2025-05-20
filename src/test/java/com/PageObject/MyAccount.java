package com.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccount {
	
	 WebDriver ldriver;
	 
	 public MyAccount (WebDriver rdriver) {
		 ldriver = rdriver;
		 
		 PageFactory.initElements(rdriver, this);
	 }
	 // we need to find WebElement
	 // this is for new account creation
	 @FindBy(id="email_create")
	 WebElement createEmailId;
	 
	 @FindBy(id="SubmitCreate")
	 WebElement submit;
	 
	 // find the WebElement for already registered user
	 @FindBy(id="email")
	 WebElement RegisteredUserEmail;
	 
	 @FindBy(id="passwd")
	 WebElement RegisteredUserPwd;
	 
	 @FindBy(id="SubmitLogin")
	 WebElement submitLogin   ;
	 
	 // perform Action
	 public void enterEmailId(String emailAdd)
	 {
		createEmailId.sendKeys(emailAdd);
	 }
	 public void clickSubmit()
	 {
		submit.click();
	 }
	 
	 //this action for already register User
	 public void enterRegEmailAddress(String emailAdd)
	 {
		 RegisteredUserEmail.sendKeys(emailAdd);
	 }
	 public void enterRegPassword(String pwd)
	 {
		 RegisteredUserPwd.sendKeys(pwd);
	 }
	 public void loginsubmit() 
	 {
		submitLogin.click(); 
	 }
}
