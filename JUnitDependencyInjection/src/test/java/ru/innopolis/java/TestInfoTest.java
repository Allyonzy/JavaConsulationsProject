
package ru.innopolis.java;

import static java.lang.invoke.MethodHandles.lookup;
import static org.slf4j.LoggerFactory.getLogger;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.slf4j.Logger;

class TestInfoTest {

    static final Logger log = getLogger(lookup().lookupClass());

    @BeforeEach
    void init(TestInfo testInfo) {
        String displayName = testInfo.getDisplayName();
        log.debug("@BeforeEach {}", displayName);
    }

    @Test
    @DisplayName("My test")
    @Tag("my-tag")
    void testOne(TestInfo testInfo) {
        log.debug("Display name {}", testInfo.getDisplayName());
        log.debug("Tags {}", testInfo.getTags());
        log.debug("Test class {}", testInfo.getTestClass());
        log.debug("Test method {}", testInfo.getTestMethod());
    }

    @Test
    void testTwo() {
    }

}
