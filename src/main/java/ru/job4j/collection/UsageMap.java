package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("egohio.work@gmail.com", "Krivonos Egor Olegovich");
        for (String key : map.keySet()) {
            String value = map.get(key);
            System.out.println(value);
        }
    }
}
