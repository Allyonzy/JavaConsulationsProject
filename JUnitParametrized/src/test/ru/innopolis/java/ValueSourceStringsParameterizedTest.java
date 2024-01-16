
package ru.innopolis.java;

import static java.lang.invoke.MethodHandles.lookup;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.slf4j.LoggerFactory.getLogger;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.slf4j.Logger;

class ValueSourceStringsParameterizedTest {

    static final Logger log = getLogger(lookup().lookupClass());

    @ParameterizedTest
    @ValueSource(strings = { "Hello", "World" })
    void testWithStrings(String argument) {
        log.debug("Parameterized test with (String) parameter: {}", argument);
        assertNotNull(argument);
    }

}
