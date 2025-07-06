package ru.job4j.ex;

public class FindEl {

    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        int result = -1;
        for (int index = 0; index < value.length; index++) {
            if (value[index].equals(key)) {
                result = index;
                break;
            }
        }
        if (result == -1) {
            throw new ElementNotFoundException("индекс элемента не найден");
        }
        return result;
    }

    public static void main(String[] args) {
        try {
            FindEl.indexOf(new String[]{"one", "two", "three"}, "four");
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }
}