
package ru.innopolis.java;

import static java.lang.invoke.MethodHandles.lookup;
import static org.slf4j.LoggerFactory.getLogger;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;

class NestTest {

    static final Logger log = getLogger(lookup().lookupClass());

    @BeforeEach
    void setup1() {
        log.debug("Setup 1");
    }

    @Test
    void topTest() {
        log.debug("Test 1");
    }

    @Nested
    class InnerClass1 {

        @BeforeEach
        void setup2() {
            log.debug("Setup 2");
        }

        @Test
        void innerTest1() {
            log.debug("Test 2");
        }

        @Nested
        class InnerClass2 {

            @Test
            void innerTest2() {
                log.debug("Test 3");
            }

        }
    }
}
