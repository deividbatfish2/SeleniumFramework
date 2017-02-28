package br.com.autoglass.frameworkSelenium;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import br.com.autoglass.frameworkSelenium.LocatorsFactory.ElementBy;

/**
 * Hello world!
 *
 */
public class AppIT
{
    @Test
    public void teste(){
    	System.setProperty("webdriver.chrome.driver", "driver/chromedriver");
    	WebDriver navegador = new ChromeDriver();
    	navegador.findElement(ElementBy.partialText("lalala"));
    }
}
