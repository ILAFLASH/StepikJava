package com.stepik.lesson1;

import java.math.BigInteger;
import java.util.Arrays;

public class Test2 {
    public static boolean booleanExpression(boolean a, boolean b, boolean c, boolean d) {
        return (a == b && a != c && a != d) || (a == c && a != b && a != d) || (a == d && a != b && a != c);
    }

    public static int leapYearCount(int year) {
        int countOfLeapYears = 0;
        for (int i = 1; i <= year; i++) {
            if (((i % 4 == 0) && (i % 100 != 0)) || (i % 400 == 0)) countOfLeapYears++;
        }
        return countOfLeapYears;
    }

    public static boolean doubleExpression(double a, double b, double c) {
        return Math.abs(a + b - c) < 0.0001;
    }

    /**
     * Flips one bit of the given <code>value</code>.
     *
     * @param value    any number
     * @param bitIndex index of the bit to flip, 1 <= bitIndex <= 32
     * @return new value with one bit flipped
     */
    public static int flipBit(int value, int bitIndex) {
        return (1 << bitIndex - 1) ^ value;
    }

    public static char charExpression(int a) {
        return (char) ('\\' + a);
    }

    /**
     * Checks if given <code>value</code> is a power of two.
     *
     * @param value any number
     * @return <code>true</code> when <code>value</code> is power of two, <code>false</code> otherwise
     */
    public static boolean isPowerOfTwo(int value) {
        return Integer.bitCount(Math.abs(value)) == 1;
    }

    /**
     * Checks if given <code>text</code> is a palindrome.
     *
     * @param text any string
     * @return <code>true</code> when <code>text</code> is a palindrome, <code>false</code> otherwise
     */
    public static boolean isPalindrome(String text) {
        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();
        s1.append(text.toUpperCase().replaceAll("[^A-Z0-9]", ""));
        s2.append(text.toUpperCase().replaceAll("[^A-Z0-9]", "")).reverse();
        return s1.toString().equals(s2.toString());
    }

    /**
     * Calculates factorial of given <code>value</code>.
     *
     * @param value positive number
     * @return factorial of <code>value</code>
     */
    public static BigInteger factorial(int value) {
        BigInteger nFactorial = BigInteger.valueOf(1);
        for (int i = 1; i <= value; i++) {
            nFactorial = nFactorial.multiply(BigInteger.valueOf(i));
        }
        return nFactorial;
    }

    /**
     * Merges two given sorted arrays into one
     *
     * @param a1 first sorted array
     * @param a2 second sorted array
     * @return new array containing all elements from a1 and a2, sorted
     */
    public static int[] mergeArrays(int[] a1, int[] a2) {
        if (a1.length == 0) {
            return a2;
        }
        if (a2.length == 0) {
            return a1;
        }
        int i = 0;
        int j = 0;
        int[] resultArray = new int[a1.length + a2.length];

        if (a1[a1.length - 1] >= a2[a2.length - 1]) {
            while (i < a1.length) {
                while (j < a2.length) {
                    if (a2[j] <= a1[i]) {
                        resultArray[i+j] = a2[j];
                    } else {
                        resultArray[i+j] = a1[i];
                        break;
                    }
                    j++;
                }
                if (j == a2.length) {
                    resultArray[i+j] = a1[i];
                }
                i++;
            }
        } else {
            while (j < a2.length) {
                while (i < a1.length) {
                    if (a1[i] <= a2[j]) {
                        resultArray[i+j] = a1[i];
                    } else {
                        resultArray[i+j] = a2[j];
                        break;
                    }
                    i++;
                }
                if (i == a1.length) {
                    resultArray[j+i] = a2[j];
                }
                j++;
            }
        }
        return resultArray;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(mergeArrays(new int[]{0, 2, 2}, new int[]{1, 3})));
//        System.out.println(factorial(5));
//        System.out.println(isPalindrome("Madam, I'm Adam!"));
//        System.out.println(isPowerOfTwo(0));
//        System.out.println(isPowerOfTwo(1));
//        System.out.println(isPowerOfTwo(-2));
//        String s = 'A' + '1' + "2";
//        System.out.println(s);
//        s = 'A' + "12";
//        System.out.println(s);
//        s = "A" + ('\t' + '\u0003');
//        System.out.println(s);
//        s = "A" + 12;
//        System.out.println(s);
//        System.out.println(charExpression(32));
//        System.out.println(charExpression(29));
//        System.out.println(flipBit(0,1));
//        System.out.println(flipBit(7,2));
//        System.out.println(doubleExpression(01,02,03));
//        System.out.println(leapYearCount(1));
//        System.out.println(leapYearCount(4));
//        System.out.println(leapYearCount(100));
//        System.out.println(booleanExpression(false, false, false, false));
//        System.out.println(booleanExpression(true, true, true, true));
//        System.out.println(booleanExpression(false, false, true, true));
    }
}
