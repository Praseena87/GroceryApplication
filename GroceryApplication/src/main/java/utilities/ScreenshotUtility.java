package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenshotUtility {
	
	//Getscreenshot parameterized method, passing driver and failed test case
	
	public void getScreenshot(WebDriver driver, String failedTestCase) throws IOException {

		
		TakesScreenshot scrShot = (TakesScreenshot) driver;  //predefined interface for taking screenshots
		File screenShot = scrShot.getScreenshotAs(OutputType.FILE);  // captured screenshots is temporary stored in a file screenshot

		String timeStamp = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss").format(new Date()); //Screnshot timestamp stored in a variable

		File f1 = new File(System.getProperty("user.dir") + "//OutputScreenShot");// create file in directory , system.getproperty - for fetching the local path , create a folder name output screenshots
		if (!f1.exists()) {

		f1.mkdirs();  //check folder created or not, in case folder is not created it gets redirected and folder will be created
		}
		String destination = System.getProperty("user.dir") + "//outputScreenShot//" + failedTestCase + timeStamp
		+ ".png";   //file name contains method name of failed test case, current date and time with seconds and saved in png format
		
		File finalDestination = new File(destination);  //a new file finalDestination is created
		FileHandler.copy(screenShot, finalDestination); //screenshot temperorly stored in file screenshot is saved to final destination
		}
	

}
