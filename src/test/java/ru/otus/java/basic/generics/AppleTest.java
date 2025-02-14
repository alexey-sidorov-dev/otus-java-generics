package ru.otus.java.basic.generics;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AppleTest {

  @Test
  public void testConstructor() {
    Apple apple = new Apple(2);

    Assertions.assertEquals(2, apple.getWeight());
    Assertions.assertEquals("Apple", apple.getName());
  }
}