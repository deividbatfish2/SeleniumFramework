package br.com.autoglass.frameworkSelenium.configuration;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Supplier;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;

public class DelegatingSearchContext<T extends SearchContext>
	implements SearchContext, ExplicitWait{

	protected final T delegate;
	
	public DelegatingSearchContext(T delegate){
		this.delegate = delegate;
	}

	@Override
	public Element findElement(Supplier<By> by) {
		
		return new Element(delegate.findElement(by.get()));
	}

	@Override
	public List<WebElement> findElements(By by) {
		
		return delegate.findElements(by);
	}
	
	@Override
	public List<Element> findElements(Supplier<By> by) {
		
		List<Element> list = new ArrayList<>();
		list.addAll((Collection<? extends Element>) delegate.findElements(by.get()));
		return list;
	}

	@Override
	public Element findElement(By by) {
	
		return new Element(delegate.findElement(by));
	}
	
}
