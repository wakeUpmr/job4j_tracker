package ru.job4j.function;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class FunctionCalculatorTest {
    @Test
    public void whenLinearFunctionThenLinearResults() {
        FunctionCalculator function = new FunctionCalculator();
        List<Double> result = function.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result).containsAll(expected);
    }

    @Test
    public void whenQuadraticFunctionThenQuadraticResults() {
        FunctionCalculator function = new FunctionCalculator();
        List<Double> result = function.diapason(-3, 3, x -> 2 * x * x + 5 * x + 10);
        List<Double> expcted = Arrays.asList(13D, 8D, 7D, 10D, 17D, 28D);
        assertThat(result).containsAll(expcted);
    }

    @Test
    public void whenExponentialFunctionThenExponentialResults() {
        FunctionCalculator function = new FunctionCalculator();
        List<Double> result = function.diapason(0, 4, x -> Math.pow(3, x));
        List<Double> expected = Arrays.asList(1D, 9D, 27D);
        assertThat(result).containsAll(expected);

    }
}