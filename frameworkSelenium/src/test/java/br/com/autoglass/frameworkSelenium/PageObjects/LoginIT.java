package br.com.autoglass.frameworkSelenium.PageObjects;

import static org.junit.Assert.*;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import br.com.autoglass.frameworkSelenium.configuration.HttpStatusCodeSupplier;
import br.com.autoglass.frameworkSelenium.configuration.WebDriverConfig;
import br.com.autoglass.frameworkSelenium.loadingPageFactory.Path;
import br.com.autoglass.frameworkSelenium.loadingPageFactory.Verify;
import br.com.autoglass.frameworkSelenium.screenShot.ScreenshotTaker;

/**
 * Pagina de testes do framework
 *
 */

@Path("http://intranet.autoglass.com.br/homologacao/portal-de-aplicacoes/#/login")
@Verify(title = "Autoglass | Login")
public class LoginIT
{
	@FindBy(css = "input[placeholder=\"Login:\"]")
    private WebElement txbLogin;
	
	@FindBy(css = "input[placeholder=\"Senha:\"]")
	private WebElement txbSenha;
	
	//@FindBy(css = "button[type=\"submit\"]")
	private WebElement btnEntrar;
	
	public void Logar(String usuario, String senha){
		txbLogin.sendKeys(usuario);
		txbSenha.sendKeys(senha);
		
		//btnEntrar.click();
	}

}
