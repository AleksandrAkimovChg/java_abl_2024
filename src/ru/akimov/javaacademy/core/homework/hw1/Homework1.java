package ru.akimov.javaacademy.core.homework.hw1;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Homework1 {
    public static void main(String[] args) {
        //ex2();
        System.out.println("___________________________________________");
        //ex3();
        System.out.println("___________________________________________");
        //ex4();
        System.out.println("___________________________________________");
        int soldSausage = 2000;
        int soldHam = 8511;
        int soldNeck = 6988;
        advanced(soldSausage, soldHam, soldNeck);
    }

    public static void ex1() {
        //Открыть класс Calc, там задание!
    }

    public static void ex2() {
        //Дана строка
        String name = "     ПЕтРов Олег Иванович     ";
        String nameUpperCase = name.trim().toUpperCase();

        if (nameUpperCase.contains("ова ".toUpperCase())) {
            System.out.println("Уважаемая " + nameUpperCase);
        } else if (nameUpperCase.contains("ов ")) {
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

        if (fuel <= 10 && isEngineWork && !hasErrors && isWheelsWork) {
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
    public static void advanced(int soldSausage, int soldHam, int soldNeck) {
        final int priceSausage = 800;
        final int priceHam = 350;
        final int priceNeck= 500;

        int coastSausage = 0;
        int coastHam= 275;
        int coastNeck = 0;

        if (soldSausage < 1000) {
            coastSausage = 412;
        } else if (soldSausage >= 2000) {
            coastSausage = 404;
        } else {
            coastSausage = 408;
        }

        if (soldNeck < 500) {
            coastNeck = 311;
        } else {
            coastNeck = 299;
        }
        int incomeSausage = priceSausage * soldSausage;
        System.out.println("выручка от продажи сосисок: " + incomeSausage);
        int incomeHam = priceHam * soldHam;
        System.out.println("выручка от продажи ветчины: " + incomeHam);
        int incomeNeck = priceNeck * soldNeck;
        System.out.println("выручка от продажи шейки: " + incomeNeck);
        int income = incomeSausage + incomeHam + incomeNeck;
        System.out.println("выручка всего: " + income);
        int expenceSausage = coastSausage * soldSausage;
        System.out.println("расход по сосискам: " + expenceSausage);
        int expenceHam = coastHam * soldHam;
        System.out.println("расход по ветчине: " + expenceHam);
        int expenceNeck = coastNeck * soldNeck;
        System.out.println("расход по шейке: " + expenceNeck);
        int expense = expenceSausage + expenceHam + expenceNeck;
        System.out.println("расход всего: " + expense);
        int profitBeforeTax = income - expense;
        System.out.println("прибыль до налогообложения: " + profitBeforeTax);
        BigDecimal taxRate8 = new BigDecimal("0.08");
        BigDecimal taxRate10 = new BigDecimal("0.1");
        BigDecimal taxRate13 = new BigDecimal("0.13");
        int oneMln = 1_000_000;
        int twoMln = 2_000_000;
        int taxAmountUnderOneMln = 80_000;
        int taxAmountUnderTwoMln = 100_000 + taxAmountUnderOneMln;
        BigDecimal profitBeforeTaxBigDecimal = new BigDecimal(String.valueOf(profitBeforeTax));

        if (profitBeforeTax <= 1_000_000) {
            System.out.println("начинаю расчет налога по ставке 8%");
            BigDecimal tax = profitBeforeTaxBigDecimal
                    .multiply(taxRate8)
                    .setScale(2, RoundingMode.HALF_UP);
            System.out.println(tax);
            BigDecimal profitAfterTax = profitBeforeTaxBigDecimal.subtract(tax);
            System.out.println("прибыль после налогов: " + profitAfterTax);
        } else if (profitBeforeTax > 1_000_000 && profitBeforeTax <= 2_000_000) {
            System.out.println("начинаю расчет налога по ставке 10%");
            BigDecimal profitBeforeTaxUnderTwoMln = new BigDecimal(
                    String.valueOf(profitBeforeTax - oneMln)
            );
            System.out.println("прибыль свыше 1 млн: " + profitBeforeTaxUnderTwoMln);
            BigDecimal taxUnderTwoMln = profitBeforeTaxUnderTwoMln
                    .multiply(taxRate10)
                    .setScale(2, RoundingMode.HALF_UP);
            System.out.println("суммы прибыли свыше 1 млн: " + taxUnderTwoMln);
            System.out.println("сумма налога до 1 млн: " + taxAmountUnderOneMln);
            BigDecimal tax = taxUnderTwoMln.add(new BigDecimal(
                    String.valueOf(taxAmountUnderOneMln)
            ));
            System.out.println("суммы налога всего: " + tax);
            BigDecimal profitAfterTax = profitBeforeTaxBigDecimal.subtract(tax);
            System.out.println("прибыль после налогов: " + profitAfterTax);
        } else if (profitBeforeTax > 2_000_000) {
            System.out.println("начинаю расчет налога по ставке 13%");
            BigDecimal profitBeforeTaxAboveTwoMln = new BigDecimal(
                    String.valueOf(profitBeforeTax - twoMln)
            );
            System.out.println("сумма прибыли свыше 2 млн: " + profitBeforeTaxAboveTwoMln);
            BigDecimal taxAboveTwoMln = profitBeforeTaxAboveTwoMln
                    .multiply(taxRate13)
                    .setScale(2, RoundingMode.HALF_UP);
            System.out.println("сумма налога свыше 2 млн: " + taxAboveTwoMln);
            System.out.println("сумма налога до 2 млн: " + taxAmountUnderTwoMln);
            BigDecimal tax = taxAboveTwoMln.add(
                    new BigDecimal(
                            String.valueOf(taxAmountUnderTwoMln)
                    )
            );
            System.out.println("сумма налога всего: " + tax);
            BigDecimal profitAfterTax = profitBeforeTaxBigDecimal.subtract(tax);
            System.out.println("прибыль после налогов: " + profitAfterTax);
        }
    }
}
