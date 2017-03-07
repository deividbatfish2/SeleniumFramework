package br.com.autoglass.frameworkSelenium.configuration;

import org.openqa.selenium.WebElement;

public class Element extends DelegatingWebElement
	implements ExplicitWait, SearchScope{

    public Element(WebElement delegate) {
        super(delegate);
    }

}
