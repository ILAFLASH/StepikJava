package com.stepik.lesson8;

import java.io.*;

/**
 * По историческим причинам на разных платформах принят разный способ обозначения конца строки в текстовом файле.
 * На Unix-системах конец строки обозначается символом с кодом 10 ('\n'), на Windows — двумя последовательными
 * символами с кодами 13 и 10 ('\r' '\n').
 * Напишите программу, которая будет преобразовывать переводы строк из формата Windows в формат Unix. Данные в формате
 * Windows подаются программе в System.in, преобразованные данные должны выводиться в System.out. На этот раз вам надо
 * написать программу полностью, т.е. объявить класс (с именем Main — таково ограничение проверяющей системы), метод main,
 * прописать все import'ы.
 * Требуется заменить все вхождения пары символов '\r' и '\n' на один символ '\n'. Если на входе встречается одиночный
 * символ '\r', за которым не следует '\n', то символ '\r' выводится без изменения.
 * Кодировка входных данных такова, что символ '\n' представляется байтом 10, а символ '\r' — байтом 13. Поэтому программа
 * может осуществлять фильтрацию на уровне двоичных данных, не преобразуя байты в символы.
 * Из-за буферизации данных в System.out в конце вашей программы надо явно вызвать System.out.flush(). Иначе часть
 * выведенных вами данных не будет видна проверяющей системе.
 * Пример
 * Из System.in зачитаны следующие байты: 65 13 10 10 13. Внимание! Это не строка "65 13 10 10 13", а последовательность
 * чисел, возвращаемая методом System.in.read().
 * В System.out должны быть выведены байты: 65 10 10 13
 */

public class Main {
    public static void formatUnix() throws IOException {
        int currentElement = 0;
        int prevElement = 0;
        while ((currentElement = System.in.read()) > -1) {
            if (currentElement == 13) {
                if (prevElement == 13) {
                    System.out.write(prevElement);
                }
                prevElement = currentElement;
            } else {
                if (currentElement == 10) {
                    System.out.write(currentElement);
                    prevElement = currentElement;
                } else {
                    if (prevElement == 13) {
                        System.out.write(prevElement);
                    }
                    prevElement = currentElement;
                    System.out.write(currentElement);
                }
            }
        }
        if (prevElement == 13) {
            System.out.write(prevElement);
        }
        System.out.flush();
    }

    public static void formatUnixTest(InputStream inputStream) throws IOException {
        int currentElement = 0;
        int prevElement = 0;
        while ((currentElement = inputStream.read()) > -1) {
            if (currentElement == 13) {
                if (prevElement == 13) {
                    System.out.print(prevElement + " ");
                }
                prevElement = currentElement;
            } else {
                if (currentElement == 10) {
                    System.out.print(currentElement + " ");
                    prevElement = currentElement;
                } else {
                    if (prevElement == 13) {
                        System.out.print(prevElement + " ");
                    }
                    prevElement = currentElement;
                    System.out.print(currentElement + " ");
                }
            }
        }
        if (prevElement == 13) {
            System.out.print(prevElement + " ");
        }
        System.out.flush();
    }

    public static void main(String[] args) throws IOException {
        byte[] buf = new byte[]{65, 13, 10, 10, 13};
        formatUnixTest(new ByteArrayInputStream(buf));
        System.out.println();
        byte[] buf1 = new byte[]{65, 13, 10, 13, 10, 13, 10, 13};
        formatUnixTest(new ByteArrayInputStream(buf1));
        System.out.println();
        byte[] buf2 = new byte[]{65, 13, 13, 10, 13, 10, 23};
        formatUnixTest(new ByteArrayInputStream(buf2));

        formatUnix();
        OutputStream outputStream = new OutputStream() {
            @Override
            public void write(int b) throws IOException {

            }
        };
    }

}
