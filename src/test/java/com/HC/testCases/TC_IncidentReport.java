package com.HC.testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.Assert;

import com.HC.pageObjects.DashboardPO;
import com.HC.pageObjects.LoginPage;
import com.HC.utilities.BaseClass;
import com.HC.utilities.Constants;
import com.HC.utilities.XLUtils;

public class TC_IncidentReport extends BaseClass {
	@Test
	public void TC_IncidentReport() throws IOException, InterruptedException{
			
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
		

		DashboardPO db = new DashboardPO(driver);
		
		//incident Time
		String timeformat = XLUtils.getCellData(Constants.Path_IncidentData,"TC_IncidentReport", 1,0);
		System.out.println("Time format -->" + timeformat);
		lp.intdate(timeformat);
		Thread.sleep(2000);
		
		//location of incident
		String loc = XLUtils.getCellData(Constants.Path_IncidentData,"TC_IncidentReport", 1, 1);
		System.out.println("loc>" + loc);
		lp.clickincidentlocation(loc);
		logger.info("Incident Location entered");
		Thread.sleep(2000);

		
		//for Location details
		String detail = XLUtils.getCellData(Constants.Path_IncidentData,"TC_IncidentReport", 1, 2);
		System.out.println("detail is:"+detail);
		lp.setlocationdetail(detail);
		System.out.println("Location details are set");
		Thread.sleep(2000);
		
		//type of incident
		lp.settypeincident();
		logger.info("Incident type clicked");
		Thread.sleep(2000);
		
		//category
		String cat = XLUtils.getCellData(Constants.Path_IncidentData,"TC_IncidentReport", 1, 3);
		System.out.println("cat is: "+cat);
		lp.setIncicat(cat);
		logger.info("Incident Category entered");
		Thread.sleep(2000);
				
		//subcat
		String subcat = XLUtils.getCellData(Constants.Path_IncidentData,"TC_IncidentReport", 1, 4);
		System.out.println("subcat is: "+subcat);
		lp.setincidentsubcat(subcat);
		logger.info("Incident sub-category entered");
		
		//description
		String dec = XLUtils.getCellData(Constants.Path_IncidentData,"TC_IncidentReport", 1, 5);
		lp.setincidescrep(dec);
		logger.info("Incident decscription entered");
		Thread.sleep(2000);
		
		//submit
		lp.incidentsubmit();
		logger.info("Submit button clicked");
		Thread.sleep(2000);
		lp.popsubmit();
		Thread.sleep(2000);
		String number = LoginPage.getincidentnumber();
		System.out.println("incident number -->" + number);
		capureScreen(driver,"TC_IncidentReport");
		Thread.sleep(5000);
		boolean save = lp.popsave();
		Thread.sleep(2500);
		Assert.assertTrue(save);
		XLUtils.setCellData(Constants.Path_IncidentData,"TC_IncidentReport", 1 , 6, number);
		System.out.println(XLUtils.getCellData(Constants.Path_IncidentData,"TC_IncidentReport", 1, 6));
		
		//dashboard
		db.clickincidentdashboard();
		logger.info("dashboard button clicked");
		Thread.sleep(2500);

		//enter IR code
		db.enterIRCode1(number);
		logger.info("incident number entered:"+ number);
		Thread.sleep(2500);

		//search button
		db.searchButton();
		logger.info("search button is clicked");
		Thread.sleep(2500);

		//validation
		String text = db.getIRcode();
		Assert.assertEquals(number, text);
		logger.info("validation passed");
		Thread.sleep(2500);
		
		capureScreen(driver,"TC_IncidentReport");

	}
}
