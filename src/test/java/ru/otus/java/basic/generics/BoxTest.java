package ru.otus.java.basic.generics;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BoxTest {

  int appleWeight = 2;
  int orangeWeight = 3;


  @Test
  void testAdd() {
    Apple apple1 = new Apple(appleWeight);
    Orange orange1 = new Orange(orangeWeight);
    Apple apple2 = new Apple(appleWeight);
    Orange orange2 = new Orange(orangeWeight);

    Assertions.assertEquals(appleWeight, apple1.getWeight());
    Assertions.assertEquals(orangeWeight, orange1.getWeight());

    Box<Fruit> fruitBox = new Box<>();
    Assertions.assertDoesNotThrow(() -> fruitBox.add(apple1));
    Assertions.assertDoesNotThrow(() -> fruitBox.add(orange1));
    Assertions.assertDoesNotThrow(() -> fruitBox.add(new Apple[]{apple2}));
    Assertions.assertDoesNotThrow(() -> fruitBox.add(new Orange[]{orange2}));

    Box<Apple> appleBox = new Box<>();
    Assertions.assertDoesNotThrow(() -> appleBox.add(apple1));
    Assertions.assertDoesNotThrow(() -> appleBox.add(new Apple[]{apple2}));

    Box<Orange> orangeBox = new Box<>();
    Assertions.assertDoesNotThrow(() -> orangeBox.add(orange1));
    Assertions.assertDoesNotThrow(() -> orangeBox.add(new Orange[]{orange2}));
  }

  @Test
  public void testCalculateWeight() {
    Apple apple1 = new Apple(appleWeight);
    Orange orange1 = new Orange(orangeWeight);
    Apple apple2 = new Apple(appleWeight);
    Orange orange2 = new Orange(orangeWeight);

    Box<Fruit> fruitBox = new Box<>();
    fruitBox.add(apple1);
    fruitBox.add(orange1);
    Assertions.assertEquals(appleWeight + orangeWeight, fruitBox.calculateWeight());
    fruitBox.add(new Apple[]{apple2});
    fruitBox.add(new Orange[]{orange2});
    Assertions.assertEquals(2 * appleWeight + 2 * orangeWeight, fruitBox.calculateWeight());

    Box<Apple> appleBox = new Box<>();
    appleBox.add(apple1);
    Assertions.assertEquals(appleWeight, appleBox.calculateWeight());
    appleBox.add(new Apple[]{apple2});
    Assertions.assertEquals(2 * appleWeight, appleBox.calculateWeight());

    Box<Orange> orangeBox = new Box<>();
    orangeBox.add(orange1);
    Assertions.assertEquals(orangeWeight, orangeBox.calculateWeight());
    orangeBox.add(new Orange[]{orange2});
    Assertions.assertEquals(2 * orangeWeight, orangeBox.calculateWeight());
  }

  @Test
  public void testCompare() {
    Apple apple1 = new Apple(appleWeight);
    Apple apple2 = new Apple(appleWeight);
    Apple apple3 = new Apple(appleWeight);
    Orange orange1 = new Orange(orangeWeight);
    Orange orange2 = new Orange(orangeWeight);

    Box<Fruit> fruitBox1 = new Box<>();
    fruitBox1.add(apple1);
    fruitBox1.add(orange1);
    Box<Apple> appleBox = new Box<>();
    appleBox.add(apple1);
    Box<Orange> orangeBox = new Box<>();
    orangeBox.add(orange1);
    Assertions.assertFalse(appleBox.compare(orangeBox));
    Assertions.assertFalse(orangeBox.compare(appleBox));
    Assertions.assertFalse(fruitBox1.compare(orangeBox));
    Assertions.assertFalse(fruitBox1.compare(appleBox));
    Assertions.assertFalse(orangeBox.compare(fruitBox1));
    Assertions.assertFalse(appleBox.compare(fruitBox1));
    Assertions.assertTrue(orangeBox.compare(orangeBox));
    Assertions.assertTrue(appleBox.compare(appleBox));
    Assertions.assertTrue(fruitBox1.compare(fruitBox1));

    Box<Fruit> fruitBox2 = new Box<>();
    fruitBox2.add(apple1);
    Assertions.assertTrue(fruitBox2.compare(appleBox));
    Assertions.assertTrue(appleBox.compare(fruitBox2));

    appleBox.add(apple2);
    appleBox.add(apple3);
    orangeBox.add(orange2);
    Assertions.assertTrue(appleBox.compare(orangeBox));
  }

  @Test
  public void testRefill() {
    Apple apple1 = new Apple(appleWeight);
    Apple apple2 = new Apple(appleWeight);
    Orange orange1 = new Orange(orangeWeight);
    Orange orange2 = new Orange(orangeWeight);
    Box<Apple> appleBox1 = new Box<>();
    Box<Fruit> fruitBox1 = new Box<>();
    Box<Orange> orangeBox1 = new Box<>();
    Box<Apple> appleBox2 = new Box<>();
    Box<Fruit> fruitBox2 = new Box<>();
    Box<Orange> orangeBox2 = new Box<>();

    fruitBox1.add(apple1);
    fruitBox1.add(orange1);
    appleBox1.add(apple1);
    appleBox1.add(apple2);
    orangeBox1.add(orange1);
    orangeBox1.add(orange2);

    fruitBox1.refill(fruitBox1);
    Assertions.assertEquals(appleWeight + orangeWeight, fruitBox1.calculateWeight());
    appleBox1.refill(appleBox1);
    Assertions.assertEquals(2 * appleWeight, appleBox1.calculateWeight());
    orangeBox1.refill(orangeBox1);
    Assertions.assertEquals(2 * orangeWeight, orangeBox1.calculateWeight());

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