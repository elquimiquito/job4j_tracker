package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book first = new Book("Властелин колец", 1000);
        Book second = new Book("Унесенные ветром", 400);
        Book third = new Book("Война и мир", 1250);
        Book fourth = new Book("Clean code", 240);
        Book[] books = new Book[4];
        books[0] = first;
        books[1] = second;
        books[2] = third;
        books[3] = fourth;
        for (int i = 0; i < books.length; i++) {
            Book bk = books[i];
            System.out.println(bk.getName() + " - " + bk.getNumberOfPages());
        }
        Book temporal = books[3];
        books[3] = books[0];
        books[0] = temporal;
        for (int i = 0; i < books.length; i++) {
            Book bk = books[i];
            System.out.println(bk.getName() + " - " + bk.getNumberOfPages());
        }
        for (int i = 0; i < books.length; i++) {
            if ("Clean code".equals(books[i].getName())) {
                System.out.println(books[i].getName());
            }
        }
    }
}
