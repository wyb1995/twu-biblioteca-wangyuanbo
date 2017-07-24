package com.twu.biblioteca;

public class Book {
    String name, auth, date;

    public Book(String name, String auth, String date){
        this.name = name;
        this.auth = auth;
        this.date = date;
    }

    public String getBook(){
        return name + "  " + auth + "  " + date;
    }
}
