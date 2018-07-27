package ru.mail.webdriver.properties;

import ru.yandex.qatools.properties.PropertyLoader;
import ru.yandex.qatools.properties.annotations.Property;
import ru.yandex.qatools.properties.annotations.Resource;

/**
 * Created by sergey.zinchuk on 26.07.2018.
 */
@Resource.Classpath("global.properties")
public class GlobalProperties {

    public GlobalProperties() {
        PropertyLoader.populate(this);
    }

    @Property("loginPage.correct.login")
    private String login;

    @Property("loginPage.correct.domen")
    private String domen;

    @Property("loginPage.correct.password")
    private String pass;

    @Property("letterPage.correct.email")
    private String email;

    @Property("letterPage.subject")
    private String subject;

    public String getLogin() {
        return login;
    }

    public String getDomen() {
        return domen;
    }

    public String getPass() {
        return pass;
    }

    public String getEmail() {
        return email;
    }

    public String getSubject() {
        return subject;
    }
}
