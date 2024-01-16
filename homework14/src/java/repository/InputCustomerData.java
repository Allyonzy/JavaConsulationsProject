package repository;

import model.Person;
import model.Product;

import java.util.ArrayList;

public interface InputCustomerData {
    ArrayList<Person> inputPersonData();
    Person createPerson(String[] inputData);
    ArrayList<Person> purchaseProducts(ArrayList<Person> people, ArrayList<Product> products) throws RuntimeException;
    void displayProductBasket(ArrayList<Person> people);
}
