package br.com.felipe.appium;

import static org.junit.Assert.assertTrue;

import java.net.MalformedURLException;

import org.junit.Test;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import br.com.felipe.appium.PageObjects.CadastroPageObject;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import junit.framework.Assert;

public class FeatureCadastro {
	
	@Test
	public void nao_consigo_cadastrar_usuario_com_senhas_que_nao_conferem() {
		AppiumDriver<WebElement> driver = AppiumDriverConfig.Instance().driver;
		
		MobileElement botaoCadastro =  (MobileElement) driver.findElementById("br.com.alura.aluraesporte:id/login_botao_cadastrar_usuario");
		botaoCadastro.click();
		
		CadastroPageObject telaCadastro = new CadastroPageObject(driver);
		telaCadastro.buscarElementos();
		telaCadastro.cadastrar("Felipe", "123456", "654321");
		Assert.assertEquals("Senhas não conferem", telaCadastro.msgErro());
		driver.navigate().back(); // equivale ao botao voltar do android
	}
	
	@Test
	public void posso_cadastrar_usuarios_com_senhas_que_conferem() throws NoSuchElementException {
		AppiumDriver<WebElement> driver = AppiumDriverConfig.Instance().driver;
		
		MobileElement botaoCadastro =  (MobileElement) driver.findElementById("br.com.alura.aluraesporte:id/login_botao_cadastrar_usuario");
		botaoCadastro.click();
		
		CadastroPageObject telaCadastro = new CadastroPageObject(driver);
		telaCadastro.buscarElementos();
		telaCadastro.cadastrar("Felipe", "123456", "123456");
		
		MobileElement botaoLogar = (MobileElement) driver.findElementById("br.com.alura.aluraesporte:id/login_botao_logar");
		
	}
}
