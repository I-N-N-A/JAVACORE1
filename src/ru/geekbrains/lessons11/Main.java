package ru.geekbrains.lessons11;


import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        // Задача 1
        Integer arr1[] = {1, 2, 3, 4, 5, 6, 7};
        String arr2[] = {"A", "B", "C"};
        swap(arr1, 1, 4);
        swap(arr2, 0, 2);

        // Задание 2
        Box<Apple> boxWithApple = new Box<>(new Apple(), new Apple(), new Apple());
        Box<Orange> boxWithOranges = new Box<>(new Orange(), new Orange());
        Box<Orange> anotherBoxWithOranges = new Box<>();

        System.out.println("A box of apples weight " + boxWithApple.getWeight());
        System.out.println("A box of oranges weight " + boxWithOranges.getWeight());

        System.out.println(boxWithApple.compare(boxWithOranges));
    }


    public static void swap(Object[] arr, int n1, int n2) {
        System.out.println("Задание 1: " + Arrays.toString(arr));
        Object sw = arr[n1];
        arr[n1] = arr[n2];
        arr[n2] = sw;
        System.out.println("Меняет два элемента массива местами: " + Arrays.toString(arr) + "\n================================");
    }
}
