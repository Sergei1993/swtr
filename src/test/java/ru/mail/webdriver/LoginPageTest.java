package ru.mail.webdriver;

import org.testng.annotations.*;
import ru.mail.selenium.model.Letter;
import ru.mail.selenium.model.User;
import ru.mail.webdriver.tests.TestBase;
import static org.testng.AssertJUnit.assertTrue;

/**
 * Created by sergey.zinchuk on 26.07.2018.
 */
public class LoginPageTest extends TestBase {

    private String textLetter = "просто сообщение для проверки отправи письма.";
    private String subject = "Тест на отправление письма";

    @Test
    public void authorisationTrue() {
        User user = new User().setLogin(glProp.getLogin())
                .setDomen(glProp.getDomen())
                .setPassword(glProp.getPass());
        app.getUserService().loginAs(user);
        assertTrue(app.getUserService().isLoggedInAs(user));

        app.getUserService().openSendingLetter();

        Letter letter = new Letter()
                .setEmail(glProp.getEmail())
                .setSubject(subject)
                .setText(textLetter);
        app.getUserService().writeAndSendLetter(letter);
    }

    @AfterTest
    public void mayBeLogout() {
        if (app.getUserService().isNotLoggedIn()) {
            return;
        }
        app.getUserService().logout();
    }
}
