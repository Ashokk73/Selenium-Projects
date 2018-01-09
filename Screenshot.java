package WMS_modules;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;

public class Screenshot {
	
	static WebDriver driver;
	
	@BeforeTest
    public void launch() {
	System.setProperty("webdriver.firefox.marionette", "D:\\Ashok-Data\\Ashok\\Data\\Testing\\Java Tutorial\\G\\Firefox\\geckodriver-v0.18.0-win64.exe");
	System.setProperty("webdriver.firefox.bin", "C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
	driver = new FirefoxDriver();
	}
	
	@Test
	public void takescreenshot(String filename) throws IOException, InterruptedException {
		driver.get("https://meanwms.p2staging.us/login");
		Thread.sleep(5000);
		File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy h-m-s");
        filename="Super_Selenium";
        FileUtils.copyFile(screenshotFile, new File("D:\\login\\"+filename+"-"+dateFormat.format(date)+".png"));	
        }
	//
	@AfterTest
	public void quit()
	{
		driver.quit();
	}
}