package com.twu.biblioteca;

import java.util.Scanner;

public class BibliotecaApp {
    static Book book1 = new Book("javaScript", "yuanbo", "2017.7.1");
    static Book book2 = new Book("java", "yuanbo", "2017.7.1");
    static Book book3 = new Book("ruby", "yuanbo", "2017.7.1");

    static Movie movie1 = new Movie("javaScript", "2017.7.1", "yuanbo", 5);
    static Movie movie2 = new Movie("java", "2017.7.1", "yuanbo", 5);
    static Movie movie3 = new Movie("ruby", "2017.7.1", "yuanbo", 5);

    static User user1 = new User("111-1111", "wang", "12345678", "wang@wang.com", "12345678945");

    private static String userInfo;

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

    public static User[] userList() {
        User[] userList = {user1};
        return userList;
    }

    public static Movie[] movieList() {
        Movie[] movieList = {movie1, movie2, movie3};
        System.out.println("movieList: ");
        for (Movie movie : movieList) {
            System.out.println(movie.getMovieDetail());
        }
        return movieList;
    }

    public static String[] mainMenu() {
        String[] mainMenu = {"BookList", "check out book", "return book", "Movie List", "myInfo", "Quit"};
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

    public static boolean login() {
        System.out.println("please enter your library_number:");
        Scanner sc = new Scanner(System.in);
        String library_number = sc.next();
        System.out.println("please enter your password:");
        sc = new Scanner(System.in);
        String password = sc.next();
        User[] userList = userList();

        for (User user : userList) {
            if (user.getLibrary_number().equals(library_number) && user.getPassword().equals(password)) {
                userInfo = user.getUserInfo();
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String welcomeMessage = welcomeMessage();
        System.out.println(welcomeMessage + '\n');
        if (login()) {


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
                        Movie[] movieList = movieList();
                        break;
                    case 5:
                        System.out.println("your info:");
                        System.out.println(userInfo);
                        break;
                    case 6:
                        System.out.println("thanks");
                        flag = false;
                        break;
                }
                if (flag) {
                    showMainMenu();
                    number = chooseNumber();
                }
            }
        }else{
            System.out.println("library_number or password error");
        }
    }
}
