package ru.mail.selenium.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import ru.mail.selenium.page.basic.AnyPage;
import ru.mail.selenium.page.basic.PageManager;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

/**
 * Created by sergey.zinchuk on 26.07.2018.
 */
public class LoginPage extends AnyPage {

    public LoginPage(PageManager pages) {
        super(pages);
    }

    @FindBy(id = "mailbox:login")
    private WebElement usernameField;

    @FindBy(id = "mailbox:password")
    private WebElement passwordField;

    @FindBy(id = "auth")
    private WebElement button;

    public LoginPage setUsernameField(String text) {
        usernameField.sendKeys(text);
        return this;
    }

    public LoginPage setPasswordField(String text) {
        passwordField.sendKeys(text);
        return this;
    }

    public LoginPage setSelectDomen(String text) {
        getSelectDomen().selectByVisibleText(text);
        return this;
    }

    public Select getSelectDomen(){
        WebElement element = pages.getWebDriver().findElement(By.id("mailbox:domain"));
        return new Select(element);
    }

    public void clickButtonAut() {
        button.submit();
    }

    @Override
    public LoginPage ensurePageLoaded() {
        super.ensurePageLoaded();
        wait.until(presenceOfElementLocated(By.xpath("//*[@id=\"auth\"]")));
        return this;
    }
}
