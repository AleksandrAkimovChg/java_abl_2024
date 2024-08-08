package ru.akimov.javaacademy.core.homework.hw2.office;

public class Secretary {

    public void action(Boss boss, Manager manager, Security security) {
        System.out.println("секретарь: "
                + boss.getName() + " не волнуйтесь, "
                + manager.getName() + " все успеет. "
                + security.getName() + " - подождите!");
    }
}
