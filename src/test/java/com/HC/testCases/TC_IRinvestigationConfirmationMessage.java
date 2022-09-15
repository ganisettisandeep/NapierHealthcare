package com.HC.testCases;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

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
import com.HC.utilities.ReuseableFunctions;
import com.HC.utilities.XLUtils;
import com.aventstack.extentreports.Status;

public class TC_IRinvestigationConfirmationMessage extends BaseClass {
	@Test
	public void TC_IRinvestigationConfirmationMessage() throws IOException, InterruptedException, ParseException{
		
        SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyyyHHmm");  
        Date date = new Date();  
        String dateTime = formatter.format(date);
        System.out.println(dateTime);
     
				
		screens = 6;
		Elogger=extent.createTest("TC_IRinvestigationConfirmationMessage");		
		
		ReuseableFunctions rf = new ReuseableFunctions();
		
		DashboardPO db = new DashboardPO(driver);
		JavascriptExecutor js = (JavascriptExecutor)driver; 
		
		//login to the website
		rf.Login();
		
		//enter the IR code in quality dashboard
		String IRcode = XLUtils.getCellData(Constants.Path_IncidentData,"TC_IRinvestigationConfMess", 1,0);
		rf.IRinvestigation(IRcode);
		capureScreen(driver,"TC_IRinvestigationConfirmationMessage1");
		
		db.BacktoDashboard();
		capureScreen(driver,"TC_IRinvestigationConfirmationMessage2");
		
		// enter the IR code in quality dashboard
		db.enterIRcodeQD(IRcode);
		logger.info("entered IR code");
		Thread.sleep(2000);
		Elogger.log(Status.PASS, "entered IR code");

		// click on search button in quality dashboard
		db.searchButtonQD();
		logger.info("search button clicked");
		Thread.sleep(2000);
		Elogger.log(Status.PASS, "search button clicked");

		//fetching the status of IR from dashboard
		String statusText = db.getStatusText(js);
		Assert.assertEquals("Under investigation", statusText);
		capureScreen(driver,"TC_IRinvestigationConfirmationMessage3");
		

		//enter the IR code in quality dashboard for IR confirmation message No
		String IRcode2 = XLUtils.getCellData(Constants.Path_IncidentData,"TC_IRinvestigationConfMess", 1,1);
		
		// enter the IR code in quality dashboard
		db.enterIRcodeQD(IRcode2);
		logger.info("entered IR code");
		Thread.sleep(2000);
		Elogger.log(Status.PASS, "entered IR code");

		// click on search button in quality dashboard
		db.searchButtonQD();
		logger.info("search button clicked");
		Thread.sleep(2000);
		Elogger.log(Status.PASS, "search button clicked");

		// click on actions button for an IR code
		db.clickAction();
		logger.info("actions clicked");
		Thread.sleep(2000);

		// click on investigation button in the actions menu
		db.clickInvestigationButton();
		logger.info("investigation button clicked");
		Thread.sleep(2000);
		Elogger.log(Status.PASS, "investigation button clicked");
		capureScreen(driver,"TC_IRinvestigationConfirmationMessage4");

		try{
		// checking if confirmation message to start IR investigation
		boolean startIRinvestigation = db.isStartIRinvestigation();
		System.out.println("startIRinvestigation is: "+startIRinvestigation);
		// starts IR investigation by clicking on Yes button in confirmation message
		if (startIRinvestigation) {
			db.IRinvestigationNo();
			Elogger.log(Status.PASS, "Clicked on No button in confirmation message");
		}
		Thread.sleep(2000);
		}
		catch(Exception e){
			System.out.println("No confirmation message to start investigation");
		}

		boolean dashboardPage = db.IRincidentReportingDashboardPage();
		Assert.assertTrue(dashboardPage);
		Thread.sleep(2000);
		logger.info("Assert for confirmation message No redirected to dashboard page");
		Elogger.log(Status.PASS, "Assert for confirmation message No redirected to dashboard page");
		capureScreen(driver,"TC_IRinvestigationConfirmationMessage5");
		
		// enter the IR code in quality dashboard
		db.enterIRcodeQD(IRcode2);
		logger.info("entered IR code");
		Thread.sleep(2000);
		Elogger.log(Status.PASS, "entered IR code");

		// click on search button in quality dashboard
		db.searchButtonQD();
		logger.info("search button clicked");
		Thread.sleep(2000);
		Elogger.log(Status.PASS, "search button clicked");

		//fetching the status of IR from dashboard to assert after No confirmation message
		String statusText2 = db.getStatusText(js);
		Assert.assertEquals("Submitted", statusText2);
		logger.info("assertion successful after clicking No in confirmation message");
		Elogger.log(Status.PASS, "assertion successful after clicking No in confirmation message");
		capureScreen(driver,"TC_IRinvestigationConfirmationMessage6");
				
	}
}
