package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class StartUITest {

    @Test
    void whenAddItem() {
        String[] answers = {"Fix PC"};
        Input input = new MockInput(answers);
        Tracker tracker = new Tracker();
        StartUI.createItem(input, tracker);
        Item created = tracker.findAll()[0];
        Item expected = new Item("Fix PC");
        assertThat(created.getName()).isEqualTo(expected.getName());
    }

    @Test
    void whenAddItemWithMultipleWords() {
        String[] answers = {"Fix the PC"};
        Input input = new MockInput(answers);
        Tracker tracker = new Tracker();
        StartUI.createItem(input, tracker);
        Item created = tracker.findAll()[0];
        Item expected = new Item("Fix the PC");
        assertThat(created.getName()).isEqualTo(expected.getName());
    }

    @Test
    void whenAddMultipleItems() {
        String[] answers = {"Item1", "Item2", "Item3"};
        Input input = new MockInput(answers);
        Tracker tracker = new Tracker();
        for (String answer : answers) {
            new MockInput(new String[]{answer});
            StartUI.createItem(input, tracker);
        }
        Item[] createdItems = tracker.findAll();
        assertThat(createdItems).hasSize(3);
        assertThat(createdItems[0].getName()).isEqualTo("Item1");
        assertThat(createdItems[1].getName()).isEqualTo("Item2");
        assertThat(createdItems[2].getName()).isEqualTo("Item3");
    }
}