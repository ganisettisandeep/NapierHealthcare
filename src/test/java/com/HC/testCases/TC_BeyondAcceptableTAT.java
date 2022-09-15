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
import com.HC.utilities.ReuseableFunctions;
import com.HC.utilities.XLUtils;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class TC_BeyondAcceptableTAT extends BaseClass {

	@Test
	public void TC_BeyondAcceptableTAT() throws IOException, InterruptedException{
		screens = 3;
		
		Elogger=extent.createTest("TC_BeyondAcceptableTAT");
		

		ReuseableFunctions rf = new ReuseableFunctions();
		
		DashboardPO db = new DashboardPO(driver);
		JavascriptExecutor js = (JavascriptExecutor)driver; 
		
		//login to the website
		rf.Login();

		// clicking the incident dashboard on left navigation menu
		db.clickincidentdashboard();
		logger.info("dashboard button clicked");
		Thread.sleep(2500);

		// clicking the quality dashboard inside incident dashboard
		db.clickQualityDashboard();
		logger.info("quality dashboard button clicked");
		Thread.sleep(5000);
		Elogger.log(Status.PASS, "quality dashboard button clicked");

		//enter the IR code in quality dashboard
		String IRcode = XLUtils.getCellData(Constants.Path_IncidentData,"TC_BeyondAcceptableTAT", 1,0);
		db.enterIRcodeQD(IRcode);
		logger.info("entered IR code");
		Thread.sleep(2000);
		Elogger.log(Status.PASS, "entered IR code");

		// click on search button in quality dashboard
		db.searchButtonQD();
		logger.info("search button clicked");
		Thread.sleep(2000);
		Elogger.log(Status.PASS, "search button clicked");
		capureScreen(driver,"TC_BeyondAcceptableTAT1");
		
		//asserting the Beyond acceptable TAT symbol
		boolean flag = db.assertBeyondTATsymbol();
		Assert.assertTrue(flag);
		Thread.sleep(2000);
		logger.info("Beyond acceptable TAT symbol is displayed");
		Elogger.log(Status.PASS, "Beyond acceptable TAT symbol is displayed");
		
		//click TAT link
		db.clickTAT(js);
		logger.info("TAT link is clicked");
		Thread.sleep(2500);
		Elogger.log(Status.PASS, "TAT link is clicked");
		capureScreen(driver,"TC_BeyondAcceptableTAT2");
		
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
		capureScreen(driver,"TC_BeyondAcceptableTAT3");
	}
}
