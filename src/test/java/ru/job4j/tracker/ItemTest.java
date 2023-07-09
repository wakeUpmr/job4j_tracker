package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ItemTest {
    @Test
    public void whenItemAscByNameTest() {
        List<Item> items = Arrays.asList(
                new Item("array"),
                new Item("test11"),
                new Item("test22"),
                new Item("bounce"),
                new Item("check_sort")
        );
        items.sort(new ItemAscByName());
        List<Item> expected = Arrays.asList(
                new Item("array"),
                new Item("bounce"),
                new Item("check_sort"),
                new Item("test11"),
                new Item("test22")
        );
        assertThat(items).isEqualTo(expected);
    }

    @Test
    public void whenItemDescByName() {
        List<Item> items = Arrays.asList(
                new Item("array"),
                new Item("test11"),
                new Item("test22"),
                new Item("bounce"),
                new Item("check_sort")
        );
        items.sort(new ItemDescByName());
        List<Item> expected = Arrays.asList(
                new Item("test22"),
                new Item("test11"),
                new Item("check_sort"),
                new Item("bounce"),
                new Item("array")
        );
        assertThat(items).isEqualTo(expected);
    }
}