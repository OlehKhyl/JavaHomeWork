package com.pb.khyl.hw5;

public class Reader {
    private String name;
    private int libraryCardNumber;
    private String faculty;
    private String dateOfBirth;
    private String phoneNumber;

    public Reader(String name, int libraryCardNumber, String faculty, String dateOfBirth, String phoneNumber) {
        this.name = name;
        this.libraryCardNumber = libraryCardNumber;
        this.faculty = faculty;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLibraryCardNumber() {
        return libraryCardNumber;
    }

    public void setLibraryCardNumber(int libraryCardNumber) {
        this.libraryCardNumber = libraryCardNumber;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void takeBook(int numberOfBooks) {
        System.out.println(name + " взял " + numberOfBooks + " книги");
    }

    public void takeBook(String... titles) {
        System.out.print(name + " взял книги: ");
        for(String title : titles) {
            System.out.print(title + ", ");
        }
        System.out.println();
    }

    public void takeBook(Book... books) {
        System.out.print(name + " взял книги: ");
        for (Book book : books) {
            System.out.print(book.getTitle() + " (" + book.getAuthor() + " " + book.getYearOfPublishing() + "), ");
        }
        System.out.println();
    }

    public void returnBook(int numberOfBooks) {
        System.out.println(name + " вернул " + numberOfBooks + "книги");
    }

    public void returnBook(String... titles) {
        System.out.print(name + " вернул книги: ");
        for(String title : titles) {
            System.out.print(title + ", ");
        }
        System.out.println();
    }

    public void returnBook(Book... books) {
        System.out.print(name + " вернул книги: ");
        for (Book book : books) {
            System.out.print(book.getTitle() + " (" + book.getAuthor() + " " + book.getYearOfPublishing() + "), ");
        }
        System.out.println();
    }

    public String getInfo() {
        return "ФИО: " + name + ", читателький билет №: " + libraryCardNumber + ", факультет: " + faculty + ", дата рождения: "
                + dateOfBirth + ", телефон: " + phoneNumber;
    }
}
