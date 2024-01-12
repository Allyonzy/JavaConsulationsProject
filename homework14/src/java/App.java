import com.github.javafaker.Faker;
import model.Person;
import model.Product;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        ArrayList<Person> people = inputPeopleData();
        ArrayList<Product> products = generateRandomProducts();
        purchaseProducts(people, products);
        displayShoppingCart(people);
    }

    private static ArrayList<Person> inputPeopleData() {
        ArrayList<Person> people = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имя пользователя (для завершения введите 'END' вместо имени покупателя):");
        while (true) {
            System.out.print("Имя пользователя: ");
            String name = scanner.nextLine();
            if (name.equals("END")) {
                break;
            }
            Person person = new Person();
            person.setName(name);
            System.out.print("Деньги покупателя: ");
            int cash = Integer.parseInt(scanner.nextLine());
            person.setMoney(cash);
            person.setProductBasket(new ArrayList<>());
            people.add(person);
        }

        return people;
    }

    private static ArrayList<Product> generateRandomProducts() {
        ArrayList<Product> products = new ArrayList<>();
        Locale locale = new Locale("ru_RU");
        Faker faker = new Faker(locale);
        for (int i = 0; i < 3; i++) {
            Product product = new Product();
            product.setName(faker.commerce().productName());
            product.setPrice(faker.number().numberBetween(1, 5000));
            products.add(product);
            System.out.println(products.get(i));
        }

        return products;
    }

    private static void purchaseProducts(ArrayList<Person> people, ArrayList<Product> products) {
        for (Person person : people) {
            for (Product product : products) {
                if (person.getMoney() >= product.getPrice()) {
                    person.getProductBasket().add(product);
                    person.setMoney(person.getMoney() - product.getPrice());
                } else {
                    System.out.println(person.getName() + " не может позволить себе " + product.getName());
                }
            }
        }
    }

    private static void displayShoppingCart(ArrayList<Person> people) {
        for (Person person : people) {
            if (person.getProductBasket().isEmpty()) {
                System.out.println(person.getName() + " - ничего не куплено");
            } else {
                System.out.print(person.getName() + " купил : ");
                person.getProductBasket().forEach(product -> System.out.print(product.getName() + ", "));
                System.out.println();
            }
        }
    }
}
