package esperas;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import utils.BaseTest;

public class EsperaExplicitaTest extends BaseTest {
	
	@Test
	public void loginSucesso() {
		driver.get("http://eliasnogueira.com/selenium/exercicios/lista/ajax_loading/");
		
		driver.findElement(By.id("username")).sendKeys("demo");
		
		driver.findElement(By.id("password")).sendKeys("demo");
		
		driver.findElement(By.id("login")).click();
		
		By elemento = By.id("message");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(elemento));
		assertEquals(driver.findElement(elemento).getText(), "Voce efetuou o login com sucesso!");
	}
	
	@Test
	public void loginInvalido() {
		driver.get("http://eliasnogueira.com/selenium/exercicios/lista/ajax_loading/");
		
		driver.findElement(By.id("username")).sendKeys("demo");
		
		driver.findElement(By.id("password")).sendKeys("qualquercoisa");
		
		driver.findElement(By.id("login")).click();
		
		By elemento = By.id("message");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(elemento));
		assertEquals(driver.findElement(elemento).getText(), "Usuario ou senhas invalidos.");
	}

}
