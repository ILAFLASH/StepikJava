package com.stepik.lesson12;

import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Optional;

/**
 * Реализуйте generic-класс Pair, похожий на Optional, но содержащий пару элементов разных типов и не запрещающий
 * элементам принимать значение null.
 * <p>
 * Реализуйте методы getFirst(), getSecond(), equals() и hashCode(), а также статический фабричный метод of().
 * Конструктор должен быть закрытым (private).
 * <p>
 * С корректно реализованным классом Pair должен компилироваться и успешно работать следующий код:
 * <p>
 * Pair<Integer, String> pair = Pair.of(1, "hello");
 * Integer i = pair.getFirst(); // 1
 * String s = pair.getSecond(); // "hello"
 * <p>
 * Pair<Integer, String> pair2 = Pair.of(1, "hello");
 * boolean mustBeTrue = pair.equals(pair2); // true!
 * boolean mustAlsoBeTrue = pair.hashCode() == pair2.hashCode(); // true!
 * <p>
 * Пожалуйста, не меняйте модификатор доступа класса Pair. Для корректной проверки класс должен иметь пакетную видимость.
 */

class Pair<T1, T2> {
    private final T1 valueT1;
    private final T2 valueT2;

    private Pair(T1 valueT1, T2 valueT2) {
        this.valueT1 = valueT1;
        this.valueT2 = valueT2;
    }

    public T1 getFirst() {
        if (valueT1 == null) {
            throw new NoSuchElementException("No value present");
        }
        return valueT1;
    }

    public T2 getSecond() {
        if (valueT2 == null) {
            throw new NoSuchElementException("No value present");
        }
        return valueT2;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Pair)) {
            return false;
        }


        Pair<?, ?> other = (Pair<?, ?>) obj;
        return Objects.equals(valueT1, other.valueT1) && Objects.equals(valueT2, other.valueT2);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(valueT1) + Objects.hashCode(valueT2);
    }

    public static <T1, T2> Pair<T1, T2> of(T1 valueT1, T2 valueT2) {
        return new Pair(valueT1, valueT2);
    }
}
