package br.com.autoglass.frameworkSelenium.Test;

import static org.junit.Assert.*;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import br.com.autoglass.frameworkSelenium.PageObjects.CssSelector;
import br.com.autoglass.frameworkSelenium.PageObjects.LoginIT;
import br.com.autoglass.frameworkSelenium.configuration.Browser;
import br.com.autoglass.frameworkSelenium.configuration.HttpStatusCodeSupplier;
import br.com.autoglass.frameworkSelenium.configuration.WebDriverConfig;
import br.com.autoglass.frameworkSelenium.loadingPageFactory.LoadingPageFactory;
import br.com.autoglass.frameworkSelenium.screenShot.ScreenshotTaker;

import static br.com.autoglass.frameworkSelenium.PageObjects.CssSelector.txbLogin;
import static br.com.autoglass.frameworkSelenium.PageObjects.CssSelector.btnEntrar;
import static br.com.autoglass.frameworkSelenium.PageObjects.CssSelector.txbSenha;

/**
 * Pagina de testes do framework
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = WebDriverConfig.class)
@TestExecutionListeners(listeners = {ScreenshotTaker.class, 
									DependencyInjectionTestExecutionListener.class})
public class LoginTest
{
	private Browser navegador;
	
	@Inject
	private void setWebDriver(WebDriver navegador){
		this.navegador = new Browser(navegador);
	}
	
	/*@Inject
	private URI baseUrl;*/
	
	@Inject
	private HttpStatusCodeSupplier httpStatusCodeSuplier;
	
    @Test
    public void teste() throws Exception{
    	navegador.get("/login");
    	assertEquals(200, httpStatusCodeSuplier.get());
    }
    
    @Test
    public void logarTest(){
    	navegador.get("/login");
    	/*LoginIT loginPage = LoadingPageFactory.get(navegador, LoginIT.class);
    	loginPage.Logar("qualidade.ti", "megazord");*/
    	
    	navegador.findElementwithTimeout(txbLogin).sendKeys("qualidade.ti");
    	navegador.findElementwithTimeout(txbSenha).sendKeys("megazord");
    	
    	navegador.findElement(btnEntrar).click();;
    }
}