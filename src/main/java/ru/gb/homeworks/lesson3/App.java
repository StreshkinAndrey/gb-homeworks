package ru.gb.homeworks.lesson3;

import java.util.*;

public class App {
    public static void main(String[] args) {
        task1();
        task2();
    }

    private static void task1() {
        Map<String, Integer> list = new HashMap<>();
        String[] words = {
                "Fire", "Water", "Fire",
                "Red", "Blue", "Orange",
                "Red", "Cat", "Dog",
                "Water", "Water", "Green",
                "Black", "Pink", "Cat",
                "Yellow", "Java", "Fire", "Dog"
        };

        for (String word : words) {
            if (list.containsKey(word))
                list.put(word, list.get(word) + 1);
            else
                list.put(word, 1);
        }
        System.out.println(list);
    }

    private static void task2() {
        Directory directory = new Directory();

        directory.add("Ivanov", "89610226803");
        directory.add("Ivanov", "89121132528");
        directory.add("Petrov", "89056370551");
        directory.add("Sidorov", "89152267054");
        directory.add("Petrov", "89991393456");
        directory.add("Sidorov", "89932345678");
        directory.add("Semenov", "89941054923");
        directory.add("Ignatov", "89294560943");
        directory.add("Ivanov", "89279054821");
        directory.add("Ivanov", "89243095478");

        System.out.println(directory.get("Ivanov"));
        System.out.println(directory.get("Petrov"));
        System.out.println(directory.get("Sidorov"));
        System.out.println(directory.get("Semenov"));
        System.out.println(directory.get("Ignatov"));
    }
}
