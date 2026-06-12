package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.PageUtility;

public class AdminUserPage {
	
	PageUtility pu=new PageUtility();
	public WebDriver driver;
	
	 public AdminUserPage (WebDriver driver) {
     this.driver = driver;

		PageFactory.initElements(driver, this);
		
	}
	 
	//New (Add admin user)Button locator
	 @FindBy(xpath="//a[@class='btn btn-rounded btn-danger']") WebElement newbutton;
	 
	 //Username locator
	 @FindBy(xpath="//input[@id='username']") WebElement username;
	 
	 //Password locator
	 @FindBy(xpath="//input[@id='password']") WebElement password;
	 
	//Usertype locator
	 @FindBy(xpath="//select[@id='user_type']") WebElement usertypedropdown;
	 
	 //Save locator
	 @FindBy(xpath="//div[@class='card-footer center']//button[@class='btn btn-block-sm btn-danger']") WebElement savebutton;
	 
	 //Alert message locator   //h5[text()=' Alert!']   //div[@class='alert alert-success alert-dismissible' and contains(.,'User Created Successfully')]
	 //@FindBy(xpath="//h5[text()=' Alert!']")WebElement alertmessage;
	 
	 @FindBy(xpath="//div[@class='alert alert-success alert-dismissible' and contains(.,'User Created Successfully')]")WebElement alertmessage;
	 
	 //Search button locator //a[text()=' Search']
	 @FindBy(xpath="//a[text()=' Search']") WebElement searchbutton;
	 
	 //Search username locator //input[@id='un']
	 @FindBy(xpath="//input[@id='un']")WebElement searchusername;
	 
	//Search Usertype locator //select[@id='ut']
	 @FindBy(xpath="//select[@id='ut']") WebElement searchusertype;
	 
	 //Search button after entering Username and usertype  //button[@value='sr']
	 @FindBy(xpath="//button[@value='sr']") WebElement searchmembers;
	 
	 //Username searc table locator //table[@class='table table-bordered table-hover table-sm']
	 @FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']/tbody/tr[1]/td[1]") WebElement searchedusername;
	
	 
	 
	 public void newButtonClick() {
			
			newbutton.click();
		}
	 
	 
	 public void enterAdminUserName(String usernamevalue) { //Variable to store the username read from excel
			
		 username.sendKeys(usernamevalue);
		 
		}
		
		public void enterAdminPassword(String passwordvalue) {
			
			 password.sendKeys(passwordvalue);
			 
			}
	 
	 public void userTypeDropdown() {
			
		 	pu.selectDragDropWithValue(usertypedropdown,"admin");
			//Select ut=new Select(usertypedropdown);
			//ut.selectByValue("admin");
			//ob.selectByIndex(1);
			//ob2.selectByValue("c#");
			//ob2.selectByVisibleText("Python");
		}
	 
	 public void saveButtonClick() {
		 savebutton.click();
		 
	 }
	 
	 public boolean alertmessageDisplayed() {
			
			return alertmessage.isDisplayed();
	 }
	 
	 public void searchButtonClick() {
		 searchbutton.click();
		 
	 }
	 	 
	 
	 public void enterUserName(String usernameforsearch) {
			
		 searchusername.sendKeys(usernameforsearch);
		 
		}
	 
	 public void searchUserTypeDropdown() {
			pu.selectDragDropWithValue(searchusertype,"admin");
			//Select sut=new Select(searchusertype);
			//sut.selectByValue("admin");
			//ob.selectByIndex(1);
			//ob2.selectByValue("c#");
			//ob2.selectByVisibleText("Python");
		}
	 
	 public void searchMembersButtonClick() {
		 searchmembers.click();
		 
	 }
	 
	 public String verifySearchedUserNameIsDisplayed() {
		 
		 
			return searchedusername.getText();
			
		}
}
	
	
