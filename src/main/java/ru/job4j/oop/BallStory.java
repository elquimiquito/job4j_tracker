package ru.job4j.oop;

public class BallStory {
    public static void main(String[] args) {
        Ball ball = new Ball();
        Fox fox = new Fox();
        Wolf wolf = new Wolf();
        Hare hare = new Hare();
        wolf.tryEat(ball);
        hare.tryEat(ball);
        fox.tryEat(ball);

    }
}
