package wms_project;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Driver;
import java.text.SimpleDateFormat;
import java.util.Date;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Add_Newcustomer {
	
	static String Expectedtitle = "WMS Dashboard | p2 users";
	static String Actualurl;
	static String Expectedurl;
	public static WritableSheet writablesh;
	public static WritableWorkbook workbookcopy;
	static WebDriver driver;
	
	public static void addcustomerwrite(Sheet sh, String bodyText[]) throws IOException, RowsExceededException, WriteException
	{
		FileOutputStream FOS = new FileOutputStream("C:\\Users\\ashok.k\\Desktop\\Output_Add_P2customer.xls");
		workbookcopy = Workbook.createWorkbook(FOS);
		writablesh = workbookcopy.createSheet("Sheet1", 0);
		Label lb1 = new Label(0,0,"Firstname");
	    writablesh.addCell(lb1);
		Label lb2 = new Label(1,0,"Lastname");
		writablesh.addCell(lb2);
		Label lb3 = new Label(2,0,"Mailid");
		writablesh.addCell(lb3);
		Label lb4 = new Label(3,0,"Password");
		writablesh.addCell(lb4);
		Label lb5 = new Label(4,0,"Confirm Password");
		writablesh.addCell(lb5);
		Label lb6 = new Label(5,0,"Mobile No.");
		writablesh.addCell(lb6);
		Label lb7 = new Label(6,0,"Designation");
		writablesh.addCell(lb7);
		Label lb8 = new Label(7,0,"Companyname");
		writablesh.addCell(lb8);
		Label lb9 = new Label(8,0,"Websiteurl");
		writablesh.addCell(lb9);
		Label lb10 = new Label(9,0,"Address");
		writablesh.addCell(lb10);
		Label lb11 = new Label(10,0,"Country");
		writablesh.addCell(lb11);
		Label lb12 = new Label(11,0,"State");
		writablesh.addCell(lb12);
		Label lb13 = new Label(12,0,"Zipcode");
		writablesh.addCell(lb13);
		Label lb14 = new Label(13,0,"Packages");
		writablesh.addCell(lb14);
		Label lb15 = new Label(14,0,"Results");
		writablesh.addCell(lb15);
		String tc = new String();
		
		for(int i=1; i<sh.getRows(); i++)
		{
			for(int j=0; j<sh.getColumns(); j++)
			{
				Label customer = new Label(j, i, sh.getCell(j, i).getContents());
				writablesh.addCell(customer);
				System.out.println("Actual url is " + bodyText[i]);
				if( bodyText[i].equals("https://meanwms.p2staging.us/admin/users/customers"))
				{
					tc = "Pass";
					System.out.println("Pass");

				}
				else
				{
					tc = "Fail";
					System.out.println("Fail");
				}
				Label res = new Label(14,i,tc);
				writablesh.addCell(res);
				System.out.println(i);
			}
			}
		workbookcopy.write();
		workbookcopy.close();
	}

	public static void main(String[] args) throws BiffException, IOException, InterruptedException, RowsExceededException, WriteException {
		System.setProperty("webdriver.firefox.marionette", "D:\\Ashok-Data\\Ashok\\Data\\Testing\\Java Tutorial\\G\\Firefox\\geckodriver-v0.18.0-win64.exe");
		System.setProperty("webdriver.firefox.bin", "C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
		driver = new FirefoxDriver();
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
	    	String Packages = sh.getCell(13, i).getContents();
	    	
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
		    String plan = driver.findElement(By.className("radio-button")).getText();
//		    		name("packages")).getText();
		    System.out.println(plan);
		    if(plan.equals(Packages))
		    {
		    driver.findElement(By.xpath(".//*[@id='AddDetailForm']/div/div[2]/div[15]/div/div[1]/label")).click();
		    }
		    else
		    {
		    driver.findElement(By.xpath(".//*[@id='AddDetailForm']/div/div[2]/div[15]/div/div[2]/label")).click();
		    }
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
		    File scr = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    	    String filename =  new SimpleDateFormat("'Add_Newcustomer-'yyyyMMddhhmmss").format(new Date());
    	    File dest = new File("D:/Add_Newcustomer/" + filename+".png");
    	    FileUtils.copyFile(scr, dest);
	    }
	    addcustomerwrite(sh, bodyText);
	    driver.quit();
	}
}
