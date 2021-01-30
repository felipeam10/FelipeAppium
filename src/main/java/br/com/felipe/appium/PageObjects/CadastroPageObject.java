package br.com.felipe.appium.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class CadastroPageObject extends PageObjectBase {

	private MobileElement campoNome;
	private MobileElement campoSenha;
	private MobileElement campoConfirmarSenha;
	private MobileElement botaoCadastrar;
	private MobileElement MsgErro;
	private final By erroID;
	private final By campoNomeID;
	private final By campoSenhaID;
	private final By campoConfirmacaoID;
	private final By botaoCadastrarID;
	
	
	public CadastroPageObject(AppiumDriver driver) {
		super(driver);
		erroID = By.id("br.com.alura.aluraesporte:id/erro_cadastro");
		campoNomeID = By.id("br.com.alura.aluraesporte:id/input_nome");
		campoSenhaID = By.id("br.com.alura.aluraesporte:id/input_senha");
		campoConfirmacaoID = By.id("br.com.alura.aluraesporte:id/input_confirmar_senha");
		botaoCadastrarID = By.id("br.com.alura.aluraesporte:id/cadastro_usuario_botao_cadastrar");
	}

	@Override
	public void buscarElementos() {
		
		campoNome = (MobileElement) driver.findElement(campoNomeID);
		campoSenha = (MobileElement) driver.findElement(campoSenhaID);
		campoConfirmarSenha = (MobileElement) driver.findElement(campoConfirmacaoID);
		botaoCadastrar = (MobileElement) driver.findElement(botaoCadastrarID);
	}
	
	private void preencherFormulario(String usuario, String senha, String confirmacaoSenha) {
		
		campoNome.setValue(usuario);
		campoSenha.setValue(senha);
		campoConfirmarSenha.setValue(confirmacaoSenha);
	}

	public LogginPageObject cadastrar(String usuario, String senha, String confirmacaoSenha) {
		
		preencherFormulario(usuario, senha, confirmacaoSenha);
		botaoCadastrar.click();
		return new LogginPageObject(driver);
	}

	public String msgErro() {
		
		By erroID = By.id("br.com.alura.aluraesporte:id/erro_cadastro");
		
		WebDriverWait espera = new WebDriverWait(driver, 10);
		espera.until(ExpectedConditions.presenceOfElementLocated(erroID));
		
		MsgErro = (MobileElement) driver.findElement(erroID);
		return MsgErro.getText();
	}
}
