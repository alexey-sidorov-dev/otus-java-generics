package ru.otus.java.basic.generics;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Fruit> {

  private final List<Fruit> fruits = new ArrayList<>();

  public void add(Fruit fruit) {
    fruits.add(fruit);
  }

  public void add(Fruit fruit, int count) {
    for (int i = 0; i < count; i++) {
      fruits.add(fruit);
    }
  }

  public int calculateWeight() {
    int weight = 0;
    for (Fruit item : fruits
    ) {
      weight += item.getWeight();
    }
    return weight;
  }

  public boolean compare(Box<? extends Fruit> box) {
    return this.calculateWeight() == box.calculateWeight();
  }

  public void refill(Box<? extends Fruit> box) {
    for (Fruit fruit : this.fruits
    ) {
      box.add(fruit);
    }

    this.fruits.clear();
  }
}
