package com.TestCases;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.PageObject.IndexPage;
import com.PageObject.MyAccount;
import com.PageObject.RegisteredUseraccount;
import com.Utilities.ReadExcelFile;

import junit.framework.Assert;

public class TC_MyAccountPageTestDataDriven extends BaseClass {

	@Test(dataProvider = "LoginDataProvider")
	 public void VerifyLogin(String userEmail, String userPwd, String expectedUsername) throws IOException {
		    logger.info("---------TestCase VerifyLogin starts---------");

		    try {
		        // Navigate to Sign In
		        IndexPage indexPage = new IndexPage(driver);
		        indexPage.clickOnSignIn();
		        logger.info("Clicked on Sign In link");

		        // Enter login credentials
		        MyAccount myAccount = new MyAccount(driver);
		        myAccount.enterRegEmailAddress(userEmail);
		        logger.info("Entered email address: " + userEmail);

		        myAccount.enterRegPassword(userPwd);
		        logger.info("Entered password");

		        myAccount.loginsubmit();
		        logger.info("Clicked on Sign In button");

		        // Get displayed username after login
	            RegisteredUseraccount registeredUser = new RegisteredUseraccount(driver);
		        String actualUsername = registeredUser.getUserName();

		        logger.info("Expected Username: " + expectedUsername);
		        logger.info("Actual Username: " + actualUsername);

		        // Assertion
		        if(actualUsername.trim().equalsIgnoreCase(expectedUsername.trim())) {
		            logger.info("Login successful - Test Passed");
		            Assert.assertTrue(true);
		            registeredUser.clickOnSignOut();
		            logger.info("Signed out successfully");
		        } else {
		            logger.error("Login failed - Username mismatch");
		            captureScreenShots(driver, "VerifyLogin");
	           Assert.fail("Expected: " + expectedUsername + " | Actual: " + actualUsername);
		        }
		    } catch (Exception e) {
		        logger.error("Exception occurred during VerifyLogin test", e);
		        captureScreenShots(driver, "VerifyLogin_Exception");
		        Assert.fail("Test failed due to exception: " + e.getMessage());
		    } finally {
		   logger.info("---------TestCase VerifyLogin ends----------");
		    }
		}

		@DataProvider(name = "LoginDataProvider")
		public String[][] LoginDataProvider() throws IOException {
	String fileName = "C:\\Users\\Ashwini\\Desktop\\TestData_130.xlsx"; // Fixed file path

		  int ttlRows = ReadExcelFile.getRowCount(fileName, "LoginTestData");
		  int ttlColumns = ReadExcelFile.getColCount(fileName, "LoginTestData");

		    // Defensive check
		    if (ttlRows <= 1 || ttlColumns <= 0) {
		        throw new RuntimeException("Test data is missing or malformed in sheet: LoginTestData");
		    }
		    String data[][] = new String[ttlRows - 1][ttlColumns];

		    for (int i = 1; i < ttlRows; i++) {
		    for (int j = 0; j < ttlColumns; j++) {
	data[i - 1][j] = ReadExcelFile.getCellValue(fileName, "LoginTestData", i, j);
		        }
		    }
		    return data;
		}
}