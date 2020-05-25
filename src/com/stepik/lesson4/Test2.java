package com.stepik.lesson4;

import java.util.Arrays;

public class Test2 {

    public static String getCallerClassAndMethodName() {
        try {
            throw new Exception();
        } catch (Exception e) {
            if (e.getStackTrace().length == 2) {
                return null;
            } else {
                return e.getStackTrace()[2].getClassName() + "#" + e.getStackTrace()[2].getMethodName();
            }
        }
    }

    private static void anotherMethod() {
        System.out.println(getCallerClassAndMethodName());
    }

    public static void main(String[] args) {
        System.out.println(getCallerClassAndMethodName());
        anotherMethod();
    }
}
