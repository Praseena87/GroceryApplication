package testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import constant.Constant;
import pages.LoginPage;
import project.BaseClass;
import utilities.ExcelUtility;

public class LoginTest extends BaseClass {

	@Test(priority = 1, description = "User is trying to login using valid credentials", groups = { "smoke" }) // priority
																												// is
																												// used
																												// to
																												// give
																												// priority
																												// orders
																												// for
																												// test
																												// cases
	public void verifyUserLoginUsingValidCredentials() throws IOException {

		String usernamevalue = ExcelUtility.GetStringData(0, 0, "LoginPage");
		String passwordvalue = ExcelUtility.GetStringData(0, 1, "LoginPage");

		LoginPage lp = new LoginPage(driver);
		lp.enterNameOnUserNameField(usernamevalue);
		lp.enterPasswordOnPasswordField(passwordvalue);
		lp.loginButtonClick();

		// Always give assertion at the end of test case

		boolean dashboardValue = lp.dashboardDisplayed();
		Assert.assertTrue(dashboardValue, Constant.VALIDCREDENTIALERROR);
	}

	@Test(priority = 2, description = "User is trying to login using invalid credentials", retryAnalyzer = retry.Retry.class)
	public void verifyUserLoginUsingInvalidCredentials() throws IOException {

		String usernamevalue = ExcelUtility.GetStringData(1, 0, "LoginPage");
		String passwordvalue = ExcelUtility.GetStringData(1, 1, "LoginPage");

		LoginPage lp = new LoginPage(driver);
		lp.enterNameOnUserNameField(usernamevalue);
		lp.enterPasswordOnPasswordField(passwordvalue);
		lp.loginButtonClick();

		String actual = lp.verifyLoginTextIsDisplayed();
		String expected = "7rmart supermarket";
		Assert.assertEquals(actual, expected, Constant.INVALIDCREDENTIALERROR);

	}

	@Test(priority = 3, description = "User is trying to login using invalid password credentials", groups = {
			"smoke"} , dataProvider="loginData")
	public void verifyUserLoginUsingInvalidPasswordCredentials(String usernamevalue, String passwordvalue) throws IOException {

		//String usernamevalue = ExcelUtility.GetStringData(2, 0, "LoginPage");
		//String passwordvalue = ExcelUtility.GetStringData(2, 1, "LoginPage");

		LoginPage lp = new LoginPage(driver);
		lp.enterNameOnUserNameField(usernamevalue);
		lp.enterPasswordOnPasswordField(passwordvalue);
		lp.loginButtonClick();

		String actual = lp.verifyLoginTextIsDisplayed();
		String expected = "7rmart supermarket";
		Assert.assertEquals(actual, expected, Constant.INVALIDPASSWORDERROR);

	}

	@Test(priority = 4, description = "User is trying to login using invalid username credentials")
	public void verifyUserLoginUsingInvalidUserNameCredentials() throws IOException {

		String usernamevalue = ExcelUtility.GetStringData(3, 0, "LoginPage");
		String passwordvalue = ExcelUtility.GetStringData(3, 1, "LoginPage");

		LoginPage lp = new LoginPage(driver);
		lp.enterNameOnUserNameField(usernamevalue);
		lp.enterPasswordOnPasswordField(passwordvalue);
		lp.loginButtonClick();

		String actual = lp.verifyLoginTextIsDisplayed();
		String expected = "7rmart supermarket";
		Assert.assertEquals(actual, expected, Constant.INVALIDUSERNAMEERROR);

	}

	@DataProvider(name = "loginData")
	public Object[][] getDataFromDataProvider() {

		return new Object[][] { new Object[] { "admin", "admin22" }, new Object[] { "admin123", "123" },

		};

	}
}
