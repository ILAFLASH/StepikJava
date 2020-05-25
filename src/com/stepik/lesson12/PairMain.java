package com.stepik.lesson12;

public class PairMain {

    public static void main(String[] args) {
        Pair<Integer, String> pair = Pair.of(1, "hello");
        Integer i = pair.getFirst();
        System.out.println(i);// 1
        String s = pair.getSecond();
        System.out.println(s);// "hello"

        Pair<Integer, String> pair2 = Pair.of(1, "hello");
        boolean mustBeTrue = pair.equals(pair2);
        System.out.println(mustBeTrue);// true!
        boolean mustAlsoBeTrue = pair.hashCode() == pair2.hashCode();
        System.out.println(mustAlsoBeTrue);// true!
    }
}
