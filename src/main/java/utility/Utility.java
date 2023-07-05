package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.testng.Reporter;

public class Utility 
{
	//Screenshot
	public static void takeScreenshot(WebDriver driver,String fileName) throws IOException
	{
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest=new File("C:\\Users\\Narayan\\eclipse-workspace\\MavenProject\\Screenshot\\" +fileName+ ".png");
		FileHandler.copy(source, dest);
		Reporter.log("Screenshot is stored in location :" +dest, true);
	}
	
	//Scrolling
	public static void scrollIntoView(WebDriver driver,WebElement element)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)", element);
		Reporter.log("Scrolling into view", true);
	}
	
	//Excel sheet reading
	public static String readDataFromExcel(int row,int cell) throws EncryptedDocumentException, IOException
	{
		FileInputStream myFile=new FileInputStream("C:\\Software Testing\\SeleniumExcel\\PolicyBazaar.xlsx");
		String value = WorkbookFactory.create(myFile).getSheet("Sheet1").getRow(row).getCell(cell).getStringCellValue();
		Reporter.log("Reading data from excel" +row+ "and cell num" +cell , false);
		return value;
	    
	}
	
	//Wait
	public static void waitUse(int waitTime) throws InterruptedException
	{
		Reporter.log("Waiting for" +waitTime+ "millisec.", true);
		Thread.sleep(waitTime);
	}

}














