package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage  {
	
	public HomePage(WebDriver driver)
	{
		super(driver);   //Used to invoke parent class constructor
	}
	
	// Elements
	
	@FindBy(xpath="//span[normalize-space()='My Account']")
	WebElement ClkMyaccount;
	
	@FindBy(xpath="//a[normalize-space()='Register']")
	WebElement ClkRegister;
	
	@FindBy(linkText = "Login")   // Login link added in step6
	WebElement linkLogin;
	
	//Action Methods
	
	public void clickMyAccount() {
		ClkMyaccount.click();
	}
	
	public void clickRegister() {
		ClkRegister.click();
	}
	
	public void clickLogin()    // added in step6
	{
		linkLogin.click();
	}
	
}
