package br.com.rsinet.hub_tdd.appium.testes;

import java.net.MalformedURLException;
import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import br.com.rsinet.hub_tdd.appium.pageObject.CadastroUsuarioPage;
import br.rsinet.hub_tdd.appium.suporte.DriverWeb;

@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths = "CadastroUsuario.csv")
public class CadastroUsuario {
	private WebDriver driver;
	WebDriverWait aguardar;

	@Before
	public void BeforeM() throws MalformedURLException, InterruptedException {
		driver = DriverWeb.creatDriver();

	}

	//@Test
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
			@Param(name = "cep") String cep) throws InterruptedException {
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
			@Param(name = "cep") String cep) throws InterruptedException {
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
	}

	@After
	public void afterM() {

		DriverWeb.fecharDriver();
	}

}
