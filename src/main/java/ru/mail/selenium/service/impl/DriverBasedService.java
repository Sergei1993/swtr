package ru.mail.selenium.service.impl;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.mail.selenium.page.basic.PageManager;

/**
 * Created by sergey.zinchuk on 26.07.2018.
 */
public class DriverBasedService {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected PageManager pages;

    public DriverBasedService(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
        pages = new PageManager(driver);
    }
}
