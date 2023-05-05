package ru.job4j.poly;

public class Bus implements Transport {
    @Override
    public void go() {
        System.out.println("Автобус поехал.");
    }

    @Override
    public void passengers(int passengerNumber) {
        System.out.println("В автобусе сейчас: " + passengerNumber + " пассажиров.");
    }

    @Override
    public double refuel(int fuelQuantity) {
        return 44.5 * fuelQuantity;
    }
}
