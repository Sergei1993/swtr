package ru.mail.webdriver.tests;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import ru.mail.selenium.service.ApplicationManager;
import ru.mail.selenium.service.impl.ApplicationManagerImpl;
import ru.mail.webdriver.properties.GlobalProperties;
import ru.yandex.qatools.properties.annotations.Resource;

/**
 * Created by sergey.zinchuk on 26.07.2018.
 */
public class TestBase {

    protected GlobalProperties glProp;
    protected ApplicationManager app;

    @BeforeClass
    public void init() {
        app = new ApplicationManagerImpl();
        glProp = new GlobalProperties();
    }

    @AfterSuite
    public void stop() {
        app.stop();
    }
}
