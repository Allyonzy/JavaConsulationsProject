
package ru.innopolis.java;

import static java.lang.invoke.MethodHandles.lookup;
import static org.slf4j.LoggerFactory.getLogger;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.slf4j.Logger;

class RepetitionInfoTest {

    static final Logger log = getLogger(lookup().lookupClass());

    @RepeatedTest(2)
    void test(RepetitionInfo repetitionInfo) {
        log.debug("Test {}/{}", repetitionInfo.getCurrentRepetition(),
                repetitionInfo.getTotalRepetitions());
    }

}
