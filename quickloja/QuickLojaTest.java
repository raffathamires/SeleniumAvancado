package quickloja;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import utils.BaseTest;
import utils.EsperaComboTerValor;

public class QuickLojaTest extends BaseTest {

	@Test
	public void realizarPedido() {
		driver.get("http://eliasnogueira.com/quickloja/");
		driver.manage().window().maximize();

		// login
		driver.findElement(By.id("usuariologin")).sendKeys("teste");
		driver.findElement(By.id("usuariosenha")).sendKeys("123");
		driver.findElement(By.cssSelector(".btn.btn-medium.btn-primary")).click();
		driver.findElement(By.cssSelector(".dropdown-toggle")).click();

		//novo Pedido
		By novoPedido = By.linkText("Novo pedido");

		wait.until(ExpectedConditions.visibilityOfElementLocated(novoPedido));
		driver.findElement(novoPedido).click();

		driver.findElement(By.id("clientenome")).sendKeys("AD");
		By cliente = By.cssSelector("li[data-value='ADP']");
		wait.withMessage("Produto demorou para aparecer ou nao esta na base de dados.");
		wait.until(ExpectedConditions.visibilityOfElementLocated(cliente));
		driver.findElement(cliente).click();

		By emailCliente = By.id("clienteemail");

		wait.until(ExpectedConditions.visibilityOfElementLocated(emailCliente));
		assertEquals(driver.findElement(emailCliente).getText(), "adp@adp.com");
		assertEquals(driver.findElement(By.id("clientetipo")).getText(), "Pessoa Física");

		driver.findElement(By.linkText("Dados de entrega")).click();

		driver.findElement(By.name("pedidoendereco")).sendKeys("Av Coronel Lucas de Oliveira 1831");
		driver.findElement(By.name("pedidobairro")).sendKeys("Petrópolis");
		driver.findElement(By.name("pedidocep")).sendKeys("90460001");
		driver.findElement(By.name("pedidocidade")).sendKeys("Porto Alegre");
		Select estado = new Select(driver.findElement(By.name("pedidoestado")));
		estado.selectByVisibleText("Rio Grande do Sul");

		driver.findElement(By.linkText("Itens do pedido")).click();

		driver.findElement(By.id("produtonome")).sendKeys("NI");
		By produto1 = By.cssSelector("li[data-value='Nike Model Two']");
		wait.withMessage("Produto demorou para aparecer ou nao esta na base de dados.");
		wait.until(ExpectedConditions.visibilityOfElementLocated(produto1));
		driver.findElement(produto1).click();

		wait.until(new EsperaComboTerValor(By.id("produtocortamanho")));

		By qtdproduto1 = By.id("produtoquantidade");
		wait.until(ExpectedConditions.elementToBeClickable(qtdproduto1));
		driver.findElement(qtdproduto1).sendKeys("2");

		driver.findElement(By.id("adicionar")).click();

		driver.findElement(By.id("produtonome")).sendKeys("NI");
		By produto2 = By.cssSelector("li[data-value='Nike Model Three']");
		wait.withMessage("Produto demorou para aparecer ou nao esta na base de dados.");
		wait.until(ExpectedConditions.elementToBeClickable(produto2));
		driver.findElement(produto2).click();

		wait.until(new EsperaComboTerValor(By.id("produtocortamanho")));

		By qtdproduto2 = By.id("produtoquantidade");
		wait.until(ExpectedConditions.elementToBeClickable(qtdproduto2));
		driver.findElement(qtdproduto2).sendKeys("3");

		driver.findElement(By.id("adicionar")).click();

		assertEquals(driver.findElement(By.id("total")).getText(), "R$ 3398");
		assertEquals(driver.findElement(By.id("desconto")).getText(), "R$ 0,00");
		assertEquals(driver.findElement(By.id("frete")).getText(), "R$ 0");
		assertEquals(driver.findElement(By.id("totalgeral")).getText(), "R$ 3398");

	}

	private void autoCompletar(String item) {
		By selector = By.cssSelector("li[data-value='" + item + "']");
		wait.withMessage("Produto demorou para aparecer ou nao está na base de dados");
		wait.until(ExpectedConditions.elementToBeClickable(selector));
		driver.findElement(selector).click();
	}

	private void validaDadosTabela(String textoEsperado, String corTamanho, String valor, String quantidade,
			String subTotal) {
		int totalLinhas = driver.findElements(By.xpath("//tbody[@id='listaItens']/tr")).size();
		String textoProduto;
		int linha = 0;
		for (int i = 1; i <= totalLinhas; i++) {
			textoProduto = driver
					.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr[" + i + "]/td[2]")).getText();
			if (textoProduto.equals(textoEsperado)) {
				linha = i;
				break;
			}
		}
		assertEquals(driver.findElement(By.xpath("//tr[" + linha + "]/td[3]")).getText(), "corTamanho");
		assertEquals(driver.findElement(By.xpath("//tr[" + linha + "]/td[3]")).getText(), "valor");
		assertEquals(driver.findElement(By.xpath("//tr[" + linha + "]/td[3]")).getText(), "quantidade");
		assertEquals(driver.findElement(By.xpath("//tr[" + linha + "]/td[3]")).getText(), "subTotal");

	}
}
