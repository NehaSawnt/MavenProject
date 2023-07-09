package test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Base;
import pom.LoginPagePolicyBazaar;
import pom.myProfilePolicyBazaar;
import utility.Utility;

public class ValidatePolicyUserName extends Base
{
	LoginPagePolicyBazaar login;
	myProfilePolicyBazaar myProfile;
	String TCID ="PB_TC100";
	
	@BeforeClass
	public void launchPolicyBazaar() throws InterruptedException
	{
		Utility.waitUse(1000);
		launchBrowser();
		login=new LoginPagePolicyBazaar(driver);
		myProfile =new myProfilePolicyBazaar(driver);
		Utility.waitUse(2000);

	}
	
	@BeforeMethod
	public void signInPolicyBazaar() throws EncryptedDocumentException, IOException, InterruptedException
	{
		login.ClickOnHomePageSignInButton();
		Utility.waitUse(3000);

		login.enterMobileNo(Utility.readDataFromExcel(0, 0));
		Utility.waitUse(4000);

		login.ClickOnSignInWithPassword();
		Utility.waitUse(4000);
		
		login.enterPassword(Utility.readDataFromExcel(0, 1));
		Utility.waitUse(4000);

		login.clickOnSignForPassword();
		Utility.waitUse(4000);

		
		login.ClickOnMyAccountField();
		Utility.waitUse(4000);

		login.clickOnMyProfile();
	    Utility.waitUse(4000);
		//New tab is opened
		Set<String> ids = driver.getWindowHandles();

		//get widow ids
		ArrayList<String>Allid=	new ArrayList<>(ids);
		String ProfilePageID = Allid.get(1);
		//Get ids of both paged
	    //String MainPageId = it.next();
				      
	    //Switch selenium focus from main page to profile page
		driver.switchTo().window(ProfilePageID);
				      
      //Switch selenium focus from main page to profile page
      driver.switchTo().window(ProfilePageID);
      Reporter.log("Switching on profile page", true);
		Utility.waitUse(1000);
		}
	
  @Test
  public void validateUserName() throws EncryptedDocumentException, IOException, InterruptedException
  {
	  String expectedUserName = Utility.readDataFromExcel(0, 2);
		Utility.waitUse(3000);
		String actualUserName = myProfile.getActualUserName();
		Assert.assertEquals(expectedUserName,actualUserName,"Both are not matching Tc is failed");
		Utility.takeScreenshot(driver, actualUserName +" "+TCID);
		Utility.waitUse(3000);
}
  @AfterMethod
  public void logOutFromPolicyBazaar() throws InterruptedException
  {
	  myProfile.clickOnLogOutButton();
	  
  }
  
  @AfterClass
  public void closePolicyBazaar()
  {
	  closeBrowser();
  }
}















