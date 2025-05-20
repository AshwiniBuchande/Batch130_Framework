package com.TestCases;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.Utilities.ReadConfig;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

    public static WebDriver driver;
    public static org.apache.logging.log4j.Logger logger;
    public String url;

    @BeforeClass
    public void setUp() {
        // Initialize config inside setup method
        ReadConfig readconfig = new ReadConfig();
        url = readconfig.getBaseUrl();
        String browser = readconfig.getBrowser();

        // Launch browser based on config
        if(browser.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else
		{
			throw new IllegalArgumentException("Unsupported Browser: "+browser);
		}

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(url);

        logger = LogManager.getLogger("selenium_project");
    }

//    @AfterClass
//    public void tearDown() {
//    	if (driver != null) {
//       driver.quit();
//        }
    
    public void captureScreenShots(WebDriver driver, String testName) throws IOException  {
    	TakesScreenshot sc = ((TakesScreenshot)driver);
    	File src = sc.getScreenshotAs(OutputType.FILE);
    	File dest = new File(System.getProperty("user.dir")+"//screenshots//"+testName+".png");
    	FileUtils.copyFile(src, dest);	
   }
}