package br.com.rsinet.hub_tdd.appium.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PesquisaPelaHome {
	WebDriver driver;

	public PesquisaPelaHome(WebDriver driver) {
		this.driver = driver;
	}
	public PesquisaPelaHome categoriaLaptop () {
		driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.support.v7.widget.RecyclerView/android.widget.RelativeLayout[1]/android.widget.ImageView")).click();
		return this;
	}
	
	
}
