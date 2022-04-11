package com.HC.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.HC.pageObjects.LoginPage;
import com.HC.utilities.BaseClass;
import com.HC.utilities.XLUtils;

public class TC_IncidentDashboard extends BaseClass {

	@Test
	public void TC_Incident_Dashboard_test()  throws IOException, InterruptedException
	{
		
		
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
		
		//click dashboard
		lp.clickincidentdashboard();
		Thread.sleep(2500);
		
		//enter IRcode
		logger.info("Entering IR code");
		//Xls_Reader d = new Xls_Reader("C:\\selenium\\testing\\LoginData.xlsx");
		String path="C:\\Users\\venkata\\Downloads\\LoginData.xlsx";
		String IRcode = XLUtils.getCellData(path,"Sheet3", 1, 0);
	//	String IRcode2 = d.getCellData("Sheet3", 0, 2);
	
		System.out.println("IRcode is: "+IRcode);
		Thread.sleep(2000);
		
		lp.clickcode();
		Thread.sleep(2000);
		logger.info("IR code click");
		lp.enterIRcode(IRcode);	
		logger.info("IR code entered");
		Thread.sleep(2000);
		
		//Click search
		
		lp.dashboardsearch();
		Thread.sleep(2000);
		String Actualcode = lp.verifyCode();
		System.out.println(Actualcode);
		
		if(Actualcode.equals(IRcode))
		{
			capureScreen(driver,"IRcode verfied");
			Assert.assertTrue(true);
			logger.info("IRcode Verified");
		}
		else
		{
			capureScreen(driver,"IRcode not verfied");
			Assert.assertTrue(false);
			logger.info("IRcode not verfied");
		}
		
		
	
}
	
	
	
	
}

	

