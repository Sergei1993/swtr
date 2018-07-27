package ru.mail.selenium.service.impl;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.mail.selenium.service.ApplicationManager;
import ru.mail.selenium.service.NavigationService;
import ru.mail.selenium.service.UserService;

import java.util.concurrent.TimeUnit;

/**
 * Created by sergey.zinchuk on 26.07.2018.
 */
public class ApplicationManagerImpl implements ApplicationManager {

    private final static String DRIVER_PATH = "E:/Work/projectSelenium/seleniumTask/src/test/resources/";
    private UserService userService;
    private NavigationService navService;

    private WebDriver driver;
    private String baseUrl;

    public ApplicationManagerImpl() {
        System.setProperty("webdriver.chrome.driver", DRIVER_PATH + "chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        baseUrl = "https://mail.ru/";

        userService = new UserServiceImpl(this);
        navService = new NavigationServiceImpl(this);

        getNavigationService().openMainPage();
    }

    @Override
    public UserService getUserService() {
        return userService;
    }

    @Override
    public NavigationService getNavigationService() {
        return navService;
    }

    protected WebDriver getWebDriver() {
        return driver;
    }

    protected String getBaseUrl() {
        return baseUrl;
    }

    @Override
    public void stop() {
        if (driver != null) {
            driver.quit();
        }
    }
}
