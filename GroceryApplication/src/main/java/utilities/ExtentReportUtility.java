package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportUtility {
	public static final ExtentReports extentReports= new ExtentReports();  //static instance of extentreports
	//be shared across the application
	
	public synchronized static ExtentReports createExtentReports() {  //return type ExtentReports class
		ExtentSparkReporter reporter=new ExtentSparkReporter("./extent-reports/extent-report.html");  //.represents local path of project
		reporter.config().setReportName("7RMartSupermarketProject");
		extentReports.attachReporter(reporter);
		
		extentReports.setSystemInfo("Organization","obsqura");
		extentReports.setSystemInfo("Name", "Maya"); //provided context of the report
		return extentReports;
		
	}
	
	

}
