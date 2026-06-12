package project;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import constant.Constant;
import utilities.ScreenshotUtility;

public class BaseClass {
	
		
	public WebDriver driver;
		
		Properties prop;
		FileInputStream fio;
		
		@BeforeMethod(alwaysRun=true)
		@Parameters("browsers")
		
		//@BeforeMethod
		
		public void initializeBrowser(String browsers) throws IOException {	
			
			prop=new Properties();
			fio=new FileInputStream(Constant.CONFIGFILE);
			prop.load(fio);
			
			if(browsers.equalsIgnoreCase("chrome")) {
				driver= new ChromeDriver();
			}
			
			else if(browsers.equalsIgnoreCase("firefox")){
				driver= new FirefoxDriver();
			}
			else if(browsers.equalsIgnoreCase("edge")){
				driver= new EdgeDriver();
			}
		    //public void initializeBrowser() {
		    //driver= new ChromeDriver();
			//driver= new EdgeDriver();
			driver.get(prop.getProperty("URL"));// to launch url
			driver.manage().window().maximize();//to maxmize page 
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); //implicitly wait method is used to apply implicit wait from the predefined class Duration 5 seconds
			
		}
		
		@AfterMethod (alwaysRun=true)
		//@AfterMethod 
		//public void closeBrowser() {
			//driver.close();// close method only closes current tab
			//driver.quit();  //quit method closes all opened tabs
		//}
		
		public void closeBrowser(ITestResult itestresult) throws IOException{     //ITTesResult is a predefined interface, it maintains life cycle of a test case
			
			//ITestResult interface gives the test cycle passed or failed 
			
			if(itestresult.getStatus()==ITestResult.FAILURE) {      //if the test case status is failure, if loops get executed
				ScreenshotUtility screenshotutility=new ScreenshotUtility();  //creating object for ScreenUtility class
				screenshotutility.getScreenshot(driver, itestresult.getName()); //getname()is used to fetch the method name of failed test case
			}
			 // driver.close();
			//driver.quit();
		}
		
		


}
