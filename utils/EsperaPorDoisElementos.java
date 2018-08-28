package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;

public class EsperaPorDoisElementos implements ExpectedCondition {
	private WebDriver driver;
	private By elemento1, elemento2;
	
	public EsperaPorDoisElementos(By elemento1, By elemento2) {
		this.elemento1 = elemento1;
		this.elemento2 = elemento2;
	}
	
	public Object apply(Object o) {
		driver = (WebDriver) o;
		return driver.findElement(elemento1).isDisplayed() &&
				driver.findElement(elemento2).isDisplayed();
	}
	

}
