package esperas;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import utils.BaseTest;
import utils.EsperaPorDoisElementos;

public class EsperaCustomizadaTest extends BaseTest {
	
	@Test
	public void passeioEscola() {
		driver.get("http://eliasnogueira.com/selenium/exercicios/lista/ajax_show/");
		
		driver.findElement(By.name("nome_aluno")).sendKeys("demo");
		
		driver.findElement(By.name("email_aluno")).sendKeys("demo@test.com");
		
		Select idade = new Select(driver.findElement(By.id("idade")));
		idade.selectByVisibleText("Menor que 13 anos");
		
		By nomePais = By.name("nome_pais");
		By emailPais = By.name("email_pais");
		
		wait.until(new EsperaPorDoisElementos(nomePais, emailPais));
		
		driver.findElement(nomePais).sendKeys("Maria");
		driver.findElement(emailPais).sendKeys("maria@teste.com");
		
	}

}
