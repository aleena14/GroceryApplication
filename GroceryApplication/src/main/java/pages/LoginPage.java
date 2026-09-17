package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitUtility;

public class LoginPage {
	WaitUtility wu = new WaitUtility();
	public WebDriver driver;
	
	@FindBy(name="username") WebElement username;
	@FindBy(name="password") WebElement password;
	@FindBy(xpath = "//button[text()='Sign In']") WebElement login;
	@FindBy(xpath="//li[text()='Dashboard']") WebElement  dashboard;
	@FindBy(xpath="//b[text()='7rmart supermarket']") WebElement text;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public LoginPage enterUsernameOnUsernameField(String user)
	{
		username.sendKeys(user);
		return this;
	}
	public LoginPage enterPasswordOnPasswordField(String pass)
	{
		password.sendKeys(pass);
		return this;
	}
	public HomePage clickLoginButton()
	{  
		wu.waitUntilElementToBeClickable(driver, login);
		login.click();
		return new HomePage(driver);
	}
	public boolean verifyWhetherDashboardIsDisplayed()
	{
		return dashboard.isDisplayed();
	}
	public String verifyLoginTextIsDisplayed()
	{
		return text.getText();
	}

}
