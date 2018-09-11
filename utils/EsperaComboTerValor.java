package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;

public class EsperaComboTerValor implements ExpectedCondition {
	
	private WebDriver driver;
	private By combo;
	
	public EsperaComboTerValor(By combo) {
		this.combo = combo;
	}

	public Object apply(Object o) {
		driver = (WebDriver) o;
	
		return new Select (driver.findElement(combo)).
				getFirstSelectedOption().isSelected();
	}
}
