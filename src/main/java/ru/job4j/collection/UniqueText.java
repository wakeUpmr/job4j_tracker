package ru.job4j.collection;

import java.util.Arrays;
import java.util.HashSet;

public class UniqueText {
    public boolean isEquals(String originTest, String duplicateText) {
        boolean rsl = true;
        String[] origin = originTest.split(" ");
        String[] text = duplicateText.split(" ");
        HashSet<String> check = new HashSet<>(Arrays.asList(origin));
        for (String s : text) {
            if (!check.contains(s)) {
                rsl = false;
                break;
            }
        }
        return rsl;
    }
}
