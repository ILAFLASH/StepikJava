package com.stepik.lesson18;

import java.util.*;
import java.util.function.Consumer;

public class MailService<T> implements Consumer<MessageInterface<T>> {
    private static class MyHashMap<K, V> extends HashMap<K, V> {
        @Override
        public V get(Object key) {
            V v = super.get(key);
            try {
                if (v == null) v = (V) Collections.emptyList();
            } catch (ClassCastException e) {
            }
            return v;
        }
    }

    private Map<String, List<T>> mailBox;

    public MailService() {
        mailBox = new MyHashMap<>();
    }

    @Override
    public void accept(MessageInterface<T> t) {
        if (mailBox.containsKey(t.getTo())) {
            List<T> value;
            value = mailBox.get(t.getTo());
            value.add(t.getContent());
            mailBox.put(t.getTo(), value);
        } else {
            List<T> value;
            value = new LinkedList<>();
            value.add(t.getContent());
            mailBox.put(t.getTo(), value);
        }
    }

    public Map<String, List<T>> getMailBox() {
        return mailBox;
    }
}
