package ru.job4j.polymorphism;

public class Bus implements Transport {

    @Override
    public void move() {
        System.out.println("Bus moving");
    }

    @Override
    public void passengers(int count) {

        System.out.println("Bus has " + count + " passengers");
    }

    @Override
    public int refuel(int fuel) {
        return fuel / 2;
    }
}