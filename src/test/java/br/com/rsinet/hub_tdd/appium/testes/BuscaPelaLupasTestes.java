package br.com.rsinet.hub_tdd.appium.testes;

import java.io.IOException;
import java.net.MalformedURLException;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import br.com.rsinet.hub_tdd.appium.pageObject.BuscaLupaPage;
import br.com.rsinet.hub_tdd.appium.pageObject.LoginPage;
import br.com.rsinet.hub_tdd.appium.pageObject.PesquisaPelaHome;
import br.rsinet.hub_tdd.appium.suporte.DriverWeb;
import br.rsinet.hub_tdd.appium.suporte.ExtentReport;

public class BuscaPelaLupasTestes {
	private WebDriver driver;
	private PesquisaPelaHome pesquisa;
	private LoginPage logar;
	private String teste;
	private ExtentTest report;
    static ExtentReports test;
    
    @BeforeClass
    public static void test() {
        test = ExtentReport.setExtent("PesquisaPelaLupa");
    }
	
	@Before
	public void setUp() throws MalformedURLException {
		driver = DriverWeb.creatDriver();
		
	}
	
	@Test
	public void TesteLupaSucesso() throws IOException {
		report = ExtentReport.createTest("TesteLupaSucesso");
		BuscaLupaPage lupa = new BuscaLupaPage(driver);
		lupa.clicarLupa()
			.campoDePesquisa("HP CHROMEBOOK 14 G1(ENERGY")
			.clicarLupa()
			.selecionaProduto();
		
	String nomeProduto = driver.findElement(By.id("com.Advantage.aShopping:id/textViewProductName")).getText();
	Assert.assertTrue(nomeProduto.equals("HP CHROMEBOOK 14 G1(ENERGY STAR)"));
	ExtentReport.statusReported(report, driver, teste);
	teste = "TesteLupaSucesso";
	}
	
	@Test
	public void TesteLupaFalha() throws IOException {
		report = ExtentReport.createTest("TesteLupaFalha");
		BuscaLupaPage lupa = new BuscaLupaPage(driver);
		lupa.clicarLupa()
			.campoDePesquisa("iphone")
			.clicarLupa();
	String produtoPesquisado = driver.findElement(By.id("com.Advantage.aShopping:id/textViewNoProductsToShow")).getText();
	
	Assert.assertEquals("- No results for \"iphone\" -", produtoPesquisado);
	ExtentReport.statusReported(report, driver, teste);
	teste = "TesteLupaFalha";
	}
	
	@After
	public void afterMethod() {
		DriverWeb.fecharDriver();
	}
	@AfterTest
	public void afterM() {
		ExtentReport.quitExtent(test);
	}
}
