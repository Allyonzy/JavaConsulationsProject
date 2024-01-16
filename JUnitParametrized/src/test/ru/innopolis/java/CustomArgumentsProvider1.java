
package ru.innopolis.java;

import static java.lang.invoke.MethodHandles.lookup;
import static org.slf4j.LoggerFactory.getLogger;

import java.util.stream.Stream;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.slf4j.Logger;

public class CustomArgumentsProvider1 implements ArgumentsProvider {

    static final Logger log = getLogger(lookup().lookupClass());

    @Override
    public Stream<? extends Arguments> provideArguments(
            ExtensionContext context) {
        log.debug("Arguments provider [1] to test {}",
                context.getTestMethod().get().getName());

        return Stream.of(Arguments.of("hello", 1), Arguments.of("world", 2));
    }

}
