package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;

public class FilterNegativeNumbers {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, -10, 10, 5, -4, -3, 2, -2, 11, 13, -7);
        List<Integer> positive = numbers.stream().filter((n) -> n > 0).toList();
        positive.forEach(System.out::println);
    }
}