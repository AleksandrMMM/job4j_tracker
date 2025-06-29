package ru.job4j.tracker.action;

import ru.job4j.tracker.Input;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;

public class FindAllAction implements UserAction {

    @Override
    public String name() {
        return "Вывод всех заявок";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {

        var items  = tracker.findAll();
        if (items.length > 0) {
            for (Item item : items) {
                System.out.println(item);
            }
        } else {
            System.out.println("Хранилище еще не содержит заявок");
        }

        return true;
    }
}