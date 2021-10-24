package com.pb.khyl.hw4;

import java.util.Locale;
import java.util.Scanner;

public class CapitalLetter {
    public static String capitalize(String string) {
        StringBuilder newString = new StringBuilder();
        String[] stringParts = string.split(" ");
        for (String stringPart : stringParts) {
            String firstLetter = stringPart.substring(0, 1);
            String stringRest = stringPart.substring(1).toLowerCase(Locale.ROOT);
            String capitalFirstLetter = firstLetter.toUpperCase(Locale.ROOT);
            String capitalString = capitalFirstLetter + stringRest;
            newString.append(capitalString).append(" ");
        }
        return newString.toString();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите предложение: ");
        String string = in.nextLine();
        String capitalString = capitalize(string);
        System.out.println(capitalString);
    }
}
