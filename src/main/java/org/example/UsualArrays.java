package org.example;

import java.util.Arrays;
import java.util.Scanner;

public class UsualArrays {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        arrSum(arr);
        double[] numbers = {1.1, 2.2, 3.3, 4.4, 5.5, 6.6, 7.7, 0.2, 8.8, 9.9, 9999.99, 10.10, 11.11, 12.12, 13.13};
        findMinAndMax(numbers);
        int countEven = countEven(arr);
        System.out.println("even count: " + countEven);
        boolean contains = contains(new String[]{"Apple", "Orange", "Banana"});
        charPrinter(new char[]{'h', 'e', 'l', 'l', 'o'});
    }

    //1. Сумма элементов:   - Задача: Создайте массив из 10 целых чисел. Найдите и выведите сумму всех элементов массива.
    private static int arrSum(int[] arr) {
        int sum1 = Arrays.stream(arr).sum();
        int sum2 = 0;
        for (int i : arr) {
            sum2 += i;
        }
        System.out.println("sum " + sum1 + " equals " + sum2);
        return sum1;
    }

    /*
    2. Нахождение минимума и максимума:
   - Задача: Создайте массив из 15 вещественных чисел. Найдите и выведите минимальное и максимальное значения в массиве.
    */
    private static void findMinAndMax(double[] numbers) {
        double min1 = Arrays.stream(numbers).min().orElse(0);
        double max2 = Arrays.stream(numbers).max().orElse(0);
        double min = numbers[0];
        double max = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] < min) {
                min = numbers[i];
            }
            if (numbers[i] > max) {
                max = numbers[i];
            }
        }
        System.out.println("min " + min + " equals " + min1);
        System.out.println("max " + max + " equals " + max2);
    }

    //3. Подсчет четных чисел:   - Задача: Создайте массив из 8 целых чисел. Посчитайте и выведите количество четных чисел в массиве.
    private static int countEven(int[] arr) {
        int count = 0;
        for (int i : arr) {
            if (i % 2 == 0) {
                count++;
            }
        }
        return count;
    }

    /*
    4. Поиск элемента:
   - Задача: Создайте массив строк из 12 элементов. Попросите пользователя ввести строку.
   Проверьте, содержится ли в массиве введенная строка, и выведите соответствующее сообщение.
     */
    private static boolean contains(String[] strings) {
        System.out.println("-> Enter the line");
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        scanner.close();
        boolean contains1 = Arrays.asList(strings).contains(string);
        if (contains1) {
            System.out.println("1 Your string is presented in array");
        }
        boolean contains2 = false;
        for (String s : strings) {
            if (s.equals(string)) {
                System.out.println("2 Your string is presented in array");
                contains2 = true;
            }
        }
        System.out.println("Is approaches returns the same? " + (contains1 == contains2));
        return contains2;
    }

    /*
    5. Обратный порядок:   - Задача: Создайте массив из 6 символов.
    Выведите его содержимое в прямом и обратном порядке (сначала прямой порядок, затем обратный).
     */
    private static void charPrinter(char[] chars) {
        System.out.println("chars");
        for (char aChar : chars) {
            System.out.print(aChar + " ");
        }
        System.out.println("\nreversed chars");
        for (int i = chars.length - 1; i >= 0; i--) {
            System.out.print(chars[i] + " ");
        }
    }

    private static boolean isPalindrome(char[] chars) {
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != chars[chars.length - 1 - i]) {
                return false;
            }
        }
        return true;
    }
}
