package br.com.autoglass.frameworkSelenium.configuration;

import java.util.function.Supplier;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class Browser extends DelegatingWebDriver 
	implements ExplicitWait, SearchScope, FormElements{

	public Browser(WebDriver driver) {
        super(driver);
    }
	
	public void doubleClick(Supplier<By> by){
		Element element = findElementWithTimeout(by);
		
		new Actions(delegate).doubleClick(element).perform();
	}

}
