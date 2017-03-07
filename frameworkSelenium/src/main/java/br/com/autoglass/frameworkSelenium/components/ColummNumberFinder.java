package br.com.autoglass.frameworkSelenium.components;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;

public class ColummNumberFinder {

	private final SearchContext context;
	
	public ColummNumberFinder(SearchContext context){
		this.context = context;
	}
	
	public int find(String headerText){
		for(int colummNumber = 1; ; colummNumber++){
			if(context.
					findElement(By.cssSelector(String.format("th:nth-child(%d)", colummNumber)))
					.getText().equals(headerText)){
				return colummNumber;
				
			}
		}
	}
	
}
