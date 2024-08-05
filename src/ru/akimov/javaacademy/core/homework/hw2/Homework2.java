package ru.akimov.javaacademy.core.homework.hw2;

import java.util.Arrays;
import java.util.Random;

public class Homework2 {
    public static void main(String[] args) {
        ex1();
        ex2();
        ex3();
        ex5();
    }

    public static void ex1() {
        String[] words = {"Это", "шашлык", "на", "шампуре"};
        String str = "";
        for (String word : words) {
            str += word + "-";
        }
        String result = str.substring(0, str.length() - 1);
        System.out.println(result);
    }

    public static void ex2() {
        //Дан массив с массивом чисел внутри
        int[][] arrayOfNumbers = new int[10][10];
        arrayOfNumbers[0] = new int[]{131, 1, 1, 1, 1, 1, 1, 1, 1, 102};
        arrayOfNumbers[1] = new int[]{1, 20, 1, 1, 1, 1, 1, 1, 93, 1};
        arrayOfNumbers[2] = new int[]{1, 1, 31, 1, 1, 1, 1, 81, 1, 1};
        arrayOfNumbers[3] = new int[]{1, 1, 1, 45, 1, 1, 77, 1, 1, 1};
        arrayOfNumbers[4] = new int[]{1, 1, 1, 1, 57, 67, 1, 1, 1, 1};
        arrayOfNumbers[5] = new int[]{1, 1, 1, 1, 533, 68, 1, 1, 1, 1};
        arrayOfNumbers[6] = new int[]{1, 1, 1, 40, 1, 1, 72, 1, 1, 1};
        arrayOfNumbers[7] = new int[]{1, 1, 30, 1, 1, 1, 1, 83, 1, 1};
        arrayOfNumbers[8] = new int[]{1, 20, 1, 1, 1, 1, 1, 1, 901, 1};
        arrayOfNumbers[9] = new int[]{10, 1, 1, 1, 1, 1, 1, 1, 1, 101};

        int leftUpToRightDownSum = leftUpToRightDownSum(arrayOfNumbers);
        int leftDownToRightUpSum = leftDownToRightUpSum(arrayOfNumbers);
        System.out.println("сумма диагонали с левого верхнего угла к нижнему правому: " + leftUpToRightDownSum);
        System.out.println("сумма по диагонали с левого нижнего угла к верхнему правому" + leftDownToRightUpSum);
    }

    public static int leftUpToRightDownSum(int[][] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i][i];
        }
        return sum;
    }

    public static int leftDownToRightUpSum(int[][] array) {
        int sum = 0;
        for (int i = array.length -1, j = 0; i >= 0; i--, j++) {
            sum += array[i][j];
        }
        return sum;
    }

    public static void ex3() {
        Random random = new Random(1);
        int number = random.nextInt(1000);
        int count = 1;

        while (number != 999) {
            count++;
            number = random.nextInt(1000);
        }
        System.out.println(number);
        System.out.println(count);
    }

    public static void ex4() {
        //Создать пакет office.
        //Создать класс офис, в котором есть босс, менеджер, секретарь, охранник.
        //Босс обладает именем. Умеет подгонять менеджера - "{Имя менеджера}" быстрее!
        //Менеджер обладает именем. Умеет кричать - "я ничего не успеваю, помогите!".
        //Секретарь умеет просить менеджера и босса успокоится, а охранника подождать:
        //"{Имя босса} не волнуйтесь, {имя менеджера} все успеет. {имя охранника} - подождите!"
        //Охранник обладает именем. Просит выдать ему аванс.
        //В офисе есть метод рабочий день:
        //--Босс начинает подгонять менеджера
        //--Менеджер кричит
        //--Охранник просит аванс
        //--Секретарша всех успокаивает, и просит подождать
        //Создать класс Runner, в котором:
        //Создать босса (Петр Николаевич), Менеджера (Володя), охранника (Петрович)
        //Секретаря.
        //Создать офис
        //Запустить рабочий день в офисе
    }

    /**
     * Для продвинутых
     */
    public static void ex5() {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int length = numbers.length;
        for (int i = 0, j = length - 1; i < length / 2; i++, j--) {
            int temp = numbers[i];
            numbers[i] = numbers[j];
            numbers[j] = temp;
        }
        System.out.println(Arrays.toString(numbers));
    }
}