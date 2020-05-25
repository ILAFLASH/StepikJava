package com.stepik.lesson3;

public class AsciiCharSequence implements CharSequence {
    private byte[] asciiArray;

    public AsciiCharSequence(byte[] asciiArray) {
        this.asciiArray = new byte[asciiArray.length];
        System.arraycopy(asciiArray, 0, this.asciiArray, 0, asciiArray.length);
    }

    @Override
    public int length() {
        return this.asciiArray.length;
    }

    @Override
    public char charAt(int index) {
        return (char) this.asciiArray[index];
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        byte[] asciiArraySubSequence = new byte[end - start];
        System.arraycopy(asciiArray, start, asciiArraySubSequence, 0, asciiArraySubSequence.length);
        return new AsciiCharSequence(asciiArraySubSequence);
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        for (byte b : asciiArray) {
            output.append((char) b);
        }
        return output.toString();
    }

    public static void main(String[] args) {

        byte[] example = {72, 101, 108, 108, 111, 33};
        AsciiCharSequence answer = new AsciiCharSequence(example);
        System.out.println("Последовательность - " + answer.toString());//Hello!
        System.out.println("Размер её - " + answer.length());//6
        System.out.println("Символ под № 1 - " + answer.charAt(1));//e
        System.out.println("Подпоследовательность - " + answer.subSequence(1, 5));//ello
//проверка на нарушение инкапсуляции private поля
        System.out.println(answer.toString());//Hello!
        example[0] = 74;
        System.out.println(answer.toString());//Hello!
    }
}
