package com.HC.testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.HC.pageObjects.DashboardPO;
import com.HC.pageObjects.LoginPage;
import com.HC.utilities.BaseClass;
import com.HC.utilities.Constants;
import com.HC.utilities.XLUtils;
import com.HC.utilities.Reporting;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;


public class TC_IRAcknowledge extends BaseClass {
	
	
	@Test
	public void TC_IRAcknowledge() throws IOException, InterruptedException{

		screens = 6;		
		
		Elogger=extent.createTest("TC_IRAcknowledge");
	
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
		JavascriptExecutor js = (JavascriptExecutor)driver; 

		//dashboard
		db.clickincidentdashboard();
		logger.info("dashboard button clicked");
		Thread.sleep(2500);
		Elogger.log(Status.PASS, "dashboard is clicked");
	/*	
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
	*/
		//enter IR code
		String IRcode = XLUtils.getCellData(Constants.Path_IncidentData,"TC_IRAcknowledge", 1,0);
		db.enterIRcodeQD(IRcode);
		logger.info("entered IR code");
		Thread.sleep(2000);
		Elogger.log(Status.PASS, "entered IR code");
				
		//search button
		db.searchButtonQD();
		logger.info("search button clicked");
		Thread.sleep(2000);
		Elogger.log(Status.PASS, "search button clicked");

		capureScreen(driver,"TC_IRAcknowledge1");
		
		//acknowledgeIR
		db.clickInciAcknowledge();
		logger.info("acknowledge button clicked on dashboard");
		Thread.sleep(2000);
		Elogger.log(Status.PASS, "acknowledge button clicked on dashboard");

		capureScreen(driver,"TC_IRAcknowledge2");
		
		//acknowledge button click
		db.buttonAcknowledge();
		logger.info("acknowledge button is clicked");
		Thread.sleep(2000);
		Elogger.log(Status.PASS, "acknowledge button is clicked");
		
		//enter remark
		db.enterRemark("automation test");
		logger.info("remark is entered");
		Thread.sleep(2000);
		Elogger.log(Status.PASS, "remark is entered");

		capureScreen(driver,"TC_IRAcknowledge3");
		
		//confirm Acknowledge
		db.confirmAcknowledge();
		logger.info("acknowledge button is clicked");
		Thread.sleep(2000);
		Elogger.log(Status.PASS, "acknowledge button is clicked");

		//button OK
		db.buttonOk();
		logger.info("OK button is clicked");
		Thread.sleep(2000);
		
		//assert for acknowledged message
		boolean ackicon = db.assertAcknowledge();
		Thread.sleep(2000);
		Assert.assertEquals(ackicon, true);
		logger.info("Acknowledged message is displayed");
		Elogger.log(Status.PASS, "Acknowledged message is displayed");
		
		//dashboard
		db.clickincidentdashboard();
		logger.info("dashboard button clicked");
		Thread.sleep(2500);
		Elogger.log(Status.PASS, "dashboard button clicked");
		
		//IR code
		db.enterIRcodeQD(IRcode);
		logger.info("entered IR code");
		Thread.sleep(2000);
		
		//search button
		db.searchButtonQD();
		logger.info("search button clicked");
		Thread.sleep(2000);
		capureScreen(driver,"TC_IRAcknowledge4");
		
		/*
		//fetching the status of IR
		String statusText = db.getStatusText(js);
		logger.info("statusText fetched is: "+statusText);
		Thread.sleep(2000);
		Elogger.log(Status.PASS, "statusText fetched is: "+statusText);
		
		//result
		Assert.assertEquals(statusText, "Acknowledged");
		logger.info("status is matching");
		Elogger.log(Status.PASS, "status assertion is passed");
		*/
		
		//acknowledgeIR
		db.clickInciAcknowledge();
		logger.info("acknowledge button clicked on dashboard");
		Thread.sleep(2000);

		//assertAcknowledgeBanner
		boolean banner = db.assertAcknowledgeBanner();
		Thread.sleep(2000);
		Assert.assertEquals(banner, true);
		logger.info("acknowledge banner is checked");
		Elogger.log(Status.PASS, "acknowledge banner is checked");
		
		capureScreen(driver,"TC_IRAcknowledge5");
		

		//dashboard
		db.clickincidentdashboard();
		logger.info("dashboard button clicked");
		Thread.sleep(2500);
		
		//quality dashboard
		db.clickQualityDashboard();
		logger.info("quality dashboard button clicked");
		Thread.sleep(5000);
		Elogger.log(Status.PASS, "Dashboard is clicked");
		
		//enter IR code
		db.enterIRcodeQD(IRcode);
		logger.info("entered IR code");
		Thread.sleep(2000);
		
		//search button
		db.searchButtonQD();
		logger.info("search button clicked");
		Thread.sleep(4000);
		Elogger.log(Status.PASS, "searched with IRcode");

		//asserting the green flag
		boolean flag = db.assertFlag();
		Assert.assertEquals(flag, true);
		Elogger.log(Status.PASS, "asserted the green flag");

		capureScreen(driver,"TC_IRAcknowledge6");
		
		
	}
}
