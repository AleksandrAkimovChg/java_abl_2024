package ru.akimov.javaacademy.core.homework.hw1;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Homework1 {
    public static void main(String[] args) {
        ex2();
        System.out.println("___________________________________________");
        ex3();
        System.out.println("___________________________________________");
        ex4();
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
    public static void advanced(int soldSausage, int soldHam, int soldNeck) {

        int coastSausage = 0;
        int coastHam = 275;
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

        final BigDecimal priceSausage = new BigDecimal("800");
        final BigDecimal priceHam = new BigDecimal("350");
        final BigDecimal priceNeck = new BigDecimal("500");

        BigDecimal incomeSausage =  priceSausage.multiply(new BigDecimal(String.valueOf(soldSausage)));
        BigDecimal incomeHam = priceHam.multiply(new BigDecimal(String.valueOf(soldHam)));
        BigDecimal incomeNeck = priceNeck.multiply(new BigDecimal(String.valueOf(soldNeck)));
        BigDecimal income = incomeSausage.add(incomeHam).add(incomeNeck);

        BigDecimal coastSausageBigDecimal = new BigDecimal(String.valueOf(coastSausage));
        BigDecimal expenceSausage = coastSausageBigDecimal.multiply(new BigDecimal(String.valueOf(soldSausage)));
        BigDecimal coastHamBigDecimal = new BigDecimal(String.valueOf(coastHam));
        BigDecimal expenceHam = coastHamBigDecimal.multiply(new BigDecimal(String.valueOf(soldHam)));
        BigDecimal coastNeckBigdecimal = new BigDecimal(String.valueOf(coastNeck));
        BigDecimal expenceNeck = coastNeckBigdecimal.multiply(new BigDecimal(String.valueOf(soldNeck)));
        BigDecimal expense = expenceSausage.add(expenceHam).add(expenceNeck);

        BigDecimal profitBeforeTax = income.subtract(expense);
        System.out.println("прибыль до налогообложения: " + profitBeforeTax);

        BigDecimal taxRate8 = new BigDecimal("0.08");
        BigDecimal taxRate10 = new BigDecimal("0.1");
        BigDecimal taxRate13 = new BigDecimal("0.13");

        BigDecimal profitBeforeTaxOneMln = new BigDecimal(String.valueOf(1_000_000));
        BigDecimal taxAmountOneMln = profitBeforeTaxOneMln
                .multiply(taxRate8)
                .setScale(2, RoundingMode.HALF_UP);

        BigDecimal profitBeforeTaxAboveOneMlbUnderTwoMln = new BigDecimal(String.valueOf(2_000_000 - 1_000_000));
        BigDecimal taxAmountAboveOneMlnUnderTwoMln = profitBeforeTaxAboveOneMlbUnderTwoMln
                .multiply(taxRate10)
                .setScale(2, RoundingMode.HALF_UP);

        if (profitBeforeTax.compareTo(profitBeforeTaxOneMln) <= 0) {
            System.out.println("начинаю расчет налога по ставке 8%");
            BigDecimal tax = profitBeforeTax
                    .multiply(taxRate8)
                    .setScale(2, RoundingMode.HALF_UP);
            System.out.println("суммы налога всего: " + tax);
            BigDecimal profitAfterTax = profitBeforeTax.subtract(tax);
            System.out.println("прибыль после налогов: " + profitAfterTax);
        } else if (profitBeforeTax.compareTo(profitBeforeTaxOneMln) > 0
                && profitBeforeTax.compareTo(profitBeforeTaxAboveOneMlbUnderTwoMln) <= 0) {
            System.out.println("начинаю расчет налога по ставке 10%");
            BigDecimal profitBeforeTaxUnderTwoMln = profitBeforeTax.subtract(profitBeforeTaxOneMln);
            System.out.println("прибыль свыше 1 млн: " + profitBeforeTaxUnderTwoMln);
            BigDecimal taxUnderTwoMln = profitBeforeTaxUnderTwoMln
                    .multiply(taxRate10)
                    .setScale(2, RoundingMode.HALF_UP);
            System.out.println("сумма налога с прибыли свыше 1 млн: " + taxUnderTwoMln);
            System.out.println("сумма налога до 1 млн: " + taxAmountOneMln);
            BigDecimal tax = taxUnderTwoMln.add(taxAmountOneMln);
            System.out.println("суммы налога всего: " + tax);
            BigDecimal profitAfterTax = profitBeforeTax.subtract(tax);
            System.out.println("прибыль после налогов: " + profitAfterTax);
        } else if (profitBeforeTax.compareTo(profitBeforeTaxAboveOneMlbUnderTwoMln) > 0) {
            System.out.println("начинаю расчет налога по ставке 13%");
            BigDecimal profitBeforeTaxAboveTwoMln = profitBeforeTax.subtract(profitBeforeTaxAboveOneMlbUnderTwoMln);
            System.out.println("сумма прибыли свыше 2 млн: " + profitBeforeTaxAboveTwoMln);
            BigDecimal taxAboveTwoMln = profitBeforeTaxAboveTwoMln
                    .multiply(taxRate13)
                    .setScale(2, RoundingMode.HALF_UP);
            System.out.println("сумма налога свыше 2 млн: " + taxAboveTwoMln);
            System.out.println("сумма налога c суммы прибыли 1 млн: " + taxAmountOneMln);
            System.out.println("сумма налога c суммы прибыли 2 млн без 1 млн: " + taxAmountAboveOneMlnUnderTwoMln);
            BigDecimal taxAmountTwoMln = taxAmountOneMln.add(taxAmountAboveOneMlnUnderTwoMln);
            System.out.println("сумма налога c суммы прибыли свыше 2 млн всего: " + taxAmountTwoMln);
            BigDecimal tax = taxAboveTwoMln.add(taxAmountTwoMln);
            System.out.println("сумма налога всего: " + tax);
            BigDecimal profitAfterTax = profitBeforeTax.subtract(tax);
            System.out.println("прибыль после налогов: " + profitAfterTax);
        }
    }
}
