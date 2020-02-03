package br.com.rsinet.hub_tdd.appium.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class BuscaLupaPage {
	WebDriver driver;
	
	public BuscaLupaPage(WebDriver driver) {
		this.driver = driver;
	}

	public BuscaLupaPage clicarLupa() {
		driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.ImageView")).click();
		return this;
	}
	public BuscaLupaPage campoDePesquisa (String pesquisa) {
		driver.findElement(By.id("com.Advantage.aShopping:id/editTextSearch")).sendKeys(pesquisa);
		return this;
	}
	public BuscaLupaPage selecionaProduto () {
		driver.findElement(By.id("com.Advantage.aShopping:id/imageViewProduct")).click();
		return this;
	}
}
