package WMS_modules;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class crossbrowser {
	private  WebDriver driver=null;
	
	 @BeforeTest
	 @Parameters ({"BROWSER"})
	 public void setup(String BROWSER){
	  System.out.println("Browser: " + BROWSER);

	  if (BROWSER.equals("FF")) {
	   System.out.println("FF is selected");
	   driver = new FirefoxDriver();
	  } else if (BROWSER.equals("IE")) {
	   System.out.println("IE is selected");
	   driver = new InternetExplorerDriver();
	  } else if (BROWSER.equals("HU")) {
	   System.out.println("HU is selected");
	   driver = new HtmlUnitDriver();
	  } else if (BROWSER.equals("CH")){
	   System.out.println("Google chrome is selected");
	   driver = new ChromeDriver();
	  }
	 }
	 
	 @Test
	 public  void testParallel()throws Exception{

	  driver.get("http://www.google.com");
	 }

}
