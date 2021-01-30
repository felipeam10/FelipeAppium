package br.com.felipe.appium.PageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class LogginPageObject extends PageObjectBase {
	
	private MobileElement botaoCadastro;

	public LogginPageObject(AppiumDriver driver) {
		super(driver);
	}
	
	@Override
	public void buscarElementos() {
		
		botaoCadastro =  (MobileElement) driver.findElementById("br.com.alura.aluraesporte:id/login_botao_cadastrar_usuario");
	}

	public CadastroPageObject irParaTelaDeCadastro() {
		botaoCadastro.click();
		return new CadastroPageObject(this.driver);
	}
}
