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
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Read_writeExcel {
	
	static int totalNoOfRows;
    public static WritableSheet writablesh;
    public static WritableWorkbook workbookcopy;
    static String Testcase;
    
    //Write data in Excel
    public static void callToWrite(Sheet sh, String Pagetitle[]) throws IOException, RowsExceededException, JXLException
    {
    	System.out.println(Pagetitle);

    FileOutputStream output = new FileOutputStream("C:\\Users\\ashok.k\\Desktop\\Output-login.xls");
    workbookcopy = Workbook.createWorkbook(output);
    writablesh = workbookcopy.createSheet("Sheet1", 0);
    System.out.println("------ New sheet created ------");
	Label lb1 = new Label(0,0,"Username");
	Label lb2 = new Label(1,0,"Password");
	Label lb3 = new Label(2,0,"Results");
	writablesh.addCell(lb1);
	writablesh.addCell(lb2);	
	writablesh.addCell(lb3);
	String tc = new String();

    for(int row = 1; row<sh.getRows(); row++){
    	for(int col = 0; col<sh.getColumns(); col++){
    		Label un = new Label(col, row, sh.getCell(col, row).getContents());
    		writablesh.addCell(un);
        	 
        	  if(Pagetitle[row - 1].equals("WMS Dashboard | Home"))
        		 {
        			 tc = "Pass";
        			 //System.out.println(row + tc);
        		 }
        		 else
        		 {
        			 tc = "Fail";
        			 
        		 }        	 
    		 
    		 Label res=new Label(2,row,tc);
    		 writablesh.addCell(res);
        }
    	System.out.println(row + tc);
    	}
    System.out.println("------ Sheet closed ------");
    workbookcopy.write();
    workbookcopy.close();
    }
    
    public static void main(String[] args) throws IOException, InterruptedException, JXLException {      
        
        System.setProperty("webdriver.firefox.marionette", "D:\\Ashok-Data\\Ashok\\Data\\Testing\\Java Tutorial\\G\\Firefox\\geckodriver-v0.18.0-win64.exe");
        System.setProperty("webdriver.firefox.bin", "C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
        
        WebDriver driver = new FirefoxDriver();
        FileInputStream fs = new FileInputStream("C:\\Users\\ashok.k\\Desktop\\Book1.xls");
        Workbook wb = Workbook.getWorkbook(fs);
        
        Sheet sh = wb.getSheet("Sheet1");
        System.out.println(sh);
        
        totalNoOfRows = sh.getRows();
        
        System.out.println(totalNoOfRows);
        
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
            File scr = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    	    String filename =  new SimpleDateFormat("'Login-'yyyyMMddhhmmss").format(new Date());
    	    File dest = new File("D:/login/" + filename+".png");
    	    FileUtils.copyFile(scr, dest);
       }
        callToWrite( sh,  Pagetitle);
        driver.quit();
     }
}
