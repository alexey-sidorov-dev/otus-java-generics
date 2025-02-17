package ru.otus.java.basic.generics;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class OrangeTest {
  @Test
  public void testConstructor() {
    Orange orange = new Orange( 3);

    Assertions.assertEquals(3, orange.getWeight());
    Assertions.assertEquals("Orange", orange.getName());
  }
}