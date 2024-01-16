package ru.innopolis.java;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class NumbersProcessorTest {

    private NumbersProcessor numbersProcessor;

    @Mock
    private Parser parser;


    @BeforeEach
    void setUp() {
        when(parser.parse("12345")).thenReturn(12345);
        when(parser.parse("-1234")).thenReturn(1234);
        when(parser.parse("+123")).thenReturn(123);

        numbersProcessor = new NumbersProcessor(parser);
    }

    @Test
    void checkEven() {
        String forTest[] = {"12345", "-1234", "+123"};
        List<Boolean> actual = numbersProcessor.checkEven(forTest);
        List<Boolean> expected = Arrays.asList(false, true, false);
        assertEquals(expected, actual);

    }
}