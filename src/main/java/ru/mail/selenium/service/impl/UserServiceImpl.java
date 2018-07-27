package ru.mail.selenium.service.impl;

import ru.mail.selenium.model.Letter;
import ru.mail.selenium.model.User;
import ru.mail.selenium.service.UserService;

/**
 * Created by sergey.zinchuk on 26.07.2018.
 */
public class UserServiceImpl extends DriverBasedService implements UserService {

    public UserServiceImpl(ApplicationManagerImpl manager) {
        super(manager.getWebDriver());
    }

    @Override
    public void loginAs(User user) {
        pages.loginPage.ensurePageLoaded()
                .setUsernameField(user.getLogin())
                .setPasswordField(user.getPassword())
                .setSelectDomen(user.getDomen())
                .clickButtonAut();
    }

    @Override
    public void openSendingLetter() {
        pages.userProfilePage.ensurePageLoaded()
                .openSendingLetter();
    }

    @Override
    public void writeAndSendLetter(Letter letter) {
        pages.letterPage.ensurePageLoaded()
                .setToWhomField(letter.getEmail())
                .setSubjectField(letter.getSubject())
                .setLetterField(letter.getText())
                .clickButtonSend();
    }

    @Override
    public void logout() {
        pages.internalPage.ensurePageLoaded()
                .clickLogoutLink();
    }

    @Override
    public boolean isLoggedIn() {
        return pages.internalPage.waitPageLoaded();
    }

    @Override
    public boolean isLoggedInAs(User user) {
        return isLoggedIn()
                && getLoggedUser().getEmail().equals(user.getEmail());
    }

    @Override
    public boolean isNotLoggedIn() {
        return pages.loginPage.waitPageLoaded();
    }

    private User getLoggedUser() {
        String email = pages.userProfilePage.ensurePageLoaded()
                .getEmail();
        return new User()
                .setEmail(email);
    }
}
