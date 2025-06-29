package ru.job4j.tracker.action;

import ru.job4j.tracker.Input;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;

public class ReplaceAction implements UserAction {

    @Override
    public String name() {
        return "Редактирование заявки";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {

        var id = input.askInt("Введите id: ");
        Item item = new Item(input.askStr("Введите имя: "));
        if (tracker.replace(id, item)) {
            System.out.println("Заявка изменена успешно.");
        } else {
            System.out.println("Ошибка замены заявки.");
        }

        return true;
    }
}
