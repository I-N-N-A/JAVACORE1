package ru.geekbrains.lessons11;

import java.util.*;

public class PhoneBook {
    private final Map<String, ArrayList<String>> phoneBook = new HashMap<>();

    public void add(String lastName, String phoneNumber) {
        ArrayList<String> phoneNumberList = new ArrayList<>();
        if (phoneBook.containsKey(lastName)) {
            phoneNumberList = phoneBook.get(lastName);
            phoneNumberList.add(phoneNumber);
            System.out.println("Для абонента (" + lastName + ") был добавлен дополнительный номер: " + phoneNumber);
        } else {
            phoneNumberList.add(phoneNumber);
            phoneBook.put(lastName, phoneNumberList);
            System.out.println("В каталог добавлен новый подписчик. " + lastName + ": " + phoneNumber);
        }
    }

    public String get(String lastName) {
        return "Абонент " + lastName + " владеет следующими номерами: " + phoneBook.get(lastName);
    }

}
