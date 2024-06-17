package org.example;
/*
6. Практические сценарии:
   - Как реализовать алгоритм умножения двух матриц?
   - Как определить, является ли матрица симметричной?

7. Безопасность работы с индексами:
   - Как предотвратить выход за границы матрицы при обращении по индексам?
   - Какие проверки стоит внедрять для обеспечения безопасности работы с матрицами?
 */

import java.util.Scanner;

public class Matrix {
    public static void main(String[] args) {
        System.out.println("Matrix sum: " + matrixSum(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}));

        findMinAndMax(new double[][]{
                {2.2, 3.3, 4.4},
                {5.5, 6.6, 1.1, 7.7, 8.8},
                {9.9, 16.16, 10.10, 11.11, 12.12},
                {13.13, 14.14, 15.15}
        });

        System.out.println("even count: " + countEven(new int[][]{
                {1, 2, 3, 4, 5, 6},
                {7, 8, 9, 10, 11, 12}
        }));

        contains(new String[][]{
                {"hello", "world", "java", "matrix"},
                {"search", "me", "if", "you"},
                {"can", "find", "this", "string"}
        });

        matrixTranspose(new int[][]{{1, 3, 5}, {2, 4, 6}});

        matrixGenerator();
    }


    //1. Сумма элементов: - Задача: Создайте матрицу размером 3x3 целых чисел. Найдите и выведите сумму всех элементов матрицы.
    private static int matrixSum(int[][] matrix) {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                sum += matrix[i][j];
            }
        }
        return sum;
    }

    /*2. Нахождение минимума и максимума:
    - Задача: Создайте матрицу размером 4x4 вещественных чисел.
    Найдите и выведите минимальное и максимальное значения в матрице.
     */
    private static void findMinAndMax(double[][] matrix) {
        double min = matrix[0][0];
        double max = matrix[0][0];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                double element = matrix[i][j];
                if (element < min) min = element;
                if (element > max) max = element;
            }
        }
        System.out.println("max: " + max);
        System.out.println("min: " + min);
    }

    /*3. Подсчет четных чисел: -
    Задача: Создайте матрицу размером 2x6 целых чисел. Посчитайте и выведите количество четных чисел в матрице.
     */
    private static int countEven(int[][] matrix) {
        int count = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] % 2 == 0) count++;
            }
        }
        return count;
    }

    /*4. Поиск элемента:
   - Задача: Создайте матрицу строк размером 3x4. Попросите пользователя ввести строку.
   Проверьте, содержится ли в матрице введенная строка, и выведите соответствующее сообщение.
     */
    private static boolean contains(String[][] matrix) {
        System.out.println("-> Enter the line");
        Scanner scanner = new Scanner(System.in);
        String enteredString = scanner.nextLine();
        scanner.close();
        boolean contains = false;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                String s = matrix[i][j];
                if (s.equals(enteredString)) {
                    System.out.println("Your entered string is presented in array");
                    contains = true;
                }
            }
        }
        return contains;
    }

    /*5. Транспонирование матрицы:
    - Задача: Создайте матрицу размером 2x3 символов. Выведите исходную матрицу и ее транспонированный вариант.
     */
    private static void matrixTranspose(int[][] matrix) {
        int[][] transposedMatrix = new int[matrix[0].length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                transposedMatrix[j][i] = matrix[i][j];
            }
        }
        System.out.println("Original");
        printMatrix(matrix);
        System.out.println("Transposed");
        printMatrix(transposedMatrix);
    }


    /*
        6. Попробуйте написать программный код, который может создавать динамически следующие матрицы
         */
    private static void matrixGenerator() {
        printMatrix(generateFirst());
        System.out.println();
        printMatrix(generateSecond());
        System.out.println();
        printMatrix(generateThird());
    }

    /*
     11
    1
    11
    1
    11
      */
    private static int[][] generateFirst() {
        int number = 1;
        int[][] arr = new int[5][];
        for (int i = 0; i < arr.length; i++) {
            if (i % 2 == 0) {
                arr[i] = new int[]{1, 1};
            } else {
                arr[i] = new int[]{1};
            }
        }
        return arr;
    }


    /*
    1
    22
    333
    4444
    55555
    666666
     */
    private static int[][] generateSecond() {
        int[][] arr = new int[6][];
        for (int i = 0; i < arr.length; i++) {
            int number = i + 1;
            int[] ints = new int[number];
            //Arrays.fill(ints, number);
            for (int j = 0; j < ints.length; j++) {
                ints[j] = number;
            }
            arr[i] = ints;
        }
        return arr;
    }


    /*
        1
        11
        121
        1331
        14641
     */
    private static int[][] generateThird() {
        int[][] matrix = new int[5][];
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = new int[i + 1];
            for (int j = 0; j < matrix[i].length; j++) {
                if (j == 0 || j == matrix[i].length - 1) {
                    matrix[i][j] = 1;
                } else {
                    matrix[i][j] = matrix[i - 1][j] + matrix[i - 1][j - 1];
                }
            }
        }
        return matrix;
    }

    private static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }
}
