package br.com.autoglass.frameworkSelenium.configuration;

import java.net.URI;

import org.openqa.selenium.WebDriver;

public class BaseUrlDriver extends DelegatingWebDriver {

private final URI baseUrl;
	
BaseUrlDriver(WebDriver driver, URI uri) {
		super(driver);
		this.baseUrl = uri;
	}

	@Override
	public void get(String url){
		super.get(!url.contains("://") ? baseUrl.toString() + url : url);
	}
}