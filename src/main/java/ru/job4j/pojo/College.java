package ru.job4j.pojo;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("Igor Bielogolowski");
        student.setGroup("PR-34");
        student.setDate("28.08.2020");
        System.out.println(student.getName() + ", " + student.getGroup() + ", " + student.getDate());
    }

}
