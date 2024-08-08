package ru.akimov.javaacademy.core.homework.hw1;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static java.math.BigDecimal.ZERO;
import static java.math.BigDecimal.valueOf;

public class Homework1 {
    public static void main(String[] args) {
        ex2();
        System.out.println("___________________________________________");
        ex3();
        System.out.println("___________________________________________");
        ex4();
        System.out.println("___________________________________________");
        advanced();
    }

    public static void ex1() {
        //Открыть класс Calc, там задание!
    }

    public static void ex2() {

        String name = "     ПЕтРов Олег Иванович     ";
        String nameUpperCase = name.trim().toUpperCase();

        if (nameUpperCase.contains("ОВА ")) {
            System.out.println("Уважаемая " + nameUpperCase);
        } else if (nameUpperCase.contains("ОВ ")) {
            System.out.println("Уважаемый " + nameUpperCase);
        } else {
            System.out.println("Неизвестное лицо " + nameUpperCase);
        }
    }

    public static void ex3() {
        double fuel = 10;
        boolean isEngineWork = true;
        boolean hasErrors = false;
        boolean isWheelWork1 = true;
        boolean isWheelWork2 = true;
        boolean isWheelWork3 = true;
        boolean isWheelWork4 = true;
        boolean isWheelsWork = isWheelWork1 && isWheelWork2 && isWheelWork3 && isWheelWork4;

        if (fuel >= 10 && isEngineWork && !hasErrors && isWheelsWork) {
            System.out.println("Машина едет");
        } else {
            System.out.println("Машина не едет");
        }
    }

    public static void ex4() {
        String simply = "this is simply. This is my favorite song.";
        String strChange = simply.replaceAll("this is", "those are");
        int secondIndex = strChange.indexOf("o", strChange.indexOf("o") + 1);
        System.out.println(secondIndex);
    }

    /**
     * Для продвинутых!
     * Принимается только при использовании класса BigDecimal в расчетах.
     */
    public static void advanced() {
        final BigDecimal priceSausage = valueOf(800);
        long soldSausage = 2000;
        BigDecimal coastSausage;

        if (soldSausage < 1000) {
            coastSausage = valueOf(412);
        } else if (soldSausage >= 2000) {
            coastSausage = valueOf(404);
        } else {
            coastSausage = valueOf(408);
        }

        final BigDecimal priceHam = valueOf(350);
        long soldHam = 8511;
        BigDecimal coastHam = valueOf(275);

        final BigDecimal priceNeck = valueOf(500);
        long soldNeck = 6988;
        BigDecimal coastNeck = soldNeck < 500 ? valueOf(311) : valueOf(299);

        BigDecimal incomeSausage = priceSausage.multiply(valueOf(soldSausage));
        BigDecimal incomeHam = priceHam.multiply(valueOf(soldHam));
        BigDecimal incomeNeck = priceNeck.multiply(valueOf(soldNeck));
        BigDecimal totalIncome = incomeSausage.add(incomeHam).add(incomeNeck);

        BigDecimal expenceSausage = coastSausage.multiply(valueOf(soldSausage));
        BigDecimal expenceHam = coastHam.multiply(valueOf(soldHam));
        BigDecimal expenceNeck = coastNeck.multiply(valueOf(soldNeck));
        BigDecimal otherExpence = valueOf(1_000_000);
        BigDecimal totalExpense = expenceSausage.add(expenceHam).add(expenceNeck).add(otherExpence);

        BigDecimal profitBeforeTax = totalIncome.subtract(totalExpense);

        BigDecimal taxRate8 = new BigDecimal("0.08");
        BigDecimal lowLimitTaxRange = valueOf(1_000_000);
        BigDecimal taxRate10 = new BigDecimal("0.1");
        BigDecimal topLimitTaxRange = valueOf(2_000_000);
        BigDecimal taxAmountAboveOneMlnUnderTwoMln = topLimitTaxRange.subtract(lowLimitTaxRange)
                .multiply(taxRate10)
                .setScale(2, RoundingMode.HALF_UP);
        BigDecimal taxRate13 = new BigDecimal("0.13");

        BigDecimal totalTax = ZERO;
        if (profitBeforeTax.compareTo(lowLimitTaxRange) <= 0) {
            BigDecimal taxLowLimitTaxRange = profitBeforeTax
                    .multiply(taxRate8)
                    .setScale(2, RoundingMode.HALF_UP);
            totalTax = totalTax.add(taxLowLimitTaxRange);
        } else {
            BigDecimal taxAmountOneMln = lowLimitTaxRange
                    .multiply(taxRate8)
                    .setScale(2, RoundingMode.HALF_UP);
            totalTax = totalTax.add(taxAmountOneMln);
        }

        if (profitBeforeTax.compareTo(topLimitTaxRange) <= 0) {
            BigDecimal taxUnderTwoMln = profitBeforeTax.subtract(lowLimitTaxRange)
                    .multiply(taxRate10)
                    .setScale(2, RoundingMode.HALF_UP);
            totalTax = totalTax.add(taxUnderTwoMln);
        } else {
            BigDecimal taxAboveTwoMln = profitBeforeTax.subtract(topLimitTaxRange)
                    .multiply(taxRate13)
                    .setScale(2, RoundingMode.HALF_UP);
            BigDecimal taxAmountTwoMln = topLimitTaxRange.subtract(lowLimitTaxRange)
                    .multiply(taxRate10).
                    setScale(2, RoundingMode.HALF_UP);
            totalTax = totalTax.add(taxAboveTwoMln).add(taxAmountTwoMln);
        }
        System.out.println("Налог составил: " + totalTax);
        BigDecimal profitAfterTax = profitBeforeTax.subtract(totalTax);
        System.out.println("Прибылть после налога: " + profitAfterTax);
    }
}
