package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import testBase.BaseClass;
import pageObjects.HomePage;
import pageObjects.AccountRegistrationPage;

public class TC_001_AccountRegistrationTest extends BaseClass {

	@Test(groups= {"Regression","Master"}) //Step8 groups added
	public void test_account_registration() throws InterruptedException
	{
		logger.debug("application logs .....");	
		logger.info( "*****   Starting TC_001_AccountRegistrationTest   *****");
		try 
		{
		HomePage hp=new HomePage(driver);              //created object of home page to access its all methods 
		hp.clickMyAccount();
		logger.info("Clicked on My account link");
		
		hp.clickRegister();
		logger.info("Clicked on Register link");
		
		AccountRegistrationPage regpage=new AccountRegistrationPage(driver);      //created object of Account Registration page to access its all methods
		
		logger.info("Providing Customer Data");
		regpage.setFirstName(randomeString().toUpperCase());
		
		regpage.setLastName(randomeString().toUpperCase());
		
		regpage.setEmail(randomeString() + "@gmail.com");
		
		regpage.setTelephone(randomeNumber());
		
		String password=randomAlphaNumeric();
		regpage.setPassword(password);
		regpage.setConfirmPassword(password);
		
		regpage.setPrivacyPolicy();
		
		regpage.clickContinue();
		logger.info("Clicked on Continue");
		
		logger.info("Validating expected message");
		String confirm_msg = regpage.getConfirmationMsg();
		
		Assert.assertEquals(confirm_msg, "Your Account Has Been Created!","test failed");
		}
		
		catch(Exception e)
		{
			logger.error("test failed");
		}
		logger.info("****   Finished TC_001_AccountRegistrationTest   ****");
		}
	
	
}
