package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int i = 0;
        while (i < Math.min(left.length(), right.length())) {
            int rsl = Character.compare(left.charAt(i), right.charAt(i));
            if (rsl != 0) {
                return rsl;
            }
            i++;
        }
        return Integer.compare(left.length(), right.length());
    }
}