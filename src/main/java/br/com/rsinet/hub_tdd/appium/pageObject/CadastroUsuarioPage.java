package br.com.rsinet.hub_tdd.appium.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;

public class CadastroUsuarioPage {
	private WebDriver driver;
	WebDriverWait aguardar;
	TouchAction actions;

	public CadastroUsuarioPage(WebDriver driver) {
		this.driver = driver;
		aguardar = new WebDriverWait (driver, 5);
		actions = new TouchAction((PerformsTouchActions) driver);
	}

	public CadastroUsuarioPage cadastro() {
		driver.findElement(By.id("com.Advantage.aShopping:id/imageViewMenu")).click();
		driver.findElement(By.id("com.Advantage.aShopping:id/textViewMenuUser")).click();
		driver.findElement(By.id("com.Advantage.aShopping:id/textViewDontHaveAnAccount")).click();
		return this;

	}
	public CadastroUsuarioPage digitarLogin(String login) {
		WebElement usuario = driver.findElement(By.xpath(
				"//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.RelativeLayout/android.widget.EditText"));
		usuario.click();
		usuario.sendKeys(login);
		return this;
	}

	public CadastroUsuarioPage digitarEmail(String email) {
		WebElement Email = driver.findElement(By.xpath(
				"//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.RelativeLayout/android.widget.EditText"));
		Email.click();
		Email.sendKeys(email);
		return this;
	}

	public CadastroUsuarioPage digitarSenha(String senha) {
		WebElement Senha = driver.findElement(By.xpath(
				"//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.RelativeLayout/android.widget.EditText"));
				Senha.click();
				Senha.sendKeys(senha);
		return this;
	}
	public CadastroUsuarioPage confirmarSenha(String confirmaSenha) {
		WebElement ConfirmaSenha = driver.findElement(By.xpath(
				"//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[4]/android.widget.RelativeLayout/android.widget.EditText"));
				ConfirmaSenha.click();
				ConfirmaSenha.sendKeys(confirmaSenha);
		return this;
	}
	public CadastroUsuarioPage digitarNome(String nome) {
		WebElement Nome = driver.findElement(By.xpath(
				"//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.RelativeLayout[1]/android.widget.EditText"));
		Nome.click();
		Nome.sendKeys(nome);
		return this;
	}
	public CadastroUsuarioPage digitarSobrenome(String sobreNome) {
		WebElement SobreNome = driver.findElement(By.xpath(
				"//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.RelativeLayout[2]/android.widget.EditText"));
		SobreNome.click();
		SobreNome.sendKeys(sobreNome);
		return this;
	}
	public CadastroUsuarioPage digitarTelefone(String contato) {
		WebElement Telefone = driver.findElement(By.xpath(
				"//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.EditText"));
		Telefone.click();
		Telefone.sendKeys(contato);
		return this;
	}

	public CadastroUsuarioPage selecionaPais() {
		driver.findElement(By.id("com.Advantage.aShopping:id/textViewCountries")).click();
		driver.findElement(By.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[9]"))
				.click();
		return this;
	}

	public CadastroUsuarioPage digitarEstado(String estado) {
		WebElement Estado = driver.findElement(By.xpath(
				"//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.RelativeLayout/android.widget.EditText"));
		Estado.click();
		Estado.sendKeys(estado);
		return this;
	}

	public CadastroUsuarioPage digitarRua(String rua) {
		WebElement Endereco = driver.findElement(By.xpath(
				"//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.EditText"));
		Endereco.click();
		Endereco.sendKeys(rua);
		return this;
	}

	public CadastroUsuarioPage digitarCidade(String cidade) {
		WebElement Cidade = driver.findElement(By.xpath(
				"//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.RelativeLayout[1]/android.widget.EditText"));
		Cidade.click();
		Cidade.sendKeys(cidade);
		return this;
	}

	public CadastroUsuarioPage digitarCodigoPostal(String cep) {
		WebElement Cep = driver.findElement(By.xpath(
				"//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.RelativeLayout[2]/android.widget.EditText"));
		Cep.click();
		Cep.sendKeys(cep);
		return this;
	}

	public CadastroUsuarioPage enviarFormulario() {
		driver.findElement(By.id("com.Advantage.aShopping:id/buttonRegister")).click();
		return this;
	}

	public CadastroUsuarioPage scroll() {
		actions.press(PointOption.point(1042, 1694)).moveTo(PointOption.point(1063, 403)).release().perform();
		return this;
	}

	public CadastroUsuarioPage Expected() throws InterruptedException {
		aguardar.until(ExpectedConditions.elementToBeClickable(By.id("com.Advantage.aShopping:id/imageViewMenu")));
		return this;
	}
}