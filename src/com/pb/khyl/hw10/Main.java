package com.pb.khyl.hw10;

public class Main {
    public static void main(String[] args) {
        NumBox<Float> floatNumBox = new NumBox<>(3);
        try {
            floatNumBox.add(3.14f);
        } catch (Exception e) {
            System.out.println("Ошибка добавления " + e.getMessage());
        }
        try {
            floatNumBox.add(4.22f);
        } catch (Exception e) {
            System.out.println("Ошибка добавления " + e.getMessage());
        }
//        try {
//            floatNumBox.add(10.2f);
//        } catch (Exception e) {
//            System.out.println("Ошибка добавления " + e.getMessage());
//        }
//        try {
//            floatNumBox.add(10.2f);
//        } catch (Exception e) {
//            System.out.println("Ошибка добавления " + e.getMessage());
//        }


        System.out.println(
            "нулевой индекс: " + floatNumBox.get(0) +
            " длина: " + floatNumBox.length() +
            " среднее: " + floatNumBox.average() +
            " сумма: " + floatNumBox.sum() +
            " максимальное: " + floatNumBox.max()
        );

        System.out.println("******************************************************************************");

        NumBox<Integer> integerNumBox = new NumBox<>(5);
        Integer[] integers = {5,10,5,2,4,7,8};

        for(int i : integers) {
            try {
                integerNumBox.add(i);
            } catch (Exception e) {
                System.out.println("Ошибка добавления " + e.getMessage());
            }
        }

        System.out.println(
                "первый индекс: " + integerNumBox.get(1) +
                " длина: " + integerNumBox.length() +
                " среднее: " + integerNumBox.average() +
                " сумма: " + integerNumBox.sum() +
                " максимальное: " + integerNumBox.max()
        );
    }
}
