package com.pb.khyl.hw12;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.*;


public class PhoneBook {
    ArrayList<Contact> contacts = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    public void addContact() {
        Contact c;
        System.out.println("Введите ФИО: ");
        String FIO = sc.nextLine();
        ArrayList<String> phones = new ArrayList<>();
        String anotherOne = "Y";
        while (anotherOne.equals("Y")||anotherOne.equals("y")||anotherOne.equals("Д")||anotherOne.equals("д")) {
            System.out.println("Введите номер телефона: ");
            String phone = sc.nextLine();
            phones.add(phone);
            System.out.println("Добавить еще один? Y(Д)/N(Н): ");
            anotherOne = sc.nextLine();
        }
        System.out.println("Указать дату рождения и адрес? Y(Д)/N(Н): ");
        String answer = sc.nextLine();
        if (answer.equals("Y")||answer.equals("y")||answer.equals("Д")||answer.equals("д")) {
            System.out.println("Введите год рождения: ");
            int year = sc.nextInt();
            System.out.println("Введите месяц рождения: ");
            int month = sc.nextInt();
            System.out.println("Введите день рождения: ");
            int day = sc.nextInt();
            GregorianCalendar date = new GregorianCalendar(year, month-1, day);
            sc.nextLine();
            System.out.print("Веедите адрес: ");
            String address = sc.nextLine();
            c = new Contact(FIO, date, phones, address);
        } else {
            c = new Contact(FIO, phones);
        }
        contacts.add(c);
    }

    public void deleteContact(String FIO) {
        for (int i=0; i < contacts.size(); i++) {
            if (contacts.get(i).getFullName().contains(FIO)) {
                contacts.remove(i);
            }
        }

    }

    public void searchContact(String FIO) {
        int index = 0;
        for (int i=0; i< contacts.size(); i++){
            if (contacts.get(i).getFullName().contains(FIO)){
                index = i;
            }
        }
        System.out.println(contacts.get(index));
     }

     public void sortByName() {
         contacts.stream()
                 .sorted(Comparator.comparing(Contact::getFullName))
                 .forEach(x -> System.out.println(x));
         }

     public void reverseSortByName() {
         contacts.stream()
                 .sorted(Comparator.comparing(Contact::getFullName).reversed())
                 .forEach(x -> System.out.println(x));
     }

     public void sortByChangeTime() {
         contacts.stream()
                 .sorted(Comparator.comparing(Contact::getChangeTime))
                 .forEach(x -> System.out.println(x));
        }

    public void reverseSortByChangeTime() {
        contacts.stream()
                .sorted(Comparator.comparing(Contact::getChangeTime).reversed())
                .forEach(x -> System.out.println(x));
    }

    public void editContact(String FIO) {
        System.out.println("Выберите поле которое хотите изменить: Имя(И/N), дата рождения (Д/D), номер телефона (T), адрес (А)");
        String choise = sc.nextLine();
        switch (choise) {
            case "N":
            case "n":
            case "И":
            case "и":
                System.out.println("Введите новое ФИО: ");
                String FIOnew = sc.nextLine();
                int index = 0;
                for (int i=0; i< contacts.size(); i++){
                    if (contacts.get(i).getFullName().contains(FIO)){
                        index = i;
                    }
                }
                contacts.get(index).setFullName(FIOnew);
                contacts.get(index).setChangeTime();
                break;
            case "D":
            case "d":
            case "Д":
            case "д":
                System.out.println("Введите год рождения: ");
                int year = sc.nextInt();
                System.out.println("Введите месяц рождения: ");
                int month = sc.nextInt();
                System.out.println("Введите день рождения: ");
                int day = sc.nextInt();
                GregorianCalendar date = new GregorianCalendar(year, month-1, day);
                sc.nextLine();
                index = 0;
                for (int i=0; i< contacts.size(); i++){
                    if (contacts.get(i).getFullName().contains(FIO)){
                        index = i;
                    }
                }
                contacts.get(index).setDateOfBirth(date);
                contacts.get(index).setChangeTime();
                break;
            case "T":
            case "t":
            case "Т":
            case "т":
                ArrayList<String> phoneNumbers = new ArrayList<>();
                index = 0;
                for (int i=0; i< contacts.size(); i++){
                    if (contacts.get(i).getFullName().contains(FIO)){
                        index = i;
                    }
                }
                phoneNumbers = contacts.get(index).getPhoneNumbers();
                System.out.println(phoneNumbers + " Какой номер по порядку изменить?");
                int pos = sc.nextInt();
                sc.nextLine();
                System.out.println("Введите номер: ");
                String number = sc.nextLine();
                phoneNumbers.set(pos-1, number);
                contacts.get(index).setPhoneNumbers(phoneNumbers);
                contacts.get(index).setChangeTime();
                break;
            case "A":
            case "a":
            case "А":
            case "а":
                System.out.println("Введите адрес: ");
                String address = sc.next();
                index = 0;
                for (int i=0; i< contacts.size(); i++) {
                    if (contacts.get(i).getFullName().contains(FIO)) {
                        index = i;
                    }
                }
                contacts.get(index).setAddress(address);
                contacts.get(index).setChangeTime();
        }
    }

    public void writeToFile() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValue(new File("contacts.json"), contacts);
        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
    }

    public ArrayList<Contact> readFile() {
        ObjectMapper objectMapper = new ObjectMapper();
        File contactFile = new File("contacts.json");
        ArrayList<Contact> cont = null;
        try {
            cont = objectMapper.readValue(contactFile, new TypeReference<ArrayList<Contact>>(){});
            System.out.println(cont);
            contacts.addAll(cont);
            return contacts;
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        return cont;
    }

    @Override
    public String toString() {
        return "PhoneBook{" +
                "contacts=" + contacts.toString() +
                '}';
    }
}


