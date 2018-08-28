package utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
	protected WebDriver driver;
	
	  @BeforeMethod
	  public void beforeMethod() {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\\\raffaela_monteiro\\Downloads\\prova_sicredi-master\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  }
	  
	  @AfterMethod
	  public void afterMethod() {
		  driver.quit();
	  }

}
