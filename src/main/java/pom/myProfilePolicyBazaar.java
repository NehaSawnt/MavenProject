package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import utility.Utility;

public class myProfilePolicyBazaar 
{
    //Variable
	@FindBy(xpath = "//div[@class='textCapitalize sc-ckVGcZ kWpXlQ']")private WebElement userName;
	@FindBy(className="h_l") private WebElement logOutbutton;
	
	//Costructor
	public myProfilePolicyBazaar(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}
	
	//Method
	public String getActualUserName() throws InterruptedException
	{
		Reporter.log("Getting actual username", true);
		Utility.waitUse(4000);
		String actualUN = userName.getText();
		return actualUN;
		
	}
	public void clickOnLogOutButton() throws InterruptedException
	{
		Utility.waitUse(2000);

		logOutbutton.click();
		Reporter.log("Clicking on logout", true);

	}
}
