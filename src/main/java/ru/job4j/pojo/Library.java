package ru.job4j.pojo;

public class Library {

    public static void main(String[] args) {

        Book book = new Book("one", 1200);
        Book bookTwo = new Book("Clean code", 997);
        Book bookThree = new Book("Java", 1000);
        Book bookFour = new Book("Go", 1001);

        Book[] books = {book, bookTwo, bookThree, bookFour};

        for (int i = 0; i < books.length; i++) {
            System.out.println(books[i] + " " + i);
        }

        Book temp = books[0];
        books[0] = books[3];
        books[1] = temp;

        for (Book b : books) {
            System.out.println(b.getName());
        }

        for (Book book1 : books) {
            if (book1.getName().equals("Clean code")) {
                System.out.println(book1.getName());
            }
        }
    }
}