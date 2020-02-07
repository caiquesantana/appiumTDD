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
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import br.com.rsinet.hub_tdd.appium.pageObject.LoginPage;
import br.com.rsinet.hub_tdd.appium.pageObject.PesquisaPelaHome;
import br.rsinet.hub_tdd.appium.suporte.DriverWeb;
import br.rsinet.hub_tdd.appium.suporte.ExtendReport;
import br.rsinet.hub_tdd.appium.suporte.Screenshot;

public class BuscaPelaHomePage {
	private WebDriver driver;
	private PesquisaPelaHome pesquisa;
	private LoginPage logar;
	private String teste;
	private ExtentTest report;
    static ExtentReports test;
	
    @BeforeClass
    public static void test() {
        test = ExtendReport.setExtent("ReportDeBuscaPaginaInicial");
    }
    
	@Before
	public void setUp() throws MalformedURLException {
		driver = DriverWeb.creatDriver();
	}
	
	@Test
	public void TesteHomePageSucesso() throws IOException {
		report = ExtendReport.createTest("TesteHomePageSucesso");
		pesquisa = new PesquisaPelaHome(driver);
		pesquisa.categoriaLaptop().produtoSelecionado();
		String nomeProduto = driver.findElement(By.id("com.Advantage.aShopping:id/textViewProductName")).getText();
		Assert.assertTrue(nomeProduto.equals("HP CHROMEBOOK 14 G1(ENERGY STAR)"));
		ExtendReport.statusReported(report, driver, teste);
		teste = "TesteHomePageSucesso";
		
	}
	
	@SuppressWarnings("unlikely-arg-type")
	@Test
	public void TesteHomePageFalha() throws IOException {
	    report = ExtendReport.createTest("TesteHomePageFalha"); 
	    
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
		ExtendReport.statusReported(report, driver, teste);
		teste = "TesteHomePageFalha";
		
	}
	@After
	public void afterM() {
		ExtendReport.quitExtent(test);
	DriverWeb.fecharDriver();

	}
}
