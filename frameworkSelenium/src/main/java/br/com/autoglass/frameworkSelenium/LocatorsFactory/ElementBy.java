package br.com.autoglass.frameworkSelenium.LocatorsFactory;

import org.openqa.selenium.By;

public final class ElementBy {

	private ElementBy(){
		
	}
	
	public static By partialText(String text){
	
		return By.xpath("//*[contains(normalize-space(.), " + text + ")]");
	}
}
