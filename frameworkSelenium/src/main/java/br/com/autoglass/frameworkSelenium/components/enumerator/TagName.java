package br.com.autoglass.frameworkSelenium.components.enumerator;

import java.util.function.Supplier;

import org.openqa.selenium.By;

public enum TagName implements Supplier<By>{
	
	OPTION("option"),
	
	txbSenha("input[placeholder=\"Senha:\"]"),
	
	btnEntrar("button[type=\"submit\"]");

	private final By by;
	
	TagName(String by) {
		this.by = By.tagName(by);
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
