package com.stepik.lesson9;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class ReadAsString {
    /**
     * Реализуйте метод, который зачитает данные из InputStream и преобразует их в строку, используя заданную кодировку.
     * <p>
     * Пример
     * <p>
     * InputStream последовательно возвращает четыре байта: 48 49 50 51.
     * <p>
     * Метод, вызванный для такого InputStream и кодировки ASCII, должен вернуть строку "0123".
     */
    public static String readAsString(InputStream inputStream, Charset charset) throws IOException {
        Reader reader = new InputStreamReader(inputStream, charset);
        StringBuilder resultString = new StringBuilder();
        int element;
        while ((element = reader.read()) != -1) {
            resultString.append((char) element);
        }
        return resultString.toString();
    }

    public static void main(String[] args) throws IOException {
        byte[] buf = new byte[]{48, 49, 50, 51};

        System.out.println(readAsString(new ByteArrayInputStream(buf), StandardCharsets.US_ASCII));
    }
}
