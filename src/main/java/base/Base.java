package base;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Reporter;

public class Base
{
	//driver and browser setup
	protected static WebDriver driver;
	
	//1.Launch browser
	public void launchBrowser()
	{
		driver=new ChromeDriver();
		driver.get("https://www.policybazaar.com/");
		driver.manage().window().maximize();
		Reporter.log("Launching browser", true);
	}
	
	
	//2.Close browser
	public void closeBrowser()
	{
		driver.quit();
		Reporter.log("Closing browser", true);
	}

}
