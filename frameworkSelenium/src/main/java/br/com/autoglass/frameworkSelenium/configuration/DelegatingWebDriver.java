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

public class DelegatingWebDriver implements WebDriver, JavascriptExecutor, TakesScreenshot,
HasInputDevices, HasCapabilities{

	private final WebDriver driver;
	
	DelegatingWebDriver(WebDriver driver){
		
		this.driver = driver;
	}
	
	@Override
	public void get(String url) {
		driver.get(url);
	}

	@Override
	public String getCurrentUrl() {
		
		return driver.getCurrentUrl();
	}

	@Override
	public String getTitle() {

		return driver.getTitle();
	}

	@Override
	public List<WebElement> findElements(By by) {
		
		return driver.findElements(by);
	}

	@Override
	public WebElement findElement(By by) {

		return driver.findElement(by);
	}

	@Override
	public String getPageSource() {

		return driver.getPageSource();
	}

	@Override
	public void close() {

		driver.close();
	}

	@Override
	public void quit() {
		
		driver.quit();
	}

	@Override
	public Set<String> getWindowHandles() {
		
		return driver.getWindowHandles();
	}

	@Override
	public String getWindowHandle() {
		
		return driver.getWindowHandle();
	}

	@Override
	public TargetLocator switchTo() {
		
		return driver.switchTo();
	}

	@Override
	public Navigation navigate() {
		
		return driver.navigate();
	}

	@Override
	public Options manage() {
		
		return driver.manage();
	}

	@Override
	public Capabilities getCapabilities() {
		
		return ((HasCapabilities) driver).getCapabilities();
	}

	@Override
	public Keyboard getKeyboard() {
		
		 return ((HasInputDevices) driver).getKeyboard();
	}

	@Override
	public Mouse getMouse() {
		
		return ((HasInputDevices) driver).getMouse();
	}

	@Override
	public <X> X getScreenshotAs(OutputType<X> target) throws WebDriverException {
		
		return ((TakesScreenshot) driver).getScreenshotAs(target);
	}

	@Override
	public Object executeScript(String script, Object... args) {
		
		return ((JavascriptExecutor) driver).executeScript(script, args);
	}

	@Override
	public Object executeAsyncScript(String script, Object... args) {
		
		return ((JavascriptExecutor) driver).executeAsyncScript(script, args);
	}

}