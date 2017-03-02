package br.com.autoglass.frameworkSelenium.locatorsFactory;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;

public class AllBy extends By{

	private	final By[] bys;
	
	private	AllBy(By...	bys){
		this.bys	=	bys;
	}
	
	//Static factory method
	public	static	AllBy	all(By...	bys){
		return	new	AllBy(bys);
	}
	
	@Override
	public List<WebElement> findElements(SearchContext context) {
		List<WebElement> elements =	null;
		
		for	(By	by	:	bys){
			List<WebElement> newElements = context.findElements(by);
			if	(elements	==	null){
				//If you have the first set	of elements, initialize	the	list.
				elements	=	newElements;
			}	
			else{
				//Otherwise, keep only the new elements.
				elements.retainAll(newElements);
			}
		}
		return	elements;
	}

}