package ru.innopolis.java;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;


class ParserTest {

    private ParserImpl parser;

    @BeforeEach
    public void setUp() {
        this.parser = new ParserImpl();
    }

//    @Test
//    public void testOnCorrectNumber() {
//        String forTest = "12345";
//        int expected = 12345;
//        int actual = this.parser.parse(forTest);
//        assertEquals(expected, actual);
//    }
//
//    @Test
//    public void testOnCorrectNumberWithNegativeSign() {
//        String forTest = "-12345";
//        int expected = -12345;
//        int actual = this.parser.parse(forTest);
//        assertEquals(expected, actual);
//    }
//
//    @Test
//    public void testOnCorrectNumberWithPositiveSign() {
//        String forTest = "+12345";
//        int expected = 12345;
//        int actual = this.parser.parse(forTest);
//        assertEquals(expected, actual);
//    }
//
//    @Test
//    public void testOnIncorrectNumber() {
//        String forTest = "+1asda2345";
//
//        assertThrows(IllegalArgumentException.class, () -> {
//            parser.parse(forTest);
//        });
//    }

    @ParameterizedTest
//    @CsvSource(value = {
//            "12345, 12345",
//            "-12345, -12345",
//            "+123, 123"
//    })
    @CsvFileSource(resources = "/data.csv")
    public void testOnCorrectNumbers(String forTest, int expected) {
        assertEquals(expected, parser.parse(forTest));
    }

    @ParameterizedTest
    @ValueSource(strings = {"1asda2345", "", "aba", "+1a", "0001a"})
    public void testOnIncorrectNumber(String forTest) {
        assertThrows(IllegalArgumentException.class, () -> {
            parser.parse(forTest);
        });
    }

}