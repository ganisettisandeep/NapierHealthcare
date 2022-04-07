package com.HC.testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.HC.pageObjects.LoginPage;
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

		//dashboard
		lp.clickincidentdashboard();
		logger.info("dashboard button clicked");
		Thread.sleep(2500);
		
		//quality dashboard
		lp.clickQualityDashboard();
		logger.info("quality dashboard button clicked");
		Thread.sleep(2000);
		
		//IR code
		String IRcode = XLUtils.getCellData(Constants.Path_IncidentData,"TC_QualityDashboardAssign", 1, 0);
		lp.enterIRcodeQD(IRcode);
		logger.info("entered IR code");
		Thread.sleep(2000);
		
		//search button
		lp.searchButtonQD();
		logger.info("search button clicked");
		Thread.sleep(2000);
		
		//actions
		lp.clickAction();
		logger.info("actions clicked");
		Thread.sleep(2000);

		//click assign IR
		lp.clickAssignIR();
		logger.info("assign IR clicked");
		Thread.sleep(2000);

		//select user assign
		//String user = XLUtils.getCellData(Constants.Path_IncidentData,"TC_QualityDashboardAssign", 1, 1);
		lp.selectAssignUser();
		logger.info("selected user to assign");
		Thread.sleep(2000);

		//assign button
		boolean assign = lp.clickAssignButton();
		logger.info("click assign button");
		Thread.sleep(2000);
		Assert.assertTrue(assign);
				
						
	}
}
