package com.pb.khyl.hw9;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileNumbers {
    private static final Logger LOGGER = Logger.getLogger(FileNumbers.class.getName());

    public static void createNumbersFile() {
        int[] numbersLine = new int[10];
        Path path = Paths.get("numbers.txt");
        StringBuilder stringBuilder = new StringBuilder();
        String s = "";
        for (int i = 0; i < 10; i++) {
            for (int n = 0; n < numbersLine.length; n++) {
                numbersLine[n] = 1 + (int) (Math.random() * 99);
                if(n < numbersLine.length - 1) {
                    stringBuilder.append(numbersLine[n]).append(" ");
                } else {
                    stringBuilder.append(numbersLine[n]).append("\r\n");
                }
            }
            s += stringBuilder;
            LOGGER.entering(FileNumbers.class.getName(), "createNumbersFile");
            try (BufferedWriter writer = Files.newBufferedWriter(path)) {
                writer.write(s);
                s = "";
                LOGGER.log(Level.INFO, "Файл: " + path + " создан и записан успешно");
            } catch (IOException e) {
                LOGGER.log(Level.SEVERE, "Ошибка при создании/записи файла " + path, e.getMessage());
            }
            LOGGER.exiting(FileNumbers.class.getName(), "createNumbersFile");
        }

    }

    public static void createOddNumbersFile() {
        Path readPath = Paths.get("numbers.txt");
        String readString = "";
        StringBuilder str = new StringBuilder();
        LOGGER.entering(FileNumbers.class.getName(), "readNumbersFile");
        try (BufferedReader reader = Files.newBufferedReader(readPath)){
            String line;
            while((line = reader.readLine()) != null) {
                str.append(line).append(" ");
            }
            LOGGER.log(Level.INFO, "Файл: " + readPath + " прочитан успешно");
        } catch (IOException e) {
            System.out.println("Error " + e.getMessage());
            LOGGER.log(Level.SEVERE, "Ошибка при чтении файла: " + readPath, e.getMessage());
        }
        LOGGER.exiting(FileNumbers.class.getName(), "readNumbersFile");
        readString += str;
        readString = readString.replaceAll("\r\n", " ");
        String[] readStringArray = readString.split(" ");
        ArrayList<Integer> nums = new ArrayList<>();
        for (String i : readStringArray) {
            int num = Integer.parseInt(i);
            nums.add(num);
        }
        for (int i = 0; i < nums.size(); i++) {
            if (nums.get(i) % 2 == 0) {
                nums.set(i, 0);
            }
        }
        Path path = Paths.get("odd-numbers.txt");
        StringBuilder stringBuilder = new StringBuilder();
        String s = "";
        int counter = 0;
        for (int i = 0; i < nums.size(); i++) {
            stringBuilder.append(nums.get(i)).append(" ");
            counter++;
            if (counter % 10 == 0) {
                stringBuilder.append("\r\n");
            }
        }
        s += stringBuilder;
        LOGGER.entering(FileNumbers.class.getName(), "createOddNumbersFile");
        try (BufferedWriter writer = Files.newBufferedWriter(path)){
            writer.write(s);
            LOGGER.log(Level.INFO, "Файл: " + path + " создан и записан успешно");
        } catch (IOException e) {
            System.out.println("Error " + e.getMessage());
            LOGGER.log(Level.SEVERE, "Ошибка при создании/записи файла " + path, e.getMessage());
        }
        LOGGER.exiting(FileNumbers.class.getName(), "createOddNumbersFile");
    }

    public static void main(String[] args) {
        createNumbersFile();
        createOddNumbersFile();
    }


}
