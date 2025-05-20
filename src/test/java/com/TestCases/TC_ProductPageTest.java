package com.TestCases;

import java.io.IOException;

import org.testng.annotations.Test;

import com.PageObject.IndexPage;
import com.PageObject.MyAccount;
import com.PageObject.RegisteredUseraccount;
import com.PageObject.SearchResultPage;

import junit.framework.Assert;

public class TC_ProductPageTest extends BaseClass {
     
	
	@Test(enabled=true)
	public void VerifySearchProduct() throws IOException
	{
		String searchKey = "T-shirts";
		logger.info("\n***************TestCase Search Product started*****************"); 

		//Sign in 
		IndexPage indexPg = new IndexPage(driver);
		indexPg.clickOnSignIn();


		//Enter account details- email and password
		MyAccount pg = new MyAccount(driver);
		pg.enterRegEmailAddress("batch_111@gmail.com");

		logger.info("User Email and Password entered.");
		pg.enterRegPassword("vj123");

		pg.loginsubmit();
		logger.info("Sign In link clicked");
		
		//Enter searchkey in search box
				RegisteredUseraccount productPg = new RegisteredUseraccount(driver);
				productPg.EnterDataInSearchBox(searchKey);
				productPg.ClickOnSearchButton();
	
				// Get Name of Searched Product
				SearchResultPage resultPg = new SearchResultPage(driver);

				String SearchResultProductname=resultPg.getSearchResultProductName();
				//Verify that correct Product is displaying after search

				if(SearchResultProductname.contains(searchKey))
				{
					logger.info("Search Product testcase - Passed"); 
					Assert.assertTrue(true);

					productPg.clickOnSignOut();

				}
				else
				{
					logger.info("Search Product testcase - Failed");
					captureScreenShots(driver,"VerifySearchProduct");
					Assert.assertTrue(false);

				} 

				logger.info("---------TestCase Search Product ends-------"); 
			}		
}