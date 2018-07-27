package ru.mail.selenium.model;

/**
 * Created by sergey.zinchuk on 26.07.2018.
 */
public class User {

    private String id;
    private String login;
    private String password;
    private String email;
    private String domen;

    public String getId() {
        return id;
    }

    public User setId(String id) {
        this.id = id;
        return this;
    }

    public String getLogin() {
        return login;
    }

    public User setLogin(String login) {
        this.login = login;
        return this;
    }

    public String getEmail() {
        if (email == null){
            if (login != null && domen != null){
                return login + domen;
            }
        }
        return email;
    }

    public User setEmail(String email){
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getDomen() {
        return domen;
    }

    public User setDomen(String domen) {
        this.domen = domen;
        return this;
    }
}
