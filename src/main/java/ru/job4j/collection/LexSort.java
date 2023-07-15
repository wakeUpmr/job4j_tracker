package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        String[] leftStrArr = left.split("\\.");
        String[] rightStrArr = right.split("\\.");
        return Integer.compare(Integer.parseInt(leftStrArr[0]), Integer.parseInt(rightStrArr[0]));
    }
}