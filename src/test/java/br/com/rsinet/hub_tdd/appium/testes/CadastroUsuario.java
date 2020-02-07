package br.com.rsinet.hub_tdd.appium.testes;

import java.io.IOException;
import java.net.MalformedURLException;
import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import br.com.rsinet.hub_tdd.appium.pageObject.CadastroUsuarioPage;
import br.com.rsinet.hub_tdd.appium.pageObject.LoginPage;
import br.com.rsinet.hub_tdd.appium.pageObject.PesquisaPelaHome;
import br.rsinet.hub_tdd.appium.suporte.DriverWeb;
import br.rsinet.hub_tdd.appium.suporte.ExtendReport;

@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths = "CadastroUsuario.csv")
public class CadastroUsuario {
	private WebDriver driver;
	private WebDriverWait aguardar;
	private PesquisaPelaHome pesquisa;
	private LoginPage logar;
	private String teste;
	private ExtentTest report;
    static ExtentReports test;
    
    @BeforeClass
    public static void test() {
        test = ExtendReport.setExtent("ReportDeCadastroDeUsuario");
    }

	@Before
	public void BeforeM() throws MalformedURLException, InterruptedException {
		driver = DriverWeb.creatDriver();

	}

	@Test
	public void CadastroUsuarioSucesso(@Param(name = "login") String login, 
			@Param(name = "email") String email,
			@Param(name = "senha") String senha,
			@Param(name = "confirmarSenha") String confirmaSenha,
			@Param(name = "nome") String nome, 
			@Param(name = "sobrenome") String sobrenome,
			@Param(name = "contato") String contato,
			@Param(name = "pais") String pais,
			@Param(name = "estado") String estado,
			@Param(name = "rua") String rua,
			@Param(name = "cidade") String cidade,
			@Param(name = "cep") String cep) throws InterruptedException, IOException {
		report = ExtendReport.createTest("CadastroUsuarioSucesso");
		CadastroUsuarioPage cadastro = new CadastroUsuarioPage(driver);
		
		cadastro.cadastro()
		.digitarLogin(login)
		.digitarEmail(email)
		.digitarSenha(senha)
		.confirmarSenha(confirmaSenha)
		.digitarNome(nome)
		.digitarSobrenome(sobrenome).scroll()
		.digitarTelefone(contato)
		.selecionaPais()
		.digitarEstado(estado)
		.digitarRua(rua)
		.digitarCidade(cidade)
		.digitarCodigoPostal(cep).scroll()
		.enviarFormulario().Expected();
		
		driver.findElement(By.id("com.Advantage.aShopping:id/imageViewMenu")).click();
		String usuarioLogado = driver.findElement(By.id("com.Advantage.aShopping:id/textViewMenuUser")).getText();
		Assert.assertTrue(usuarioLogado.equals(login));
		ExtendReport.statusReported(report, driver, teste);
		teste = "CadastroUsuarioSucesso";
	}

	@Test
	public void CadastroUsuarioFalha(@Param(name = "login") String login, 
			@Param(name = "email") String email,
			@Param(name = "senha") String senha,
			@Param(name = "confirmarSenha") String confirmaSenha,
			@Param(name = "nome") String nome, 
			@Param(name = "sobrenome") String sobrenome,
			@Param(name = "contato") String contato,
			@Param(name = "pais") String pais,
			@Param(name = "estado") String estado,
			@Param(name = "rua") String rua,
			@Param(name = "cidade") String cidade,
			@Param(name = "cep") String cep) throws InterruptedException, IOException {
		report = ExtendReport.createTest("CadastroUsuarioFalha");
		CadastroUsuarioPage cadastro = new CadastroUsuarioPage(driver);
		cadastro.cadastro()
		.digitarLogin(login)
		.digitarEmail(email)
		.digitarSenha(senha)
		.confirmarSenha(confirmaSenha)
		.digitarNome(nome)
		.digitarSobrenome(sobrenome).scroll()
		.digitarTelefone(contato)
		.selecionaPais()
		.digitarEstado(estado)
		.digitarRua(rua)
		.digitarCidade(cidade)
		.digitarCodigoPostal(cep).scroll()
		.enviarFormulario().Expected();

		// Valida se o usuario está logado
		driver.findElement(By.xpath(
				"//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout[1]/android.widget.RelativeLayout/android.widget.ImageView[1]"))
				.click();
		String usuarioLogado = driver.findElement(By.id("com.Advantage.aShopping:id/textViewMenuUser")).getText();
		Assert.assertFalse(usuarioLogado.equals(login));
		ExtendReport.statusReported(report, driver, teste);
		teste = "CadastroUsuarioFalha";
	}

	@After
	public void afterM() {
		ExtendReport.quitExtent(test);
		DriverWeb.fecharDriver();
	}

}
