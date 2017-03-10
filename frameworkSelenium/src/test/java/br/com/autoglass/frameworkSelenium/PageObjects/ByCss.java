package br.com.autoglass.frameworkSelenium.PageObjects;

import java.util.function.Supplier;

import org.openqa.selenium.By;

public enum ByCss implements Supplier<By>{
	
	txbLogin("input[placeholder=\"Login:\"]"),
	
	txbSenha("input[placeholder=\"Senha:\"]"),
	
	btnEntrar("button[type=\"submit\"]");

	private final By by;
	
	ByCss(String by) {
		this.by = By.cssSelector(by);
	}
	
	@Override
	public By get(){
		return by;
	}
	
	@Override
	public String toString(){
		return by.toString();
	}
}
