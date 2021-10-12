package com.pb.khyl.hw2;

import java.util.Scanner;

public class Interval {
    public static void main(String[] args) {
        int enteredNumber;
        Scanner input = new Scanner(System.in);
        System.out.println("Введите число от 0 до 100: ");
        enteredNumber = input.nextInt();
        if (enteredNumber <= 14) {
            System.out.println("Введено число в диапозоне [0-14]");
        } else if (enteredNumber >= 15 && enteredNumber <= 35) {
            System.out.println("Введено число в диапозоне [15-35]");
        } else if (enteredNumber >= 36 && enteredNumber <= 50) {
            System.out.println("Введено число в диапозоне [36-50]");
        } else if (enteredNumber >= 51 && enteredNumber <= 100) {
            System.out.println("Введено число в диапозоне [51-100]");
        } else {
            System.out.println("Введено некорректное число");
        }
    }
}
