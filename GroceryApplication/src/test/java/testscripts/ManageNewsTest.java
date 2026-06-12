package testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.ManageNewsPage;
import project.BaseClass;
import utilities.ExcelUtility;

public class ManageNewsTest extends BaseClass{

	@Test (description="User is trying to add a news")	

	public void verifyUserCanAddNews() throws IOException {
		
		String usernamevalue = ExcelUtility.GetStringData(0, 0, "LoginPage");
		String passwordvalue = ExcelUtility.GetStringData(0, 1, "LoginPage");

		LoginPage lp = new LoginPage(driver);
		lp.enterNameOnUserNameField(usernamevalue);
		lp.enterPasswordOnPasswordField(passwordvalue);
		lp.loginButtonClick();

		// Home page News More info click
		HomePage hp = new HomePage(driver);
		hp.manageNewsMoreInfoClick();
		
		// News Page class 
		ManageNewsPage mnp= new ManageNewsPage(driver);
		mnp.newButtonClick();
		// News from excel sheet
		String news = ExcelUtility.GetStringData(0, 0, "News");
		mnp.enterTheNews(news);
		mnp.saveButtonClick();
		
		// Assertion
		boolean addNewsMessage = mnp.addNewsAlertDispalyed();;
		Assert.assertTrue(addNewsMessage, "News was not updated successfully");
	
	}
	
	@Test (description="User is trying to search news")	

	public void verifyUserCanSearchNews() throws IOException {
		
		String usernamevalue = ExcelUtility.GetStringData(0, 0, "LoginPage");
		String passwordvalue = ExcelUtility.GetStringData(0, 1, "LoginPage");

		LoginPage lp = new LoginPage(driver);
		lp.enterNameOnUserNameField(usernamevalue);
		lp.enterPasswordOnPasswordField(passwordvalue);
		lp.loginButtonClick();

		// Home page News More info click
		HomePage hp = new HomePage(driver);
		hp.manageNewsMoreInfoClick();
		
		//News Page search click
		ManageNewsPage mnp= new ManageNewsPage(driver);
		mnp.searchNewsClick();
		
		//Manage News, search
		String news = ExcelUtility.GetStringData(0, 0, "News");
		mnp.enterNewsForSearch(news);
		mnp.searchButtonClick();
			
		//Assertion to check whether the searched news and the returned news in the table is correct
		
		String actualnews =mnp.verifySearchedNewsIsDisplayed();
		String expectednews= news;
		Assert.assertEquals(actualnews, expectednews, "Searched news does not match the returned news");
	}
}
