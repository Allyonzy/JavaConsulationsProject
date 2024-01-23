import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.UUID;
import java.util.logging.Logger;

public class App {
    public static void main(String[] args) {
        System.out.println("Введите число UUID генераций");
        Integer end = 0;
        try (Scanner scanner = new Scanner(System.in) ) {
            end = scanner.nextInt();
        } catch (InputMismatchException exception) {
            System.err.println("Ошибка ввода числа");
        }

        for (int start = 0; start < end; start++) {
            System.out.println(UUID.randomUUID().toString());
        }
    }
}
