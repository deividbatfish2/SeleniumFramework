package br.com.autoglass.frameworkSelenium.configuration;

import java.io.IOException;
import java.net.URI;
import java.net.URL;

import org.apache.commons.lang3.SystemUtils;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
public class WebDriverConfig {

	private WebDriver navegador;
	
	@Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    public DesiredCapabilities desiredCapabilities(
            @Value("${webdriver.capabilities.browserName:chrome}") String browserName
    ) {
        return new DesiredCapabilities(browserName, "", Platform.ANY);
    }

    private WebDriver localDriver(DesiredCapabilities desiredCapabilities) throws IOException {
		
    	switch (desiredCapabilities.getBrowserName()) {
    	case BrowserType.CHROME:
    		verificaSOESetaBinarioNavegador(desiredCapabilities);
    		
    		navegador.manage().window().maximize();
    		
    		EventFiringWebDriver navegador = encapisulaNavegador();
    		
    		return navegador;
    	case BrowserType.FIREFOX:
    		return new FirefoxDriver(desiredCapabilities);
    	case BrowserType.HTMLUNIT:
    		return new HtmlUnitDriver(desiredCapabilities);
    	case BrowserType.SAFARI:
    		return new SafariDriver(desiredCapabilities);
    	default:
    		throw new IllegalStateException("unknown browser " + desiredCapabilities.getBrowserName());
    	}
    }

	private void verificaSOESetaBinarioNavegador(DesiredCapabilities desiredCapabilities) {
		if(SystemUtils.IS_OS_LINUX){
			System.setProperty("webdriver.chrome.driver", "target/chromedriver");
			navegador = new ChromeDriver(desiredCapabilities);
		}
		else{
			System.setProperty("webdriver.chrome.driver", "target/chromedriver.exe");
			navegador = new ChromeDriver(desiredCapabilities);
		}
	}
    
    private WebDriver remoteDriver(URL remoteUrl, DesiredCapabilities desiredCapabilities) {
    	return new Augmenter().augment(new RemoteWebDriver(remoteUrl, desiredCapabilities));
	}
    
    @Bean(destroyMethod = "quit")
    public WebDriver webDriver(
    		@Value("${webdriver.remote:false}") boolean remoteDriver,
    		@Value("${webdriver.remote.url:http://localhost:4444/wd/hub}") 
    		URL remoteUrl,
    		DesiredCapabilities desiredCapabilities) throws Exception {
    		return remoteDriver ?
    		remoteDriver(remoteUrl, desiredCapabilities) :
    		localDriver(desiredCapabilities);
    }
    
    @Bean
    public URI baseUrl(@Value("${webdriver.baseUrl:https://economia.uol.com.br}") URI value) {
    return value;
    }
    
    private EventFiringWebDriver encapisulaNavegador() {
		
    	WebDriverConfigEncapsular encapisula = new WebDriverConfigEncapsular();
    	
    	EventFiringWebDriver navegador = encapisula.encapsular(this.navegador);
		
		return navegador;
	}
	
}
