package br.com.rsinet.hub_tdd.appium.testes;

import java.net.MalformedURLException;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import br.com.rsinet.hub_tdd.appium.pageObject.LoginPage;
import br.com.rsinet.hub_tdd.appium.pageObject.PesquisaPelaHome;
import br.rsinet.hub_tdd.appium.suporte.DriverWeb;

public class BuscaPelaHomePage {
	private WebDriver driver;
	PesquisaPelaHome pesquisa;
	LoginPage logar;
	
	@Before
	public void setUp() throws MalformedURLException {
		driver = DriverWeb.creatDriver();
	}
	
	@Test
	public void TesteHomePageSucesso() {
		pesquisa = new PesquisaPelaHome(driver);
		pesquisa.categoriaLaptop().produtoSelecionado();
		String nomeProduto = driver.findElement(By.id("com.Advantage.aShopping:id/textViewProductName")).getText();
		Assert.assertTrue(nomeProduto.equals("HP CHROMEBOOK 14 G1(ENERGY STAR)"));
		
	}
	
	@Test
	public void TesteHomePageFalha() {
		pesquisa = new PesquisaPelaHome(driver);
		logar = new LoginPage(driver);
		
		logar.homePage().usuario("cauasantana").password("Caique1").entrar();
		
		pesquisa.categoriaLaptop().produtoSelecionado().addCarrinho();
		WebElement quantidade = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.EditText"));
		quantidade.click();
		quantidade.sendKeys("20");
		pesquisa.confirmarCompra();
		String qtdCarrinho = driver.findElement(By.id("com.Advantage.aShopping:id/textViewCartLength")).getText();
		Assert.assertFalse(qtdCarrinho.equals(quantidade));
		
	}
	@After
	public void afterM() {
		DriverWeb.fecharDriver();

	}
}
