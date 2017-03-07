package br.com.autoglass.frameworkSelenium.components;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;

import br.com.autoglass.frameworkSelenium.components.interfaces.Table;
import br.com.autoglass.frameworkSelenium.locatorsFactory.TdBy;

public class SimpleTable implements Table {

	private final WebElement tableElement;
	
	public SimpleTable(WebElement tableElement) {
		this.tableElement = tableElement;
	}
	
	@Override
	public void click() {
		
		tableElement.click();
	}

	@Override
	public void submit() {
		
		tableElement.submit();
	}

	@Override
	public void sendKeys(CharSequence... keysToSend) {
		
		tableElement.sendKeys(keysToSend);
	}

	@Override
	public void clear() {
		
		tableElement.clear();
	}

	@Override
	public String getTagName() {
		
		return tableElement.getTagName();
	}

	@Override
	public String getAttribute(String name) {
		
		return tableElement.getAttribute(name);
	}

	@Override
	public boolean isSelected() {
		
		return tableElement.isSelected();
	}

	@Override
	public boolean isEnabled() {
		
		return tableElement.isEnabled();
	}

	@Override
	public String getText() {
		
		return tableElement.getText();
	}

	@Override
	public List<WebElement> findElements(By by) {
		
		return tableElement.findElements(by);
	}

	@Override
	public WebElement findElement(By by) {
		
		return tableElement.findElement(by);
	}

	@Override
	public boolean isDisplayed() {
		
		return tableElement.isDisplayed();
	}

	@Override
	public Point getLocation() {
		
		return tableElement.getLocation();
	}

	@Override
	public Dimension getSize() {
		
		return tableElement.getSize();
	}

	@Override
	public Rectangle getRect() {
		
		return tableElement.getRect();
	}

	@Override
	public String getCssValue(String propertyName) {
		
		return tableElement.getCssValue(propertyName);
	}

	@Override
	public <X> X getScreenshotAs(OutputType<X> target) throws WebDriverException {
		
		return tableElement.getScreenshotAs(target);
	}

	@Override
	public WebElement getBodyCell(int rowNumber, int colummNumber) {
		
		return tableElement.findElement(By.tagName("tbody")).findElement(TdBy.cellLocation(rowNumber, colummNumber));
	}

	@Override
	public int getWidth() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getBodyHeigth() {
		// TODO Auto-generated method stub
		return 0;
	}

}
