package ru.job4j.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class AttachmentSort {
    public static void main(String[] args) {
        List<Attachment> attachments = Arrays.asList(
                new Attachment("image 1", 100),
                new Attachment("image 2", 34),
                new Attachment("image 3", 13)
        );
        Comparator<Attachment> comparator = new Comparator<>() {
            @Override
            public int compare(Attachment o1, Attachment o2) {
                return Integer.compare(o1.getSize(), o2.getSize());
            }
        };
        attachments.sort(comparator);
        System.out.println(attachments);
        Comparator<Attachment> comparatorByName = new Comparator<>() {
            @Override
            public int compare(Attachment left, Attachment right) {
                for (int i = 0; i < Math.min(left.getName().length(), right.getName().length()); i++) {
                    int rsl = Character.compare(left.getName().charAt(i), right.getName().charAt(i));
                    if (rsl != 0) {
                        return rsl;
                    }
                }
                return Integer.compare(left.getName().length(), right.getName().length());
            }
        };
    }
}