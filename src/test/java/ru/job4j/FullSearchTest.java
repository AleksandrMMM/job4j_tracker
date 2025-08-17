package ru.job4j;

import org.junit.jupiter.api.Test;
import ru.job4j.collection.FullSearch;
import ru.job4j.collection.Task;

import java.util.*;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class FullSearchTest {

    @Test
    public void whenExtractNumberWithDuplicates() {
        FullSearch fullSearch = new FullSearch();
        List tasks = Arrays.asList(
                new Task("1", "First desc"),
                new Task("2", "Second desc"),
                new Task("1", "First desc")
        );
        var expected = new HashSet<>(Arrays.asList("1", "2"));
        assertThat(fullSearch.extractNumber(tasks)).containsAll(expected);
    }

    @Test
    public void whenExtractNumberWithUniqueTasks() {
        FullSearch fullSearch = new FullSearch();
        List tasks = Arrays.asList(
                new Task("1", "First desc"),
                new Task("2", "Second desc"),
                new Task("3", "Third desc")
        );
        var expected = new HashSet<>(Arrays.asList("1", "2", "3"));
        assertThat(fullSearch.extractNumber(tasks)).containsAll(expected);
    }

    @Test
    public void whenExtractNumberWithEmptyList() {
        FullSearch fullSearch = new FullSearch();
        List tasks = List.of();
        assertThat(fullSearch.extractNumber(tasks)).isEmpty();
    }

    @Test
    public void whenExtractNumberWithAllTasksHavingSameNumber() {
        FullSearch fullSearch = new FullSearch();
        List tasks = Arrays.asList(
                new Task("1", "First desc"),
                new Task("1", "Second desc"),
                new Task("1", "Third desc")
        );
        Set expected = Set.of("1");
        assertThat(fullSearch.extractNumber(tasks)).containsAll(expected);
    }
}
