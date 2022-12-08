package ru.job4j.oop;

public class Error {
    private boolean active;
    private int status;
    private String message;


    public Error() {
    }

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public void printInfo() {
        System.out.println("Результат: " + active);
        System.out.println("Статус: " + status);
        System.out.println("Сообщение: " + message);
    }

    public static void main(String[] args) {
        Error task1 = new Error();
        task1.printInfo();
        Error task2 = new Error(true, 125, "Ошибок нет");
        task2.printInfo();
        Error task3 = new Error(false, 0, "Все очень плохо");
        task3.printInfo();
    }
}
