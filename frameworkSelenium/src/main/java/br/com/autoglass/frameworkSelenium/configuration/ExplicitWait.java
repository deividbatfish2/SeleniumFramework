package br.com.autoglass.frameworkSelenium.configuration;

import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static java.util.concurrent.TimeUnit.SECONDS;

import java.util.function.Supplier;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.FluentWait;

public interface ExplicitWait extends SearchScope{
	
	default Element findElementwithTimeout(Supplier<By> by){
		
		return new FluentWait<>(this)
				.withTimeout(1, SECONDS)
				.pollingEvery(10, MILLISECONDS)
				.ignoring(NoSuchElementException.class)
				.until((ExplicitWait e) -> findElement(by));
		
	}
	
	default void click(Supplier<By> by){
		
		findElement(by).click();
	}
	
	default String getText(Supplier<By> by){
		
		return findElement(by).getText();
	}
}
