
package ru.innopolis.java;

import static java.lang.invoke.MethodHandles.lookup;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.slf4j.LoggerFactory.getLogger;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.slf4j.Logger;

class ValueSourcePrimitiveTypesParameterizedTest {

    static final Logger log = getLogger(lookup().lookupClass());

    @ParameterizedTest
    @ValueSource(ints = { 0, 1 })
    void testWithInts(int argument) {
        log.debug("Parameterized test with (int) argument: {}", argument);
        assertNotNull(argument);
    }

    @ParameterizedTest
    @ValueSource(longs = { 2L, 3L })
    void testWithLongs(long argument) {
        log.debug("Parameterized test with (long) argument: {}", argument);
        assertNotNull(argument);
    }

    @ParameterizedTest
    @ValueSource(doubles = { 4d, 5d })
    void testWithDoubles(double argument) {
        log.debug("Parameterized test with (double) argument: {}", argument);
        assertNotNull(argument);
    }

    @ParameterizedTest
    @ValueSource(strings = { "aa", "bb" })
    void testWithsStrings(String argument) {
        log.debug("Parameterized test with (String) argument: {}", argument);
        assertNotNull(argument);
    }

}
