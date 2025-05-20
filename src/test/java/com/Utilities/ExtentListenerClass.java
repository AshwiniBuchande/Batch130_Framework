package com.Utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentListenerClass implements ITestListener{
	
	ExtentSparkReporter htmlReporter;
	ExtentReports reports;
	ExtentTest test;
	public void configurationReport() {
		ReadConfig readConfig = new ReadConfig();
		String timestamp = new SimpleDateFormat("yyyy.mm.dd.hh.mm.ss").format(new Date());
		String reportName = "Batch_13_Framework"+timestamp+".html";
		htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir")+"//Reports//"+reportName);
		
		reports = new ExtentReports();
		reports.attachReporter(htmlReporter);
		
		// add system info or Environment info
		reports.setSystemInfo("Machine","hp");
		reports.setSystemInfo("OS","Windows 11");
		reports.setSystemInfo("browser: ", "Chrome");
		reports.setSystemInfo("QA","Ashwini");
		
		// configuration  to change look and feel
		htmlReporter.config().setDocumentTitle("Extent Listener Report Demo ");
		htmlReporter.config().setReportName("This is my First framework report");
		htmlReporter.config().setTheme(Theme.DARK);
		
	}
	//onStart method is called when any test Starts
	public void onStart(ITestContext result) {
		configurationReport();
		System.out.println("On Start method invoked....");	
	}

	public void onTestStart(ITestResult result) {
		System.out.println("Name of test method started : "+result.getName());
		
	}
	public void onTestSuccess(ITestResult result) {
	System.out.println("Name of test method successfully executed : "+result.getName());
	test = reports.createTest(result.getName());
	test.log(Status.PASS, MarkupHelper.createLabel("Name of the passed test case is : "+result.getName(),ExtentColor.GREEN));	
	}
	
	public void onTestFailure(ITestResult result) {
	System.out.println("Name of test method failed : "+result.getName());
	test = reports.createTest(result.getName()); // create entry in html report
	test.log(Status.FAIL, MarkupHelper.createLabel("Name of test failed test case is :"+result.getName(),ExtentColor.RED));
	
	String screenShotPath = System.getProperty("user.dir")+"\\screenshots\\"+result.getName()+".png";
	
	File screenShotFile = new File(screenShotPath);
	if(screenShotFile.exists()) {
		test.fail("Captured Screenshots is Below :"+test.addScreenCaptureFromPath(screenShotPath));
	}
		
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("Name of test method skipped: "+result.getName());
		test = reports.createTest(result.getName());
		test.log(Status.SKIP, MarkupHelper.createLabel("Name of the skip test case is : "+result.getName(), ExtentColor.YELLOW));
	}
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
			
	}
	public void onFinish(ITestContext result) {
     System.out.println("On Finished method invoked...");
     reports.flush();//it is mandatory to call flush method to ensure information is written to the started reporter
     	
	}
}
