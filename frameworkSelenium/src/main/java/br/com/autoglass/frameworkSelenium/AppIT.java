package br.com.autoglass.frameworkSelenium;

import java.net.URI;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import br.com.autoglass.frameworkSelenium.screenShot.ScreenshotTaker;

import br.com.autoglass.frameworkSelenium.configuration.WebDriverConfig;

/**
 * Hello world!
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
	
	@Inject
	private URI baseUrl;
	
    @Test
    public void teste(){
    	navegador.get(baseUrl + "/empreendedorismo");
    }
}
