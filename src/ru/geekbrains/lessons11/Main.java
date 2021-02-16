package ru.geekbrains.lessons11;


import java.util.*;

public class Main {

    public static void main(String[] args) {
             // Задание 1.
            List<String> words = Arrays.asList(
                    "Роза", "Гвоздика", "Пион", "Посолнух", "Астра",
                    "Астра", "Астра", "Пион", "Роза", "Роза",
                    "Пион", "Пион", "Пион", "Роза", "Астра",
                    "Гвоздика", "Гвоздика", "Роза ", "Пион", "Подсолнух"
            );

            Set<String> unique = new HashSet<>(words);

            System.out.println("Первоначальный массив");
            System.out.println(words.toString());
            System.out.println("Уникальные слова");
            System.out.println(unique.toString());
            System.out.println("Частота встречаемости слов");
            for (String key : unique) {
                System.out.println(key + ": " + Collections.frequency(words, key));
            }

        // Задание 2.
        PhoneBook phoneBook = new PhoneBook();

        phoneBook.add("Иванов", "+995543223351");
        phoneBook.add("Петров", "+995543223351");
        phoneBook.add("Сидоров", "+995554723351");
        phoneBook.add("Орлов", "+995548533351");
        phoneBook.add("Соколов", "+995545433351");
        phoneBook.add("Иванов", "+995543252351");
        phoneBook.add("Петров", "+995543297551");
        phoneBook.add("Сидоров", "+995543325351");
        phoneBook.add("Орлов", "+9955438763351");
        phoneBook.add("Jones", "+995549873351");
        phoneBook.add("Сидоров", "+995549543351");
        System.out.println(phoneBook.get("Иванов"));
        System.out.println(phoneBook.get("Петров"));
        System.out.println(phoneBook.get("Сидоров"));
        System.out.println(phoneBook.get("Орлов"));
        System.out.println(phoneBook.get("Соколов"));
        }

}

