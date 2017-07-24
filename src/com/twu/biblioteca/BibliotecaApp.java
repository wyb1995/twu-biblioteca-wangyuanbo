package com.twu.biblioteca;

import java.util.Scanner;

public class BibliotecaApp {

    public static String welcomeMessage() {
        return "Welcome to Biblioteca!";
    }

    public static String[] bookList() {
        Book book1 = new Book("javaScript", "yuanbo", "2017.7.1");
        Book book2 = new Book("javaScript", "yuanbo", "2017.7.1");
        Book book3 = new Book("javaScript", "yuanbo", "2017.7.1");
        String[] bookList = {book1.getBook(), book2.getBook(), book3.getBook()};
        return bookList;
    }

    public static String[] mainMenu() {
        String[] mainMenu = {"BookList"};
        return mainMenu;
    }

    public static void main(String[] args) {
        String welcomeMessage = welcomeMessage();
        System.out.println(welcomeMessage + '\n');
        String[] bookList = bookList();
        System.out.println("Main Menu");
        String[] mainMenu = mainMenu();
        for (int i = 0; i < mainMenu.length; i++) {
            System.out.println(i + 1 + "  " + mainMenu[i]);
        }
        System.out.println("Please enter You choose Number: ");
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        while (number > mainMenu.length || number < 1) {
            System.out.println("input error");
            System.out.println("Please input again: ");
            sc = new Scanner(System.in);
            number = sc.nextInt();
        }
        switch (number) {
            case 1:
                System.out.println("bookList: ");
                System.out.println("书名      作者      出版日期");
                for (String book : bookList) {
                    System.out.println(book);
                }
                break;
        }
    }
}
