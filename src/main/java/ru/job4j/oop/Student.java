package ru.job4j.oop;

public class Student {

    public void music() {
        System.out.println("Tra tra tra");
    }

    public void sing() {
        System.out.println("I believe I can fly");
    }

    public void sing(String song) {
        System.out.println(song);
    }

    public static void main(String[] args) {
        Student petya = new Student();
        for (int i = 0; i < 4; i++) {
            petya.music();
            petya.sing();
        }
    }
}