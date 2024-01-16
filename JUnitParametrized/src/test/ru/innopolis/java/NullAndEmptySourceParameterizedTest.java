
package ru.innopolis.java;

import static java.lang.invoke.MethodHandles.lookup;
import static org.slf4j.LoggerFactory.getLogger;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import org.slf4j.Logger;

class NullAndEmptySourceParameterizedTest {

    static final Logger log = getLogger(lookup().lookupClass());

    @ParameterizedTest
    @ValueSource(strings = { "five", "six" })
    @NullAndEmptySource
    void testWithStringsAndNullAndEmpty(String arg) {
        log.debug("arg: {}", arg);
    }

}
