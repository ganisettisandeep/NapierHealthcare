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
import com.HC.utilities.XLUtils;
import com.aventstack.extentreports.Status;

public class TC_IRinvestigationRequestInput extends BaseClass {
	@Test
	public void TC_IRinvestigationRequestInput() throws IOException, InterruptedException, ParseException{
     
		screens = 8;
		Elogger=extent.createTest("TC_IRinvestigationRequestInput");		
		
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
		String IRcode = XLUtils.getCellData(Constants.Path_IncidentData,"TC_IRinvestigationRequestInput", 1,0);
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
		capureScreen(driver,"TC_IRinvestigationRequestInput1");

		//click on investigation button in the actions menu
		db.clickInvestigationButton();
		logger.info("investigation button clicked");
		Thread.sleep(2000);
		Elogger.log(Status.PASS, "investigation button clicked");
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
		
		//select IR information in RequestForInput pop-up
		db.selectIRinfo();
		logger.info("IR information is selected");
		Thread.sleep(2000);
		
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

		// click on submit button in RequestForInput pop-up
		db.submitQuery();
		logger.info("query submitted");
		Thread.sleep(2000);
		Elogger.log(Status.PASS, "query submitted");
				
		//assertion for date&time of RaisedOn field getting reflected in the grid
		ArrayList<String> dateTimeArr = new ArrayList<String>();
		dateTimeArr = db.getQueryDateTime();
		boolean flag3 = dateTimeArr.contains(dateTimeF);
		Assert.assertTrue(flag3);
		Thread.sleep(2000);
		logger.info("assertion is successful");
		Elogger.log(Status.PASS, "assertion is successful");
		
		//click on IR Query Dashboard in left menuu navigation
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
		capureScreen(driver,"TC_IRinvestigationRequestInput5");

		//asserting the query from investigation in submit IR inputs pop-up
		String requestQuery = db.assertQuery();
		Assert.assertEquals(requestQuery, query);
		logger.info("query asserted");
		Elogger.log(Status.PASS, "query is asserted");
		Thread.sleep(2000);
		
		//enter the response in submit IR inputs pop-up
		String response = XLUtils.getCellData(Constants.Path_IncidentData,"TC_IRinvestigationRequestInput", 1,4);
		db.responseText(response);
		logger.info("response is entered");
		Thread.sleep(2000);
		Elogger.log(Status.PASS, "response is entered from query dashboard");
		capureScreen(driver,"TC_IRinvestigationRequestInput6");
		
		//click on submit button in submit IR inputs pop-up
		db.responseSubmit();
		logger.info("submit response is clicked");
		Thread.sleep(2000);
		Elogger.log(Status.PASS, "submit response is clicked");
		capureScreen(driver,"TC_IRinvestigationRequestInput7");
		
		//again going to investigation page to assert the submitted response whether coming up in request input pop-up
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

		//click on view button in grid of investigation page
		db.viewSubmittedResponse();
		logger.info("view button clicked");
		Thread.sleep(2000);
		Elogger.log(Status.PASS, "view button clicked");
		capureScreen(driver,"TC_IRinvestigationRequestInput8");
		
		//asserting the response from query dashboard in request input pop-up
		String responseIRinputs = db.assertResponse();
		Assert.assertEquals(responseIRinputs, response);
		logger.info("response from query dashboard is asserted in IR Input page");
		Thread.sleep(2000);
		Elogger.log(Status.PASS, "response from query dashboard is asserted in IR Input page");
		
	}
}
