package br.com.autoglass.frameworkSelenium.Test;

import static br.com.autoglass.frameworkSelenium.PageObjects.ByCss.btnEntrar;
import static br.com.autoglass.frameworkSelenium.PageObjects.ByCss.txbLogin;
import static br.com.autoglass.frameworkSelenium.PageObjects.ByCss.txbSenha;
import static org.junit.Assert.assertEquals;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import br.com.autoglass.frameworkSelenium.configuration.Browser;
import br.com.autoglass.frameworkSelenium.configuration.HttpStatusCodeSupplier;
import br.com.autoglass.frameworkSelenium.configuration.WebDriverConfig;
import br.com.autoglass.frameworkSelenium.screenShot.ScreenshotTaker;

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
    	
    	navegador.setImputText(txbLogin, "qualidade.ti");
    	navegador.setImputText(txbSenha, "megazord");
    	
    	navegador.findElementWithTimeout(btnEntrar).click();;
    }
}