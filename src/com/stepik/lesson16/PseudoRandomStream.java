package com.stepik.lesson16;

import java.util.Comparator;
import java.util.function.BiConsumer;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PseudoRandomStream {
    /**
     * Напишите метод, возвращающий стрим псевдослучайных целых чисел. Алгоритм генерации чисел следующий:
     * Берется какое-то начальное неотрицательное число (оно будет передаваться в ваш метод проверяющей системой).
     * Первый элемент последовательности устанавливается равным этому числу.
     * Следующие элементы вычисляются по рекуррентной формуле Rn+1=mid(Rn^2), где mid — это функция, выделяющая второй,
     * третий и четвертый разряд переданного числа. Например, mid(123456) = 345.
     * Алгоритм, конечно, дурацкий и не выдерживающий никакой критики, но для практики работы со стримами сойдет :)
     * Пример
     * pseudoRandomStream(13) должен вернуть стрим, состоящий из следующих чисел:
     * 13, 16, 25, 62, 384, 745, 502, 200, 0, ... (дальше бесконечное количество нулей)
     */
    public static IntStream pseudoRandomStream(int seed) {
        return IntStream.iterate(seed, n -> ((n * n) / 10 % 1000));
    }

    /**
     * Напишите метод, находящий в стриме минимальный и максимальный элементы в соответствии порядком,
     * заданным Comparator'ом.
     * <p>
     * Найденные минимальный и максимальный элементы передайте в minMaxConsumer следующим образом:
     * <p>
     * minMaxConsumer.accept(min, max);
     * Если стрим не содержит элементов, то вызовите
     * minMaxConsumer.accept(null, null);
     */

    public static <T> void findMinMax(
            Stream<? extends T> stream,
            Comparator<? super T> order,
            BiConsumer<? super T, ? super T> minMaxConsumer) {

        T min = null;
        T max = null;
        T[] array;

        array = (T[]) stream.sorted(order).toArray();

        if (array.length > 0) {
            min = array[0];
            max = array[array.length - 1];
        }

        minMaxConsumer.accept(min, max);
    }

    public static void main(String[] args) {
        pseudoRandomStream(13);
    }
}
