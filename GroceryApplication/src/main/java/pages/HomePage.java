package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	public WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;

		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//img[@class='img-circle']")
	WebElement adminimage;
	@FindBy(xpath = "//i[@class='ace-icon fa fa-power-off']")
	WebElement logout; // annotation to find elements provided by Page Factory class

	// Admin users more info locator
	@FindBy(xpath = "//div[@class='small-box bg-info']//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin']")
	WebElement adminUsersMoreinfo;

	// Manage Contact more info locator
	@FindBy(xpath = "//div[@class='small-box bg-info']//a[@href='https://groceryapp.uniqassosiates.com/admin/list-contact']")
	WebElement manageAccountMoreinfo;

	// Manage news more info locator
	@FindBy(xpath = "//div[@class='small-box bg-info']//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news']")
	WebElement manageNewsMoreInfo;

	public void adminImageClick() {

		adminimage.click();

	}

	public void logoutClick() {

		logout.click();

	}

	public void adminUsersMoreInfoClick() {

		adminUsersMoreinfo.click();
	}

	public void manageAccountMoreInfoClick() {

		manageAccountMoreinfo.click();
	}

	public void manageNewsMoreInfoClick() {

		manageNewsMoreInfo.click();
	}

}
