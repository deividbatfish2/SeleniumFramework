package br.com.autoglass.frameworkSelenium.configuration;

import org.apache.commons.lang3.SystemUtils;
import org.littleshoot.proxy.HttpFiltersSource;
import org.littleshoot.proxy.HttpProxyServer;
import org.littleshoot.proxy.impl.DefaultHttpProxyServer;
import org.openqa.selenium.Platform;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import java.io.IOException;
import java.net.*;
import java.util.AbstractMap;
import java.util.Map;
import java.util.stream.Collectors;

@Configuration
public class WebDriverConfig {

	private WebDriver navegador;
	
	@Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

	@Bean
	public HttpStatusCodeSupplier httpStatusCodeSupplier() {
	
		return new HttpStatusCodeSupplier();
	}
	
    @Bean
    public DesiredCapabilities desiredCapabilities(
    		HttpProxyServer proxyServer,
            @Value("${webdriver.capabilities.browserName:chrome}") String browserName,
            @Value("${webdriver.proxy.enabled:true}") boolean proxyEnabled
    ) throws UnknownHostException {
    	
            DesiredCapabilities capabilities =
                    new DesiredCapabilities(browserName, "", Platform.ANY);
            capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);

            if (proxyEnabled) {
                String httpProxy = proxyServer.getListenAddress().toString().substring(1); // remove a leading "/"
                Proxy proxy = new Proxy().setHttpProxy(httpProxy).setSslProxy(httpProxy)
                    .setFtpProxy(httpProxy).setSocksProxy(httpProxy);
                capabilities.setCapability(CapabilityType.PROXY, proxy);
            }

           // populateCapabilites(capabilities);


            return capabilities;
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
			System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
			navegador = new BaseUrlDriver(new ChromeDriver(desiredCapabilities), new RetornaURL().retornaURL());
		}
		else{
			System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
			navegador = new BaseUrlDriver(new ChromeDriver(desiredCapabilities), new RetornaURL().retornaURL());
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
    
    /*@Bean
    public URI baseUrl(@Value("${webdriver.baseUrl:https://economia.uol.com.br}") URI value) {
    return value;
    }*/
    
    private EventFiringWebDriver encapisulaNavegador() {
		
    	WebDriverConfigEncapsular encapisula = new WebDriverConfigEncapsular();
    	
    	EventFiringWebDriver navegador = encapisula.encapsular(this.navegador);
		
		return navegador;
	}
    
    private static int freePort() throws IOException {
    	
    	try (ServerSocket serverSocket = new ServerSocket(0)) {
    		return serverSocket.getLocalPort();
    	}
	}
    
	@Bean(destroyMethod = "abort")
	public HttpProxyServer proxyServer(HttpFiltersSource httpFiltersSource)
	throws IOException, InterruptedException {
		
		InetSocketAddress inetSocketAddress = new InetSocketAddress(InetAddress.getLocalHost(), 0);
		return DefaultHttpProxyServer.bootstrap()
				.withNetworkInterface(inetSocketAddress)
				.withFiltersSource(httpFiltersSource)
				.withPort(freePort())
				.start();
	}
	
}
