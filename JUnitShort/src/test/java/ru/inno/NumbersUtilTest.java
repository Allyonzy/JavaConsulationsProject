package ru.inno;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

@DisplayNameGeneration(value = DisplayNameGenerator.ReplaceUnderscores.class)
@DisplayName("NumbersUtil is working when ...")
class NumbersUtilTest {

    // объект, который я буду тестировать
    private final NumbersUtil numbersUtil = new NumbersUtil();

    @DisplayName("isPrime() is working when ...")
    @Nested
    class ForIsPrime {
        @ParameterizedTest(name = "return <true> on {0}")
        @ValueSource(ints = {2, 3, 7, 113, 31, 41})
        public void on_prime_numbers_return_true(int primeNumber) {
            assertTrue(numbersUtil.isPrime(primeNumber));
        }

        @ParameterizedTest(name = "return <false> on {0}")
        @ValueSource(ints = {121, 169})
        public void on_square_numbers_return_false(int sqrNumber) {
            assertFalse(numbersUtil.isPrime(sqrNumber));
        }

        @ParameterizedTest(name = "throws exception on {0}")
        @ValueSource(ints = {0, 1})
        public void on_problem_numbers_throws_exception(int problemNumber) {
            assertThrows(IllegalArgumentException.class, () -> numbersUtil.isPrime(problemNumber));
        }
    }

}