package ru.job4j.tracker.action;

import ru.job4j.tracker.Input;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;

import java.util.Objects;

public class FindByIdAction implements UserAction {

    @Override
    public String name() {
        return "Вывод заявки по id";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {

        int id = input.askInt("Введите id: ");
        Item item = tracker.findById(id);
        if (Objects.nonNull(item)) {
            System.out.println(item);
        } else {
            System.out.println("Заявка с введенным id: " + id + " не найдена.");
        }
        return true;
    }
}