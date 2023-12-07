import java.util.function.Predicate;

public class App {
    public static void main(String[] args) {
        Predicate<Integer> isEvenNumber = number -> number % 2 == 0;

        System.out.println(isEvenNumber.test(4));
        System.out.println(isEvenNumber.test(15));
        System.out.println(isEvenNumber.test(40));
        System.out.println(isEvenNumber.test(45436));
    }
}
