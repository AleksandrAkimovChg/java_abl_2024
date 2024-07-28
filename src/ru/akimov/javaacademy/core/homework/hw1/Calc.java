package ru.akimov.javaacademy.core.homework.hw1;

import java.util.Scanner;

public class Calc {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите первое число");
        double number1 = Double.parseDouble(scanner.nextLine()); // scanner.nextDouble();
        //scanner.nextLine();
        System.out.println("Введите знак операции - \"+\", \"-\", \"*\", \"/\"");
        String operator = scanner.nextLine();
        System.out.println("Введите второе число");
        double number2 = scanner.nextDouble();

        if (operator.equals("+")) {
            System.out.println(number1 + number2);
        } else if (operator.equals("-")) {
            System.out.println(number1 - number2);
        } else if (operator.equals("*")) {
            System.out.println(number1 * number2);
        } else if (operator.equals("/")) {
            System.out.println(number1 / number2);
        } else {
            System.out.println("Ошибка");
        }
        scanner.close();
    }
}
