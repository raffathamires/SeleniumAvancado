package manipulacao;

import static org.testng.Assert.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import utils.BaseTest;

public class ManipulacaoElementosTest extends BaseTest {
	
	@Test
	public void manipulacaoElementos() {
		driver.get("http://eliasnogueira.com/selenium/exercicios/lista/elementos_html/");
		
		WebElement nome = driver.findElement(By.id("name1"));
		nome.sendKeys("Raffaela");
		
		WebElement sobrenome = driver.findElement(By.id("name2"));
		sobrenome.sendKeys("Monteiro");
		
		WebElement sexo = driver.findElement(By.cssSelector("input[value='Mulher']"));
		sexo.click();
		
		WebElement carne = driver.findElement(By.id("value1"));
		carne.click();
		
		WebElement frango = driver.findElement(By.id("value2"));
		frango.click();
		
		WebElement pizza = driver.findElement(By.id("value3"));
		pizza.click();
		
		WebElement outraComida = driver.findElement(By.id("txtarea"));
		outraComida.sendKeys("Churrasco");
		
		Select educacao = new Select(driver.findElement(By.name("education")));
		educacao.selectByVisibleText("Graduado");
		
		Select parteDia = new Select(driver.findElement(By.id("dia")));
		parteDia.selectByVisibleText("Manhã");
		parteDia.selectByVisibleText("Noite");
		
		WebElement enviarDados = driver.findElement(By.name("send"));
		enviarDados.click();
		
		//validacao dos resultados
		
		assertEquals(driver.findElement(By.id("nome")).getText(), "Olá, Raffaela Monteiro");
		assertEquals(driver.findElement(By.id("sexo")).getText(), "Você é Mulher");
		assertEquals(driver.findElement(By.id("comida")).getText(), "E você gosta de Carne Frango Pizza");
		assertEquals(driver.findElement(By.id("outra_comida")).getText(), "Você também gosta de: Churrasco");
		assertEquals(driver.findElement(By.id("parte_favorita")).getText(), "Sua parte favorita do dia é: Manhã Noite");
		assertEquals(driver.findElement(By.id("instrucao")).getText(), "Seu grau de instrução é: Graduado");
		
	}

}
