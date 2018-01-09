package WMS_modules;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Forgot_password {
	
	static WebDriver driver;
	
	@BeforeTest
    public void launch() {
	System.setProperty("webdriver.firefox.marionette", "D:\\Ashok-Data\\Ashok\\Data\\Testing\\Java Tutorial\\G\\Firefox\\geckodriver-v0.18.0-win64.exe");
	System.setProperty("webdriver.firefox.bin", "C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
	driver = new FirefoxDriver();
	}
	
	@Test
	public void forgotpasswordvalid()
	{
		driver.get("https://meanwms.p2staging.us/login");
		driver.findElement(By.xpath("html/body/div[1]/div/div[3]/a")).click();
		String actual = driver.getTitle();
		String expected = "WMS Dashboard | Forogot Password";
		Assert.assertEquals(actual, expected);
	}
	
	@AfterTest
	public void quit()
	{
		driver.quit();
	}
}
