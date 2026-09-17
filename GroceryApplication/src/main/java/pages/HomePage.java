package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	public WebDriver driver;
	   
	@FindBy(xpath="//img[@class='img-circle']") WebElement admin;
	@FindBy(xpath="//i[@class='ace-icon fa fa-power-off']") WebElement logout;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin' and text()='More info ']") WebElement adminusersmoreinfo;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-deliveryboy' and text()=\"More info \"]") WebElement managedeliveryboymoreinfo;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news' and text()=\"More info \"]") WebElement managenewsmoreinfo;
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	public HomePage clickAdminButton()
	{
		admin.click();
		return this;
	}
	public LoginPage clickLogoutButton()
	{
		logout.click();
		return new LoginPage(driver);
	}
	public AdminUsersPage clickAdminUsersMoreInfoButton()
	{
		adminusersmoreinfo.click();
		return new AdminUsersPage(driver);
	}
	public ManageDeliveryBoyPage clickManageDeliveryBoyMoreInfo()
	{
		managedeliveryboymoreinfo.click();
		return new ManageDeliveryBoyPage(driver);
	}
	public ManageNewsPage clickManageNewsMoreInfo() 
	{
		Actions obj = new Actions(driver);
		obj.click(managenewsmoreinfo).perform();
		return new ManageNewsPage(driver);
	}
}
