package alertas;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import utils.BaseTest;

public class AlertasTest extends BaseTest{
	
	@Test
	public void naoPreencheCamposObrigatorio() {
		
		driver.get("http://eliasnogueira.com/selenium/exercicios/lista/alert_confirmation/");
		driver.manage().window().maximize();
		
		driver.findElement(By.name("destinatario")).sendKeys("Raffaela");
		driver.findElement(By.id("obs")).sendKeys("Monteiro");
		driver.findElement(By.name("send")).click();
		
		Alert alerta = driver.switchTo().alert();
		assertEquals(alerta.getText(), "Preencha os campos obrigatórios");
		alerta.accept();
	}
	
	@Test
	public void clickaAlerta() {
		
		driver.get("http://eliasnogueira.com/selenium/exercicios/lista/alert_confirmation_js/");
		driver.manage().window().maximize();
		
		driver.findElement(By.id("alerta")).click();
		
		By elemento = By.className("alertify-message");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(elemento));
		assertEquals(driver.findElement(elemento).getText(), "Este é o exemplo de um alerta!");
		
		driver.findElement(By.id("alertify-ok")).click();
	}

}
