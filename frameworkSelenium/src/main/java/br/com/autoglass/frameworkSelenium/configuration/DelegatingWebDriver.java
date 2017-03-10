package br.com.autoglass.frameworkSelenium.configuration;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.HasCapabilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.HasInputDevices;
import org.openqa.selenium.interactions.Keyboard;
import org.openqa.selenium.interactions.Mouse;

public class DelegatingWebDriver extends DelegatingSearchContext<WebDriver>
	implements WebDriver, JavascriptExecutor, TakesScreenshot,
	HasInputDevices, HasCapabilities, ExplicitWait {
	
	DelegatingWebDriver(WebDriver delegate){
		
		super(delegate);
	}
	
	@Override
	public void get(String url) {
		delegate.get(url);
	}

	@Override
	public String getCurrentUrl() {
		
		return delegate.getCurrentUrl();
	}

	@Override
	public String getTitle() {

		return delegate.getTitle();
	}

	@Override
	public List<WebElement> findElements(By by) {
		
		return delegate.findElements(by);
	}

	/*@Override
	public WebElement findElement(By by) {

		return delegate.findElement(by);
	}*/

	@Override
	public String getPageSource() {

		return delegate.getPageSource();
	}

	@Override
	public void close() {

		delegate.close();
	}

	@Override
	public void quit() {
		
		delegate.quit();
	}

	@Override
	public Set<String> getWindowHandles() {
		
		return delegate.getWindowHandles();
	}

	@Override
	public String getWindowHandle() {
		
		return delegate.getWindowHandle();
	}

	@Override
	public TargetLocator switchTo() {
		
		return delegate.switchTo();
	}

	@Override
	public Navigation navigate() {
		
		return delegate.navigate();
	}

	@Override
	public Options manage() {
		
		return delegate.manage();
	}

	@Override
	public Capabilities getCapabilities() {
		
		return ((HasCapabilities) delegate).getCapabilities();
	}

	@Override
	public Keyboard getKeyboard() {
		
		 return ((HasInputDevices) delegate).getKeyboard();
	}

	@Override
	public Mouse getMouse() {
		
		return ((HasInputDevices) delegate).getMouse();
	}

	@Override
	public <X> X getScreenshotAs(OutputType<X> target) throws WebDriverException {
		
		return ((TakesScreenshot) delegate).getScreenshotAs(target);
	}

	@Override
	public Object executeScript(String script, Object... args) {
		
		return ((JavascriptExecutor) delegate).executeScript(script, args);
	}

	@Override
	public Object executeAsyncScript(String script, Object... args) {
		
		return ((JavascriptExecutor) delegate).executeAsyncScript(script, args);
	}

}
