package ru.job4j.oop;

public class Jukebox {

    public void music(int position) {

        if (position == 1) {
            new Student().sing("Пусть бегут неуклюже");
        }
        if (position == 2) {
            new Student().sing("Спокойной ночи");
        }
        if (position != 1 && position != 2) {
            System.out.println("Песня не найдена");
        }
    }

    public static void main(String[] args) {
        new Jukebox().music(1);
        new Jukebox().music(2);
        new Jukebox().music(0);
    }
}