package br.com.felipe.appium;

import static org.junit.Assert.assertTrue;

import java.net.MalformedURLException;

import org.junit.Test;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import junit.framework.Assert;

public class FeatureCadastro {
	
	@Test
	public void nao_consigo_cadastrar_usuario_com_senhas_que_nao_conferem() {
		AppiumDriver<WebElement> driver = AppiumDriverConfig.Instance().driver;
		
		MobileElement botaoCadastro =  (MobileElement) driver.findElementById("br.com.alura.aluraesporte:id/login_botao_cadastrar_usuario");
		botaoCadastro.click();
		MobileElement campoNome = (MobileElement) driver.findElementById("br.com.alura.aluraesporte:id/input_nome");
		MobileElement campoSenha = (MobileElement) driver.findElementById("br.com.alura.aluraesporte:id/input_senha");
		MobileElement campoConfirmarSenha = (MobileElement) driver.findElementById("br.com.alura.aluraesporte:id/input_confirmar_senha");
		campoNome.setValue("Felipe");
		campoSenha.setValue("123456");
		campoConfirmarSenha.setValue("654321");
		
		MobileElement botaoConfirmarCadastro = (MobileElement) driver.findElementById("br.com.alura.aluraesporte:id/cadastro_usuario_botao_cadastrar");
		botaoConfirmarCadastro.click();
		MobileElement erro = (MobileElement) driver.findElementById("br.com.alura.aluraesporte:id/erro_cadastro");
		Assert.assertEquals("Senhas não conferem", erro.getText());
		driver.navigate().back(); // equivale ao botao voltar do android
	}
	
	@Test
	public void posso_cadastrar_usuarios_com_senhas_que_conferem() throws NoSuchElementException {
		AppiumDriver<WebElement> driver = AppiumDriverConfig.Instance().driver;
		
		MobileElement botaoCadastro =  (MobileElement) driver.findElementById("br.com.alura.aluraesporte:id/login_botao_cadastrar_usuario");
		botaoCadastro.click();
		
		MobileElement campoNome = (MobileElement) driver.findElementById("br.com.alura.aluraesporte:id/input_nome");
		MobileElement campoSenha = (MobileElement) driver.findElementById("br.com.alura.aluraesporte:id/input_senha");
		MobileElement campoConfirmarSenha = (MobileElement) driver.findElementById("br.com.alura.aluraesporte:id/input_confirmar_senha");
		campoNome.setValue("Felipe");
		campoSenha.setValue("123456");
		campoConfirmarSenha.setValue("123456");
		
		MobileElement botaoConfirmarCadastro = (MobileElement) driver.findElementById("br.com.alura.aluraesporte:id/cadastro_usuario_botao_cadastrar");
		botaoConfirmarCadastro.click();

		MobileElement botaoLogar = (MobileElement) driver.findElementById("br.com.alura.aluraesporte:id/login_botao_logar");
		
	}
}
