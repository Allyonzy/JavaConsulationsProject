package ru.innopolis.java.homework04;

import ru.innopolis.java.homework05.Person;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Task01 {
    /**
     * Для введенной с клавиатуры буквы английского алфавита
     * нужно вывести слева стоящую букву на стандартной клавиатуре.
     * При этом
     * клавиатура замкнута, т.е. справа от буквы «p» стоит буква «a»,
     * а слева от "а"
     * буква "р", также соседними считаются буквы «l» и буква «z»,
     * а буква «m» с
     * буквой «q»
     * @param args
     */
    public static void main(String[] args) {
        taskExample();
    }

    public static void taskExample(){
        Scanner scanner = new Scanner(System.in);
        try {
            String letter = scanner.nextLine();

            String alphabet = "qwertyuiopasdfghjklzxcvbnm";
            int index = alphabet.indexOf(letter); // получить индекс буквы
            int lastIndex = index-1;

            if(letter.equals("q")){
                lastIndex = 25;
            }
            //charAt - получить букву по индексу
            System.out.println("Левая буква: " + alphabet.charAt(lastIndex));
        } catch(StringIndexOutOfBoundsException | InputMismatchException exeption) {
            System.out.printf("Ошибка: %s\n", exeption);
        }

        System.out.println("Test");

    }
}