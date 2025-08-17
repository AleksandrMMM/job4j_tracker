package ru.job4j.collection;

import java.util.HashSet;

public class UsageHashSet {

    public static void main(String[] args) {
        HashSet<String> autos = new HashSet<>();
        autos.add("Volvo");
        autos.add("BMW");
        autos.add("Toyota");
        autos.add("Lada");

        autos.forEach(System.out::println);
    }
}
