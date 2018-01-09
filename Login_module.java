package WMS_modules;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import jxl.JXLException;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.biff.RowsExceededException;


public class Login_module {
	
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

//    	@BeforeTest
//    	@Parameters("browser")
//    	public void setup(String browser) throws Exception{
//    		//Check if parameter passed from TestNG is 'firefox'
//    		if(browser.equalsIgnoreCase("firefox")){
//    		//create firefox instance
//    			System.setProperty("webdriver.firefox.marionette", ".\\geckodriver.exe");
//    			driver = new FirefoxDriver();
//    		}
//    		//Check if parameter passed as 'chrome'
//    		else if(browser.equalsIgnoreCase("chrome")){
//    			//set path to chromedriver.exe
//    			System.setProperty("webdriver.chrome.driver",".\\chromedriver.exe");
//    			//create chrome instance
//    			driver = new ChromeDriver();
//    		}
//    		//Check if parameter passed as 'Edge'
//    				else if(browser.equalsIgnoreCase("Edge")){
//    					//set path to Edge.exe
//    					System.setProperty("webdriver.edge.driver",".\\MicrosoftWebDriver.exe");
//    					//create Edge instance
//    					driver = new EdgeDriver();
//    				}
//    		else{
//    			//If no browser passed throw exception
//    			throw new Exception("Browser is not correct");
//    		}
//    		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//    		driver.get("https://meanwms.p2staging.us/login");
//    	}
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
	        callToWrite( sh,  Pagetitle);

	    } 
	    
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
	       
	    @AfterTest
	    public void close()
	    {
	        driver.close();
	    }
	    
	    
	}
