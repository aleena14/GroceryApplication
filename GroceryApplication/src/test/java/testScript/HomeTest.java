package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class HomeTest extends Base{
	HomePage hp; 
	@Test(description="Verifying whether user is able to logout successfully")
	public void verifyWhetherUserIsAbleToSuccessfullyLoggedOut() throws IOException
	{  
		String usernamevalue = ExcelUtility.getStringData(0, 0, "LoginCreds");
		String passwordvalue = ExcelUtility.getStringData(0, 1, "LoginCreds");
		LoginPage lp = new LoginPage(driver);
		lp.enterUsernameOnUsernameField(usernamevalue).enterPasswordOnPasswordField(passwordvalue);
		hp=lp.clickLoginButton();
		hp.clickAdminButton();
		lp=hp.clickLogoutButton();
		String actual = lp.verifyLoginTextIsDisplayed();
		String expected = "7rmart supermarket";
		Assert.assertEquals(actual, expected,Constant.UNABLETOLOGOUTERROR);
	}

}
