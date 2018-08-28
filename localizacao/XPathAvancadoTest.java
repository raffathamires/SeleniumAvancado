package localizacao;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import utils.BaseTest;

public class XPathAvancadoTest extends BaseTest {
	
	  @Test
	  public void XPathAvancado() {	
		
		  driver.get("http://eliasnogueira.com/selenium/exercicios/lista/css_xpath/");
		  
		  //email
		  WebElement email = driver.findElement(By.xpath("//input[starts-with(@id,'name-')]"));
		  System.out.println("Encontrei email");
		  //senha
		  WebElement repetirSenha = driver.findElement(By.xpath("//input[contains(@id,'-password-')]"));
		  System.out.println("Encontrei repetir senha");
		  
	  }

}
