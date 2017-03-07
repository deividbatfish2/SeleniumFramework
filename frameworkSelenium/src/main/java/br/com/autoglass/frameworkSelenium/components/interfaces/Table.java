package br.com.autoglass.frameworkSelenium.components.interfaces;

import org.openqa.selenium.WebElement;

public interface Table extends WebElement {

	WebElement getBodyCell(int rowNumber, int colummNumber);
	
	int getWidth();
	
	int getBodyHeigth();
	
}
