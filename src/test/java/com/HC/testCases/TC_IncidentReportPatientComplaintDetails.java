package com.HC.testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.HC.pageObjects.IncidentPO;
import com.HC.pageObjects.LoginPage;
import com.HC.utilities.BaseClass;
import com.HC.utilities.Constants;
import com.HC.utilities.XLUtils;

public class TC_IncidentReportPatientComplaintDetails extends BaseClass {
	@Test
	public void TC_IncidentReportPatientComplaintDetails() throws IOException, InterruptedException{
			
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
		Thread.sleep(1000);
		lp.clickLoginHIS();
		lp.clicksubmit();
		logger.info("Login button pressed");
		Thread.sleep(5000);

		IncidentPO in = new IncidentPO(driver);
		
		//click anonymous details
		in.clickAnonymous();
		logger.info("Anonymous is clicked");
		Thread.sleep(2000);

		//save anonymous confirmation
		in.popClickAnonymous();
		logger.info("popup anonymous is clicked");
		Thread.sleep(2000);
		
		//incident Time
		String timeformat = XLUtils.getCellData(Constants.Path_IncidentData,"TC_InciRepPatientComplaint", 1,0);
		System.out.println("Time format -->" + timeformat);
		lp.intdate(timeformat);
		Thread.sleep(2000);

		//location of incident
		String loc = XLUtils.getCellData(Constants.Path_IncidentData,"TC_InciRepPatientComplaint", 1, 1);
		System.out.println("loc>" + loc);
		lp.clickincidentlocation(loc);
		logger.info("Incident Location entered");
		Thread.sleep(2000);

		//for Location details
		String detail = XLUtils.getCellData(Constants.Path_IncidentData,"TC_InciRepPatientComplaint", 1, 2);
		System.out.println("detail is:"+detail);
		lp.setlocationdetail(detail);
		System.out.println("Location details are set");
		Thread.sleep(2000);

		//selection of patient compliant
		in.patientCompliantYes();
		logger.info("patient compliant yes selected");
		Thread.sleep(2000);

		//selection of patient name
		String patientName = XLUtils.getCellData(Constants.Path_IncidentData,"TC_InciRepPatientComplaint", 1, 3);
		lp.setIncicat(patientName);
		logger.info("patient compliant yes selected");
		Thread.sleep(2000);

		//ComplaintDateTime
		String ComplaintDateTime = XLUtils.getCellData(Constants.Path_IncidentData,"TC_InciRepPatientComplaint", 1, 4);
		in.selectComplaintDateTime(ComplaintDateTime);
		logger.info("Compliant Date&Time entered");
		Thread.sleep(2000);

		//Complaint ID
		String ComplaintID = XLUtils.getCellData(Constants.Path_IncidentData,"TC_InciRepPatientComplaint", 1, 5);
		in.complaintID(ComplaintID);
		logger.info("Compliant ID entered");
		Thread.sleep(2000);
		
		//type of incident
		lp.settypeincident();
		logger.info("Incident type clicked");
		Thread.sleep(2000);
		
		//category
		String cat = XLUtils.getCellData(Constants.Path_IncidentData,"TC_InciRepPatientComplaint", 1, 6);
		System.out.println("cat is: "+cat);
		lp.setincidentsubcat(cat);
		logger.info("Incident Category entered");
		Thread.sleep(2000);
				
		//subcat
		String subcat = XLUtils.getCellData(Constants.Path_IncidentData,"TC_InciRepPatientComplaint", 1, 7);
		System.out.println("subcat is: "+subcat);
		in.selectDeptInvolved(subcat);
		logger.info("Incident sub-category entered");

		//description
		String dec = XLUtils.getCellData(Constants.Path_IncidentData,"TC_InciRepPatientComplaint", 1, 8);
		lp.setincidescrep(dec);
		logger.info("Incident decscription entered");
		Thread.sleep(2000);
		
		//dept involved
		String dept = XLUtils.getCellData(Constants.Path_IncidentData,"TC_InciRepPatientComplaint", 1, 9);
		in.selectImmedActionTakenBy(dept);
		logger.info("dept involved entered");
		Thread.sleep(2000);

		//preventability
		in.selectpreventability();
		logger.info("preventability selected");
		Thread.sleep(2000);

		//ActionTakenText
		String text = XLUtils.getCellData(Constants.Path_IncidentData,"TC_InciRepPatientComplaint", 1, 10);
		in.immedActionTakenText(text);
		logger.info("ActionTaken entered");
		Thread.sleep(2000);

		//action takenBy
		String takenBy = XLUtils.getCellData(Constants.Path_IncidentData,"TC_InciRepPatientComplaint", 1, 11);
		in.selectWitnessedBy(takenBy);
		logger.info("action takenBy selected");
		Thread.sleep(2000);
		
		//action DateTime selection
		String actionDateTime = XLUtils.getCellData(Constants.Path_IncidentData,"TC_InciRepPatientComplaint", 1, 12);
		in.selectActionTakenDateTime(actionDateTime);
		logger.info("action DateTime selected");
		Thread.sleep(2000);

		//witness selected
		String witness = XLUtils.getCellData(Constants.Path_IncidentData,"TC_InciRepPatientComplaint", 1, 13);
		in.selectNotifiedTo(witness);
		logger.info("witness selected");
		Thread.sleep(2000);

		//notifiedTo selection
		String notifiedTo = XLUtils.getCellData(Constants.Path_IncidentData,"TC_InciRepPatientComplaint", 1, 14);
		in.selectHeadofDept(notifiedTo);
		logger.info("notifiedTo selected");
		Thread.sleep(2000);

		//notifiedDateTime selection
		String notifiedDateTime = XLUtils.getCellData(Constants.Path_IncidentData,"TC_InciRepPatientComplaint", 1, 15);
		in.selectNotifiedDateTime(notifiedDateTime);
		logger.info("notified DateTime selected");
		Thread.sleep(2000);

		//submit
		lp.incidentsubmit();
		logger.info("Submit button clicked");
		Thread.sleep(2000);
		lp.popsubmit();
		Thread.sleep(2000);
		String number = LoginPage.getincidentnumber();
		System.out.println("incident number -->" + number);
		capureScreen(driver,"TC_IncidentReportPatientComplaintDetails");
		Thread.sleep(5000);
		lp.popsave();
		Thread.sleep(2500);
		XLUtils.setCellData(Constants.Path_IncidentData,"TC_InciRepPatientComplaint", 1 , 15, number);
		System.out.println(XLUtils.getCellData(Constants.Path_IncidentData,"TC_InciRepPatientComplaint", 1, 16));
				
	}
}
