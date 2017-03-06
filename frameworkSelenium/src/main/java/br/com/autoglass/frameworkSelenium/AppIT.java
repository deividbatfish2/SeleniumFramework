package br.com.autoglass.frameworkSelenium;

import static org.junit.Assert.*;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

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
public class AppIT
{
	@Inject
	private WebDriver navegador;
	
	/*@Inject
	private URI baseUrl;*/
	
	@Inject
	private HttpStatusCodeSupplier httpStatusCodeSuplier;
	
    @Test
    public void teste() throws Exception{
    	navegador.get("/empreendedorismo");
    	
    	assertEquals(200, httpStatusCodeSuplier.get());
    	
    	System.out.println("Mais uma linha");
    }
}
