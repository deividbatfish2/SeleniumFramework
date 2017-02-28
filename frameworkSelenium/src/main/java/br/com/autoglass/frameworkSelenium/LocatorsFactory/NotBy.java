package br.com.autoglass.frameworkSelenium.LocatorsFactory;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;

public class NotBy extends By{

	private By by;
	
	private NotBy(By by) {
		this.by = by;
	}
	
	public static NotBy not(By by){
		return new NotBy(by);
	}
	
	@Override
	public List<WebElement> findElements(SearchContext context) {
		
		List<WebElement> elements = context.findElements(By.cssSelector("*"));
		elements.removeAll(context.findElements(by));
		
		return elements;
	}

}
