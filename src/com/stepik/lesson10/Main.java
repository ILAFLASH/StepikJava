package com.stepik.lesson10;

import java.io.*;
import java.util.Scanner;

public class Main {
    /**
     * Напишите программу, читающую текст из System.in и выводящую в System.out сумму всех встреченных в тексте
     * вещественных чисел с точностью до шестого знака после запятой. Числом считается последовательность символов,
     * отделенная от окружающего текста пробелами или переводами строк и успешно разбираемая методом Double.parseDouble.
     * <p>
     * На этот раз вам надо написать программу полностью, т.е. объявить класс (с именем Main — таково ограничение
     * проверяющей системы), метод main, прописать все import'ы.
     * <p>
     * Sample Input 1:
     * 1 2 3
     * Sample Output 1:
     * 6.000000
     * <p>
     * Sample Input 2:
     * a1 b2 c3
     * Sample Output 2:
     * 0.000000
     * <p>
     * Sample Input 3:
     * -1e3
     * 18 .111 11bbb
     * Sample Output 3:
     * -981.889000
     */
    public static void sumOfNumber() {
        double sum = 0;
        double doubleNumber = 0;
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            doubleNumber = 0;
            try {
                doubleNumber = Double.parseDouble(scanner.next());
            } catch (NumberFormatException e) {

            }
            sum += doubleNumber;
        }
        System.out.format("%6f\n", sum);
    }

    public static void sumOfNumbersTest(InputStream inputStream) {
        double sum = 0;
        double doubleNumber = 0;
        Scanner scanner = new Scanner(inputStream);
        while (scanner.hasNext()) {
            doubleNumber = 0;
            try {
                doubleNumber = Double.parseDouble(scanner.next());
            } catch (NumberFormatException e) {

            }
            sum += doubleNumber;
        }
        System.out.printf("%6f\n", sum);
    }

    public static void main(String[] args) {
//        byte[] buf = new byte[]{49, 32, 50, 32, 51};
//        sumOfNumbersTest(new ByteArrayInputStream(buf));
//        byte[] buf2 = new byte[]{97, 49, 32, 98, 50, 32, 99, 51};
//        sumOfNumbersTest(new ByteArrayInputStream(buf2));
//        byte[] buf3 = new byte[]{45, 49, 101, 51, '\n', 49, 56, ' ', 46, 49, 49, 49, ' ', 49, 49, 98, 98, 98};
//        sumOfNumbersTest(new ByteArrayInputStream(buf3));
        sumOfNumber();
    }
}
