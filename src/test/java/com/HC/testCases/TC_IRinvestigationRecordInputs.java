package com.HC.testCases;

import java.awt.AWTException;
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
import com.HC.pageObjects.IncidentPO;
import com.HC.pageObjects.LoginPage;
import com.HC.utilities.BaseClass;
import com.HC.utilities.Constants;
import com.HC.utilities.ReuseableFunctions;
import com.HC.utilities.XLUtils;
import com.aventstack.extentreports.Status;

public class TC_IRinvestigationRecordInputs extends BaseClass {
	@Test
	public void TC_IRinvestigationRecordInputs() throws IOException, InterruptedException, ParseException, AWTException{

		SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyyyHHmm");  
        Date date = new Date();  
        String dateTime = formatter.format(date);
        System.out.println(dateTime);
     
		screens = 6;
		Elogger=extent.createTest("TC_IRinvestigationRecordInputs");		

		ReuseableFunctions rf = new ReuseableFunctions();

		DashboardPO db = new DashboardPO(driver);
		IncidentPO in = new IncidentPO(driver);
		
		//login
		rf.Login();
		
		//enter the IR code in quality dashboard
		String IRcode = XLUtils.getCellData(Constants.Path_IncidentData,"TC_IRinvestigationRecordInputs", 1,0);
		rf.IRinvestigation(IRcode);
		capureScreen(driver,"TC_IRinvestigationRecordInputs1");
		
		
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
/*
		in.clickFileUpload("recordInputs");
		logger.info("file uploaded");
		Thread.sleep(2000);
		Elogger.log(Status.PASS, "file uploaded successfully");
	*/	
		capureScreen(driver,"TC_IRinvestigationRecordInputs3");
		
		//click on submit button in record inputs pop-up
		String user = db.getUser();
		db.submitResponse();
		logger.info("submit Response clicked");
		Thread.sleep(2000);
		Elogger.log(Status.PASS, "submit Response clicked");
		capureScreen(driver,"TC_IRinvestigationRecordInputs4");
		
		
		boolean flag5 = db.assertRecordSubmit();
		Assert.assertTrue(flag5);
		Thread.sleep(2000);
		logger.info("assertion is successful after record is submitted for success pop-up");
		Elogger.log(Status.PASS, "assertion is successful for success message in pop-up");
		
		//assertion for date&time of received on field getting reflected in the grid
		ArrayList<String> dateTimeArr = new ArrayList<String>();
		dateTimeArr = db.getResDateTime();
		boolean flag3 = dateTimeArr.contains(dateTimeF);
		Assert.assertTrue(flag3);
		Thread.sleep(2000);
		logger.info("assertion for date and time is successful");
		Elogger.log(Status.PASS, "assertion for date and time is successful");

		//assertion for department is getting reflected in the grid
		ArrayList<String> getDeptArr = new ArrayList<String>();
		getDeptArr = db.getDept();
		boolean flag4 = getDeptArr.contains(dept);
		Assert.assertTrue(flag4);
		Thread.sleep(2000);
		logger.info("assertion for department is successful");
		Elogger.log(Status.PASS, "assertion for department is successful");

		System.out.println("usernameHIS: "+usernameHIS);
		System.out.println("user: "+user);
		Assert.assertEquals(user, usernameHIS);
		Thread.sleep(2000);
		logger.info("assertion for logged in user is successful");
		Elogger.log(Status.PASS, "assertion for logged in user is successful");
		capureScreen(driver,"TC_IRinvestigationRecordInputs5");
		
		//evidence section
		//selecting EvidenceType
		db.selectEvidenceType();
		Thread.sleep(2000);
		logger.info("EvidenceType is selected");
		Elogger.log(Status.PASS, "EvidenceType is selected");

		//selecting EvidenceSource
		db.selectEvidenceSource();
		Thread.sleep(2000);
		logger.info("EvidenceSource is selected");
		Elogger.log(Status.PASS, "EvidenceSource is selected");

		//enter Evidence description
		String desc = XLUtils.getCellData(Constants.Path_IncidentData,"TC_IRinvestigationRecordInputs", 1,2);
		db.evidenceDesc(desc);
		Thread.sleep(2000);
		logger.info("Evidence Description is entered");
		Elogger.log(Status.PASS, "Evidence Description is entered");
		
		//select Evidence Date & Time
		db.evidenceDateTime(dateTime);
		Thread.sleep(2000);
		logger.info("Evidence Date & Time is selected");
		Elogger.log(Status.PASS, "Evidence Date & Time is selected");
		
		//click add button for evidence
		db.addEvidence();
		Thread.sleep(2000);
		logger.info("add button for evidence is clicked");
		Elogger.log(Status.PASS, "add button for evidence is clicked");

		//assertion for date&time of received on field getting reflected in the grid
		ArrayList<String> dateTimeEvidence = new ArrayList<String>();
		dateTimeEvidence = db.getEvidenceDateTime();
		boolean flag6 = dateTimeEvidence.contains(dateTimeF);
		Assert.assertTrue(flag6);
		Thread.sleep(2000);
		logger.info("assertion for evidence date and time is successful");
		Elogger.log(Status.PASS, "assertion for evidence date and time is successful");
		capureScreen(driver,"TC_IRinvestigationRecordInputs6");

		
	}
}
