package ru.job4j.poly;

public class Bus implements Transport {

    @Override
    public void drive() {
        System.out.println("Чтобы начать движение, нужно нажать на педаль газа");
    }

    @Override
    public void passengers(int number) {
        System.out.println("Автобус вмещает 50 пассажиров");
    }

    @Override
    public int charge(int fuelVolume) {
        return 40 * fuelVolume;
    }
}
