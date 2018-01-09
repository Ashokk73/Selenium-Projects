package wms_project;

import java.io.FileInputStream;
import java.io.IOException;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Loginpage {
	
	
	static String Actualtitle;
	static String Expectedtitle = "WMS Dashboard | Home";
	static String Expectedtitle1 = "WMS Dashboard | Login";
	static int totalNoOfRows;

	public static void main(String[] args) throws BiffException, IOException, InterruptedException {      
	    //Sheet s;
		
		System.setProperty("webdriver.firefox.marionette", "D:\\Ashok-Data\\Ashok\\Data\\Testing\\Java Tutorial\\G\\Firefox\\geckodriver-v0.18.0-win64.exe");
		System.setProperty("webdriver.firefox.bin", "C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
		
	    WebDriver driver = new FirefoxDriver();
		FileInputStream fs = new FileInputStream("C:\\Users\\ashok.k\\Desktop\\Book1.xls");
		Workbook wb = Workbook.getWorkbook(fs);
		//System.out.println(fs);
		
		Sheet sh = wb.getSheet("Sheet1");
		System.out.println(sh);
		
		totalNoOfRows = sh.getRows();
		
		System.out.println(totalNoOfRows);
				
			for (int row = 1; row <= totalNoOfRows; row++)
			{
				driver.get("https://meanwms.p2staging.us/login");
				
				Actualtitle = driver.getTitle();
				System.out.println("Actualtitle is "+Actualtitle);
				
				if(Actualtitle.equals(Expectedtitle))
				{
			
			String Username = sh.getCell(0, row).getContents();
			System.out.println("Username is "+Username);
			driver.findElement(By.xpath("html/body/div[1]/div/div[2]/form/div[1]/input")).sendKeys(Username);
			
			String Password = sh.getCell(1, row).getContents();
			System.out.println("Password is "+Password);
			driver.findElement(By.xpath("html/body/div[1]/div/div[2]/form/div[2]/input")).sendKeys(Password);
			driver.findElement(By.xpath("html/body/div[1]/div/div[2]/form/button")).click();	
			}	
				if(Actualtitle.equals(Expectedtitle1))
				{
			driver.findElement(By.xpath(".//*[@id='navbar']/ul/li[2]/a[2]/i")).click();
				}
			}

	}
	

}
