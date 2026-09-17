package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageDeliveryBoyPage {

	public WebDriver driver;

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger' and text()=\" New\"]") WebElement newbutton;
	@FindBy(xpath="//input[@id='name']") WebElement name;
	@FindBy(xpath="//input[@id='email']") WebElement email;
	@FindBy(xpath="//input[@id='phone']") WebElement phone;
	@FindBy(xpath="//textarea[@id='address']") WebElement address;
	@FindBy(xpath="//input[@id='username']") WebElement username;
	@FindBy(xpath="//input[@id='password']") WebElement password;
	@FindBy(xpath="//button[text()=\"Save\"]") WebElement savebutton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible' ]") WebElement deliveryboycreationsuccessalert;

	public ManageDeliveryBoyPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}

	public ManageDeliveryBoyPage clickNewButton() {
		newbutton.click();
		return this;
	}
	
	public ManageDeliveryBoyPage enterNameOnNameField(String inpname) {
		name.sendKeys(inpname);
		return this;
	}
	public ManageDeliveryBoyPage enterEmailOnEmailField(String inpemail) {
		email.sendKeys(inpemail);
		return this;
	}
	public ManageDeliveryBoyPage enterPhoneNumberOnPhoneield(String inpphone) {
		phone.sendKeys(inpphone);
		return this;
	}
	public ManageDeliveryBoyPage enterAddressOnAddressField(String inpaddress) {
		address.sendKeys(inpaddress);
		return this;
	}
	public ManageDeliveryBoyPage enteUsernameOnNUserNameField(String inpusername) {
		username.sendKeys(inpusername);
		return this;
	}
	public ManageDeliveryBoyPage enterPasswordOnPasswordField(String inppassword) {
		password.sendKeys(inppassword);
		return this;
	}
	public ManageDeliveryBoyPage clickSaveButton() {
		Actions obj = new Actions(driver);
		obj.click(savebutton).perform();
		return this;
	}
	public boolean verifyNewDeliveryBoyCreationSuccessAlertIsDisplayed() {
		return deliveryboycreationsuccessalert.isDisplayed();
	}
	
}
