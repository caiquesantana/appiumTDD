package br.com.rsinet.hub_tdd.appium.pageObject;

import org.openqa.selenium.By;

import br.com.rsinet.hub_tdd.appium.utility.Constante;
import br.com.rsinet.hub_tdd.appium.utility.ExcelUtils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class CadastroUsuarioPage {
	private AndroidDriver<MobileElement> driver;

	public CadastroUsuarioPage(AndroidDriver<MobileElement> driver) {
		this.driver = driver;
	}

	public CadastroUsuarioPage cadastro(String cadastro) {
		driver.findElement(By.id("com.Advantage.aShopping:id/imageViewMenu")).click();
		driver.findElement(By.id("com.Advantage.aShopping:id/textViewMenuUser")).click();
		driver.findElement(By.id("com.Advantage.aShopping:id/textViewDontHaveAnAccount")).click();
		return this;

	}

	public CadastroUsuarioPage digitarLogin(String login) {
		driver.findElement(By.xpath(
				"//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.RelativeLayout/android.widget.EditText"))
				.sendKeys(login);
		return this;
	}

	public CadastroUsuarioPage digitarEmail(String email) {
		driver.findElement(By.xpath(
				"//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.RelativeLayout/android.widget.EditText"))
				.sendKeys(email);
		return this;
	}

	public CadastroUsuarioPage digitarSenha(String senha) {

		driver.findElement(By.xpath(
				"//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.RelativeLayout/android.widget.EditText"))
				.sendKeys(senha);
		return this;
	}

	public CadastroUsuarioPage confirmarSenha(String confirmaSenha) {
		driver.findElement(By.xpath(
				"//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[4]/android.widget.RelativeLayout/android.widget.EditText"))
				.sendKeys(confirmaSenha);
		return this;
	}

	public CadastroUsuarioPage digitarNome(String nome) {
		driver.findElement(By.xpath(
				"//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.RelativeLayout[1]/android.widget.EditText"))
				.sendKeys(nome);
		return this;
	}

	public CadastroUsuarioPage digitarSobrenome(String sobreNome) {
		driver.findElement(By.xpath(
				"//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.EditText"))
				.sendKeys(sobreNome);
		return this;
	}

	public CadastroUsuarioPage digitarTelefone(String contato) {
		driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.EditText"))
						.sendKeys(contato);
		return this;
	}

	public CadastroUsuarioPage selecionaPais(String nacionalidade) {
		driver.findElement(By.id("com.Advantage.aShopping:id/textViewCountries")).click();
		driver.findElement(By.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[9]"))
				.click();
		return this;
	}
	public CadastroUsuarioPage digitarEstado(String estado) {
		driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.RelativeLayout/android.widget.EditText"))
							.sendKeys(estado);
	return this;
	}
	
	public CadastroUsuarioPage digitarRua(String rua) {
		driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.EditText"))
							.sendKeys(rua);
	
	return this;
	}
	
	public CadastroUsuarioPage digitarCidade(String cidade) {
		driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.RelativeLayout[1]/android.widget.EditText"))
							.sendKeys(cidade);
	
	return this;
	}

	public CadastroUsuarioPage digitarCodigoPostal(String cep) {
		driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.RelativeLayout[2]/android.widget.EditText"))
							.sendKeys(cep);
	return this;
	}
	public CadastroUsuarioPage enviarFormulario() {
		driver.findElement(By.id("com.Advantage.aShopping:id/buttonRegister")).click();
		return this;
		
	}
}