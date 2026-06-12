package testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;
import pages.AdminUserPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageAccountPage;
import project.BaseClass;
import utilities.ExcelUtility;
import utilities.RandomDataUtility;

public class ManageAccountTest extends BaseClass {

	@Test(description = "User is trying to update contact information")
	public void verifyUserCanManageAccounts() throws IOException {

		String usernamevalue = ExcelUtility.GetStringData(0, 0, "LoginPage");
		String passwordvalue = ExcelUtility.GetStringData(0, 1, "LoginPage");

		LoginPage lp = new LoginPage(driver);
		lp.enterNameOnUserNameField(usernamevalue);
		lp.enterPasswordOnPasswordField(passwordvalue);
		lp.loginButtonClick();

		// Home page More info
		HomePage hp = new HomePage(driver);
		hp.manageAccountMoreInfoClick();

		// Manage Account Page
		ManageAccountPage mnp = new ManageAccountPage(driver);
		mnp.actionArrowClick();

		// Data read from faker class
		RandomDataUtility rd = new RandomDataUtility();

		String phonenumber = rd.generateRandomPhoneNo();
		String email = rd.generateRandomEmailID();
		// Contact information from excel sheet
		String address = ExcelUtility.GetStringData(1, 0, "ManageContact");
		int deliverytime = ExcelUtility.GetIntegerData(1, 1, "ManageContact");
		int deliverycharge = ExcelUtility.GetIntegerData(1, 2, "ManageContact");

		mnp.enterPhoneNumber(phonenumber); // Enter user phone number
		mnp.enterEmail(email);
		// Enter email
		mnp.enterAddress(address); // Enter address
		mnp.enterDeliveryTime(deliverytime);
		mnp.enterDeliveryChargeLimit(deliverycharge);
		mnp.updateButtonClick();
	

		// Assertion
		boolean updateContactInfoMessage = mnp.updateInformationMessageDisplayed();
		Assert.assertTrue(updateContactInfoMessage, "User information was not updated successfully");

	}

}
