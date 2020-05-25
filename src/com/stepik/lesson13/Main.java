package com.stepik.lesson13;

import com.stepik.mailsystem.Sendable;

import java.util.HashSet;
import java.util.Set;

public class Main {
    /**
     Реализуйте метод, вычисляющий симметрическую разность двух множеств.
     Метод должен возвращать результат в виде нового множества. Изменять переданные в него множества не допускается.
     Пример
     Симметрическая разность множеств {1, 2, 3} и {0, 1, 2} равна {0, 3}.
     */

    public static <T> Set<T> symmetricDifference(Set<? extends T> set1, Set<? extends T> set2) {
        Set <T> resultSet1 = new HashSet<>();
        Set <T> resultSet2 = new HashSet<>();
        resultSet1.addAll(set1);
        resultSet2.addAll(set2);
        resultSet1.removeAll(set2);
        resultSet2.removeAll(set1);
        resultSet1.addAll(resultSet2);
        return resultSet1;
    }

    public static void main(String[] args) {
        Set seta = new HashSet();
        seta.add(1);
        seta.add(2);
        seta.add(3);
        Set setb = new HashSet();
        setb.add(0);
        setb.add(1);
        setb.add(2);

        System.out.println(symmetricDifference(seta, setb));
    }
}
