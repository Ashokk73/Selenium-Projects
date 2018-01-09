package wms_project;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import jxl.JXLException;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Add_P2user {
	
	static String Expectedtitle = "WMS Dashboard | p2 users";
	static String Actualurl;
	static String Expectedurl;
	public static WritableSheet writablesh;
	public static WritableWorkbook workbookcopy;
	static WebDriver driver;
	//static String bodyText;
	
	public static void addp2user(Sheet sh, String bodyText[])throws JXLException, IOException
	{
		FileOutputStream output = new FileOutputStream("C:\\Users\\ashok.k\\Desktop\\Output-Add_P2user.xls");
	    workbookcopy = Workbook.createWorkbook(output);
	    System.out.println("-------Sheet Created--------");
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
		Label lb7 = new Label(6,0,"Department1");
		writablesh.addCell(lb7);
		Label lb8 = new Label(7,0,"User Type");
		writablesh.addCell(lb8);
		Label lb9 = new Label(8,0,"Results");
		writablesh.addCell(lb9);
		String tc = new String();
		
		for(int i=1; i<sh.getRows(); i++)
		{
			for(int j=0; j<sh.getColumns(); j++)
			{
				Label customer = new Label(j, i, sh.getCell(j, i).getContents());
				writablesh.addCell(customer);
				System.out.println("Actual url is " + bodyText[i]);
				if( bodyText[i].equals("https://meanwms.p2staging.us/admin/users/p2-users"))
				{
					tc = "Pass";
					System.out.println("Pass");

				}
				else
				{
					tc = "Fail";
					System.out.println("Fail");
				}
				Label res = new Label(8,i,tc);
				writablesh.addCell(res);
				System.out.println(i);
			}
			}
		workbookcopy.write();
		workbookcopy.close();
	}
	
	
	public static void main(String[] args) throws InterruptedException, IOException, JXLException {
		System.setProperty("webdriver.firefox.marionette", "D:\\Ashok-Data\\Ashok\\Data\\Testing\\Java Tutorial\\G\\Firefox\\geckodriver-v0.18.0-win64.exe");
		System.setProperty("webdriver.firefox.bin", "C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
		
	    driver = new FirefoxDriver();
	    driver.get("https://meanwms.p2staging.us/login");
	    driver.findElement(By.xpath("html/body/div[1]/div/div[2]/form/div[1]/input")).sendKeys("lakshmi.prasanna@position2.com");
	    driver.findElement(By.xpath("html/body/div[1]/div/div[2]/form/div[2]/input")).sendKeys("prasanna1612");
	    driver.findElement(By.xpath("html/body/div[1]/div/div[2]/form/button")).click();
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("html/body/div[1]/nav/aside/div[2]/div[2]/ul/li[3]/a")).click();
	    driver.findElement(By.xpath("html/body/div[1]/div/div/div[2]/div/div[1]/a")).click();
	    System.out.println("Page title is " +driver.getTitle());
	    Thread.sleep(2000);
	    
	    FileInputStream read = new FileInputStream("C:\\Users\\ashok.k\\Desktop\\Add_p2user.xls");
	    Workbook wb = Workbook.getWorkbook(read);
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
	    	String Department1 = sh.getCell(6, i).getContents();
	    	String Designation = sh.getCell(7, i).getContents();
	    
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
	    Select dptmt = new Select(driver.findElement(By.xpath(".//*[@id='department']")));
	    dptmt.selectByVisibleText(Department1);
	    Select designation = new Select(driver.findElement(By.xpath(".//*[@id='usertype']")));
	    designation.selectByVisibleText(Designation);
	    driver.findElement(By.xpath(".//*[@id='AddDetailForm']/div/div[3]/button")).click();
	    Thread.sleep(2000);
	    Expectedurl = "https://meanwms.p2staging.us/admin/users/p2-users";
	    System.out.println();
	    Actualurl = driver.getCurrentUrl();
	    System.out.println("Actual Url is "+Actualurl);
	    if(Actualurl.equals(Expectedurl))	
	    {
	    	System.out.println("Pass");
	    	bodyText[i] = driver.getCurrentUrl();
	    	driver.findElement(By.xpath("html/body/div[1]/div/div/div[2]/div/div[1]/a")).click();
	    }
	    else
	    {
	    	bodyText[i] = driver.getCurrentUrl();
	    	System.out.println("Fail");
	    }
	    String modulename = "p2user";
	    File scr = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	    String filename =  new SimpleDateFormat("'Add_P2user-'yyyyMMddhhmmss").format(new Date());
	    File dest = new File("D:/Add_P2user/" + filename+".png");
	    FileUtils.copyFile(scr, dest);
	    }
	    addp2user(sh, bodyText);
	    driver.quit();
	}

}
