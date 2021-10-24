package com.pb.khyl.hw4;

import java.util.Locale;
import java.util.Scanner;

public class Anagram {
    public static String isAnagram (String sentence1, String sentence2) {
        String answer;
//        Убираем из предложений пробелы и знаки препинания и переводим в нижний регистр для сравнения
        String sentence1Clear = sentence1.replaceAll("[.,!-()<>_?'\" `~;:/]", "").toLowerCase(Locale.ROOT);
        String sentence2Clear = sentence2.replaceAll("[.,!-()<>_?'\" `~;:/]", "").toLowerCase(Locale.ROOT);
//        Проверяем, совпадает ли длина предложений без знаков препинания и пробелов,
//        если нет - предложения не могут быть анаграммой
        if (sentence1Clear.length() == sentence2Clear.length()) {
            int contains = 0;
//            Разбиваем строки на массивы символов, при совпадении увеличиваем счетчик совпадений,
//            забиваем *, чтобы избежать повторного сравнения символа и переходим к следующему символу в первой строке
            char[] str1Array = sentence1Clear.toCharArray();
            char[] str2Array = sentence2Clear.toCharArray();
            for (int i = 0; i < str1Array.length; i++) {
                for (int j = 0; j < str2Array.length; j++) {
                    if (str1Array[i] == str2Array[j]) {
                        contains++;
                        str2Array[j]= '*';
                        break;
                    }
                }
            }
//            Если количество совпадений равно длине строки - строки являются анаграммами
            if (contains == sentence1Clear.length()) {
                answer = (sentence2 + " является анаграммой " + sentence1);
            } else {
                answer = (sentence2 + " не является анаграммой " + sentence1);
            }

        } else {
            answer = (sentence2 + " не является анаграммой " + sentence1);
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите 1 предложение");
        String sentence1 = in.nextLine();
        System.out.println("Введите 2 предложение");
        String sentence2 = in.nextLine();
        System.out.println(isAnagram(sentence1, sentence2));
    }
}
