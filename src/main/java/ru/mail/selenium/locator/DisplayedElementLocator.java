package ru.mail.selenium.locator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.AjaxElementLocator;

import java.lang.reflect.Field;

/**
 * Created by sergey.zinchuk on 26.07.2018.
 */
public class DisplayedElementLocator extends AjaxElementLocator {

    public DisplayedElementLocator(WebDriver driver, Field field, int timeOutInSeconds) {
        super(driver, field, timeOutInSeconds);
    }

    @Override
    protected boolean isElementUsable(WebElement element) {
        return element.isDisplayed();
    }
}