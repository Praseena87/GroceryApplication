package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageAccountPage {

	public WebDriver driver;

	public ManageAccountPage(WebDriver driver) {
		this.driver = driver;

		PageFactory.initElements(driver, this);

	}
	// Manage Account page Action item locator //table[@class='table table-bordered
	// table-hover table-sm']//a[@class='btn btn-sm btn btn-primary btncss']
	// table[@class='table table-bordered table-hover
	// table-sm']//a[@href='https://groceryapp.uniqassosiates.com/admin/contact/edit_contact?edit=1']

	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//a[@class='btn btn-sm btn btn-primary btncss']")
	WebElement action;
	// Contact us phone field locator
	@FindBy(xpath = "//input[@id='phone']")
	WebElement phonefield;
	// Contact us email field locator
	@FindBy(xpath = "//input[@id='email']")
	WebElement emailfield;
	// Contact us address field locator //textarea[@name='address']
	@FindBy(xpath = "//textarea[@name='address']")
	WebElement addressfield;
	// Contact us delivery time field locator
	@FindBy(xpath = "//textarea[@name='del_time']")
	WebElement deliveryTimeField;
	// Contact us delivery charge field locator
	@FindBy(xpath = "//input[@name='del_limit']")
	WebElement deliveryChargeLimitField;
	// Contact us, update button locator
	@FindBy(xpath = "//button[@class='btn btn-block-sm btn-info']")
	WebElement updateButton;
	
	//Assertion, update information success message locator  
	 @FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")WebElement updateInfoMessage;
	

	public void actionArrowClick() {

		action.click();

	}

	public void enterPhoneNumber(String phonenumber) { // Variable to store the username read from excel
		
		phonefield.clear();
		phonefield.sendKeys(phonenumber);

	}

	public void enterEmail(String email) {
		
		emailfield.clear();
		emailfield.sendKeys(email);

	}

	public void enterAddress(String address) {

		addressfield.clear();
		addressfield.sendKeys(address);

	}

	public void enterDeliveryTime(int deliveryTime) {

		deliveryTimeField.clear();
		deliveryTimeField.sendKeys(Integer.toString(deliveryTime));

	}

	public void enterDeliveryChargeLimit(int deliveryChargeLimit) {

		deliveryChargeLimitField.clear();
		deliveryChargeLimitField.sendKeys(Integer.toString(deliveryChargeLimit));

	}
	
	public void updateButtonClick() {

		//updateButton.click();
		JavascriptExecutor js = (JavascriptExecutor)driver; //casting as we can not create an object for Interface.JavaScriptExecutor is a predefined class
		js.executeScript("arguments[0].click();", updateButton); //to click and element we use executeScript inside JavascriptExecutor
		
		js.executeScript("window.scrollBy(0,350)", ""); //to scroll also we use executeScript() o and 350 are x and y axis to scroll down give 
		//350 is in pixel

	}
	
	 public boolean updateInformationMessageDisplayed() {
			
			return updateInfoMessage.isDisplayed();
	 }
	 
	
}
