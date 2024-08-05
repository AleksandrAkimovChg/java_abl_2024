package ru.akimov.javaacademy.core.homework.hw2.office;

public class Office {
    Boss boss;
    Manager manager;
    Security security;
    Secretary secretary;

    public Office(Boss boss, Manager manager, Security security, Secretary secretary) {
        this.boss = boss;
        this.manager = manager;
        this.security = security;
        this.secretary = secretary;
    }

    public void doWorkDay() {
        this.boss.action(manager);
        this.manager.action();
        this.security.action();
        this.secretary.action(this.boss, this.manager, this.security);
    }
}