package ru.akimov.javaacademy.core.homework.hw2.office;

public class Boss {
    String name;

    public Boss(String name) {
        this.name = name;
    }

    public void action(Manager manager) {
        System.out.println("босс: " + manager.getName() + " быстрее!");
    }

    public String getName() {
        return name;
    }
}