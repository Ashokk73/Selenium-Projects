package wms_project;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Autoselect {
	
	static WebDriver driver;
	static WebElement ele;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.firefox.marionette", "D:\\Ashok-Data\\Ashok\\Data\\Testing\\Java Tutorial\\G\\Firefox\\geckodriver-v0.18.0-win64.exe");
		System.setProperty("webdriver.firefox.bin", "C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
		
	    driver = new FirefoxDriver();
	    driver.get("http://demoqa.com/autocomplete/");
	    driver.findElement(By.id("tagss")).sendKeys("a");
	    //driver.findElement(By.xpath(".//*[@id='ui-id-41']")).click();

	}

	}


