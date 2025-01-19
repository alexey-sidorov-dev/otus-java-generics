# Домашнее задание курса [OTUS Java Developer. Basic](https://otus.ru/lessons/java-basic/)

## Работа с обобщениями в Java

---
[![Build](https://github.com/alexey-sidorov-dev/otus-java-generics/workflows/Build/badge.svg)](https://github.com/alexey-sidorov-dev/otus-java-generics/actions)
![Language](https://img.shields.io/github/languages/top/alexey-sidorov-dev/otus-java-generics)
[![License](https://img.shields.io/github/license/alexey-sidorov-dev/otus-java-generics)](https://github.com/alexey-sidorov-dev/otus-java-generics/blob/master/LICENSE)

### Цель

Научиться работать с обобщениями в Java.

### Задание

1. Создайте классы _Fruit_, _Apple extends Fruit_, _Orange extends Fruit_;
2.  Создайте класс _Box_, в который можно складывать фрукты. Коробки условно сортируются по типу
фрукта: _Box<Apple>_ только для яблок, _Box<Orange>_ только для апельсинов, _Box<Fruit>_ и для тех, и для
других фруктов. Для хранения фруктов внутри коробки используйте _ArrayList_;
3.  Реализуйте метод добавления фрукта в коробку;
4.  Реализуйте метод _weight_, который высчитывает вес коробки (например, из веса одного фрукта и их
количества, или может через суммирование, как посчитаете нужным). Вес фрукта задаете
самостоятельно, единицы измерения не важны;
5.  Реализуйте метод _compare_, позволяющий сравнить текущую коробку с переданной в качестве
аргумента и возвращающий true, если их массы равны. Можно сравнивать коробки с разными типами фруктов;
6.  Реализуйте метод, позволяющий пересыпать фрукты из текущей коробки в другую. Помним про
сортировку фруктов в коробках;


