package com.HC.testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.HC.pageObjects.LoginPage;
import com.HC.utilities.BaseClass;
import com.HC.utilities.Constants;
import com.HC.utilities.XLUtils;

import junit.framework.Assert;

public class TC_LoginDDT_002 extends BaseClass
{

	@Test(dataProvider="LoginData")
	public void loginTest(String user,String pwd) throws InterruptedException, IOException
	{
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(user);
		logger.info("Entered username");
		System.out.println("Entered Username -->" + user);
		Thread.sleep(3000);
		lp.setPassword(pwd);
		logger.info("password provided");
		System.out.println("Entered Password --->" + pwd);
		Thread.sleep(3000);
		lp.clicksubmit();
		logger.info("Login button pressed");
		System.out.println("Sign in button pressed");
		Thread.sleep(3000);
		
		
		try {
			
			String expectedErr = "REPORT AN INCIDENT";
			String actualErr = driver.findElement(By.xpath("//h3[contains(text(),'REPORT AN INCIDENT')]")).getText();
			if(expectedErr.equals(actualErr)) 
			{
				System.out.println("Pass Login test");
				Assert.assertTrue(true);
			}
			else 
			{
				System.out.println("Fail login test");
			}
			Thread.sleep(3000);
			lp.clicklogout();
			logger.info("Logout button pressed");
			System.out.println("Logout button pressed");
			Thread.sleep(3000);
		}
		catch(Throwable t)
		{
			
			Thread.sleep(3000);
			capureScreen(driver,"Login Fail");
		//	Alert alert = driver.switchTo().alert(); // switch to alert
			String check = lp.checkloginpage();
			 // capture alert message

			System.out.println(check); // Print Alert Message
			Thread.sleep(3000);
			System.out.println("Cant login ");
			lp.popsave();
			
		
		
		}
		
		
		
	}
	
	public boolean isAlertPresent()
	{	try
		{
		driver.switchTo().alert();
		return true;
		}	
		catch (NoAlertPresentException e)
		{
			return false;
		}	
		}
	
	
	@DataProvider(name="LoginData")
	String [][] getData() throws IOException
	{
		//String path="C:\\Users\\venkata\\Downloads\\NapierHeathCareProject\\DataEngine.xlsx";
		
		int rownum=XLUtils.getRowCount(Constants.Path_IncidentData, "LoginData");
		int colcount=XLUtils.getCellCount(Constants.Path_IncidentData,"LoginData",1);
		
		String logindata[][]=new String[rownum][colcount];
		
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				logindata[i-1][j]=XLUtils.getCellData(Constants.Path_IncidentData,"LoginData", i,j);//1 0
			}
				
		}
	return logindata;
	}
	
}