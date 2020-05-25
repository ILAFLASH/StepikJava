package com.stepik.lesson7;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.IOException;

public class CheckSumOfStream {
    /**
     * Напишите метод, читающий входной поток и вычисляющий контрольную сумму прочитанных данных.
     * <p>
     * Контрольная сумма данных вычисляется по следующему алгоритму:
     * <p>
     * 1) Контрольная сумма представляет собой число типа int. Контрольная сумма пустого набора данных равна нулю.
     * 2) Контрольная сумма непустого набора данных вычисляется по следующей рекуррентной формуле:
     * C(n+1)=rotateLeft(C(n)) xor b(n+1), где C(n) — контрольная сумма
     * первых n байт данных, rotateLeft — циклический сдвиг бит числа на один бит влево (чтобы не изобретать велосипед,
     * используйте Integer.rotateLeft), b(n) — n-ный байт данных.
     * Поскольку метод не открывал данный InputStream, то и закрывать его он не должен. Выброшенное из методов
     * InputStream исключение должно выбрасываться из метода.
     * Пример
     * На вход подан InputStream, последовательно возвращающий три байта: 0x33 0x45 0x01. В качестве контрольной суммы
     * должно быть возвращено число 71.
     */

    public static int checkSumOfStream(InputStream inputStream) throws IOException {
        int controlSum = 0;
        int blockSize;
        while ((blockSize = inputStream.read()) >= 0) {
            controlSum = Integer.rotateLeft(controlSum, 1) ^ blockSize;
            System.out.println(controlSum);
        }
        return controlSum;
    }


    public static void main(String[] args) throws IOException {
        byte[] buf = new byte[]{0x33, 0x45, 0x01};
        checkSumOfStream(new ByteArrayInputStream(buf));
    }
}
