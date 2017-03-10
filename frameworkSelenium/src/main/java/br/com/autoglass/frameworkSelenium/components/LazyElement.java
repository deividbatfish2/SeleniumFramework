package br.com.autoglass.frameworkSelenium.components;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.internal.Coordinates;
import org.openqa.selenium.internal.Locatable;

public class LazyElement implements	WebElement,	Locatable{

	private	final SearchContext	searchContext;
	private	final By locator;
	
	
	public	LazyElement(SearchContext searchContext, By locator){
		this.searchContext = searchContext;
		this.locator = locator;
	}
	
	private	WebElement get(){
			return searchContext.findElement(locator);
	}
	
	@Override
	public <X> X getScreenshotAs(OutputType<X> arg0) throws WebDriverException {
		
		return get().getScreenshotAs(arg0);
	}

	@Override
	public Coordinates getCoordinates() {
		
		return ((Locatable)get()).getCoordinates();
	}

	@Override
	public void clear() {
		
		get().clear();
	}

	@Override
	public void click() {
		get().click();
		
	}

	@Override
	public WebElement findElement(By arg0) {
		
		return get().findElement(arg0);
	}

	@Override
	public List<WebElement> findElements(By arg0) {
		
		return get().findElements(arg0);
	}

	@Override
	public String getAttribute(String arg0) {
		
		return get().getAttribute(arg0);
	}

	@Override
	public String getCssValue(String arg0) {
		
		return get().getCssValue(arg0);
	}

	@Override
	public Point getLocation() {
		
		return get().getLocation();
	}

	@Override
	public Rectangle getRect() {
		
		return get().getRect();
	}

	@Override
	public Dimension getSize() {
		
		return get().getSize();
	}

	@Override
	public String getTagName() {
		
		return get().getTagName();
	}

	@Override
	public String getText() {
		
		return get().getText();
	}

	@Override
	public boolean isDisplayed() {
		
		return get().isDisplayed();
	}

	@Override
	public boolean isEnabled() {
		
		return get().isEnabled();
	}

	@Override
	public boolean isSelected() {
		
		return get().isSelected();
	}

	@Override
	public void sendKeys(CharSequence... arg0) {
		get().sendKeys(arg0);
	}

	@Override
	public void submit() {
		get().submit();
	}

}
