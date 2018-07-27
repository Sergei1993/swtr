package ru.mail.selenium.page.basic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import ru.mail.selenium.factory.DisplayedElementLocatorFactory;
import ru.mail.selenium.page.InternalPage;
import ru.mail.selenium.page.LetterPage;
import ru.mail.selenium.page.LoginPage;
import ru.mail.selenium.page.UserProfilePage;

/**
 * Created by sergey.zinchuk on 26.07.2018.
 */
public class PageManager {

    private WebDriver driver;
    public LoginPage loginPage;
    public InternalPage internalPage;
    public UserProfilePage userProfilePage;
    public LetterPage letterPage;

    public PageManager(WebDriver driver) {
        this.driver = driver;
        loginPage = initElements(new LoginPage(this));
        internalPage = initElements(new InternalPage(this));
        userProfilePage = initElements(new UserProfilePage(this));
        letterPage = initElements(new LetterPage(this));
    }

    private <T extends Page> T initElements(T page) {
        //PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), page);
        PageFactory.initElements(new DisplayedElementLocatorFactory(driver, 10), page);
        return page;
    }

    public WebDriver getWebDriver() {
        return driver;
    }
}
