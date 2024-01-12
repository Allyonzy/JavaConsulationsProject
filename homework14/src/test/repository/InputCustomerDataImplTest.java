package repository;

import com.github.javafaker.Faker;
import model.Person;
import model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.Nested;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

@DisplayName("Проверяем импорт данных покупателя")
class InputCustomerDataImplTest {


    @Mock
    private final InputCustomerData inputCustomerData = new InputCustomerDataImpl();

    static ArrayList<Product> setProductList() {
        Locale locale = new Locale("ru_RU");
        Faker faker = new Faker(locale);
        ArrayList<Product> products = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Product product = new Product();
            product.setName(faker.commerce().productName());
            product.setPrice(faker.number().numberBetween(1, 5000));
            products.add(product);
        }

        return products;
    }

    @ParameterizedTest
    @MethodSource("setProductList")
    void checkPersonPurchase(Product testProduct) {
        Person person = new Person();
        person.setName("Иван");
        person.setMoney(100000);
        person.setProductBasket(new ArrayList<>());

        ArrayList<Person> personArrayList = new ArrayList<>();
        personArrayList.add(person);

        ArrayList<Product> productsArrayList = new ArrayList<>();
        productsArrayList.add(testProduct);
        RuntimeException thrown = assertThrows(RuntimeException.class, () -> {
            inputCustomerData.purchaseProducts(personArrayList, productsArrayList);
        });
        String result = person.getName() + " может позволить себе " + testProduct.getName();
        assertEquals(result, thrown.getMessage());
//        assertNotNull(inputCustomerData.purchaseProducts(personArrayList, productsArrayList));
    }

    @ParameterizedTest(name= "Сеттим имя покупателю: {0}")
    @CsvSource(value = {"Петр, Петр", ", Вася", "Кристина, Кристина", "Светлана, Светлана"})
    void create_person(String testName, Person result) {
        String[] names = new String[]{testName, "0"};
        assertEquals(result.getName(), inputCustomerData.createPerson(names).getName());
    }
}