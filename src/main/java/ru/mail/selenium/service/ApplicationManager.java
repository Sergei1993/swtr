package ru.mail.selenium.service;

/**
 * Created by sergey.zinchuk on 26.07.2018.
 */
public interface ApplicationManager {

    UserService getUserService();

    NavigationService getNavigationService();

    void stop();
}
