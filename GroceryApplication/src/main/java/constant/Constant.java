package constant;

public class Constant {
	
	public static final String CONFIGFILE=System.getProperty("user.dir")+"\\src\\main\\resources\\config.property";
	
	public static final String TESTDATA=System.getProperty("user.dir")+"\\src\\test\\resources\\ProjectTestData.xlsx";

	public static final String VALIDCREDENTIALERROR="User is unable with to login with valid credentials";
	
	public static final String INVALIDCREDENTIALERROR="User is able to login with invalid username";
	
	public static final String INVALIDPASSWORDERROR="User is able to login with invalid password credentials";
	
	public static final String INVALIDUSERNAMEERROR="User is able to login with invalid username";
	
	public static final String USERACCOUNTCREATEERROR="New admin user was not added successfully";
	
	public static final String SEARCHUSERNAMEERROR="Searched user name does not match the returned username";
	
	public static final String USERLOGOUTERROR="User is unable to logout";
}
