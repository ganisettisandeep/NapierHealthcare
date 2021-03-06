package com.HC.testCases;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.HC.pageObjects.IncidentPO;
import com.HC.pageObjects.LoginPage;
import com.HC.utilities.BaseClass;
import com.HC.utilities.Constants;
import com.HC.utilities.XLUtils;

public class TC_IncidentReportAllDetails extends BaseClass {
	@Test
	public void TC_IncidentReportAllDetails() throws IOException, InterruptedException, AWTException{
			
		logger.info("URL is opened");
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		logger.info("Entered username");
		System.out.println("Entered Username -->" + username);
		Thread.sleep(1000);
		lp.setPassword(password);
		System.out.println("Entered Password --->" + password);
		Thread.sleep(1000);
		logger.info("Entered Password");
		lp.clicksubmit();
		logger.info("Login button pressed");
		Thread.sleep(5000);

		IncidentPO in = new IncidentPO(driver);
		
		//incident Time
		String timeformat = XLUtils.getCellData(Constants.Path_IncidentData,"TC_IncidentReportAllDetails", 1,0);
		System.out.println("Time format -->" + timeformat);
		lp.intdate(timeformat);
		Thread.sleep(2000);

		//location of incident
		String loc = XLUtils.getCellData(Constants.Path_IncidentData,"TC_IncidentReportAllDetails", 1, 1);
		System.out.println("loc>" + loc);
		lp.clickincidentlocation(loc);
		logger.info("Incident Location entered");
		Thread.sleep(2000);

		//for Location details
		String detail = XLUtils.getCellData(Constants.Path_IncidentData,"TC_IncidentReportAllDetails", 1, 2);
		System.out.println("detail is:"+detail);
		lp.setlocationdetail(detail);
		System.out.println("Location details are set");
		Thread.sleep(2000);
		
		//type of incident
		lp.settypeincident();
		logger.info("Incident type clicked");
		Thread.sleep(2000);
		
		//category
		String cat = XLUtils.getCellData(Constants.Path_IncidentData,"TC_IncidentReportAllDetails", 1, 3);
		System.out.println("cat is: "+cat);
		lp.setIncicat(cat);
		logger.info("Incident Category entered");
		Thread.sleep(2000);
				
		//subcat
		String subcat = XLUtils.getCellData(Constants.Path_IncidentData,"TC_IncidentReportAllDetails", 1, 4);
		System.out.println("subcat is: "+subcat);
		lp.setincidentsubcat(subcat);
		logger.info("Incident sub-category entered");

		//description
		String dec = XLUtils.getCellData(Constants.Path_IncidentData,"TC_IncidentReportAllDetails", 1, 5);
		lp.setincidescrep(dec);
		logger.info("Incident decscription entered");
		Thread.sleep(2000);
		
		//dept involved
		String dept = XLUtils.getCellData(Constants.Path_IncidentData,"TC_IncidentReportAllDetails", 1, 6);
		in.selectDeptInvolved(dept);
		logger.info("dept involved entered");
		Thread.sleep(2000);

		//preventability
		in.selectpreventability();
		logger.info("preventability selected");
		Thread.sleep(2000);

		//ActionTakenText
		String text = XLUtils.getCellData(Constants.Path_IncidentData,"TC_IncidentReportAllDetails", 1, 7);
		in.immedActionTakenText(text);
		logger.info("ActionTaken entered");
		Thread.sleep(2000);

		//action takenBy
		String takenBy = XLUtils.getCellData(Constants.Path_IncidentData,"TC_IncidentReportAllDetails", 1, 8);
		in.selectImmedActionTakenBy(takenBy);
		logger.info("action takenBy selected");
		Thread.sleep(2000);
		
		//action DateTime selection
		String actionDateTime = XLUtils.getCellData(Constants.Path_IncidentData,"TC_IncidentReportAllDetails", 1, 9);
		in.selectActionTakenDateTime(actionDateTime);
		logger.info("action DateTime selected");
		Thread.sleep(2000);

		//witness selected
		String witness = XLUtils.getCellData(Constants.Path_IncidentData,"TC_IncidentReportAllDetails", 1, 10);
		in.selectWitnessedBy(witness);
		logger.info("witness selected");
		Thread.sleep(2000);

		//notifiedTo selection
		String notifiedTo = XLUtils.getCellData(Constants.Path_IncidentData,"TC_IncidentReportAllDetails", 1, 11);
		in.selectNotifiedTo(notifiedTo);
		logger.info("notifiedTo selected");
		Thread.sleep(2000);

		//notifiedDateTime selection
		String notifiedDateTime = XLUtils.getCellData(Constants.Path_IncidentData,"TC_IncidentReportAllDetails", 1, 12);
		in.selectNotifiedDateTime(notifiedDateTime);
		logger.info("notified DateTime selected");
		Thread.sleep(2000);

		//HeadofDept selection
		String hod = XLUtils.getCellData(Constants.Path_IncidentData,"TC_IncidentReportAllDetails", 1, 13);
		in.selectHeadofDept(hod);
		logger.info("HeadofDept selected");
		Thread.sleep(2000);
		
		//file upload
		in.clickFileUpload("file1");
		logger.info("File upload done");
		Thread.sleep(2000);
				
		//submit
		lp.incidentsubmit();
		logger.info("Submit button clicked");
		Thread.sleep(2000);
		lp.popsubmit();
		Thread.sleep(2000);
		String number = LoginPage.getincidentnumber();
		System.out.println("incident number -->" + number);
		capureScreen(driver,"TC_IncidentReportAllDetails");
		Thread.sleep(5000);
		boolean save = lp.popsave();
		Thread.sleep(2500);
		Assert.assertTrue(save);
		XLUtils.setCellData(Constants.Path_IncidentData,"TC_IncidentReportAllDetails", 1 , 14, number);
		System.out.println(XLUtils.getCellData(Constants.Path_IncidentData,"TC_IncidentReportAllDetails", 1, 14));
				
	}
}
