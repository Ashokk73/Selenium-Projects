package wms_project;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Chrome_launching {
	
	static String Expectedtitle = "WMS Dashboard | p2 users";
	static String Actualurl;
	static String Expectedurl;
	public static WritableSheet writablesh;
	public static WritableWorkbook workbookcopy;
	static WebDriver driver;

	public static void main(String[] args) throws BiffException, IOException {
//		System.setProperty("webdriver.chrome.driver", "D:\\Ashok-Data\\Ashok\\Data\\Testing\\chromedriver_win32\\chromedriver.exe");
		System.setProperty("webdriver.ie.driver", "C:\\Program Files (x86)\\Internet Explorer\\iexplore.exe");
//		WebDriver driver = new ChromeDriver();
		WebDriver driver = new InternetExplorerDriver();
		driver.manage().window().maximize();
		driver.get("https://meanwms.p2staging.us/login");
	    driver.findElement(By.xpath("html/body/div[1]/div/div[2]/form/div[1]/input")).sendKeys("lakshmi.prasanna@position2.com");
	    driver.findElement(By.xpath("html/body/div[1]/div/div[2]/form/div[2]/input")).sendKeys("prasanna1612");
	    driver.findElement(By.xpath("html/body/div[1]/div/div[2]/form/button")).click();
	    driver.findElement(By.xpath("html/body/div[1]/nav/aside/div[2]/div[2]/ul/li[2]/a")).click();
	    driver.findElement(By.xpath("html/body/div[1]/div/div/div[2]/div/div[1]/a")).click();
	    String Pagetitle = driver.getTitle();
	    System.out.println("Page title is " +Pagetitle);
	    
	    FileInputStream FIS = new FileInputStream("C:\\Users\\ashok.k\\Desktop\\Addcustomer.xls");
	    Workbook wb = Workbook.getWorkbook(FIS);
	    Sheet sh = wb.getSheet("Sheet1");
	    System.out.println(sh.getRows());
	    String bodyText[] = new String[sh.getRows()];
	    
	    for(int i=1; i<sh.getRows(); i++)
	    {
	    	String Firstname = sh.getCell(0, i).getContents();
	    	String Lastname = sh.getCell(1, i).getContents();
	    	String Mailid = sh.getCell(2, i).getContents();
	    	String Password = sh.getCell(3, i).getContents();
	    	String Cpassword = sh.getCell(4, i).getContents();
	    	String Mobileno = sh.getCell(5, i).getContents();
	    	String Designation = sh.getCell(6, i).getContents();
	    	String Companyname = sh.getCell(7, i).getContents();
	    	String Websiteurl = sh.getCell(8, i).getContents();
	    	String Address = sh.getCell(9, i).getContents();
	    	String Country = sh.getCell(10, i).getContents();
	    	String State = sh.getCell(11, i).getContents();
	    	String Zipcode = sh.getCell(12, i).getContents();
	    	
	    	driver.findElement(By.xpath(".//*[@id='pe-first-name']")).clear();
		    driver.findElement(By.xpath(".//*[@id='pe-first-name']")).sendKeys(Firstname);
		    driver.findElement(By.xpath(".//*[@id='pe-last-name']")).clear();
		    driver.findElement(By.xpath(".//*[@id='pe-last-name']")).sendKeys(Lastname);
		    driver.findElement(By.xpath(".//*[@id='pe-email']")).clear();
		    driver.findElement(By.xpath(".//*[@id='pe-email']")).sendKeys(Mailid);
		    driver.findElement(By.xpath(".//*[@id='pe-password']")).clear();
		    driver.findElement(By.xpath(".//*[@id='pe-password']")).sendKeys(Password);
		    driver.findElement(By.xpath(".//*[@id='pe-cpassword']")).clear();
		    driver.findElement(By.xpath(".//*[@id='pe-cpassword']")).sendKeys(Cpassword);
		    driver.findElement(By.xpath(".//*[@id='phoneno']")).clear();
		    driver.findElement(By.xpath(".//*[@id='phoneno']")).sendKeys(Mobileno);
		    driver.findElement(By.xpath(".//*[@id='jobtitle']")).clear();
		    driver.findElement(By.xpath(".//*[@id='jobtitle']")).sendKeys(Designation);
		    driver.findElement(By.xpath(".//*[@id='company']")).clear();
		    driver.findElement(By.xpath(".//*[@id='company']")).sendKeys(Companyname);
		    driver.findElement(By.xpath(".//*[@id='website']")).clear();
		    driver.findElement(By.xpath(".//*[@id='website']")).sendKeys(Websiteurl);
		    driver.findElement(By.xpath(".//*[@id='AddDetailForm']/div/div[2]/div[10]/div/textarea")).clear();
		    driver.findElement(By.xpath(".//*[@id='AddDetailForm']/div/div[2]/div[10]/div/textarea")).sendKeys(Address);
		    driver.findElement(By.xpath(".//*[@id='country']")).clear();
		    driver.findElement(By.xpath(".//*[@id='country']")).sendKeys(Country);
		    driver.findElement(By.xpath(".//*[@id='state']")).clear();
		    driver.findElement(By.xpath(".//*[@id='state']")).sendKeys(State);
		    driver.findElement(By.xpath(".//*[@id='zipcode']")).clear();
		    driver.findElement(By.xpath(".//*[@id='zipcode']")).sendKeys(Zipcode);	
		    driver.findElement(By.xpath(".//*[@id='AddDetailForm']/div/div[2]/div[15]/div/div[1]/label")).click();
		    driver.findElement(By.xpath(".//*[@id='AddDetailForm']/div/div[3]/button")).click();
		    Expectedurl = "https://meanwms.p2staging.us/admin/users/customers";
		    Actualurl = driver.getCurrentUrl();
		    if(Actualurl.equals(Expectedurl))
		    	{
	    		System.out.println("Test is Pass");
	    		bodyText[i] = driver.getCurrentUrl();
	    		driver.findElement(By.xpath("html/body/div[1]/div/div/div[2]/div/div[1]/a")).click();
	    		}
		    else
		   	 {
		   	 	bodyText[i] = driver.getCurrentUrl();
		    	System.out.println("Test is Fail");
		    	}
	    }
	    driver.quit();
	}

}
