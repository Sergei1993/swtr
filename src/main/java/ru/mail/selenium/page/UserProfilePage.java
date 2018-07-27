package ru.mail.selenium.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.mail.selenium.page.basic.AnyPage;
import ru.mail.selenium.page.basic.PageManager;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

/**
 * Created by sergey.zinchuk on 26.07.2018.
 */
public class UserProfilePage extends AnyPage {

    public UserProfilePage(PageManager pages) {
        super(pages);
    }

    @FindBy(id = "PH_user-email")
    private WebElement emailField;

    @FindBy(linkText = "Написать письмо")
    private WebElement buttonWriteLetter;

    public String getEmail() {
        return emailField.getText();
    }

    public void openSendingLetter() {
        buttonWriteLetter.click();
    }

    @Override
    public UserProfilePage ensurePageLoaded() {
        super.ensurePageLoaded();
        wait.until(presenceOfElementLocated(By.cssSelector("#theme")));
        return this;
    }
}
