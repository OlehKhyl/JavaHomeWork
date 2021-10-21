package com.pb.khyl.hw3;

import java.util.Scanner;

public class Array {
    public static void main(String[] args) {
        // Создание массива и ввод элементов в консоли
        int[] array = new int[10];
        Scanner in = new Scanner(System.in);
        System.out.println("Введите значения для массива: ");
        for(int i = 0; i < array.length; i++) {
            System.out.print("array[" + i + "]= ");
            System.out.println();
            array[i] = in.nextInt();
        }

        // Вывод массива в консоль
        System.out.print("array[");
        for(int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.print("]");
        System.out.println();

        // Подсчет и отображение суммы элементов массива
        int sum = 0;
        for(int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        System.out.println("Сумма элементов массива:" + sum);

        // Подсчет количества положительных элементов массива
        int positiveCount = 0;
        for(int i = 0; i < array.length; i++) {
            if (array[i] > 0) {
                positiveCount++;
            } else {
                continue;
            }
        }
        System.out.println("Кол-во положительных элементов:" + positiveCount);


        // Сортировка массива от меньшего к большему
        int swapItem;
        for (int j = 0; j < array.length; j++) {
            for (int i = 1; i < array.length; i++) {
                if (array[i - 1] > array[i]) {
                    swapItem = array[i];
                    array[i] = array[i - 1];
                    array[i - 1] = swapItem;
                }
            }
        }

        // Вывод в консоль отсортированного массива
        System.out.println("Элементы массва от меньшего к большему: ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }

    }
}
