package com.pb.khyl.hw3;

import java.util.Scanner;

public class Bingo {
    public static void main(String[] args) {
        System.out.println("Игра Bingo - попробуй угадать число используя как можно меньше попыток. Чтобы выйти из игры напиши выход или exit");
        // Генерация случайного числа, Math.random() вернет число от 0 до 1, чтобы получить от 0 до 100 умножаем на 100,
        // и округляем Math.round, чтобы получить целое число
        int randomNumber = (int) Math.round(Math.random()*100);
        Scanner in = new Scanner(System.in);
        int count = 0;
        // Игра продолжается, пока пользователь не угадает число, или не введет команду выхода,
        // используем бескончный цикл с условиями выхода.
        while (true) {
            count++;
            String countPrase;
            switch (count) {
                case 1:
                    countPrase = "попытку";
                    break;
                case 2:
                case 3:
                case 4:
                    countPrase = "попытки";
                    break;
                default:
                    countPrase = "попыток";
            }
            System.out.println("Попытка номер " + count);
            System.out.println("Введите число от 0 до 100: ");
            //Выход из игры, если в поле ввода введено "выход" или "exit"
            if (in.hasNext("выход") || in.hasNext("exit")) {
                System.out.println("Выход из игры. Вы использовали " + count + " " + countPrase);
                break;
            } else {
                //Если вводится другое значение, преобразуем в целочисленную переменную,
                // если введено не целое число try catch обрабатывает исключение - отобразится сообщение об ошибке ввода без вылета программы
                String input = in.next();
                try {
                    int enteredNumber = Integer.parseInt(input);
                    //Диапозон вводимых чисел от 0 до 100, при вводе другого числа - отображаем ошибку, попытка не засчитывается.
                    if (enteredNumber < 0 || enteredNumber > 100) {
                        System.out.println("Ошибка! число должно быть от 0 до 100, попробуй снова.");
                        count--;
                    // Если введеное число равно случайному числу - отображаем сообщение о победе и счетчик попыток
                    } else if (enteredNumber == randomNumber) {
                        System.out.println("Bingo! Ты угадал число за " + count + " " + countPrase + "!");
                        break;
                    // Если число больше или меньше случайного числа отображаем соответствующее сообщение.
                    } else if (enteredNumber > randomNumber) {
                        System.out.println("Неверно, попробуй меньшее число");
                    } else if (enteredNumber < randomNumber) {
                        System.out.println("Неверно, попробуй большее число");
                    }
                } catch (java.lang.NumberFormatException e) {
                    System.out.println("Ошибка! Некорректное значение! Попробуй снова");
                    count--;
                }

            }


        }
    }
}
