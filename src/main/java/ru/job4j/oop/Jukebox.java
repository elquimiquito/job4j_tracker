package ru.job4j.oop;

public class Jukebox {
    public static void main(String[] args) {
        Jukebox ultimateMusicMachine = new Jukebox();
        ultimateMusicMachine.music(0);
        ultimateMusicMachine.music(1);
        ultimateMusicMachine.music(2);
    }

    public void music(int position) {
        String rsl = switch (position) {
            case 1 -> "Пусть бегут неуклюже";
            case 2 -> "Спокойной ночи";
            default -> "Песня не найдена";
        };
        System.out.println(rsl);
    }
}
