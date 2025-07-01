package ru.job4j.tracker;

import org.junit.jupiter.api.Test;
import ru.job4j.tracker.action.ExitAction;
import ru.job4j.tracker.action.FindByIdAction;
import ru.job4j.tracker.action.UserAction;
import ru.job4j.tracker.output.Output;
import ru.job4j.tracker.output.StubOutput;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class FindByIdActionTest {

    @Test
    void whenItemFoundByIdThenOutputCorrectItem() {

        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Test item"));
        Input input = new MockInput( new String[] {"0", String.valueOf(item.getId()), "1"});
        UserAction[] actions = new UserAction[] {
                new FindByIdAction(output),
                new ExitAction(output)
        };

        new StartUI(output).init(input, tracker, actions);

        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "Меню:" + ln
                        + "0. Вывод заявки по id" + ln
                        + "1. Завершить программу" + ln
                        + "=== Вывод заявки по id: ===" + ln
                        + item + ln
                        + "Меню:" + ln
                        + "0. Вывод заявки по id" + ln
                        + "1. Завершить программу" + ln
                        + "=== Завершение программы ===" + ln
        );
    }

    @Test
    void whenItemNotFoundByIdThenOutputNotFoundMessage() {
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        // Добавим элемент, но будем искать несуществующий id
        tracker.add(new Item("Another item"));
        int nonExistId = 999;
        Input input = new MockInput(new String[] {String.valueOf(nonExistId)});
        UserAction action = new FindByIdAction(output);

        action.execute(input, tracker);

        String ln = System.lineSeparator();
        assertThat(output.toString()).contains(
                "=== Вывод заявки по id: ===" + ln,
                "Заявка с введенным id: " + nonExistId + " не найдена." + ln
        );
    }
}