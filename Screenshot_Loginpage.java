package WMS_modules;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import jxl.JXLException;
import jxl.Sheet;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.biff.RowsExceededException;

public class Screenshot_Loginpage {
	

	
	static int totalNoOfRows;	
	public WebDriver driver;
	public static WritableSheet writablesh;
    public static WritableWorkbook workbookcopy;
    static String Testcase;
    
	
		@BeforeTest
	    public void launch() {
		System.setProperty("webdriver.firefox.marionette", "D:\\Ashok-Data\\Ashok\\Data\\Testing\\Java Tutorial\\G\\Firefox\\geckodriver-v0.18.0-win64.exe");
		System.setProperty("webdriver.firefox.bin", "C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
		driver = new FirefoxDriver();
		driver.get("https://meanwms.p2staging.us/login");
		}

	    @Test
	    public void homepage() throws IOException, InterruptedException, RowsExceededException, JXLException {
	    	FileInputStream fs = new FileInputStream("C:\\Users\\ashok.k\\Desktop\\Book1.xls");
	        Workbook wb = Workbook.getWorkbook(fs);
	        Sheet sh = wb.getSheet("Sheet1");
	        totalNoOfRows = sh.getRows();
	        String Pagetitle[] = new String[sh.getRows() -1];
	        for (int row = 0; row < totalNoOfRows - 1; row++)
	        {    
	            driver.get("https://meanwms.p2staging.us/login");
	            
	            String Username = sh.getCell(0, (row+1)).getContents();
	            System.out.println("Username is "+Username);
	            driver.findElement(By.xpath("html/body/div[1]/div/div[2]/form/div[1]/input")).clear();
	            driver.findElement(By.xpath("html/body/div[1]/div/div[2]/form/div[1]/input")).sendKeys(Username);
	            String Password = sh.getCell(1, (row+1)).getContents();
	            System.out.println("Password is "+Password);
	            driver.findElement(By.xpath("html/body/div[1]/div/div[2]/form/div[2]/input")).clear();
	            driver.findElement(By.xpath("html/body/div[1]/div/div[2]/form/div[2]/input")).sendKeys(Password);
	            driver.findElement(By.xpath("html/body/div[1]/div/div[2]/form/button")).click();
	            Pagetitle[row] = driver.getTitle();
	            String Actualtitle = driver.getTitle();
	        	String Expectedtitle = "WMS Dashboard | Home";
	            if(Actualtitle.equals(Expectedtitle))
	            {
	            Thread.sleep(5000);
	            driver.findElement(By.xpath(".//*[@id='navbar']/ul/li[2]/a[2]/i")).click();            
	            }
//	            Assert.assertEquals(Actualtitle, Expectedtitle);
	       }
	       } 
	    
	    @AfterMethod
	    public void tearDown(ITestResult result)
	    {

	    // Here will compare if test is failing then only it will enter into if condition
	    if(ITestResult.FAILURE==result.getStatus())
	    {
	    try 
	    {
	    // Create refernce of TakesScreenshot
	    TakesScreenshot ts=(TakesScreenshot)driver;

	    // Call method to capture screenshot
	    File source=ts.getScreenshotAs(OutputType.FILE);

	    // Copy files to specific location here it will save all screenshot in our project home directory and
	    // result.getName() will return name of test case so that screenshot name will be same
	    FileUtils.copyFile(source, new File("/WMS_Project/Screenshots/"+result.getName()+".png"));

	    System.out.println("Screenshot taken");
	    } 
	    catch (Exception e)
	    {

	    System.out.println("Exception while taking screenshot "+e.getMessage());
	    } 
	   
	    }
	}

	    @AfterTest
	    public void close()
	    {
	        driver.close();
	    }
	    
	    
	

}
