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

public class TC_IRinvestigationIRDetailsEditDelete extends BaseClass {
	@Test
	public void TC_IRinvestigationIRDetailsEditDelete() throws IOException, InterruptedException, ParseException{
		
        SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyyyHHmm");  
        Date date = new Date();  
        String dateTime = formatter.format(date);
        System.out.println(dateTime);
     
				
		screens = 6;
		Elogger=extent.createTest("TC_IRinvestigationIRDetailsEditDelete");		
		
		ReuseableFunctions rf = new ReuseableFunctions();
		
		DashboardPO db = new DashboardPO(driver);
		
		//login to the website
		rf.Login();
		
		//configuring master before test execution
		rf.IRMasterconfiguration();
		
		//enter the IR code in quality dashboard
		String IRcode = XLUtils.getCellData(Constants.Path_IncidentData,"TC_IRinvestigationIRDetails", 1,0);
		rf.IRinvestigation(IRcode);
				
		//click on IR details tab in investigation page
		db.clickIRdetailsTab();
		logger.info("IR Details tab is clicked");
		Thread.sleep(2000);
		Elogger.log(Status.PASS, "IR Details tab is clicked");
		capureScreen(driver,"TC_IRinvestigationIRDetailsEditDelete1");
		
		//select the No radio button for Previous Similar Incidents in investigation button
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
		

		//enter details in table of events for second event
		db.enterDetails(eventDetails);
		logger.info("details entered for second event");
		Thread.sleep(2000);
		
		//select Date&Time in table of events for second event
		db.TableEventsDateTime(dateTime);
		logger.info("Date&Time entered for second event");
		Thread.sleep(2000);
		
		//click on add button in table of events for second event
		db.clickAddButton();
		logger.info("add button is clicked for second event");
		Thread.sleep(2000);
		Elogger.log(Status.PASS, "add button is clicked for second event");
		
		//click on edit button
		db.clickEditButton();
		logger.info("edit button is clicked");
		Thread.sleep(2000);
		Elogger.log(Status.PASS, "edit button is clicked");
		capureScreen(driver,"TC_IRinvestigationIRDetailsEditDelete2");
		
		//Asserting the event details which are not empty
		String details = db.isDetailsNull();
		Assert.assertNotNull(details);
		
		//edit details in table of events
		String editDetails = XLUtils.getCellData(Constants.Path_IncidentData,"TC_IRinvestigationIRDetails", 1,4);
		db.enterDetails(editDetails);
		logger.info("details entered for edit");
		Thread.sleep(2000);
		Elogger.log(Status.PASS, "new text is entered in event details");
		capureScreen(driver,"TC_IRinvestigationIRDetailsEditDelete3");
		
		//click on add button in table of events for edited event
		db.editAddButton();
		logger.info("add button is clicked for edited event");
		Thread.sleep(4000);
		Elogger.log(Status.PASS, "add button is clicked for edited event");

		//assertion for edited details in table of events is getting reflected in the grid
		ArrayList<String> eventDetailsEdit = new ArrayList<String>();
		eventDetailsEdit = db.assertEventDetails();
		boolean flag7 = eventDetailsEdit.contains(editDetails);
		Assert.assertTrue(flag7);
		Thread.sleep(2000);
		Elogger.log(Status.PASS, "Assert for editing the Table of Events is successful");
		
		//click delete button for deletion of the Table of Events
		int count = db.clickDeleteButton();
		Thread.sleep(2000);
		Elogger.log(Status.PASS, "delete button for deletion of the Table of Events is clicked");
		
		//confirmation pop-up is displayed for delete event
		boolean flag8 = db.deleteConfirmation();
		Assert.assertTrue(flag8);
		Thread.sleep(2000);
		Elogger.log(Status.PASS, "Assert for delete event confirmation pop-up is displayed successful");
		capureScreen(driver,"TC_IRinvestigationIRDetailsEditDelete4");
		
		//confirmation for delete
		db.confirmationYes();
		Thread.sleep(2000);
		Elogger.log(Status.PASS, "Deleted the event in table");
		
		//assertion for count before and after event deletion
		int remainingEvents = db.noOfEvents();
		Assert.assertEquals(remainingEvents, count-1);
		Thread.sleep(2000);
		Elogger.log(Status.PASS, "Assert for count of events after deletion of 1 event successful");
		
		//selecting the Risk Register
		db.selectRiskRadioButtonYes();
		logger.info("Risk Register is selected");
		Thread.sleep(2000);
		Elogger.log(Status.PASS, "Risk Register Yes is selected");

		//enter risk id in risk register
		String riskID = XLUtils.getCellData(Constants.Path_IncidentData,"TC_IRinvestigationIRDetails", 1,5);
		db.enterRiskID(riskID);
		logger.info("riskID is entered");
		Thread.sleep(2000);
		Elogger.log(Status.PASS, "riskID is entered");
		
		//selecting the Self Reporting Yes
		db.selectSelfReportingYes();
		logger.info("Self Reporting Yes is selected");
		Thread.sleep(2000);
		Elogger.log(Status.PASS, "Self Reporting is selected");
		capureScreen(driver,"TC_IRinvestigationIRDetailsEditDelete5");
		
		//click on submit button in IR details page
		db.SubmitButton();
		logger.info("submit button clicked");
		Thread.sleep(2000);
		Elogger.log(Status.PASS, "submit button clicked");
		capureScreen(driver,"TC_IRinvestigationIRDetailsEditDelete6");

		//assertion the pop-up whether it is containing the success response of saving the data
		boolean result = db.assertSuccessResponse();
		Assert.assertTrue(result);
		Elogger.log(Status.PASS, "Success response in pop-up is validated");
		
	}
}
