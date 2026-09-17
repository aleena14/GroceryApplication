package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import constant.Constant;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends Base {
	
	HomePage home;

	@Test(priority = 1, description = "User is trying to login with valid credentials", groups = { "smoke" })
	public void verifyUserLoginWithValidCredentials() throws IOException {
		String usernamevalue = ExcelUtility.getStringData(0, 0, "LoginCreds");
		String passwordvalue = ExcelUtility.getStringData(0, 1, "LoginCreds");
		LoginPage lp = new LoginPage(driver);
		lp.enterUsernameOnUsernameField(usernamevalue).enterPasswordOnPasswordField(passwordvalue);
		home=lp.clickLoginButton();
		boolean dashboardvalue = lp.verifyWhetherDashboardIsDisplayed();
		Assert.assertTrue(dashboardvalue, Constant.VALIDCREDENTIALERROR);

	}

	@Test(priority = 3, description = "User is trying to login with valid username  and invalid password")
	public void verifyUserLoginWithValidUsernameInvalidPassword() throws IOException {
		String usernamevalue = ExcelUtility.getStringData(1, 0, "LoginCreds");
		String passwordvalue = ExcelUtility.getStringData(1, 1, "LoginCreds");
		LoginPage lp = new LoginPage(driver);
		lp.enterUsernameOnUsernameField(usernamevalue).enterPasswordOnPasswordField(passwordvalue).clickLoginButton();
		String actual = lp.verifyLoginTextIsDisplayed();
		String expected = "7rmart supermarket";
		Assert.assertEquals(actual, expected, Constant.INVALIDPASSWORDERROR);
	}

	@Test(priority = 2, description = "User is trying to login with invalid username  and valid password")
	public void verifyUserLoginWithInvalidUsernameValidPassword() throws IOException {
		String usernamevalue = ExcelUtility.getStringData(2, 0, "LoginCreds");
		String passwordvalue = ExcelUtility.getStringData(2, 1, "LoginCreds");
		LoginPage lp = new LoginPage(driver);
		lp.enterUsernameOnUsernameField(usernamevalue).enterPasswordOnPasswordField(passwordvalue).clickLoginButton();
		String actual = lp.verifyLoginTextIsDisplayed();
		String expected = "7rmart supermarket";
		Assert.assertEquals(actual, expected, Constant.INVALIDUSERNAMEERROR);
	}

	@Test(priority = 4, description = "User is trying to login with invalid credentials", retryAnalyzer = retry.Retry.class, groups = {
			"smoke" },dataProvider="LoginData")
	public void verifyUserLoginWithInvalidCredentials(String usernamevalue,String passwordvalue) throws IOException {
//		String usernamevalue = ExcelUtility.getStringData(3, 0, "LoginCreds");
//		String passwordvalue = ExcelUtility.getStringData(3, 1, "LoginCreds");
		LoginPage lp = new LoginPage(driver);
		lp.enterUsernameOnUsernameField(usernamevalue).enterPasswordOnPasswordField(passwordvalue).clickLoginButton();
		String actual = lp.verifyLoginTextIsDisplayed();
		String expected = "7rmart supermarket";
		Assert.assertEquals(actual, expected, Constant.INVALIDCREDENTIALERROR );
	}

	@DataProvider(name = "LoginData")
	public Object[][] getDataFromDataProvider() {
		return new Object[][] { new Object[] { "admin", "admin22" }, new Object[] { "admin123", "admin123" } };
	}

}
