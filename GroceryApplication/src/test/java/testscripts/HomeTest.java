package testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import pages.HomePage;
import pages.LoginPage;
import project.BaseClass;
import utilities.ExcelUtility;

public class HomeTest extends BaseClass {

	@Test(description = "User is trying to login using valid credentials")
	public void verifyUserLoginUsingValidCredentials() throws IOException {

		String usernamevalue = ExcelUtility.GetStringData(0, 0, "LoginPage");
		String passwordvalue = ExcelUtility.GetStringData(0, 1, "LoginPage");

		LoginPage lp = new LoginPage(driver);
		lp.enterNameOnUserNameField(usernamevalue);
		lp.enterPasswordOnPasswordField(passwordvalue);
		lp.loginButtonClick();

		// Always give assertion at the end of test case

		boolean dashboardValue = lp.dashboardDisplayed();
		Assert.assertTrue(dashboardValue, Constant.INVALIDCREDENTIALERROR);
	}

	@Test(description = "User is trying to logout")
	public void verifyUserCanLogOutSuccessfully() throws IOException {

		String usernamevalue = ExcelUtility.GetStringData(0, 0, "LoginPage");
		String passwordvalue = ExcelUtility.GetStringData(0, 1, "LoginPage");

		LoginPage lp = new LoginPage(driver);
		lp.enterNameOnUserNameField(usernamevalue);
		lp.enterPasswordOnPasswordField(passwordvalue);
		lp.loginButtonClick();

		// Assertion
		// String actual = lp.verifyLoginTextIsDisplayed();
		// String expected="7rmart supermarket";
		// Assert.assertEquals(actual, expected, "User is able to login with invalid
		// credentials");

		HomePage hp = new HomePage(driver);
		hp.adminImageClick();
		hp.logoutClick();

		String actual = lp.verifyLoginTextIsDisplayed();
		String expected = "7rmart supermarket";
		Assert.assertEquals(actual, expected, Constant.USERLOGOUTERROR);

	}

	@Test(description = "User is trying to add a new admin user")
	public void verifyUserCanAddNewAdminUser() throws IOException {

		String usernamevalue = ExcelUtility.GetStringData(0, 0, "LoginPage");
		String passwordvalue = ExcelUtility.GetStringData(0, 1, "LoginPage");

		LoginPage lp = new LoginPage(driver);
		lp.enterNameOnUserNameField(usernamevalue);
		lp.enterPasswordOnPasswordField(passwordvalue);
		lp.loginButtonClick();

		HomePage hp = new HomePage(driver);
		hp.adminUsersMoreInfoClick();

	}

}
