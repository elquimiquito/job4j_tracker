package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {

    public static void main(String[] args) {
        HashMap<String, String> people = new HashMap<>();
        people.put("whiteheaded12@gmail.com", "Bielogolovski I.I.");
        for (String key : people.keySet()) {
            String rsl = people.get(key);
            System.out.println(key + " = " + rsl);
        }
    }
}
