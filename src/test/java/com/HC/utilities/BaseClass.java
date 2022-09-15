package com.HC.utilities;

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class BaseClass extends Constants{

	ReadConfig readconfig=new ReadConfig();
	
	public String baseURL=readconfig.getApplicationURL();
	public String username=readconfig.getUsername();
	public String password=readconfig.getPassword();
	public String usernameHIS=readconfig.getUsernameHIS();
	public String passwordHIS=readconfig.getPasswordHIS();
	public static WebDriver driver;
	
	public static Logger logger;

	public ExtentHtmlReporter htmlReporter;
	//public ExtentReports extent;
	//public ExtentTest Elogger;
	//public ITestResult tr;
	public int screens = 1;
	public static String folderName;
	
	@BeforeTest
	public void setUpSuite() {
	     
	        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy HH.mm.ss");  
	        Date date = new Date();  
	        folderName = "TestReport-"+formatter.format(date);
	        System.out.println(folderName);
	        
	        File newDir = new File("./TestReports/"+folderName);
	        if (!newDir.exists()){
	        	newDir.mkdirs();
	        }
	        
			String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());//time stamp
			String repName="Test-Report-"+timeStamp+".html";
			
			htmlReporter=new ExtentHtmlReporter(System.getProperty("user.dir")+"/"+"TestReports"+"/"+folderName+"/"+repName);//specify location of the report
			htmlReporter.loadXMLConfig(System.getProperty("user.dir")+ "/extent-config.xml");
			
			extent = loggersGenerator();
			extent.attachReporter(htmlReporter);
			extent.setSystemInfo("Host name","localhost");
			extent.setSystemInfo("Environemnt","QA");
			extent.setSystemInfo("user","Sandeep");
			
			htmlReporter.config().setDocumentTitle("Napier HealthCare"); // Tile of report
			htmlReporter.config().setReportName("Functional Test Automation Report"); // name of the report
			htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP); //location of the chart
			htmlReporter.config().setTheme(Theme.DARK);
		
	}
	
	@Parameters("browser")
	@BeforeMethod
	public void setup(String br){
		logger=Logger.getLogger("ehealth");
		PropertyConfigurator.configure("Log4j.properties");
	if (br.equals("chrome"))	{
		System.setProperty("webdriver.chrome.driver", readconfig.getChromePath());
		driver= new ChromeDriver();
	    }
	else if (br.equals("firefox")) {
		System.getProperty("webdriver.gecko.driver", readconfig.getFirefoxPath());
		driver= new FirefoxDriver();
		}
	
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseURL);
		System.out.println("inside before method");
	}

	@AfterMethod
	public void tearDownMethod(ITestResult result){
		if(result.getStatus() == ITestResult.SUCCESS) {
			System.out.println("Test case passed" +result.getName());
			Elogger.log(Status.PASS,MarkupHelper.createLabel(result.getName(),ExtentColor.GREEN));
			Elogger.pass("Screenshot is below:");
		}
		else if(result.getStatus() == ITestResult.FAILURE) {
			System.out.println("Test case failed" +result.getName());
			Elogger.log(Status.FAIL,MarkupHelper.createLabel(result.getName(),ExtentColor.RED));
			Elogger.fail("Screenshot is below:");
		}
		else if(result.getStatus() == ITestResult.SKIP) {
			System.out.println("Test case skipped" +result.getName());
			Elogger.log(Status.SKIP,MarkupHelper.createLabel(result.getName(),ExtentColor.ORANGE));
			Elogger.skip("Screenshot is below:");
		}
		attachScreenshot(result, screens);
		driver.quit();
	}
		
	@AfterTest
	public void tearDownTest(){

		extent.flush();
	}

	public void attachScreenshot(ITestResult tr, int screens1) {
		
		for(int i=1; i<=screens1; i++) {
			
		String screenshotPath=System.getProperty("user.dir")+"\\"+"TestReports"+"\\"+folderName+"\\"+tr.getName()+i+".png";
		System.out.println("screenshotPath: "+screenshotPath);
		File f = new File(screenshotPath); 
		
		if(f.exists()){
		try {
			Elogger.addScreenCaptureFromPath(screenshotPath);
			} 
		catch (IOException e){
			e.printStackTrace();
			}
		}
	}
	}

	
	public void capureScreen(WebDriver driver, String tname) throws IOException {
	TakesScreenshot ts = (TakesScreenshot) driver;
	File scrFile = ts.getScreenshotAs(OutputType.FILE);
	File target = new File(System.getProperty("user.dir") + "/"+"TestReports"+"/"+ folderName+ "/" + tname + ".png");
	System.out.println("target"+target);
	FileUtils.copyFile(scrFile, target);
	System.out.println("ScreenShot Taken");
	
	}
	
	public String randomestring(){
		String generatedstring=RandomStringUtils.randomAlphabetic(8);
		return(generatedstring);
	}
	
	public static String randomeNum(){
		String generatedString2 = RandomStringUtils.randomNumeric(4);
		return (generatedString2);
	}

	public static ExtentReports loggersGenerator() {
		ExtentReports ExtentReport;
		ExtentReport = new ExtentReports();
		return ExtentReport;
		
	}
	
}
