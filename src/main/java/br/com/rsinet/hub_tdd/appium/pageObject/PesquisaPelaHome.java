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
	public PesquisaPelaHome produtoSelecionado() {
		driver.findElement(By.xpath("//android.widget.RelativeLayout[@content-desc=\"Laptops\"]/android.widget.LinearLayout/android.widget.GridView/android.widget.RelativeLayout[1]/android.widget.TextView[1]")).click();
		return this;
	}
//	public PesquisaPelaHome quantidade () {
//		WebElement qtd = driver.findElement(By.id("com.Advantage.aShopping:id/textViewProductQuantity"));
//		qtd.click();
//		driver.findElement(By.id("com.Advantage.aShopping:id/textViewProductQuantity")).click();
//		qtd.sendKeys("11");
//		driver.findElement(By.id("com.Advantage.aShopping:id/textViewApply")).click();
//		driver.findElement(By.id("com.Advantage.aShopping:id/buttonProductAddToCart")).click();
//		return this;
//	}
//	public PesquisaPelaHome credenciais () {
//		//credenciais necessaria para add ao carrinho
//		driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout[2]/android.widget.RelativeLayout[3]/android.widget.EditText")).sendKeys("cauasantana");
//		driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout[2]/android.widget.RelativeLayout[4]/android.widget.EditText")).sendKeys("Caique1");
//		driver.findElement(By.id("com.Advantage.aShopping:id/buttonLogin")).click();
//		return this;
//	}
	
}

