package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.ExcelUtility;

public class ManageNewsTest extends Base {
	
	HomePage hp;
	ManageNewsPage mnp;
	
	@Test(description="Verifying whether user is successfully able to add new news")
	public void verifyWhetherUserIsAbleToAddNewNews() throws IOException
	{
		String usernamevalue=ExcelUtility.getStringData(0, 0, "LoginCreds");
		String passwordvalue=ExcelUtility.getStringData(0, 1, "LoginCreds");
		LoginPage lp = new LoginPage(driver);
		lp.enterUsernameOnUsernameField(usernamevalue).enterPasswordOnPasswordField(passwordvalue);
		hp = lp.clickLoginButton();
		mnp = hp.clickManageNewsMoreInfo();
		mnp.clickNewButton();
		String news=ExcelUtility.getStringData(0, 0, "News");
		mnp.enterNewsInNewsField(news).clickSaveButton();
		boolean successalert = mnp.verifyNewsCreationSuccessAlertIsDisplayed();
		Assert.assertTrue(successalert, Constant.UNABLETOADDNEWSERROR);
	}

	@Test(description="Verifying whether user is able to search the newly added news")
	public void verifyWhetherUserIsAbleToSearchNewlyAddedNews() throws IOException 
	{
		String usernamevalue=ExcelUtility.getStringData(0, 0, "LoginCreds");
		String passwordvalue=ExcelUtility.getStringData(0, 1, "LoginCreds");
		LoginPage lp = new LoginPage(driver);
		lp.enterUsernameOnUsernameField(usernamevalue).enterPasswordOnPasswordField(passwordvalue);
		hp = lp.clickLoginButton();
		mnp = hp.clickManageNewsMoreInfo();
		mnp.clickSearchButton();
		String newstitle=ExcelUtility.getStringData(0, 0, "News");
		mnp.enterNewsTitleInSearchBox(newstitle).clickSearchTitleButton();
		String actual = mnp.getNewsTitleFromFromManageNewsTable();
		String expected = ExcelUtility.getStringData(0, 0, "News");
		Assert.assertEquals(actual, expected, Constant.UNABLETOSEARCHNEWSERROR);
	}

}
