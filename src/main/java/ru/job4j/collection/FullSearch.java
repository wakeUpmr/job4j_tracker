package ru.job4j.collection;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FullSearch {
    public Set<String> extractNumber(List<Task> numbers) {
        Set<String> rsl = new HashSet<>();
        for (Task number : numbers) {
            rsl.add(number.getNumber());
        }
        return Set.copyOf(rsl);
    }
}
