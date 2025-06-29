package ru.job4j.tracker.action;

import ru.job4j.tracker.Input;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;

public class DeleteAction implements UserAction {

    @Override
    public String name() {
        return "Удаление заявки";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {

        int id = input.askInt("Введите id: ");
        Item item = tracker.findById(id);
        tracker.delete(id);
        System.out.println(item != null ? "Заявка удалена успешно." : "Ошибка удаления заявки.");

        return true;
    }
}