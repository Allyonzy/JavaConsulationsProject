package ru.innopolis.java.homework04;

import java.util.Scanner;

/**
 * Задана последовательность, состоящая только из символов ‘>’,
 * ‘<’ и ‘-‘. Требуется найти количество стрел, которые спрятаны в этой
 * последовательности. Стрелы – это подстроки вида ‘>>-->’ и ‘<--<<’.
 *
 * Входные данные: в первой строке входного потока записана строка,
 * состоящая из символов ‘>’, ‘<’ и ‘-‘ (без пробелов).
 * Строка может содержать до 106 символов.
 * Выходные данные: в единственную строку выходного потока нужно
 * вывести искомое количество стрелок
 */
public class Task02 {

    public static void main(String[] args) {
        TaskExample();
    }

    public static void TaskExample() {
        String str ="<>--<--<<---<>--->>>->>-->--->>-->-<<<<--<<";
        int c=0;
        int b=0;

        // добавить цикл
        if(str.contains(">>-->")){
            c++;
        }

        if(str.contains("<--<<")){
            b++;
        }
        int result=c+b;
        System.out.println(result);
    }

    public static void TaskFullExamle() {
        System.out.print("Введите исходную строку: ");
        Scanner scanner = new Scanner(System.in);
        String inputArrows = scanner.nextLine();

        final String arrowFirst = "<--<<";
        final String arrowSecond = ">>-->";

        if (inputArrows.length() > 106) {
            System.out.println("Длина строки превышает условие");
        }
        else {
            int k = 0;
            int number = inputArrows.indexOf(">>-->");

            while (number != -1) {

                inputArrows = inputArrows.replaceFirst(">>->", "");
                k++;
                number = inputArrows.indexOf(">>-->");

            }

            number = inputArrows.indexOf("<--<<");

            while (number != -1) {

                inputArrows = inputArrows.replaceFirst("<--<<", "");
                k++;
                number = inputArrows.indexOf("<--<<");

            }

            System.out.println("Количество стрел: " + k);
        }
    }
}

