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

public class TC_IRinvestigationRecordInputs extends BaseClass {
	@Test
	public void TC_IRinvestigationRecordInputs() throws IOException, InterruptedException, ParseException{

		SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyyyHHmm");  
        Date date = new Date();  
        String dateTime = formatter.format(date);
        System.out.println(dateTime);
     
		screens = 4;
		Elogger=extent.createTest("TC_IRinvestigationRecordInputs");		
		
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
		Elogger.log(Status.PASS, "dashboard button clicked");

		//clicking the quality dashboard inside incident dashboard
		db.clickQualityDashboard();
		logger.info("quality dashboard button clicked");
		Thread.sleep(5000);
		Elogger.log(Status.PASS, "quality dashboard button clicked");

		//enter the IR code in quality dashboard
		String IRcode = XLUtils.getCellData(Constants.Path_IncidentData,"TC_IRinvestigationRecordInputs", 1,0);
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
		capureScreen(driver,"TC_IRinvestigationRecordInputs1");

		//click on actions button for an IR code
		db.clickAction();
		logger.info("actions clicked");
		Thread.sleep(2000);

		//click on investigation button in the actions menu
		db.clickInvestigationButton();
		logger.info("investigation button clicked");
		Thread.sleep(2000);
		Elogger.log(Status.PASS, "investigation button clicked");

		//click on recordInputs button in investigation page
		db.recordInputs();
		logger.info("recordInputs clicked");
		Thread.sleep(2000);
		Elogger.log(Status.PASS, "recordInputs tab is clicked");
		capureScreen(driver,"TC_IRinvestigationRecordInputs2");

		//select the department in record inputs pop-up
		String dept = db.selectDept();
		logger.info("department is selected");
		Thread.sleep(2000);
		Elogger.log(Status.PASS, "department is selected");
		
		//select source in record inputs pop-up
		db.evidenceSource();
		logger.info("Source clicked");
		Thread.sleep(2000);
		Elogger.log(Status.PASS, "Source is selected");
		
		//select receivedOn date in record inputs pop-up
		//String dateTime = XLUtils.getCellData(Constants.Path_IncidentData,"TC_IRinvestigationRecordInputs", 1,1);
		db.recievedOn(dateTime);
		logger.info("receivedOn date clicked");
		Thread.sleep(2000);
		Elogger.log(Status.PASS, "receivedOn date clicked");

		SimpleDateFormat format1 = new SimpleDateFormat("ddMMyyyyHHmm");
		SimpleDateFormat format2 = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		Date date1 = format1.parse(dateTime);
		String dateTimeF = format2.format(date1);
		System.out.println(dateTimeF);
		
		//enter the response in record inputs pop-up
		String response = XLUtils.getCellData(Constants.Path_IncidentData,"TC_IRinvestigationRecordInputs", 1,1);
		db.responseText(response);
		logger.info("response entered");
		Thread.sleep(2000);
		Elogger.log(Status.PASS, "test response in automation");
		capureScreen(driver,"TC_IRinvestigationRecordInputs3");
		
		//click on submit button in record inputs pop-up
		db.submitResponse();
		logger.info("submit Response clicked");
		Thread.sleep(2000);
		Elogger.log(Status.PASS, "submit Response clicked");
		capureScreen(driver,"TC_IRinvestigationRecordInputs4");
		
		//assertion for date&time of received on field getting reflected in the grid
		ArrayList<String> dateTimeArr = new ArrayList<String>();
		dateTimeArr = db.getResDateTime();
		boolean flag3 = dateTimeArr.contains(dateTimeF);
		Assert.assertTrue(flag3);
		Thread.sleep(2000);
		Elogger.log(Status.PASS, "assertion is successful");
		
	}
}
