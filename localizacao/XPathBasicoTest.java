package localizacao;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import utils.BaseTest;

public class XPathBasicoTest extends BaseTest {

	@Test
	public void xPathBasico() {
		driver.get("http://eliasnogueira.com/selenium/exercicios/lista/find_elements/");

		//div pai
		WebElement divPai = driver.findElement(By.xpath("//div[@class='divpai border']"));
		System.out.println("Encontrei a div pai");
		//div filho
		WebElement diFilho = driver.findElement(By.xpath("//div[@class='divfilho border']"));
		System.out.println("Encontrei a div filho");
		//div neto 2
		WebElement divNeto1 = driver.findElement(By.xpath("//div[@class='divneto border'][2]"));
		System.out.println("Encontrei a div neto 1");
		//data inicio relatorio
		WebElement dataInicioRelatorio = driver.findElement(By.xpath("//input[@id='dataInicio']"));
		System.out.println("Encontrei a data inicio relatorio");


	}

}
