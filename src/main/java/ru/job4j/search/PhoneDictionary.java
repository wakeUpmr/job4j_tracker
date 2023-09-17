package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        ArrayList<Person> result = new ArrayList<>();
        Predicate<Person> nameContains = person -> person.getName().contains(key);
        Predicate<Person> surnameContains = person -> person.getSurname().contains(key);
        Predicate<Person> phoneContains = person -> person.getPhone().contains(key);
        Predicate<Person> addressContains = person -> person.getAddress().contains(key);
        var overall = nameContains.or(surnameContains).or(phoneContains).or(addressContains);
        for (var person : persons) {
            if (overall.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}
