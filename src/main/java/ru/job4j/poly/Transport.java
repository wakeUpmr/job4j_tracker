package ru.job4j.poly;

public interface Transport {

    void go();

    void passengers(int passengerNumber);

    double refuel(int fuelQuantity);
}
