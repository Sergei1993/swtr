package ru.mail.selenium.service;

import ru.mail.selenium.model.Letter;
import ru.mail.selenium.model.User;

/**
 * Created by sergey.zinchuk on 26.07.2018.
 */
public interface UserService {

    void loginAs(User user);

    void openSendingLetter();

    void writeAndSendLetter(Letter letter);

    void logout();

    boolean isLoggedIn();

    boolean isLoggedInAs(User user);

    boolean isNotLoggedIn();
}
