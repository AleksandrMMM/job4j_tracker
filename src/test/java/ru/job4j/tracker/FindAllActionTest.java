package ru.job4j.tracker;

import org.junit.jupiter.api.Test;
import ru.job4j.tracker.action.ExitAction;
import ru.job4j.tracker.action.FindAllAction;
import ru.job4j.tracker.action.UserAction;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.output.MockInput;
import ru.job4j.tracker.output.Output;
import ru.job4j.tracker.output.StubOutput;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class FindAllActionTest {

    @Test
    void whenFindAllActionTestOutputIsSuccessfully() {
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        Item one = tracker.add(new Item("test1"));
        Item two = tracker.add(new Item("test2"));

        Input input = new MockInput(
                new String[]{"0", "1"}
        );

        List<UserAction> list = new ArrayList<>();
        list.add(new FindAllAction(output));
        list.add(new ExitAction(output));


        new StartUI(output).init(input, tracker, list);

        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "Меню:" + ln
                        + "0. Вывод всех заявок" + ln
                        + "1. Завершить программу" + ln
                        + "=== Показать все заявки ===" + ln
                        + one + ln
                        + two + ln
                        + "Меню:" + ln
                        + "0. Вывод всех заявок" + ln
                        + "1. Завершить программу" + ln
                        + "=== Завершение программы ===" + ln
        );
    }
}