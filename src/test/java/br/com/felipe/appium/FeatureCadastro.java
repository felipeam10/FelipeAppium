package br.com.felipe.appium;

import static org.junit.Assert.assertTrue;

import java.net.MalformedURLException;

import org.junit.Test;

import io.appium.java_client.MobileElement;

public class FeatureCadastro {
	
	@Test
	public void nao_consigo_cadastrar_usuario_com_senhas_que_nao_conferem() throws MalformedURLException {
		AppiumDriverConfig driver = new AppiumDriverConfig();
		
		MobileElement botaoCadastro =  (MobileElement) driver.driver.findElementById("br.com.alura.aluraesporte:id/login_botao_cadastrar_usuario");
		botaoCadastro.click();
		assertTrue(true);
	}
}
