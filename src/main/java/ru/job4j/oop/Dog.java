package ru.job4j.oop;

public class Dog {
    private String name;

    public Dog(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        var dog = new Dog("polkan");
        var dogTwo = new Dog("sharick");
        var dogThree = new Dog("zhuchka");
    }
}