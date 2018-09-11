package actions;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import utils.BaseTest;

public class MenuTest extends BaseTest {
	
	@Test
	public void selecionaLinkMenu() {
		
		driver.get("http://eliasnogueira.com/selenium/exercicios/lista/actions_menu/");
		
		Actions action = new Actions(driver);
		By button = By.cssSelector(".dropbtn");
		
		action.moveToElement(driver.findElement(button)).build().perform();
		
		driver.findElement(By.linkText("Link 2")).click();
		
		Alert alerta = driver.switchTo().alert();
		assertEquals(alerta.getText(), "Voce clicou no Link 2");
		alerta.accept();
		
	}

}
