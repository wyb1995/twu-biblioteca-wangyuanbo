package com.twu.biblioteca;

public class User {
    private String library_number;
    private String userName;
    private String password;
    private String email;
    private String phoneNumber;

    public User(String library_number, String userName, String password, String email, String phoneNumber) {
        this.library_number = library_number;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public String getUserInfo() {
        return String.format("library_number:%-4s name:%-4s email:%-4s phoneNumber:%s", library_number, userName, email, phoneNumber);
    }

    public String getPassword() {
        return this.password;
    }

    public String getLibrary_number() {
        return this.library_number;
    }
}
