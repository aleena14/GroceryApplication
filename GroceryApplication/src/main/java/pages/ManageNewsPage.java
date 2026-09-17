package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageNewsPage {
	
	public WebDriver driver;
	
	@FindBy(xpath=" //a[@href='https://groceryapp.uniqassosiates.com/admin/news/add']") WebElement newbutton;
	@FindBy(xpath="//textarea[@id='news']") WebElement newsbox;
	@FindBy(xpath="//button[text()=\"Save\"]") WebElement savebutton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']") WebElement newscreationsuccessalert;
	@FindBy(xpath="//a[@href='javascript:void(0)']") WebElement searchbutton;
	@FindBy(xpath="//input[@name='un']") WebElement searchtitlebox;
	@FindBy(xpath="//button[@name='Search']") WebElement searchtitlebutton;
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']/tbody/tr[1]/td[1]") WebElement managenewstable;
	
	public ManageNewsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	public ManageNewsPage clickNewButton() {
		newbutton.click();
		return this;
	}
	
	public ManageNewsPage enterNewsInNewsField(String news){
	    newsbox.sendKeys(news);
	    return this;
	}
	
	public ManageNewsPage clickSaveButton() {
		savebutton.click();
		return this;
	}
	
	public boolean verifyNewsCreationSuccessAlertIsDisplayed() {
		return newscreationsuccessalert.isDisplayed();
	}
	
	public ManageNewsPage clickSearchButton() {
		searchbutton.click();
		return this;
	}
	
	public ManageNewsPage enterNewsTitleInSearchBox(String newstitle){
		searchtitlebox.sendKeys(newstitle);
		return this;
	}
	
	public ManageNewsPage clickSearchTitleButton() {
		searchtitlebutton.click();
		return this;
	}
	
	public String getNewsTitleFromFromManageNewsTable()
	{
		return managenewstable.getText(); 
	}

}
