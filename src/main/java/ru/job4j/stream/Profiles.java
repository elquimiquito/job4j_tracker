package ru.job4j.stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Profiles {

    public static List<Address> collect(List<Profile> profiles) {
        return profiles.stream()
                .map(Profile::getAddress)
                .collect(Collectors.toList());
    }

    public static List<Address> collectSortWithoutDuplicate(List<Profile> profiles) {
        Comparator<Address> cmp = Comparator.comparing(Address::getCity);
        return Profiles.collect(profiles).stream()
                .sorted(cmp)
                .distinct()
                .collect(Collectors.toList());
    }
}