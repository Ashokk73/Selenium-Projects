package wms_project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class dropdown {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.firefox.marionette", "D:\\Ashok-Data\\Ashok\\Data\\Testing\\Java Tutorial\\G\\Firefox\\geckodriver-v0.18.0-win64.exe");
		System.setProperty("webdriver.firefox.bin", "C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
		
	    WebDriver driver = new FirefoxDriver();
	    driver.get("https://meanwms.p2staging.us/login");
	    driver.findElement(By.xpath("html/body/div[1]/div/div[2]/form/div[1]/input")).sendKeys("lakshmi.prasanna@position2.com");
	    driver.findElement(By.xpath("html/body/div[1]/div/div[2]/form/div[2]/input")).sendKeys("position2!");
	    driver.findElement(By.xpath("html/body/div[1]/div/div[2]/form/button")).click();
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("html/body/div[1]/nav/aside/div[2]/div[2]/ul/li[3]/a")).click();
	    driver.findElement(By.xpath("html/body/div[1]/div/div/div[2]/div/div[1]/a")).click();
   
//	    Select designation = new Select(driver.findElement(By.xpath(".//*[@id='department']")));
//	    designation.selectByVisibleText("WAAS");
	    
	    String[] exp = {"WAAS", "Creative", "SEO", "MAST", "PA", "GDO", "Management"};
	    WebElement dropdown = driver.findElement(By.xpath(".//*[@id='department']"));    
	    Select select = new Select(dropdown); 
	                     java.util.List<WebElement> options = select.getOptions(); 
	                      for(WebElement item:options) 
	                      {  
	                       for (int i=0; i<exp.length; i++){
	                           if (item.getText().equals(exp[i])){
	                        	   driver.findElement(By.xpath(".//*[@id='department']")).click();
	                           System.out.println("Matched");
	                           }
	                         }
	                       }  
	    driver.quit();
	}

}
