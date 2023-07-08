package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("egohio.work@gmail.com", "Krivonos Egor Olegovich");
        map.put("egohio.work@gmail.com", "Krivonos Yakov Olegovich");
        map.put("ktulh0@gmail.com", "Krivonos Nikolay Olegovich");
        map.put("karl11karl11@gmail.com", "Ivanov Stepan Maksimovich");
        for (String key : map.keySet()) {
            String value = map.get(key);
            System.out.println(value);
        }
    }
}
