package wms_project;


import java.io.IOException;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;


public class Homepage {
	
	public static String Actualtitle;
	public static String Expectedtitle;
	static WebDriver driver;

	public static void main(int option ) throws IOException, EncryptedDocumentException, InvalidFormatException, InterruptedException  {
		
		System.setProperty("webdriver.firefox.marionette", "D:\\Ashok-Data\\Ashok\\Data\\Testing\\Java Tutorial\\G\\Firefox\\geckodriver-v0.18.0-win64.exe");
		System.setProperty("webdriver.firefox.bin", "C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
		driver = new FirefoxDriver();
		
		driver.get("https://meanwms.p2staging.us/login");
	    driver.findElement(By.xpath("html/body/div[1]/div/div[2]/form/div[1]/input")).sendKeys("lakshmi.prasanna@position2.com");
	    driver.findElement(By.xpath("html/body/div[1]/div/div[2]/form/div[2]/input")).sendKeys("lakshmi.prasanna");
	    driver.findElement(By.xpath("html/body/div[1]/div/div[2]/form/button")).click();
	    driver.findElement(By.xpath("html/body/div[1]/nav/aside/div[2]/div[2]/ul/li[2]/a")).click();
	    driver.findElement(By.xpath("html/body/div[1]/div/div/div[2]/div/div[1]/a")).click();
	    List<WebElement> radios = driver.findElements(By.name("packages"));
	    if (option > 0 && option <= radios.size()) {
	        radios.get(option - 1).click();
	        System.out.println("Radio button size is " +radios.get(option - 1));
	    } else {
	        throw new NotFoundException("option " + option + " not found");
	    }
		
		
	}

	
}
