package com.HC.testCases;

import java.io.IOException;

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

public class TC_QualityDashboardAssign extends BaseClass {
	@Test
	public void TC_QualityDashboardAssign() throws IOException, InterruptedException{
			
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
		
		//dashboard
		db.clickincidentdashboard();
		logger.info("dashboard button clicked");
		Thread.sleep(2500);
		
		//quality dashboard
		db.clickQualityDashboard();
		logger.info("quality dashboard button clicked");
		Thread.sleep(2000);
		
		//IR code
		String IRcode = XLUtils.getCellData(Constants.Path_IncidentData,"TC_QualityDashboardAssign", 1, 0);
		db.enterIRcodeQD(IRcode);
		logger.info("entered IR code");
		Thread.sleep(2000);
		
		//search button
		db.searchButtonQD();
		logger.info("search button clicked");
		Thread.sleep(2000);
		
		//actions
		db.clickAction();
		logger.info("actions clicked");
		Thread.sleep(2000);

		//click assign IR
		db.clickAssignIR();
		logger.info("assign IR clicked");
		Thread.sleep(2000);

		//select user assign
		//String user = XLUtils.getCellData(Constants.Path_IncidentData,"TC_QualityDashboardAssign", 1, 1);
		db.selectAssignUser();
		logger.info("selected user to assign");
		Thread.sleep(2000);

		//assign button
		boolean assign = db.clickAssignButton();
		logger.info("click assign button");

		capureScreen(driver,"TC_QualityDashboardAssign");
		
		Thread.sleep(2000);
		Assert.assertTrue(assign);
	}
}
