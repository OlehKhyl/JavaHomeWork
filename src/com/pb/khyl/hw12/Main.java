package com.pb.khyl.hw12;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Главное меню");
            System.out.println("Выберите операцию: ");
            System.out.println("Список(С/L)::Добавить новый контакт(Н/N)::Найти(П/F)::Удалить(У/D)::Изменить(Р/E)::Сохранить(З/S)::Загрузить(Ч/Load)::Выйти(В/Q)");
            String menu = sc.next();
            switch (menu) {
                case "С":
                case "с":
                case "L":
                case "l":
                    sc.nextLine();
                    System.out.println("Выберите порядок отображения: ");
                    System.out.println("Имя[А-Я](И/N)::Имя[Я-А](ИР/NR)::Дата изменения(Д/D)::Дата изменения обратный[ДР/DR]");
                    String m = sc.nextLine();
                    if (m.equals("И") || m.equals("и") || m.equals("N") || m.equals("n")) {
                        phoneBook.sortByName();
                    } else if (m.equals("ИР") || m.equals("ир") || m.equals("NR") || m.equals("nr")) {
                        phoneBook.reverseSortByName();
                    } else if (m.equals("Д") || m.equals("д") || m.equals("D") || m.equals("d")) {
                        phoneBook.sortByChangeTime();
                    } else if (m.equals("ДР") || m.equals("др") || m.equals("DR") || m.equals("dr")) {
                        phoneBook.reverseSortByChangeTime();
                    }
                   break;
                case "Н":
                case "н":
                case "N":
                case "n":
                    phoneBook.addContact();
                    break;
                case "П":
                case "п":
                case "F":
                case "f":
                    sc.nextLine();
                    System.out.println("Введите имя для поиска: ");
                    String search = sc.nextLine();
                    phoneBook.searchContact(search);
                    break;
                case "У":
                case "у":
                case "D":
                case "d":
                    sc.nextLine();
                    System.out.println("Введите имя удаления: ");
                    String del = sc.nextLine();
                    phoneBook.deleteContact(del);
                    break;
                case "Р":
                case "р":
                case "E":
                case "e":
                    sc.nextLine();
                    System.out.println("Введите имя для поиска и редактирования: ");
                    String edit = sc.nextLine();
                    phoneBook.editContact(edit);
                    break;
                case "З":
                case "з":
                case "S":
                case "s":
                    phoneBook.writeToFile();
                    break;
                case "Ч":
                case "ч":
                case "Load":
                case "load":
                    phoneBook.readFile();
                    break;
                case "В":
                case "в":
                case "Q":
                case "q":
                    System.exit(0);
            }
        }
    }
}
