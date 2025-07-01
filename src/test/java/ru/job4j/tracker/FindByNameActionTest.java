package ru.job4j.tracker;

import org.junit.jupiter.api.Test;
import ru.job4j.tracker.action.ExitAction;
import ru.job4j.tracker.action.FindByNameAction;
import ru.job4j.tracker.action.UserAction;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.output.MockInput;
import ru.job4j.tracker.output.Output;
import ru.job4j.tracker.output.StubOutput;

import static org.assertj.core.api.Assertions.assertThat;

public class FindByNameActionTest {

    @Test
    void whenItemFoundByName() {

        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        Item item1 = tracker.add(new Item("TestName"));
        Item item2 = tracker.add(new Item("TestName"));
        Input input = new MockInput(
        new String[]{"0", "TestName", "1"}
        );

        UserAction[] actions = new UserAction[]{
                new FindByNameAction(output),
                new ExitAction(output)
        };

        new StartUI(output).init(input, tracker, actions);

        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "Меню:" + ln
                        + "0. Вывод заявок по имени " + ln
                        + "1. Завершить программу" + ln
                        + "=== Вывод заявки по имени ===" + ln
                        + item1 + ln
                        + item2 + ln
                        + "Меню:" + ln
                        + "0. Вывод заявок по имени " + ln
                        + "1. Завершить программу" + ln
                        + "=== Завершение программы ===" + ln
        );
    }
}