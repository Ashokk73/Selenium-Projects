package wms_project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Spellchecker {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.firefox.marionette", "D:\\Ashok-Data\\Ashok\\Data\\Testing\\Java Tutorial\\G\\Firefox\\geckodriver-v0.18.0-win64.exe");
		System.setProperty("webdriver.firefox.bin", "C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
		
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		//String t = driver.getTitle();
		//driver.findElement(By.xpath(".//*[@id='email']")).sendKeys("ashokyoungboy@gmail.com");
		//driver.findElement(By.xpath(".//*[@id='pass']")).sendKeys("ashok1592");
		//driver.findElement(By.id("loginbutton")).click();
		//System.out.println(t);
		//Thread.sleep(5000);
		//driver.close();

	}

}
