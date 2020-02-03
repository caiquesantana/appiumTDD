package br.com.rsinet.hub_tdd.appium.testes;

import java.net.MalformedURLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import br.com.rsinet.hub_tdd.appium.pageObject.BuscaLupaPage;
import br.rsinet.hub_tdd.appium.suporte.DriverWeb;

public class BuscaPelaLupasTestes {
	private WebDriver driver;
	
	@Before
	public void beforeM() throws MalformedURLException {
		driver = DriverWeb.creatDriver();
	}
	
	@Test
	public void TesteLupaSucesso() {
		BuscaLupaPage lupa = new BuscaLupaPage(driver);
		lupa.clicarLupa()
			.campoDePesquisa("HP ZBOOK 17 G2 MOBILE")
			.clicarLupa()
			.selecionaProduto();
	}
	@After
	public void afterM() {
		//SDriverWeb.fecharDriver();
		
	}
}
