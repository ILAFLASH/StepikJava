package com.stepik.lesson14;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {

    public static void reverseDeleteEvenTest (InputStream inputStream) {
        Scanner scanner = new Scanner(inputStream);
        Deque<Integer> deque = new LinkedList<>();
        while (scanner.hasNext()) {
            scanner.nextInt();
            if (scanner.hasNext()) {deque.addFirst(scanner.nextInt());}
        }

        for (Integer element: deque) {
            System.out.print(element + " ");
        }
    }

//    public static void reverseDeleteEven() {
//        Scanner scanner = new Scanner(System.in);
//        Deque<Integer> deque = new LinkedList<>();
//        while (scanner.hasNextInt()) {
//            scanner.nextInt();
//            if (scanner.hasNextInt()) {
//                deque.addFirst(scanner.nextInt());
//            }
//        }
//        System.out.println(deque);
//    }


    public static void main(String[] args) throws IOException {
        byte[] buf = new byte[] {49, 32, 50, 32, 51, 32, 52, 32, 53, 32, 54, 32, 55};
        reverseDeleteEvenTest(new ByteArrayInputStream(buf));
    }
}

