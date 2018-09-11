package utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
	protected WebDriver driver;
	protected WebDriverWait wait;
	
	  @BeforeMethod
	  public void beforeMethod() {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\\\raffaela_monteiro\\Downloads\\prova_sicredi-master\\chromedriver.exe");
			driver = new ChromeDriver();
			wait = new WebDriverWait(driver, 5);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.get(LerPropriedades.retornarValor("url"));
			driver.manage().window().maximize();
	  }
	  
	  @AfterMethod
	  public void afterMethod() {
		  //driver.quit();
	  }

}
