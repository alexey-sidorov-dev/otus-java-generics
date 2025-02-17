package ru.otus.java.basic.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Box<T extends Fruit> {

  private final List<T> fruits;

  public Box() {
    fruits = new ArrayList<>();
  }

  public void add(T fruit) {
    fruits.add(fruit);
  }

  public void add(T[] fruits) {
    Arrays.stream(fruits).forEach(this::add);
  }

  public int calculateWeight() {
    int weight = 0;
    for (Fruit fruit : fruits
    ) {
      weight += fruit.getWeight();
    }
    return weight;
  }

  public boolean compare(Box<?> box) {
    return calculateWeight() == box.calculateWeight();
  }

  public void refill(Box<? super T> box) {
    if (this != box) {
      for (T fruit : fruits) {
        box.add(fruit);
      }
      fruits.clear();
    }
  }
}
