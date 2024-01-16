
package ru.innopolis.java;

import static java.lang.invoke.MethodHandles.lookup;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.slf4j.LoggerFactory.getLogger;

import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.slf4j.Logger;

class MethodSourcePrimitiveTypesParameterizedTest {

    static final Logger log = getLogger(lookup().lookupClass());

    static IntStream intProvider() {
        return IntStream.of(0, 1);
    }

    @ParameterizedTest
    @MethodSource("intProvider")
    void testWithIntProvider(int argument) {
        log.debug("Parameterized test with (int) argument: {}", argument);
        assertNotNull(argument);
    }

    static DoubleStream doubleProvider() {
        return DoubleStream.of(2d, 3d);
    }

    @ParameterizedTest
    @MethodSource("doubleProvider")
    void testWithDoubleProvider(double argument) {
        log.debug("Parameterized test with (double) argument: {}", argument);
        assertNotNull(argument);
    }

    static LongStream longProvider() {
        return LongStream.of(4L, 5L);
    }

    @ParameterizedTest
    @MethodSource("longProvider")
    void testWithLongProvider(long argument) {
        log.debug("Parameterized test with (long) argument: {}", argument);
        assertNotNull(argument);
    }

}