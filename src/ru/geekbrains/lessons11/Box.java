package ru.geekbrains.lessons11;

import java.util.ArrayList;
import java.util.Arrays;

public class Box <T extends Fruit> {
    ArrayList<T> box = new ArrayList<>();

    @SafeVarargs
    public Box(T... fruits) {
        box = new ArrayList<>(Arrays.asList(fruits));
    }

    public ArrayList<T> getBox() {
        return box;

    }

    public void addFruit(T fruit) {
        box.add(fruit);
    }

    public float getWeight() {

        float totalWeight = 0.0f;

        for (int i = 0; i < box.size(); i++) {
            totalWeight = totalWeight + box.get(i).getWeight();

        }
        return totalWeight;
    }

    public boolean compare(Box<? extends Fruit> boxWithSomething) {
        return Math.abs(getWeight() - boxWithSomething.getWeight()) < 0.0001f;
    }



}