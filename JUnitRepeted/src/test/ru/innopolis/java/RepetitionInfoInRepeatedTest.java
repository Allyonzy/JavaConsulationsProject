
package ru.innopolis.java;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.slf4j.Logger;

import static java.lang.invoke.MethodHandles.lookup;
import static org.slf4j.LoggerFactory.getLogger;

class RepetitionInfoInRepeatedTest {

    static final Logger log = getLogger(lookup().lookupClass());
    @RepeatedTest(5)
    void test(RepetitionInfo repetitionInfo) {
        log.debug("Repeated test {}/{}", repetitionInfo.getCurrentRepetition(), repetitionInfo.getTotalRepetitions());
    }
}
