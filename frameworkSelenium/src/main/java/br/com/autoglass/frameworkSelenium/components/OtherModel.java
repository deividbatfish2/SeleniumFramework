package br.com.autoglass.frameworkSelenium.components;

import org.openqa.selenium.Alert;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.security.Credentials;

public class OtherModel implements Alert{

	private final SearchContext searchContext;
	
	
	public OtherModel(SearchContext searchContext) {
		this.searchContext = searchContext;
	}


	@Override
	public void dismiss() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void accept() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public String getText() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void sendKeys(String keysToSend) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void setCredentials(Credentials credentials) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void authenticateUsing(Credentials credentials) {
		// TODO Auto-generated method stub
		
	}
	
}
