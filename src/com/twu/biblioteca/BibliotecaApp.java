package com.twu.biblioteca;

import java.util.Scanner;

public class BibliotecaApp {
    static Book book1 = new Book("javaScript", "yuanbo", "2017.7.1");
    static Book book2 = new Book("java", "yuanbo", "2017.7.1");
    static Book book3 = new Book("ruby", "yuanbo", "2017.7.1");

    public static String welcomeMessage() {
        return "Welcome to Biblioteca!";
    }

    public static Book[] bookList() {
        Book[] bookList = {book1, book2, book3};
        System.out.println("bookList: ");
        System.out.println("书名      作者      出版日期");
        for (Book book : bookList) {
            if (!book.getChecked()) {
                System.out.println(book.getBook());
            }
        }
        return bookList;
    }

    public static String[] mainMenu() {
        String[] mainMenu = {"BookList", "check out book", "return book", "Quit"};
        return mainMenu;
    }

    public static boolean checkOutBook(int number) {
        Book[] bookList = bookList();
        if (number > bookList.length || number <= 0) {
            return false;
        } else {
            bookList[number - 1].setChecked(true);
            return true;
        }
    }

    public static boolean returnBook(String name) {
        Book[] bookList = bookList();
        for (Book book : bookList) {
            if (book.getName().equals(name) && book.getChecked()) {
                book.setChecked(false);
                return true;
            }
        }
        return false;
    }

    public static void showMainMenu() {
        System.out.println("Main Menu");
        String[] mainMenu = mainMenu();
        for (int i = 0; i < mainMenu.length; i++) {
            System.out.println(i + 1 + "  " + mainMenu[i]);
        }
    }

    public static int chooseNumber() {
        System.out.println("Please enter You choose Number: ");
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        String[] mainMenu = mainMenu();
        while (number > mainMenu.length || number < 1) {
            System.out.println("input error");
            System.out.println("Please input again: ");
            sc = new Scanner(System.in);
            number = sc.nextInt();
        }
        return number;
    }

    public static void main(String[] args) {
        String welcomeMessage = welcomeMessage();
        System.out.println(welcomeMessage + '\n');
        showMainMenu();
        int number = chooseNumber();
        boolean flag = true;
        while (flag) {
            switch (number) {
                case 1:
                    Book[] bookList = bookList();
                    break;
                case 2:
                    System.out.println("please input book Number: ");
                    Scanner sc = new Scanner(System.in);
                    number = sc.nextInt();
                    boolean isChecked = checkOutBook(number);
                    if (isChecked) {
                        System.out.println("Thank you! Enjoy the book");
                    } else {
                        System.out.println("That book is not available.");
                    }
                    break;
                case 3:
                    System.out.println("please input book Name: ");
                    sc = new Scanner(System.in);
                    String name = sc.next();
                    boolean isReturn = returnBook(name);
                    if (isReturn) {
                        System.out.println("Thank you for returning the book.");
                    } else {
                        System.out.println("That is not a valid book to return.");
                    }
                    break;
                case 4:
                    System.out.println("thanks");
                    flag = false;
                    break;
            }
            if (flag) {
                showMainMenu();
                number = chooseNumber();
            }
        }
    }
}
