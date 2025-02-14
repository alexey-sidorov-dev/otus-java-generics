package ru.otus.java.basic.generics;

public abstract class Fruit {

  private final String name;
  private final int weight;

  public Fruit(String name, int weight) {
    this.name = name;
    this.weight = weight;
  }

  public int getWeight() {
    return weight;
  }

  public String getName() {
    return name;
  }
}
