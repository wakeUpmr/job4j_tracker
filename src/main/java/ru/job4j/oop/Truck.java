package ru.job4j.oop;

public class Truck extends Vehicle {

    @Override
    public void accelerate() {
        System.out.println("Электроная педаль газа");
    }

    @Override
    public void steer() {
        System.out.println("Стандартное рулевое управление");
    }

}