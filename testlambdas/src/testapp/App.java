package testapp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.function.IntPredicate;

public class App {
    private static final String FILE_NAME = "testlambdas/resources/data.txt";
    public static void main(String[] args) {
        IntPredicate isEvenNumber = number -> number % 2 == 0;

        System.out.println(isEvenNumber.test(4));
        System.out.println(isEvenNumber.test(15));
        System.out.println(isEvenNumber.test(40));
        System.out.println(isEvenNumber.test(45436));

        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(FILE_NAME))) {
            String readline = bufferedReader.readLine();

            int[] numbersFromConsole = Arrays
                    .stream(readline.split(",\\s+"))
                    .mapToInt(Integer::parseInt)
                    .filter(isEvenNumber)
                    .toArray();

            System.out.println(Arrays.toString(numbersFromConsole));

        } catch(IOException exception) {
            System.err.println("Файла не существует");
        } catch (NumberFormatException exception) {
            System.err.println("Входные данные должны быть формата числа");
        }
    }
}
