package ru.mail.selenium.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.mail.selenium.page.basic.AnyPage;
import ru.mail.selenium.page.basic.PageManager;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

/**
 * Created by sergey.zinchuk on 26.07.2018.
 */
public class LetterPage extends AnyPage {

    public LetterPage(PageManager pages) {
        super(pages);
    }

    @FindBy(css = "textarea.js-input.compose__labels__input")
    private WebElement toWhomField;

    @FindBy(name = "Subject")
    private WebElement subjectField;

    @FindBy(id = "tinymce")
    private WebElement letterField;

    @FindBy(xpath = "//*[@id=\"b-toolbar__right\"]/div[3]/div/div[2]/div[1]/div/span")
    private WebElement buttonSend;

    public LetterPage setToWhomField(String text) {
        toWhomField.sendKeys(text);
        return this;
    }

    public LetterPage setSubjectField(String text) {
        subjectField.sendKeys(text);
        return this;
    }

    public LetterPage setLetterField(String text) {
        pages.getWebDriver().switchTo().frame(0);
        letterField.sendKeys(text);
        pages.getWebDriver().switchTo().defaultContent();
        return this;
    }

    public void clickButtonSend() {
        buttonSend.click();
    }

    @Override
    public LetterPage ensurePageLoaded() {
        super.ensurePageLoaded();
        wait.until(visibilityOfElementLocated(By.tagName("iframe")));
        return this;
    }
}
