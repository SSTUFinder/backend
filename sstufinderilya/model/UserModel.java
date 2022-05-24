package com.diplom.sstufinder.model;

public class UserModel {

    private Long id;
    private String login;
    private String password;
    private String firstname;
    private String lastname;
    private String email;
    private String number_record_book;

    public UserModel() {
    }

    public UserModel(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public UserModel(Long id, String login, String password, String firstName, String lastName, String email, String number_record_book) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.firstname = firstName;
        this.lastname = lastName;
        this.email = email;
        this.number_record_book = number_record_book;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumber_record_book() {
        return number_record_book;
    }

    public void setNumber_record_book(String number_record_book) {
        this.number_record_book = number_record_book;
    }
}
