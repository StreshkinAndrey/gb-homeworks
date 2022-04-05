package ru.gb.homeworks.lesson3;

import java.util.*;

public class Directory {
    private Map<String, List<String>> directory = new HashMap<>();
    private List<String> phone_number_list;

    public void add(String surname, String phone_number) {
        if (directory.containsKey(surname)) {
            phone_number_list = directory.get(surname);
            phone_number_list.add(phone_number);
            directory.put(surname, phone_number_list);
        } else {
            phone_number_list = new ArrayList<>();
            phone_number_list.add(phone_number);
            directory.put(surname, phone_number_list);
        }
    }

    public List<String> get(String surname) {
        return directory.get(surname);
    }
}