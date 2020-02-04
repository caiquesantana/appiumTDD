package br.com.rsinet.hub_tdd.appium.testes;

import java.net.MalformedURLException;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import br.com.rsinet.hub_tdd.appium.pageObject.PesquisaPelaHome;
import br.rsinet.hub_tdd.appium.suporte.DriverWeb;

public class BuscaPelaHomePage {
	private WebDriver driver;
	
	@Before
	public void setUp() throws MalformedURLException {
		driver = DriverWeb.creatDriver();
	}
	
	@Test
	public void TesteHomePageSucesso() {
		PesquisaPelaHome pesquisa = new PesquisaPelaHome(driver);
		pesquisa.categoriaLaptop().produtoSelecionado();
		String nomeProduto = driver.findElement(By.id("com.Advantage.aShopping:id/textViewProductName")).getText();
		Assert.assertTrue(nomeProduto.equals("HP CHROMEBOOK 14 G1(ENERGY STAR)"));
		
	}
	
	@Test
	public void TesteHomePageFalha() {
		PesquisaPelaHome pesquisa = new PesquisaPelaHome(driver);
		
	}
	
	@After
	public void afterM() {
		//DriverWeb.fecharDriver();

	}
}
