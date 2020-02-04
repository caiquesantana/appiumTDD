package br.com.rsinet.hub_tdd.appium.testes;

import java.net.MalformedURLException;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import br.com.rsinet.hub_tdd.appium.pageObject.BuscaLupaPage;
import br.rsinet.hub_tdd.appium.suporte.DriverWeb;

public class BuscaPelaLupasTestes {
	private WebDriver driver;
	
	@Before
	public void setUp() throws MalformedURLException {
		driver = DriverWeb.creatDriver();
		
	}
	
	@Test
	public void TesteLupaSucesso() {
		BuscaLupaPage lupa = new BuscaLupaPage(driver);
		lupa.clicarLupa()
			.campoDePesquisa("HP CHROMEBOOK 14 G1(ENERGY")
			.clicarLupa()
			.selecionaProduto();
		
	String nomeProduto = driver.findElement(By.id("com.Advantage.aShopping:id/textViewProductName")).getText();
	Assert.assertTrue(nomeProduto.equals("HP CHROMEBOOK 14 G1(ENERGY STAR)"));
	}
	
	@Test
	public void TesteLupaFalha() {
		BuscaLupaPage lupa = new BuscaLupaPage(driver);
		lupa.clicarLupa()
			.campoDePesquisa("iphone")
			.clicarLupa();
	String produtoPesquisado = driver.findElement(By.id("com.Advantage.aShopping:id/textViewNoProductsToShow")).getText();
	
	Assert.assertEquals("- No results for \"iphone\" -", produtoPesquisado);
			
	}
	
	@After
	public void afterM() {
		DriverWeb.fecharDriver();
		
	}
}
