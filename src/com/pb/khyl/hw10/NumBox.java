package com.pb.khyl.hw10;

public class NumBox<T extends Number>{
    private int i;
    private int size;
    private final T[] numbers;

    public NumBox(int size) {
        numbers = (T[]) new Number[size];
        i = 0;
    }

    public void add(T t) throws Exception {
        numbers[i] = t;
        i++;
        size = i;
        if (i > numbers.length) {
            throw new Exception("Массив полный");
        }
    }

    public T get(int index) {
        return numbers[index];
    }

    public int length() {
        return size;
    }

    public double average() {
        double average = 0;
        for (int i = 0; i < size; i++) {
            average = average + numbers[i].doubleValue();
        }
        average /= i;
        return average;
    }

    public double sum() {
        double sum = 0;
        for (int i = 0; i < size; i++) {
            sum = sum + numbers[i].doubleValue();
        }
        return sum;
    }

    public T max() {
        int j = 0;
        double max = 0;
        for (int i = 0; i < size; i++) {
            if (numbers[i].doubleValue() > max) {
                max = numbers[i].doubleValue();
                j = i;
            }
        }
        return numbers[j];
    }
}
