package com.pb.khyl.hw5;

public class Library {
    public static void main(String[] args) {
        Book[] book = new Book[3];
        book[0] = new Book("Приключения", "Иванов И. И.", 2000);
        book[1] = new Book("Словарь", "Сидоров А. В.", 1980);
        book[2] = new Book("Энциклопедия", "Гусев К. В.", 2010);

        Reader[] reader = new Reader[3];
        reader[0] = new Reader("Петров В. В.", 55522202, "Юридический", "02.04.2002", "+380959379992");
        reader[1] = new Reader("Сидоров В. С.", 77889563, "ПриМат", "29.09.2004", "+8800253535");
        reader[2] = new Reader("Шевченко Т. Г.", 15967842, "Литература", "09.03.1814", "+380442783511");

        for(Book b : book) {
            System.out.println(b.getInfo());
        }
        System.out.println();

        for(Reader r : reader) {
            System.out.println(r.getInfo());
        }
        System.out.println();

        reader[0].takeBook(3);
        reader[1].takeBook("Приключения", "Словарь", "Энциклопедия");
        reader[2].takeBook(book[0], book[1]);

        reader[0].returnBook(3);
        reader[1].returnBook("Словарь", "Энциклопедия");
        reader[2].returnBook(book[0], book[2]);
    }
}
