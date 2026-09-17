package constant;

public class Constant {
	public static final String CONFIGFILE= System.getProperty("user.dir")+"\\src\\main\\resources\\Config.property";
	public static final String TESTDATA= System.getProperty("user.dir")+"\\src\\test\\resources\\TestData.xlsx";
	public static final String VALIDCREDENTIALERROR = "User is unable to login with valid credentials";
	public static final String INVALIDCREDENTIALERROR = "User is able to login with invalid credentials";
	public static final String INVALIDPASSWORDERROR = "User is able to login with Invalid Password";
	public static final String INVALIDUSERNAMEERROR = "User is able to login with invalid Username";
	public static final String UNABLETOCREATENEWADMINUSERERROR = "New Admin User Creation is Unsuccessful";
	public static final String UNABLETOSEARCHNEWADMINUSERERROR = "Expected user is not found in Admin Users table";
	public static final String UNABLETOLOGOUTERROR = "User is unable to logout";
	public static final String UNABLETOADDDELIVERYBOYERROR = "New Delivery Boy Creation is Unsuccessful!";
	public static final String UNABLETOADDNEWSERROR = "User unable to add new news!";
	public static final String UNABLETOSEARCHNEWSERROR = "Search result does not match the entered news";
}
