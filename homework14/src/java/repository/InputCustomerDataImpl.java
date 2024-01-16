package repository;

import model.Person;
import model.Product;

import java.util.ArrayList;
import java.util.Scanner;

public class InputCustomerDataImpl implements InputCustomerData{

    private static final Scanner scanner = new Scanner(System.in);
    /**
     * @return
     */
    @Override
    public ArrayList<Person> inputPersonData() {
        ArrayList<Person> people = new ArrayList<>();
        String[] inputDataArray = new String[2];
        String name = scanner.nextLine();
        while (!name.equals("END")) {
            inputDataArray[0] = scanner.nextLine();
            inputDataArray[1] = scanner.nextLine();
            people.add(createPerson(inputDataArray));
            name = scanner.nextLine();
        }

        return people;
    }

    @Override
    public Person createPerson(String[] inputData) {
        Person person = new Person();
        person.setName(inputData[0]);
        person.setMoney(Integer.parseInt(inputData[1]));
        person.setProductBasket(new ArrayList<>());
        return person;
    }

    /**
     * @param people
     * @param products
     */
    @Override
    public ArrayList<Person> purchaseProducts(ArrayList<Person> people, ArrayList<Product> products) throws RuntimeException{
        for (Person person : people) {
            for (Product product : products) {
                if (person.getMoney() >= product.getPrice()) {
                    person.getProductBasket().add(product);
                    person.setMoney(person.getMoney() - product.getPrice());
                } else {
                    //TODO переписать на throw exception
                    //TODO убрать все System out
                    throw new RuntimeException(person.getName() + " не может позволить себе " + product.getName());
                }
            }
        }
        return people;
    }

    /**
     * @param people
     */
    @Override
    public void displayProductBasket(ArrayList<Person> people) {
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
