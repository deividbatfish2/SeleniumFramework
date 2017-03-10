package br.com.autoglass.frameworkSelenium.configuration;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

public interface SearchScope {

	 Element findElement(Supplier<By> by);
	 
	 List<Element> findElements(Supplier<By> by);

    default Optional<Element> optionalElement(Supplier<By> by) {
        try {
            return Optional.of(findElement(by));
        } catch (NoSuchElementException ignored) {
            return Optional.empty();
        }
    }

    default boolean isPresent(Supplier<By> by) {
        return optionalElement(by).isPresent();
    }
	
}
