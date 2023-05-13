package ru.job4j.ex;

public class FindEl {
    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        int rsl = -1;
        for (int i = 0; i < value.length; i++) {
            if (key.equals(value[i])) {
                rsl = i;
                break;
            }
        }
        if (rsl == -1) {
            throw new ElementNotFoundException("element was not found");
        }
        return rsl;
    }

    public static void main(String[] args) {
        try {
            String[] value = {"apple", "samsung", "honor", "huawei", "asus", "lenovo", "nokia"};
            System.out.println(indexOf(value, "lg"));
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }
}