package ru.mail.selenium.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.pagefactory.ElementLocator;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;
import ru.mail.selenium.locator.DisplayedElementLocator;

import java.lang.reflect.Field;

/**
 * Created by sergey.zinchuk on 26.07.2018.
 */
public class DisplayedElementLocatorFactory implements ElementLocatorFactory {
    private final WebDriver driver;
    private final int timeOutInSeconds;

    public DisplayedElementLocatorFactory(WebDriver driver, int timeOutInSeconds) {
        this.driver = driver;
        this.timeOutInSeconds = timeOutInSeconds;
    }

    public ElementLocator createLocator(Field field) {
        return new DisplayedElementLocator(driver, field, timeOutInSeconds);
    }
}
