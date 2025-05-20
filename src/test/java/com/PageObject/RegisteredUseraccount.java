package com.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisteredUseraccount {
	
	WebDriver ldriver;
	
	public RegisteredUseraccount(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
   }
	
	//Find the WebElement
	@FindBy(xpath="//a[@title='View my customer account']")
	WebElement userName;
	
	@FindBy(linkText = "Sign out")
	WebElement signOut;
	
	// search box WebElement
	@FindBy(name ="search_query")
	WebElement searchBox;

	@FindBy(name ="submit_search")
	WebElement submit_search;

	@FindBy(linkText = "Women")
	WebElement WomenMenu;

	@FindBy(linkText="T-shirts")
	WebElement TShirtMenu;
	
	//Perform Action
	public String getUserName() {
		String text = userName.getText();
		return text;
	}
	
	public void clickOnSignOut()
	{
		signOut.click();
	}
	public void EnterDataInSearchBox(String searchKey)
	{
		searchBox.sendKeys(searchKey);
	}

	public void ClickOnSearchButton()
	{
		submit_search.click();

	}	
	public void MouseOverTShirtMenu()
	{
		Actions actions=new Actions(ldriver);
		actions.moveToElement(WomenMenu).moveToElement(TShirtMenu).click().perform();
	}
	
}
	