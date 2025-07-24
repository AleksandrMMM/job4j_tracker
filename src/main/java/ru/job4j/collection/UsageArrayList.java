package ru.job4j.collection;

import java.util.ArrayList;
import java.util.List;

public class UsageArrayList {

    public static void main(String[] args) {

        List<String> stringList = new ArrayList<>();
        stringList.add("Petr");
        stringList.add("Ivan");
        stringList.add("Stepan");

        stringList.forEach(System.out::println);
    }
}
