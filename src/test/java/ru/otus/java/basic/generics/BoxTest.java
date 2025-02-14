package ru.otus.java.basic.generics;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BoxTest {

  int appleWeight = 2;
  int orangeWeight = 3;
  Apple apple = new Apple(appleWeight);
  Orange orange = new Orange(orangeWeight);

  @Test
  void testAdd() {

    Assertions.assertEquals(appleWeight, apple.getWeight());
    Assertions.assertEquals(orangeWeight, orange.getWeight());

    Box<Fruit> fruitBox = new Box<>();
    Assertions.assertDoesNotThrow(() -> {
      fruitBox.add(apple);
    });
    Assertions.assertDoesNotThrow(() -> {
      fruitBox.add(orange);
    });

    Box<Apple> appleBox = new Box<>();
    Assertions.assertDoesNotThrow(() -> {
      appleBox.add(apple);
    });

    Box<Orange> orangeBox = new Box<>();
    Assertions.assertDoesNotThrow(() -> {
      orangeBox.add(orange);
    });
  }

  @Test
  public void testCalculateWeight() {
    Box<Fruit> fruitBox = new Box<>();
    fruitBox.add(apple);
    fruitBox.add(orange);
    Assertions.assertEquals(appleWeight + orangeWeight, fruitBox.calculateWeight());
    fruitBox.add(apple, 2);
    fruitBox.add(orange, 2);
    Assertions.assertEquals(3 * appleWeight + 3 * orangeWeight, fruitBox.calculateWeight());

    Box<Apple> appleBox = new Box<>();
    appleBox.add(apple);
    appleBox.add(apple);
    Assertions.assertEquals(2 * appleWeight, appleBox.calculateWeight());
    appleBox.add(apple, 2);
    Assertions.assertEquals(4 * appleWeight, appleBox.calculateWeight());

    Box<Orange> orangeBox = new Box<>();
    orangeBox.add(orange);
    orangeBox.add(orange);
    Assertions.assertEquals(2 * orangeWeight, orangeBox.calculateWeight());
    orangeBox.add(orange, 2);
    Assertions.assertEquals(4 * orangeWeight, orangeBox.calculateWeight());

  }

  @Test
  public void testCompare() {
    Box<Fruit> fruitBox = new Box<>();
    fruitBox.add(apple);
    fruitBox.add(orange, 1);

    Box<Apple> appleBox = new Box<>();
    appleBox.add(apple, 3);

    Box<Orange> orangeBox = new Box<>();
    orangeBox.add(orange, 2);

    Assertions.assertTrue(appleBox.compare(orangeBox));
    Assertions.assertTrue(orangeBox.compare(appleBox));
    Assertions.assertTrue(orangeBox.compare(orangeBox));
    Assertions.assertTrue(appleBox.compare(appleBox));
    Assertions.assertTrue(fruitBox.compare(fruitBox));

    Assertions.assertFalse(fruitBox.compare(appleBox));
    Assertions.assertFalse(fruitBox.compare(orangeBox));
    Assertions.assertFalse(appleBox.compare(fruitBox));
    Assertions.assertFalse(orangeBox.compare(fruitBox));
  }

  @Test
  public void testRefill() {
    Box<Fruit> fruitBox1 = new Box<>();
    fruitBox1.add(apple);
    fruitBox1.add(orange);

    Box<Apple> appleBox1 = new Box<>();
    appleBox1.add(apple, 2);

    Box<Orange> orangeBox1 = new Box<>();
    orangeBox1.add(orange, 2);

    Box<Apple> appleBox2 = new Box<>();
    Box<Fruit> fruitBox2 = new Box<>();
    Box<Orange> orangeBox2 = new Box<>();

    appleBox1.refill(appleBox2);
    Assertions.assertEquals(2 * appleWeight, appleBox2.calculateWeight());
    Assertions.assertEquals(0, appleBox1.calculateWeight());
    appleBox2.refill(fruitBox2);
    Assertions.assertEquals(2 * appleWeight, fruitBox2.calculateWeight());
    Assertions.assertEquals(0, appleBox2.calculateWeight());

    orangeBox1.refill(orangeBox2);
    Assertions.assertEquals(2 * orangeWeight, orangeBox2.calculateWeight());
    Assertions.assertEquals(0, orangeBox1.calculateWeight());
    orangeBox2.refill(fruitBox2);
    Assertions.assertEquals(2 * appleWeight + 2 * orangeWeight, fruitBox2.calculateWeight());
    Assertions.assertEquals(0, orangeBox2.calculateWeight());

    fruitBox1.refill(fruitBox2);
    Assertions.assertEquals(3 * appleWeight + 3 * orangeWeight, fruitBox2.calculateWeight());
    Assertions.assertEquals(0, fruitBox1.calculateWeight());

    fruitBox2.refill(fruitBox1);
    Assertions.assertEquals(3 * appleWeight + 3 * orangeWeight, fruitBox1.calculateWeight());
    Assertions.assertEquals(0, fruitBox2.calculateWeight());
  }
}