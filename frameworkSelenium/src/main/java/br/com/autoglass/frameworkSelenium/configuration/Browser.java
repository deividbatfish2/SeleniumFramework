package br.com.autoglass.frameworkSelenium.configuration;

import org.openqa.selenium.WebDriver;

public class Browser extends DelegatingWebDriver 
	implements ExplicitWait, SearchScope{

	public Browser(WebDriver driver) {
        super(driver);
    }

}
