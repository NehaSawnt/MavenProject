package test;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import base.Base;
import utility.Utility;

public class FirstListener extends Base implements ITestListener
{
	Base b=new Base();
	@Override
	public void onTestSuccess(ITestResult result) 
	{
		Reporter.log("This " +result.getName()+" method is successfull", true);
	}
	
	@Override
	public void onTestFailure(ITestResult result) 
	{
		
		try 
		{
			Utility.takeScreenshot(driver, result.getName());
		} 
		catch(IOException e)
		{
			e.printStackTrace();
		}
		Reporter.log("This "+result.getName()+" method is failed ,Plz try again", true);
	}
	
	@Override
	public void onTestStart(ITestResult result)
	{
		Reporter.log("Test "+result.getName()+" execution starting", true);
	}
	@Override
	public void onTestSkipped(ITestResult result)
	{
		Reporter.log("This "+result.getName()+" method is skipped", true);
	}

}
