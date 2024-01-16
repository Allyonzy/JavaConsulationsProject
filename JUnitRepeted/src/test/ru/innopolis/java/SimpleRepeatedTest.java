
package ru.innopolis.java;

import static java.lang.invoke.MethodHandles.lookup;
import static org.slf4j.LoggerFactory.getLogger;

import org.junit.jupiter.api.RepeatedTest;
import org.slf4j.Logger;

class SimpleRepeatedTest {

    static final Logger log = getLogger(lookup().lookupClass());

    @RepeatedTest(5)
    void test() {
        log.debug("Repeated test");
    }

}
