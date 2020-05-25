package com.stepik.lesson18;

public interface MessageInterface<T> {
    String getFrom();

    String getTo();

    T getContent();
}
