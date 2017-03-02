package br.com.autoglass.frameworkSelenium.locatorsFactory;

import org.openqa.selenium.By;

public final class TdBy {

	private TdBy(){
		
	}
	
	public static By cellLocation(int rowNumber, int columnNumber){
		return By.cssSelector(String.format("tbody tr:nth-child(%d) td:nth-child(%d)",
				rowNumber, columnNumber));
	}
	
}