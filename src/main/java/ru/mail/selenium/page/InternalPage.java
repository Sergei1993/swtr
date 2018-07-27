package ru.mail.selenium.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.mail.selenium.page.basic.AnyPage;
import ru.mail.selenium.page.basic.PageManager;

import static org.openqa.selenium.support.ui.ExpectedConditions.alertIsPresent;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

/**
 * Created by sergey.zinchuk on 26.07.2018.
 */
public class InternalPage extends AnyPage {

    public InternalPage(PageManager pages) {
        super(pages);
    }

    @FindBy(id = "PH_user-email")
    private WebElement emailField;

    @FindBy(id = "PH_logoutLink")
    private WebElement logoutLink;

    public String getEmail() {
        return emailField.getText();
    }

    public LoginPage clickLogoutLink() {
        logoutLink.click();
        return pages.loginPage.ensurePageLoaded();
    }

    public InternalPage ensurePageLoaded() {
        super.ensurePageLoaded();
        wait.until(presenceOfElementLocated(By.cssSelector("div.w-x-ph__auth__dropdown__inner")));
        return this;
    }
}
