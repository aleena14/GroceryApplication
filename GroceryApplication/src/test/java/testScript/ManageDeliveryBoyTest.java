package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageDeliveryBoyPage;
import utilities.ExcelUtility;
import utilities.RandomDataUtility;

public class ManageDeliveryBoyTest extends Base{
	
		HomePage hp;
		ManageDeliveryBoyPage mdbp;
	
	@Test(description="Verifying whether user is able to add new delivery boy details.")
	public void verifyWhetherUserIsAbleToAddNewDeliveryBoy() throws IOException
	{
		String usernamevalue=ExcelUtility.getStringData(0, 0, "LoginCreds");
		String passwordvalue=ExcelUtility.getStringData(0, 1, "LoginCreds");
		LoginPage lp = new LoginPage(driver);
		lp.enterUsernameOnUsernameField(usernamevalue).enterPasswordOnPasswordField(passwordvalue);
		hp = lp.clickLoginButton();
		mdbp = hp.clickManageDeliveryBoyMoreInfo();
		RandomDataUtility rd = new RandomDataUtility();
		mdbp.clickNewButton().enterNameOnNameField(rd.generateFullName()).enterEmailOnEmailField(rd.generateRandomEmailID()).enterPhoneNumberOnPhoneield(rd.generateRandomPhoneNumber()).enterAddressOnAddressField(rd.generateRandomAddress()).enteUsernameOnNUserNameField(rd.generateRandomUsername()).enterPasswordOnPasswordField(rd.generateRandomPassword()).clickSaveButton();
		Boolean successalert = mdbp.verifyNewDeliveryBoyCreationSuccessAlertIsDisplayed();
		Assert.assertTrue(successalert, Constant.UNABLETOADDDELIVERYBOYERROR);
	}

}
