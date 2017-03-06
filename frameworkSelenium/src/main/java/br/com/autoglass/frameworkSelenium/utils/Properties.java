package br.com.autoglass.frameworkSelenium.utils;

import java.util.Locale;
import java.util.ResourceBundle;

public class Properties {

	public static String getProperty(String chave){
		
		ResourceBundle strings = ResourceBundle.getBundle("strings", Locale.ENGLISH);
		
		return strings.getString(chave);
		 
	}
	
}
