package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import pages.AdminUsersPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;
import utilities.RandomDataUtility;

public class AdminUsersTest extends Base{
	
	HomePage hp;
	AdminUsersPage aup;
	
	@Test(description="Checking whether the user is able to add new admin user")
	public void verifyWhetherUserIsAbledToAddNewAdminUser() throws IOException
	{
	String usernamevalue=ExcelUtility.getStringData(0, 0, "LoginCreds");
	String passwordvalue=ExcelUtility.getStringData(0, 1, "LoginCreds");
	LoginPage lp = new LoginPage(driver);
	lp.enterUsernameOnUsernameField(usernamevalue).enterPasswordOnPasswordField(passwordvalue);
	hp = lp.clickLoginButton();
	aup = hp.clickAdminUsersMoreInfoButton();
	aup.clickNewButton();
	RandomDataUtility rd = new RandomDataUtility();
	String adminusernamevalue = rd.generateRandomUsername();
	String adminpasswordvalue = rd.generateRandomPassword();
	aup.enterUsernameOnUsernameField(adminusernamevalue).enterPasswordOnPasswordField(adminpasswordvalue).selectUserTypeFromDropdown().clickSaveButton();
	boolean successalert = aup.verifyUserCreationSuccessAlertIsDisplayed();
	Assert.assertTrue(successalert, Constant.UNABLETOCREATENEWADMINUSERERROR);
	}
	@Test(description="Verify whether user is able to search the newly added admin user")
	public void verifyWhetherUserIsAbleToSearchTheNewlyAddedAdminUser() throws IOException
	{   
		String usernamevalue=ExcelUtility.getStringData(0, 0, "LoginCreds");
		String passwordvalue=ExcelUtility.getStringData(0, 1, "LoginCreds");
		LoginPage lp = new LoginPage(driver);
		lp.enterUsernameOnUsernameField(usernamevalue).enterPasswordOnPasswordField(passwordvalue);
		hp = lp.clickLoginButton();
		aup = hp.clickAdminUsersMoreInfoButton();
		aup.clickSearchOptionButton();
		String adminusernamevalue=ExcelUtility.getStringData(0, 0, "AdminUsersInput");
		aup.enterUsernameOnUsernameFieldInSearch(adminusernamevalue).selectUserTypeFromDropdownInSearch().clickSearchButton();
		String actual = aup.getUsernameFromAdminUsersTable();
		String expected = adminusernamevalue;
		Assert.assertEquals(actual, expected,Constant.UNABLETOSEARCHNEWADMINUSERERROR);
	}
}
