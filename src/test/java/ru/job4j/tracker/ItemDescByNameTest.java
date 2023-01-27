package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ItemDescByNameTest {

    @Test
    public void itemAscByNameTest() {
        List<Item> items = Arrays.asList(new Item("Ivan"), new Item("Petr"), new Item("Boris"));
        List<Item> expected = Arrays.asList(new Item("Petr"), new Item("Ivan"), new Item("Boris"));
        Collections.sort(items, new ItemDescByName());
        assertThat(items).isEqualTo(expected);
    }
}