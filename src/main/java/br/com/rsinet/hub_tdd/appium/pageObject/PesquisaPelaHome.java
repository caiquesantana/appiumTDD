package br.com.rsinet.hub_tdd.appium.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PesquisaPelaHome {
	WebDriver driver;

	public PesquisaPelaHome(WebDriver driver) {
		this.driver = driver;
	}
	public PesquisaPelaHome categoriaLaptop () {
		driver.findElement(By.xpath("//android.widget.LinearLayout/android.support.v7.widget.RecyclerView/android.widget.RelativeLayout[1]/android.widget.ImageView")).click();
		return this;
	}
	public PesquisaPelaHome produtoSelecionado(String produto) {
		String equipamento = driver.findElement(By.id("com.Advantage.aShopping:id/textViewProductName")).sendKeys(produto);
		return this;
	}
	
	
}
