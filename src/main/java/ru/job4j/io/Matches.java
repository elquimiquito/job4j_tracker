package ru.job4j.io;

import java.util.Scanner;

public class Matches {
    public static void main(String[] args) {
        System.out.println("Игра 11.");
        boolean turn = true;
        int count = 11;
        while (count > 0) {
            String player = turn ? "Первый игрок" : "Второй игрок";
            System.out.println(player + " введите число от 1 до 3:");
            Scanner input = new Scanner(System.in);
            int matches = Integer.parseInt(input.nextLine());
            if (matches >= 1 && matches <= 3 && matches <= count) {
                count -= matches;
                System.out.println("На столе осталось " + count + " спичек");
                turn = !turn;
            }
        }
        String winner = !turn ? "Выиграл первый игрок" : "Выиграл второй игрок";
        System.out.println(winner);
    }
}
