package com.HC.testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.Test;

import com.HC.pageObjects.DashboardPO;
import com.HC.pageObjects.LoginPage;
import com.HC.utilities.BaseClass;
import com.HC.utilities.Constants;
import com.HC.utilities.Reporting;
import com.HC.utilities.XLUtils;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class TC_IR_TAT extends BaseClass {

	@Test
	public void TC_IR_TAT() throws IOException, InterruptedException{
		screens = 3;
		
		Elogger=extent.createTest("TC_IR_TAT");
		
		logger.info("URL is opened");
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(usernameHIS);
		logger.info("Entered username");
		System.out.println("Entered Username -->" + usernameHIS);
		Thread.sleep(1000);
		lp.setPassword(passwordHIS);
		System.out.println("Entered Password --->" + passwordHIS);
		Thread.sleep(1000);
		logger.info("Entered Password");
		lp.clicksubmit();
		logger.info("Login button pressed");
		Thread.sleep(5000);
		
		Elogger.log(Status.PASS, "Login is successful");
		
		DashboardPO db = new DashboardPO(driver);
		Actions actions = new Actions(driver); 
		JavascriptExecutor js = (JavascriptExecutor)driver; 

		//dashboard
		db.clickincidentdashboard();
		logger.info("dashboard button clicked");
		Thread.sleep(2500);
		
		//quality dashboard
		db.clickQualityDashboard();
		logger.info("quality dashboard button clicked");
		Thread.sleep(5000);
		Elogger.log(Status.PASS, "Dashboard is clicked");
		
		//select status
		db.selectStatus();
		logger.info("Status is selected");
		Thread.sleep(2500);
		Elogger.log(Status.PASS, "Status is selected");
		
		//search button
		db.searchButton();
		logger.info("search button is clicked");
		Thread.sleep(5000);
		Elogger.log(Status.PASS, "search button is clicked");
		
		//getIRcode
		String IRcode = db.getIRcodeText();
		System.out.println("IRcode is:"+IRcode);
		
		//enter IR code
		db.enterIRcodeQD(IRcode);
		logger.info("entered IR code");
		Thread.sleep(2000);
				
		//search button
		db.searchButtonQD();
		logger.info("search button clicked");
		Thread.sleep(2000);
		Elogger.log(Status.PASS, "searched with IRcode");
		
		//fetching the status of IR
		String statusText = db.getStatusText(js);

		//fetching the DateTime of IR
		String DateTime = db.getinciDateTime();

		capureScreen(driver,"TC_IR_TAT1");
		
		//click TAT link
		db.clickTAT(js);
		logger.info("TAT link is clicked");
		Thread.sleep(2500);
		Elogger.log(Status.PASS, "TAT link is clicked");
		
		//get status from pop-up
		String status = db.getStatus();
		logger.info("status text is captured");
		Thread.sleep(2500);
		Elogger.log(Status.PASS, "status from pop-up: "+status);
		
		//asserting the status
		Assert.assertEquals(statusText, status);
		Elogger.log(Status.PASS, "status is asserted");
		
		//get IRcode from pop-up
		String IRcodePopup = db.IRcodePopup();
		logger.info("IRcode from Popup is captured");
		Thread.sleep(2500);
		
		//asserting the IRcode
		String IRcodePopup1 = IRcodePopup.substring(9);
		logger.info("IRcode from Popup is: "+IRcodePopup1);
		Elogger.log(Status.PASS, "IRcode from Popup is:"+IRcodePopup1);
		Assert.assertEquals(IRcode, IRcodePopup1);
		Elogger.log(Status.PASS, "IRcode is asserted");
		
		
		//get DateTime from pop-up
		String DateTimePopup = db.getDateTimePopup();
		logger.info("DateTime from Popup is captured");
		Thread.sleep(2500);

		//asserting the DateTime
		String DateTimePopup1 = DateTimePopup.substring(22);
		logger.info("DateTime from Popup is: "+DateTimePopup1);
		Elogger.log(Status.PASS, "DateTime from Popup is: "+DateTimePopup1);
		Assert.assertEquals(DateTime, DateTimePopup1);
		Elogger.log(Status.PASS, "Date&Time is asserted");


		capureScreen(driver,"TC_IR_TAT2");
		
		//get TAT from pop-up
		String TAT = db.getTAT();
		logger.info("TAT text is captured");
		String[] arr = TAT.split(" ", -2);
		Thread.sleep(2500);

		//get TATlink from dashboard
		String TATlink = db.getTATlink();
		logger.info("TAT from dashboard is captured");
		Thread.sleep(5000);
		
		//asserting the days
		Elogger.log(Status.PASS, "TAT from pop-up: "+arr[1]);
		Assert.assertEquals(TATlink, arr[1]);
		Elogger.log(Status.PASS, "TAT is asserted");

		capureScreen(driver,"TC_IR_TAT3");
		
	}
}
