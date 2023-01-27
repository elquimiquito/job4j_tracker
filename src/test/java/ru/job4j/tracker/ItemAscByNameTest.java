package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ItemAscByNameTest {

    @Test
    public void itemAscByNameTest() {
        List<Item> items = Arrays.asList(new Item("Ivan"), new Item("Petr"), new Item("Boris"));
        List<Item> expected = Arrays.asList(new Item("Boris"), new Item("Ivan"), new Item("Petr"));
        Collections.sort(items, new ItemAscByName());
        assertThat(items).isEqualTo(expected);
    }
}