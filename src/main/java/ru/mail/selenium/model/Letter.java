package ru.mail.selenium.model;

/**
 * Created by sergey.zinchuk on 26.07.2018.
 */
public class Letter {

    private String email;
    private String subject;
    private String text;

    public String getEmail() {
        return email;
    }

    public Letter setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getSubject() {
        return subject;
    }

    public Letter setSubject(String subject) {
        this.subject = subject;
        return this;
    }

    public String getText() {
        return text;
    }

    public Letter setText(String text) {
        this.text = text;
        return this;
    }
}
