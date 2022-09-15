package com.HC.testCases;

import static org.testng.Assert.assertEquals;

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
import com.HC.utilities.ReuseableFunctions;
import com.HC.utilities.XLUtils;
import com.aventstack.extentreports.Status;

public class TC_IRinvestigationRequestInput extends BaseClass {
	@Test
	public void TC_IRinvestigationRequestInput() throws IOException, InterruptedException, ParseException{
     
		screens = 10;
		Elogger=extent.createTest("TC_IRinvestigationRequestInput");		

		ReuseableFunctions rf = new ReuseableFunctions();
		DashboardPO db = new DashboardPO(driver);
		
		//login
		rf.Login();
		capureScreen(driver,"TC_IRinvestigationRequestInput1");

		//enter the IR code in quality dashboard
		String IRcode = XLUtils.getCellData(Constants.Path_IncidentData,"TC_IRinvestigationRequestInput", 1,0);
		rf.IRinvestigation(IRcode);
		capureScreen(driver,"TC_IRinvestigationRequestInput2");
		
		//click on RequestForInput button in investigation page
		db.clickRequestForInput();
		logger.info("RequestForInput button clicked");
		Thread.sleep(2000);
		Elogger.log(Status.PASS, "RequestForInput button clicked");
		capureScreen(driver,"TC_IRinvestigationRequestInput3");
		
		//select department in RequestForInput pop-up
		String dept = XLUtils.getCellData(Constants.Path_IncidentData,"TC_IRinvestigationRequestInput", 1,1);
		db.selectDepartment(dept);
		logger.info("dept is selected");
		Thread.sleep(2000);
		Elogger.log(Status.PASS, "dept is selected");
		
		//select user in RequestForInput pop-up
		String user = XLUtils.getCellData(Constants.Path_IncidentData,"TC_IRinvestigationRequestInput", 1,2);
		db.selectUser(user);
		logger.info("user is selected");
		Thread.sleep(2000);
		Elogger.log(Status.PASS, "user is selected");
		
		//select Description in IR Information dropdown in RequestForInput pop-up
		db.selectDescription();
		logger.info("Description is selected in IR Information dropdown");
		Thread.sleep(2000);
		Elogger.log(Status.PASS, "user is selected");
		
		//select Departments Involved in IR Information dropdown in RequestForInput pop-up
		db.selectdepartmentsInvolved();
		logger.info("Departments Involved is selected in IR Information dropdown ");
		Thread.sleep(2000);
		Elogger.log(Status.PASS, "Departments Involved is selected in IR Information dropdown ");
		
		//select Copy From Previous in IR Information dropdown in RequestForInput pop-up
		try {
		boolean previousIsDisplayed = db.isCopyFromPreviousDisplayed();
		if(previousIsDisplayed==true) {
			db.selectCopyFromPrevious();
		}
		logger.info("Copy From Previous is selected in IR Information dropdown ");
		Thread.sleep(2000);
		Elogger.log(Status.PASS, "Copy From Previous is selected in IR Information dropdown ");
		}
		catch(Exception e) {
			Elogger.log(Status.PASS, "Copy From Previous is not present in IR Information dropdown ");	
		}
		
		//writing query in RequestForInput pop-up
		String query = XLUtils.getCellData(Constants.Path_IncidentData,"TC_IRinvestigationRequestInput", 1,3);
		db.inputQuery(query);
		logger.info("query noted");
		Thread.sleep(2000);
		Elogger.log(Status.PASS, "query noted");
		capureScreen(driver,"TC_IRinvestigationRequestInput4");

		//capturing the date&time of RaisedOn field while submitting query
		String queryDateTime = db.getRaisedOnDateTime();
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		SimpleDateFormat format2 = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		Date date = format1.parse(queryDateTime);
		String dateTimeF = format2.format(date);
		System.out.println(dateTimeF);
		Thread.sleep(2000);

		//capturing the raised by field while submitting query
		String raisedBy = db.getRaisedBy();

		//assertion for raised by in RequestForInput pop-up
		System.out.println("usernameHIS: "+usernameHIS);
		System.out.println("raisedBy: "+raisedBy);
		Assert.assertEquals(usernameHIS, raisedBy);
		Thread.sleep(2000);
		logger.info("assertion for raised by user is successful");
		Elogger.log(Status.PASS, "assertion for raised by user is successful");					
		
		
		//assertion for text in "From Previous" field in RequestForInput pop-up
		String previousTextpopUp = db.getPreviousText();
		String previousTextexcel = XLUtils.getCellData(Constants.Path_IncidentData,"TC_IRinvestigationRequestInput", 1,6);
		System.out.println("previousTextpopUp: "+previousTextpopUp);
		System.out.println("previousTextexcel: "+previousTextexcel);
		Assert.assertEquals(previousTextexcel, previousTextpopUp);
		Thread.sleep(2000);
		logger.info("assertion for previousText in RequestForInput pop-up is successful");
		Elogger.log(Status.PASS, "assertion for previousText in RequestForInput pop-up is successful");					
		
		
		//click on submit button in RequestForInput pop-up
		db.submitQuery();
		logger.info("query submitted");
		Thread.sleep(2000);
		Elogger.log(Status.PASS, "query submitted");
		
		//assertion for submit of RequestForInput pop-up
		boolean flag2 = db.assertRequestSubmit();
		Assert.assertTrue(flag2);
		Thread.sleep(2000);
		logger.info("assertion is successful");
		Elogger.log(Status.PASS, "assertion is successful for success submittion of query");
		
		//assertion for date&time of RaisedOn field getting reflected in the grid
		ArrayList<String> dateTimeArr = new ArrayList<String>();
		dateTimeArr = db.getQueryDateTime();
		boolean flag3 = dateTimeArr.contains(dateTimeF);
		Assert.assertTrue(flag3);
		Thread.sleep(2000);
		logger.info("assertion is successful");
		Elogger.log(Status.PASS, "assertion is successful for date&time validation");
		
		//edit the request
		int rowIndex = dateTimeArr.indexOf(dateTimeF);
		System.out.println("rowIndex: "+rowIndex);
		db.clickEditInputs(rowIndex+1);

		//editing query in RequestForInput pop-up
		String editedQuery = XLUtils.getCellData(Constants.Path_IncidentData,"TC_IRinvestigationRequestInput", 1,5);
		db.editedInputQuery(editedQuery);
		logger.info("edited query is logged");
		Thread.sleep(2000);
		Elogger.log(Status.PASS, "edited query is logged");
		capureScreen(driver,"TC_IRinvestigationRequestInput5");

		//click on submit button in RequestForInput pop-up after editing query
		db.submitQuery();
		logger.info("edited query submitted");
		Thread.sleep(2000);
		Elogger.log(Status.PASS, "edited query submitted");

		//assertion for submit of RequestForInput pop-up after edit
		boolean flag5 = db.assertRequestSubmit();
		Assert.assertTrue(flag5);
		Thread.sleep(2000);
		logger.info("assertion is successful after editing query submit");
		Elogger.log(Status.PASS, "assertion is successful for success submittion of edited query");
		
		//click on IR Query Dashboard in left menu navigation
		db.IRQueryDashboard();
		logger.info("IR Query Dashboard clicked");
		Thread.sleep(2000);
		Elogger.log(Status.PASS, "IR Query Dashboard clicked");
		
		//enter IR code in IR Query Dashboard page
		db.enterIRcodeQueryDB(IRcode);
		logger.info("entered IR code");
		Thread.sleep(2000);
		Elogger.log(Status.PASS, "entered IR code in query dashboard");
				
		//click on search button in IR Query Dashboard
		db.searchButtonQD();
		logger.info("search button clicked");
		Thread.sleep(2000);
		Elogger.log(Status.PASS, "search button clicked in query dashboard");

		//click on view Response button for the IR code
		db.viewResponse();
		logger.info("view response clicked");
		Thread.sleep(2000);
		capureScreen(driver,"TC_IRinvestigationRequestInput6");

		//asserting the query from investigation in submit IR inputs pop-up
		String requestQuery = db.assertQuery();
		Assert.assertEquals(requestQuery, editedQuery);
		logger.info("query asserted");
		Elogger.log(Status.PASS, "query is asserted");
		Thread.sleep(2000);
		
		//enter the response in submit IR inputs pop-up
		String response = XLUtils.getCellData(Constants.Path_IncidentData,"TC_IRinvestigationRequestInput", 1,4);
		db.responseText(response);
		logger.info("response is entered");
		Thread.sleep(2000);
		Elogger.log(Status.PASS, "response is entered from query dashboard");
		capureScreen(driver,"TC_IRinvestigationRequestInput7");
		
		//click on submit button in submit IR inputs pop-up
		db.responseSubmit();
		logger.info("submit response is clicked");
		Thread.sleep(2000);
		Elogger.log(Status.PASS, "submit response is clicked");
		capureScreen(driver,"TC_IRinvestigationRequestInput8");
		
		boolean flag6 = db.assertRespSubmit();
		Assert.assertTrue(flag6);
		Thread.sleep(2000);
		logger.info("assertion is successful after response is submitted");
		Elogger.log(Status.PASS, "assertion is successful for success message in pop-up for response");
	
		
		//again going to investigation page to assert the submitted response whether coming up in request input pop-up
		
		rf.IRinvestigation(IRcode);
		
		//click on view button in grid of investigation page
		db.viewSubmittedResponse();
		logger.info("view button clicked");
		Thread.sleep(2000);
		Elogger.log(Status.PASS, "view button clicked");
		capureScreen(driver,"TC_IRinvestigationRequestInput9");
		
		//asserting the response from query dashboard in request input pop-up
		String responseIRinputs = db.assertResponse();
		Assert.assertEquals(responseIRinputs, response);
		logger.info("response from query dashboard is asserted in IR Input page");
		Thread.sleep(2000);
		Elogger.log(Status.PASS, "response from query dashboard is asserted in IR Input page");
		
		//click close button
		db.clickCloseButton();
		Thread.sleep(2000);
		logger.info("close button clicked");

		//click delete button
		db.clickDeleteButtonRequest();
		logger.info("delete button is clicked");
		Thread.sleep(2000);
		Elogger.log(Status.PASS, "delete button is clicked");

		//confirmation pop-up is displayed for delete event
		boolean flag8 = db.deleteConfirmation();
		Assert.assertTrue(flag8);
		Thread.sleep(2000);
		Elogger.log(Status.PASS, "Assert for delete request confirmation pop-up is displayed successfully");
		capureScreen(driver,"TC_IRinvestigationRequestInput10");
		
		//confirmation for delete
		db.confirmationYes();
		Thread.sleep(2000);
		Elogger.log(Status.PASS, "Deleted the request in grid");
		
		
		
		
		
	}
}
