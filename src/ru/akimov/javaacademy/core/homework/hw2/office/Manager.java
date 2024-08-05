package ru.akimov.javaacademy.core.homework.hw2.office;

public class Manager {
    String name;

    public Manager(String name) {
        this.name = name;
    }

    public void action() {
        System.out.println("менеджер: Я ничего не успеваю, помогите!");
    }
}