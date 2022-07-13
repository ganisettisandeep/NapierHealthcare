package com.HC.testCases;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.HC.pageObjects.DashboardPO;
import com.HC.pageObjects.LoginPage;
import com.HC.utilities.BaseClass;
import com.HC.utilities.Constants;
import com.HC.utilities.XLUtils;
import com.aventstack.extentreports.Status;

public class TC_IRinvestigationIRDetails extends BaseClass {
	@Test
	public void TC_IRinvestigationIRDetails() throws IOException, InterruptedException, ParseException{
		
        SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyyyHHmm");  
        Date date = new Date();  
        String dateTime = formatter.format(date);
        System.out.println(dateTime);
     
				
		screens = 3;
		Elogger=extent.createTest("TC_IRinvestigationIRDetails");		
		
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
		
		//IR Configuration
		db.IRConfiguration();
		logger.info("IR Configuration clicked");
		Thread.sleep(2000);
		
		//checking the risk assessment
		boolean f1 = db.isRiskAssessment();
		Thread.sleep(2500);
		if(f1==false) {
			logger.info("enabling the risk assessment");
			db.enableRiskAssessment();
		}
		logger.info("checked the risk assessment");
		Thread.sleep(2500);
		

		//checking the Self-reporting IRs
		boolean f2 = db.isSelfReporting();
		Thread.sleep(2500);
		if(f2==false) {
			logger.info("enabling the Self-reporting IRs");
			db.enableSelfReporting();
		}
		logger.info("checked the Self-reporting IRs");
		Thread.sleep(2500);
		

		//checking the IPSG Type
		boolean f3 = db.isIPSGtype();
		Thread.sleep(2500);
		if(f3==false) {
			logger.info("enabling the IPSG Type");
			db.enableIPSGtype();
		}
		logger.info("checked the IPSG Type");
		Thread.sleep(2500);

		//clicking the incident dashboard on left navigation menu
		db.clickincidentdashboard();
		logger.info("dashboard button clicked");
		Thread.sleep(2500);

		//clicking the quality dashboard inside incident dashboard
		db.clickQualityDashboard();
		logger.info("quality dashboard button clicked");
		Thread.sleep(5000);
		Elogger.log(Status.PASS, "quality dashboard button clicked");

		//enter the IR code in quality dashboard
		String IRcode = XLUtils.getCellData(Constants.Path_IncidentData,"TC_IRinvestigationIRDetails", 1,0);
		//String IRcode = "018 /06/2022 NAP H";
		db.enterIRcodeQD(IRcode);
		logger.info("entered IR code");
		Thread.sleep(2000);
		Elogger.log(Status.PASS, "entered IR code");

		//click on search button in quality dashboard
		db.searchButtonQD();
		logger.info("search button clicked");
		Thread.sleep(2000);
		Elogger.log(Status.PASS, "search button clicked");

		//click on actions button for an IR code
		db.clickAction();
		logger.info("actions clicked");
		Thread.sleep(2000);

		//click on investigation button in the actions menu
		db.clickInvestigationButton();
		logger.info("investigation button clicked");
		Thread.sleep(2000);
		Elogger.log(Status.PASS, "investigation button clicked");
		
		//click on IR details tab in investigation page
		db.clickIRdetailsTab();
		logger.info("IR Details tab is clicked");
		Thread.sleep(2000);
		Elogger.log(Status.PASS, "IR Details tab is clicked");
		capureScreen(driver,"TC_IRinvestigationIRDetails1");
		
		//selct the No radio button for Previous Similar Incidents in investigation button
		db.clickNoRadioButton();
		logger.info("No radio button for previous similar incidents is clicked");
		Thread.sleep(2000);
		Elogger.log(Status.PASS, "No radio button for previous similar incidents is clicked");
		
		//enter details in table of events
		String eventDetails = XLUtils.getCellData(Constants.Path_IncidentData,"TC_IRinvestigationIRDetails", 1,1);
		db.enterDetails(eventDetails);
		logger.info("details entered");
		Thread.sleep(2000);
		
		//select Date&Time in table of events
		//String dateTime = XLUtils.getCellData(Constants.Path_IncidentData,"TC_IRinvestigationIRDetails", 1,2);
		db.TableEventsDateTime(dateTime);
		logger.info("Date&Time entered");
		Thread.sleep(2000);
		
		SimpleDateFormat format1 = new SimpleDateFormat("ddMMyyyyHHmm");
		SimpleDateFormat format2 = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		Date date1 = format1.parse(dateTime);
		String dateTimeF = format2.format(date1);
		System.out.println(dateTimeF);
		
		//click on add button in table of events
		db.clickAddButton();
		logger.info("add button is clicked");
		Thread.sleep(2000);
		Elogger.log(Status.PASS, "add button is clicked");
		
		//assertion for date&time of table of events is getting reflected in the grid
		ArrayList<String> dateTimeArr = new ArrayList<String>();
		dateTimeArr = db.assertEvent();
		boolean flag3 = dateTimeArr.contains(dateTimeF);
		Assert.assertTrue(flag3);
		Thread.sleep(2000);
		Elogger.log(Status.PASS, "Assert for addition of Table of Events is successful");
		
		//select severity in IR details page
		db.selectSeverity();
		logger.info("severity is selected");
		Thread.sleep(2000);
		Elogger.log(Status.PASS, "severity is selected");
		
		//select Likelihood in IR details page
		db.selectLikelihood();
		logger.info("Likelihood is selected");
		Thread.sleep(2000);
		Elogger.log(Status.PASS, "Likelihood is selected");
		
		//selecting the Risk Register
		db.selectRiskRadioButton();
		logger.info("Risk Register is selected");
		Thread.sleep(2000);
		Elogger.log(Status.PASS, "Risk Register is selected");
		
		//selecting the Self Reporting
		db.selectSelfReporting();
		logger.info("Self Reporting is selected");
		Thread.sleep(2000);
		Elogger.log(Status.PASS, "Self Reporting is selected");
		
		//select name in self-reporting
		String notesName = XLUtils.getCellData(Constants.Path_IncidentData,"TC_IRinvestigationIRDetails", 1,2);
		db.selectName(notesName);
		logger.info("name is selected");
		Thread.sleep(2000);
		Elogger.log(Status.PASS, "name is selected");
		
		//enter notes in notes section
		String notesDetails = XLUtils.getCellData(Constants.Path_IncidentData,"TC_IRinvestigationIRDetails", 1,3);
		db.enterNotes(notesDetails);
		logger.info("notes is entered");
		Thread.sleep(2000);
		
		//select Date&Time in notes section
		db.selectDateTime(dateTime);
		logger.info("Date&Time is entered");
		Thread.sleep(2000);
		
		//click on add button in notes section
		db.clickNotesAddButton();
		logger.info("add button clicked");
		Thread.sleep(2000);
		capureScreen(driver,"TC_IRinvestigationIRDetails2");
		Elogger.log(Status.PASS, "notes is added");
		
		//assertion for date&time of table of events is getting reflected in the grid
		ArrayList<String> dateTimeNotes = new ArrayList<String>();
		dateTimeNotes = db.assertNotes();
		boolean flagN = dateTimeNotes.contains(dateTimeF);
		Assert.assertTrue(flagN);
		Thread.sleep(2000);
		Elogger.log(Status.PASS, "Assert for addition of Notes is successful");
		
		//click on submit button in IR details page
		db.SubmitButton();
		logger.info("submit button clicked");
		Thread.sleep(2000);
		Elogger.log(Status.PASS, "submit button clicked");
		capureScreen(driver,"TC_IRinvestigationIRDetails3");

		//assertion the pop-up whether it is containing the success response of saving the data
		boolean result = db.assertSuccessResponse();
		Assert.assertTrue(result);
		Elogger.log(Status.PASS, "Success response in pop-up is validated");
		
		//click on Ok button of pop-up
		db.OKbutton();
		logger.info("Ok button clicked");
		Thread.sleep(2000);
		
	}
}
