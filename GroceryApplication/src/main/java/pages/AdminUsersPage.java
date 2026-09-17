package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.PageUtility;

public class AdminUsersPage {
	PageUtility pu = new PageUtility();
	public WebDriver driver;
	
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger' and text()=' New']") WebElement newbutton;
	@FindBy(xpath="//input[@name='username']") WebElement username;
	@FindBy(xpath="//input[@name='password']") WebElement password;
	@FindBy(xpath="//select[@name='user_type']") WebElement usertype;
	@FindBy(xpath="//button[@name='Create']") WebElement savebutton;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-primary' and text()=' Search']") WebElement searchbutton;
	@FindBy(xpath="//input[@id='un']") WebElement searchusername;
	@FindBy(xpath="//select[@id='ut']") WebElement searchusertype;
	@FindBy(xpath="//button[@name='Search']") WebElement search;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible' and contains(normalize-space(),'User Created Successfully')]") WebElement usercreationsuccessalert;
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']/tbody/tr[1]/td[1]") WebElement adminuserstableusername;
	
	public AdminUsersPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	public AdminUsersPage clickNewButton()
	{
		newbutton.click();
		return this;
	}
	public AdminUsersPage enterUsernameOnUsernameField(String user)
	{
		username.sendKeys(user);
		return this;
	}
	public AdminUsersPage enterPasswordOnPasswordField(String pass)
	{
		password.sendKeys(pass);
		return this;
	}
	public AdminUsersPage selectUserTypeFromDropdown()
	{
		pu.selectDropdownWithValue(usertype,"admin");
		return this;
//		Select s= new Select(usertype);
//		s.selectByValue("admin");
	}
	public AdminUsersPage clickSaveButton()
	{
		savebutton.click();
		return this;
	}
	public AdminUsersPage clickSearchOptionButton()
	{
		searchbutton.click();
		return this;
	}
	public AdminUsersPage enterUsernameOnUsernameFieldInSearch(String user)
	{
		searchusername.sendKeys(user);
		return this;
	}
	public AdminUsersPage selectUserTypeFromDropdownInSearch()
	{
		pu.selectDropdownWithValue(searchusertype, "admin");
		return this;
//		Select s = new Select(searchusertype);
//		s.selectByValue("admin");
	}
	public AdminUsersPage clickSearchButton()
	{
		search.click();
		return this;
	}
	public boolean verifyUserCreationSuccessAlertIsDisplayed()
	{
		return usercreationsuccessalert.isDisplayed();
	}
	public String getUsernameFromAdminUsersTable()
	{
		return adminuserstableusername.getText(); 
	}
	

}
