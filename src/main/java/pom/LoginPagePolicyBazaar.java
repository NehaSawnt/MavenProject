package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class LoginPagePolicyBazaar 
{
	//variables
	@FindBy(xpath = "//a[text()='Sign in']") private WebElement SignInButton;
	
	@FindBy(xpath = "(//input[@type='number'])[2]")private WebElement mobileNoField;
	@FindBy(xpath = "(//span[text()='Sign in with Password'])[2]")private WebElement passwordButton;
	@FindBy(xpath = "//input[@type='password']") private WebElement password;
	@FindBy(xpath = "//span[text()='Sign in']") private WebElement signInPassword;
	@FindBy(xpath = "//div[text()='My Account']")private WebElement myAccount;
	@FindBy(xpath = "//span[text()=' My profile ']") private WebElement myProfile;
	
	//Constructor
	public LoginPagePolicyBazaar(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Methods
	//1.Click on signIn button
			public void ClickOnHomePageSignInButton()
			{
				SignInButton.click();
				Reporter.log("Clicking on HomePageSignInButton ", true);
			}
			
			//Enter mobile no
			public void enterMobileNo(String MobNo)
			{
				mobileNoField.sendKeys(MobNo);
				Reporter.log("Entering Mobile No.", true);
			}
			//Click on sign in with  password
			public void ClickOnSignInWithPassword()
			{
				passwordButton.click();
				Reporter.log("Signing in with PW", true);
			}
			//Enter password
			public void enterPassword(String PW)
			{
				password.sendKeys(PW);
				Reporter.log("Entering Password", true);

			}
			
			//Click on sign in
			public void clickOnSignForPassword()
			{
				signInPassword.click();
				Reporter.log("Clicking on sign In PW", true);
			}
			
			//Click on my account
			public void ClickOnMyAccountField()
			{
				myAccount.click();
				Reporter.log("Clicking on My Account button", true);
			}
			//click on myProfile
			public void clickOnMyProfile()
			{
				myProfile.click();
				Reporter.log("Clicking on my profile", true);
			}
		

	

	

}
