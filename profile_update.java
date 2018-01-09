package WMS_modules;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class profile_update {
	
static WebDriver driver;
	
	@BeforeTest
    public void launch() {
	System.setProperty("webdriver.firefox.marionette", "D:\\Ashok-Data\\Ashok\\Data\\Testing\\Java Tutorial\\G\\Firefox\\geckodriver-v0.18.0-win64.exe");
	System.setProperty("webdriver.firefox.bin", "C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
	driver = new FirefoxDriver();
	driver.get("https://meanwms.p2staging.us/login");
	driver.findElement(By.xpath("html/body/div[1]/div/div[2]/form/div[1]/input")).sendKeys("lakshmi.prasanna@position2.com");
    driver.findElement(By.xpath("html/body/div[1]/div/div[2]/form/div[2]/input")).sendKeys("prasanna1612");
    driver.findElement(By.xpath("html/body/div[1]/div/div[2]/form/button")).click();
	driver.findElement(By.xpath(".//*[@id='navbar']/ul/li[2]/a[1]")).click();
	driver.findElement(By.xpath(".//*[@id='tab-detail-contact']/dl[1]/div/a/i")).click();
	}
	
	@Test
	public void updateprofile()
	{
		driver.findElement(By.xpath("html/body/div[1]/div/div/div[2]/div[1]/ul/li[2]/a")).click();
		driver.findElement(By.xpath(".//*[@id='account-edit-new-password']")).sendKeys("abcd1234");
		driver.findElement(By.xpath(".//*[@id='account-edit-confirm-new-password']")).sendKeys("1234abcd");
		driver.findElement(By.xpath(".//*[@id='ResetPswd']/div[3]/div/button")).click();
	}
	
	@AfterTest
	public void quit()
	{
		driver.quit();
	}

}
