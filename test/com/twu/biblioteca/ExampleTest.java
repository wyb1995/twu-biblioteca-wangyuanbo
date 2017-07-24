package com.twu.biblioteca;


import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ExampleTest {
    BibliotecaApp bibliotecaApp = new BibliotecaApp();
    @Test
    public void test() {
        assertEquals(1, 1);
    }

    @Test
    public void welcomeMessageTest(){
        assertEquals(bibliotecaApp.welcomeMessage(), "Welcome to Biblioteca!");
    }

    @Test
    public void bookListTest() {
        assertEquals(bibliotecaApp.bookList().length, 3);
    }

    @Test
    public void mainMenuTest() {
        assertEquals(bibliotecaApp.mainMenu().length, 2);
    }

}
