package localizacao;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import utils.BaseTest;

public class CSSAvancadoTest extends BaseTest {	
	
  @Test
  public void cssSelectorAvancado() {	
	
	  driver.get("http://eliasnogueira.com/selenium/exercicios/lista/css_xpath/");
	  
	  //email
	  WebElement email = driver.findElement(By.cssSelector("input[id^='name-']"));
	  System.out.println("Encontrei email");
	  //senha
	  WebElement senha = driver.findElement(By.cssSelector("input[id$='-password']"));
	  System.out.println("Encontrei senha");
	  //repetir senha
	  WebElement repetirSenha = driver.findElement(By.cssSelector("input[id*='-password-']"));
	  System.out.println("Encontrei repetir senha");
	  
  }

}
