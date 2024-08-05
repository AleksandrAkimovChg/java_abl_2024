package ru.akimov.javaacademy.core.homework.hw2.office;

public class Security {
    String name;

    public Security(String name) {
        this.name = name;
    }

    public void action() {
        System.out.println("охранник: Прошу выдать мне аванс.");
    }
}