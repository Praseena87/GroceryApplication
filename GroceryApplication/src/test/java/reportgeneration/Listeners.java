package reportgeneration;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import utilities.ExtentReportUtility;

public class Listeners implements ITestListener {
	
	ExtentTest test; 
 	ExtentReports extent = ExtentReportUtility.createExtentReports(); 
 	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>(); 
  
 	//greenup arrow represents overrides
 	public void onTestStart(ITestResult result) { //first execute method before the test case execution
  
 	ITestListener.super.onTestStart(result); 
 	test = extent.createTest(result.getMethod().getMethodName()); 
 	extentTest.set(test); 
  
 	} 
   
 	public void onTestSuccess(ITestResult result) { //it executes after the test case pass
  
 	ITestListener.super.onTestSuccess(result); 
 	extentTest.get().log(Status.PASS, "Test Passed"); 
  
 	} 
  
 	public void onTestFailure(ITestResult result) { //it executes after the test case failure
  
 	ITestListener.super.onTestFailure(result); 
  
 	extentTest.get().log(Status.FAIL, "Test Failed"); 
 	extentTest.get().fail(result.getThrowable()); 
  
 	WebDriver driver = null; 
  
 	String testMethodName = result.getMethod().getMethodName(); 
  
 	try { 
  
 	driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver") 
 	.get(result.getInstance()); 
 	} catch (IllegalArgumentException e) { 
  
 	e.printStackTrace(); //used to print error  or exception, why the test case failed
 	} catch (IllegalAccessException e) { 
  
 	e.printStackTrace(); 
 	} catch (NoSuchFieldException e) { 
  
 	e.printStackTrace(); 
 	} catch (SecurityException e) { 
  
 	e.printStackTrace(); 
 	} 
  
 	try { 
 	driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver") 
 	.get(result.getInstance()); 
 	} catch (Exception e) { 
 	} 
 	} 
  
 	public void onTestSkipped(ITestResult result) { //when  a test case skipped, automatically invoked method
  
 	ITestListener.super.onTestSkipped(result); 
 	extentTest.get().log(Status.SKIP, "Test Skipped"); 
 	String testMethodName = result.getMethod().getMethodName(); 
  
 	} 
  
 	public void onTestFailedButWithinSuccessPercentage(ITestResult result) { 
  
 	ITestListener.super.onTestFailedButWithinSuccessPercentage(result); //Some test cases failed within the success percentage
 	} 
  
 	public void onTestFailedWithTimeout(ITestResult result) { //some test cases are time out because of Internet or loading issue 
  
 	ITestListener.super.onTestFailedWithTimeout(result); 
 	} 
  
 	public void onStart(ITestContext context) { //first executed method
  
 	ITestListener.super.onStart(context); 
 	} 
  
 	public void onFinish(ITestContext context) { //after all test cases execution, last execute method
  
 	ITestListener.super.onFinish(context); 
 	extent.flush(); //this method is used to log all information getting from the above methods to reports
 	}
 	
}