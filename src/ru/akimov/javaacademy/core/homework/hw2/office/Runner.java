package ru.akimov.javaacademy.core.homework.hw2.office;

public class Runner {
    public static void main(String[] args) {
        Boss boss = new Boss("Петр Николаевич");
        Manager manager = new Manager("Володя");
        Security security = new Security("Петрович");
        Secretary secretary = new Secretary();
        Office office = new Office(boss, manager, security, secretary);
        office.doWorkDay();
    }
}