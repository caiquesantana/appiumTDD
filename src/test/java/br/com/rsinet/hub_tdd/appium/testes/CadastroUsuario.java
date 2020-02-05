package br.com.rsinet.hub_tdd.appium.testes;

import java.net.MalformedURLException;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.core.annotation.Order;

import br.com.rsinet.hub_tdd.appium.pageObject.CadastroUsuarioPage;
import br.rsinet.hub_tdd.appium.suporte.DriverWeb;
import br.rsinet.hub_tdd.appium.suporte.Screenshot;

public class CadastroUsuario {
	private WebDriver driver;
	WebDriverWait aguardar;

	@Before
	public void BeforeM() throws MalformedURLException, InterruptedException {
		driver = DriverWeb.creatDriver();

	}
	@Test
	public void CadastroUsuarioSucesso() throws InterruptedException {
		CadastroUsuarioPage cadastro = new CadastroUsuarioPage(driver);
		cadastro.cadastro()
		.digitarLogin("aqaOliveira")
		.digitarEmail("abcd@email.com")
		.digitarSenha("Abcdc1")
		.confirmarSenha("Abcdc1")
		.digitarNome("Abcsdc")
		.digitarSobrenome("asefaxc").scroll()
		.digitarTelefone("34465768")
		.selecionaPais()
		.digitarEstado("São Paulo")
		.digitarRua("rua 1")
		.digitarCidade("osasco")
		.digitarCodigoPostal("093983-090")
		.scroll().enviarFormulario().Expected();
		driver.findElement(By.id("com.Advantage.aShopping:id/imageViewMenu")).click();
		String usuarioLogado = driver.findElement(By.id("com.Advantage.aShopping:id/textViewMenuUser")).getText();
		Assert.assertTrue(usuarioLogado.equals("aqaOliveira"));
	}

	@Test
	public void CadastroReprovou() throws InterruptedException {
		CadastroUsuarioPage cadastro = new CadastroUsuarioPage(driver);
		cadastro
		.cadastro()
		.digitarLogin("cauasantana")
		.digitarEmail("abcd@email.com")
		.digitarSenha("Abcdc1")
		.confirmarSenha("Abcdc1")
		.digitarNome("Abcsdc")
		.digitarSobrenome("asefaxc").scroll()
		.digitarTelefone("34465768")
		.selecionaPais()
		.digitarEstado("São Paulo")
		.digitarRua("rua 1")
		.digitarCidade("osasco")
		.digitarCodigoPostal("093983-090")
		.scroll().enviarFormulario().Expected();
		
		//Valida se o usuario está logado
		driver.findElement(By.xpath(
				"//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout[1]/android.widget.RelativeLayout/android.widget.ImageView[1]"))
				.click();
		String usuarioLogado = driver.findElement(By.id("com.Advantage.aShopping:id/textViewMenuUser")).getText();
		Assert.assertFalse(usuarioLogado.equals("cauasantana"));
	}

	@After
	public void afterM () {

		DriverWeb.fecharDriver();
	}

}
