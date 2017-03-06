package br.com.autoglass.frameworkSelenium.configuration;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class WebDriverConfigEncapisular {
	
	public EventFiringWebDriver navegador;

	public WebDriverConfigEncapisular() {
		
	}
	
	public EventFiringWebDriver encapisular(WebDriver navegador){
		
		this.navegador = new EventFiringWebDriver(navegador);
		
		retirarScreenshotAposCarregarAPagina();
		
		return this.navegador;
		
	}

	private void retirarScreenshotAposCarregarAPagina() {
		
		navegador.register(new AbstractWebDriverEventListener() {
			
			@Override
			public void afterNavigateTo(String url, WebDriver driver) {
				String regex = "/|:";
				File screenshotFile = ((TakesScreenshot) driver)
						.getScreenshotAs(OutputType.FILE);
				File file = new File("target",
						url.replaceAll(regex, "-") + ".png");
						FileUtils.deleteQuietly(file);
						try {
							FileUtils.moveFile(screenshotFile, file);
						} catch (IOException e) {
							e.printStackTrace();
						}
						System.out.println("saved " + url.replaceAll(regex, "-") + " as " + screenshotFile);
			}
		});
	}
}