package localizacao;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import utils.BaseTest;

public class CSSBasicoTest extends BaseTest {	
	
  @Test
  public void cssSelectorBasico() {	  
	  driver.get("http://eliasnogueira.com/selenium/exercicios/lista/find_elements/");
	  
	  //div pai
	  WebElement divPai = driver.findElement(By.cssSelector(".divpai.border"));
	  System.out.println("Encontrei a div pai");
	  //div filho
	  WebElement diFilho = driver.findElement(By.cssSelector(".divfilho.border"));
	  System.out.println("Encontrei a div filho");
	  //div neto 1
	  WebElement divNeto1 = driver.findElement(By.cssSelector("body > div > div > div > div > div:nth-child(1)"));
	  System.out.println("Encontrei a div neto 1");
	  //data inicio relatorio
	  WebElement dataInicioRelatorio = driver.findElement(By.cssSelector("#dataInicio"));
	  System.out.println("Encontrei a data inicio relatorio");
	  
  }

}
