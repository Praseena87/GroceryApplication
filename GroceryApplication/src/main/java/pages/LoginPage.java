package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Waitutility;

public class LoginPage {
	Waitutility wu=new Waitutility();
	
	public WebDriver driver;
	
	 public LoginPage(WebDriver driver) {
       this.driver = driver;

		PageFactory.initElements(driver, this);
		
	}

	@FindBy(name="username") WebElement username; // annotation to find elements provided by Page Factory class
	@FindBy(name="password") WebElement password;
	@FindBy(xpath="//button[@type='submit']") WebElement signinbtn;
	
	@FindBy(xpath="//p[text()='Dashboard']") WebElement dashboard;
	
	@FindBy(xpath="//b[text()='7rmart supermarket']") WebElement loginpagetext;

	public void enterNameOnUserNameField(String usernamevalue) { //Variable to store the username read from excel
		
	 username.sendKeys(usernamevalue);
	 
	}
	
	public void enterPasswordOnPasswordField(String passwordvalue) {
		
		 password.sendKeys(passwordvalue);
		 
		}
	
	
	public void loginButtonClick() {
		wu.waitUntilElementToBeClickable(driver, signinbtn);
		signinbtn.click();
		}
	
	public boolean dashboardDisplayed() {
		
		return dashboard.isDisplayed();
	}
	 
	
	public String verifyLoginTextIsDisplayed() {
		
		return loginpagetext.getText();
	}



}
