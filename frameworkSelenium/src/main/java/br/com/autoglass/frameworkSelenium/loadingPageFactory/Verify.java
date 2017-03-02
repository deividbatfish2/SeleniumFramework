package br.com.autoglass.frameworkSelenium.loadingPageFactory;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.ElementType;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Verify {
	String INVALID_TITLE = "\0";
	String INVALID_XPATH = "\0";
	String title() default INVALID_TITLE;
	String xpath() default INVALID_XPATH;
}