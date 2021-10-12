package com.pb.khyl.hw2;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        float operand1;
        float operand2;
        String sign;
        Scanner input = new Scanner(System.in);
        System.out.println("Введите 1 число: ");
        operand1 = input.nextFloat();
        System.out.println("Введите 2 число: ");
        operand2 = input.nextFloat();
        System.out.println("Введите знак операции '+', '-', '*' или '/': ");
        sign = input.next();
        switch (sign) {
            case "+":
                System.out.println("Ответ: " + (operand1 + operand2));
                break;
            case "-":
                System.out.println("Ответ: " + (operand1 - operand2));
                break;
            case "*":
                System.out.println("Ответ: " + (operand1 * operand2));
                break;
            case "/":
                if(operand2 == 0) {
                    System.out.println("Ошибка! Нельзя делить на 0.");
                }
                else {
                    System.out.println("Ответ: " + (operand1 / operand2));
                }
                break;
            default:
                System.out.println("Ошибка! Введен некорректный знак операции");
        }
    }
}
