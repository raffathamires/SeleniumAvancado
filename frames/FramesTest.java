package frames;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import utils.BaseTest;

public class FramesTest extends BaseTest {

	@Test
	public void frames() {
		driver.get("http://eliasnogueira.com/selenium/exercicios/lista/frames/");

		//cabe�alho
		driver.switchTo().frame("topNav");
		assertEquals(driver.findElement(By.tagName("h3")).getText(),
					"Cabe�alho");
		driver.switchTo().defaultContent();
		
		//rodap�
		driver.switchTo().frame("footer");
		assertEquals(driver.findElement(By.tagName("h3")).getText(),
					"Rodap�");
		driver.switchTo().defaultContent();
		
		//menu
		driver.switchTo().frame("menu");
		assertEquals(driver.findElement(By.tagName("h3")).getText(),
					"Menu 1");
		driver.switchTo().defaultContent();
		
		//conteudo
		driver.switchTo().frame("content");
		assertEquals(driver.findElement(By.tagName("h1")).getText(),
					"Conteudo");
		driver.switchTo().defaultContent();
		

	}

}
