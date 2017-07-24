package com.twu.biblioteca;

public class Book {
    String name, auth, date;
    boolean isChecked;

    public Book(String name, String auth, String date){
        this.name = name;
        this.auth = auth;
        this.date = date;
        this.isChecked = false;
    }

    public void setChecked(boolean isChecked){
        this.isChecked = isChecked;
    }

    public boolean getChecked(){
        return this.isChecked;
    }

    public String getName() {
        return this.name;
    }

    public String getBook(){
        return name + "  " + auth + "  " + date;
    }
}
