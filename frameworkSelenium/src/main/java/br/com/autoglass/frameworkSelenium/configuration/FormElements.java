package br.com.autoglass.frameworkSelenium.configuration;

import static br.com.autoglass.frameworkSelenium.components.enumerator.TagName.OPTION;

import java.util.List;
import java.util.function.Supplier;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public interface FormElements extends ExplicitWait {
	
	default public void setImputText(Supplier<By> by, Object text){
		Element elemento = findElementWithTimeout(by);
		elemento.clear();
		elemento.sendKeys(text.toString());
	}
	
	default public String getImputText(Supplier<By> by){
		return findElement(by).getValue();
	}
	
	default public String getRadio(Supplier<By> by) {
		
		List<Element> radiobuttons = findElements(by);
		assert radiobuttons.size() >= 2;
		for (WebElement e : radiobuttons) {
			if (Boolean.valueOf(e.getAttribute("checked"))) {
				return e.getAttribute("value");
			}
		}
		return null;
	}
	
	default public void setRadio(Supplier<By> by, String value) {
		List<Element> radiobuttons = findElements(by);
		assert radiobuttons.size() >= 2 ;
		for (WebElement e : radiobuttons) {
			if (value.equals(e.getAttribute("value"))) {
				e.click();
				return;
			}
		}
		throw new IllegalArgumentException("unable to find element with value " + value);
	}
	
	
	default public Select getSelect(Supplier<By> by) {
		
		final Element element = findElementWithTimeout(by);
		
		element.click();
		
		if(element.findElementWithTimeout(OPTION).isDisplayed()){
			return new Select(element);
		}
		else{
			throw new IllegalArgumentException("Não foram encontrados opções no select " + by);
		}
	}
	
	default public void selectByVisibleText(Supplier<By> by, String ... values) {
		for (String v: values) {
			getSelect(by).selectByVisibleText(v);
		}
	}
	
}
