package br.com.autoglass.frameworkSelenium.configuration;

import java.net.URI;

import static br.com.autoglass.frameworkSelenium.utils.Properties.getProperty;
public class RetornaURL{

	public URI retornaURL(){
		
		return System.getProperty("webdriver.baseUrl") == null ? 
				URI.create(getProperty("webdriver.baseUrl")) : 
					URI.create(System.getProperty("webdriver.baseUrl"));
		
	}
}
