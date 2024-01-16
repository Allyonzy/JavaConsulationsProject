
package ru.innopolis.java;

import static java.lang.invoke.MethodHandles.lookup;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.slf4j.LoggerFactory.getLogger;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.slf4j.Logger;

class ArgumentSourceParameterizedTest {

    static final Logger log = getLogger(lookup().lookupClass());

    @ParameterizedTest
    @ArgumentsSource(CustomArgumentsProvider1.class)
    void testWithArgumentsSource(String first, int second) {
        log.debug("Parameterized test with (String) {} and (int) {} ", first,
                second);

        assertNotNull(first);
        assertTrue(second > 0);
    }

}
