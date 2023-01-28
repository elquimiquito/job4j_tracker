package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        Integer leftInt = Integer.parseInt(left.split(". ")[0]);
        Integer rightInt = Integer.parseInt(right.split(". ")[0]);
        return leftInt.compareTo(rightInt);
    }
}