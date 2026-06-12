package testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import pages.AdminUserPage;
import pages.HomePage;
import pages.LoginPage;
import project.BaseClass;
import utilities.ExcelUtility;
import utilities.RandomDataUtility;

public class AdminUserTest extends BaseClass {
	
	
@Test (description="User is trying to add a new admin user")	

public void verifyUserCanAddNewAdminUser() throws IOException {
		
		String usernamevalue= ExcelUtility.GetStringData(0, 0, "LoginPage");
		String passwordvalue=ExcelUtility.GetStringData(0, 1, "LoginPage");
		
		LoginPage lp= new LoginPage(driver);
		lp.enterNameOnUserNameField(usernamevalue);
		lp.enterPasswordOnPasswordField(passwordvalue);
		lp.loginButtonClick();
		
		//Home page More info 
		HomePage hp=new HomePage(driver);
		hp.adminUsersMoreInfoClick();
		
		AdminUserPage ap=new AdminUserPage(driver);
		ap.newButtonClick();
		
		//Data read from faker class
		RandomDataUtility rd=new RandomDataUtility();
		
		String adminusername= rd.generateRandomUserName();
		String adminpassword=rd.generateRandomPassword();
		//New admin user information from excel sheet
		//String adminusername= ExcelUtility.GetStringData(0, 0, "AdminUserPage");
		//String adminpassword=ExcelUtility.GetStringData(0, 1, "AdminUserPage");
		
		ap.enterAdminUserName(adminusername);   //Enter user name info
		ap.enterAdminPassword(adminpassword);  //Enter password
		ap.userTypeDropdown();    //Enter user type
		ap.saveButtonClick();
		
		//Assertion
		boolean alertmessageValue=ap.alertmessageDisplayed();
		Assert.assertTrue(alertmessageValue, Constant.USERACCOUNTCREATEERROR);
	
		
	}

@Test(description="User is trying to search newly added members")	
public void verifyUserCanSearchMembers() throws IOException {
	
	String usernamevalue= ExcelUtility.GetStringData(0, 0, "LoginPage");
	String passwordvalue=ExcelUtility.GetStringData(0, 1, "LoginPage");
	
	LoginPage lp= new LoginPage(driver);
	lp.enterNameOnUserNameField(usernamevalue);
	lp.enterPasswordOnPasswordField(passwordvalue);
	lp.loginButtonClick();
	
	//Home page More info 
	HomePage hp=new HomePage(driver);
	hp.adminUsersMoreInfoClick();
	
	//Admin User Page Search members
	AdminUserPage ap=new AdminUserPage(driver);
	ap.searchButtonClick();
	
	//Search members
	//Member name from excel sheet
	String searchusername= ExcelUtility.GetStringData(0, 0, "SearchNames");
			
	ap.enterUserName(searchusername);   //Enter user name info
	ap.searchUserTypeDropdown();
	ap.searchMembersButtonClick();
	
	//Assertion to check whether the searched name and the returned name in the table is correct
	
	String actualname =ap.verifySearchedUserNameIsDisplayed();
	String expectedname= searchusername;
	Assert.assertEquals(actualname, expectedname, Constant.SEARCHUSERNAMEERROR);
}


	

}
