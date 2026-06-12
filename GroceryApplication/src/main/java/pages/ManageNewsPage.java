package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageNewsPage {

	public WebDriver driver;

	public ManageNewsPage(WebDriver driver) {
		this.driver = driver;

		PageFactory.initElements(driver, this);

	}
	
	//Manage News page "New" button locator
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']") WebElement newButton;
	//Manage News news field locator
	@FindBy(xpath="//textarea[@id='news']") WebElement newsField;
	//Manage News save button locator
	@FindBy(xpath="//button[@class='btn btn-danger']") WebElement saveButton;
	
	//Assertion locator //div[@class='alert alert-success alert-dismissible']
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']") WebElement addNewsAlert;
	
	//Search button locator //i[@class=' fa fa-search']
	@FindBy(xpath="//i[@class=' fa fa-search']")WebElement searchNews;
	
	//News search text locator //input[@class='form-control']
	@FindBy(xpath="//input[@class='form-control']") WebElement searchNewsTextArea;
	
	//News search button text locator //button[@class='btn btn-danger btn-fix']
	@FindBy(xpath="//button[@class='btn btn-danger btn-fix']") WebElement searchButton;
	
	 //News searc table locator //table[@class='table table-bordered table-hover table-sm']
	 @FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']/tbody/tr[1]/td[1]") WebElement searchNewsActual;
	
	
	public void newButtonClick() {
		newButton.click();
	}
	
	public void enterTheNews(String news) {
		
		newsField.sendKeys(news);
	}
	
	public void saveButtonClick() {
		saveButton.click();
	}
	
	public boolean addNewsAlertDispalyed() {
		return addNewsAlert.isDisplayed();
	}
	
	public void searchNewsClick() {
		searchNews.click();
	}
	
	public void enterNewsForSearch(String searchnews) {
		searchNewsTextArea.sendKeys(searchnews);
	}
	
	public void searchButtonClick() {
		searchButton.click();
	}
	
	public String verifySearchedNewsIsDisplayed() {
		
		return searchNewsActual.getText();
		
	}

}
