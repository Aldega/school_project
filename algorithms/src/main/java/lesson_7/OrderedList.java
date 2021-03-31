package lesson_7;

import java.util.*;


class Node<T> {
    public T value;
    public Node<T> next, prev;

    public Node(T _value) {
        value = _value;
        next = null;
        prev = null;
    }
}

public class OrderedList<T> {
    public Node<T> head, tail;
    private boolean _ascending;

    public OrderedList(boolean asc) {
        head = null;
        tail = null;
        _ascending = asc;
    }

    public int compare(T v1, T v2) {
        // -1 если v1 < v2
        // 0 если v1 == v2
        // +1 если v1 > v2
        if (v1 instanceof Integer && v2 instanceof Integer) {
            int value1 = (Integer) v1;
            int value2 = (Integer) v2;
            return Integer.compare(value1, value2);
        }
        if (v1 instanceof String && v2 instanceof String) {
            return ((String) v1).trim().compareTo(((String) v2).trim());
        }
        throw new RuntimeException("Unsuported type of variables");
    }

    public void add(T value) {
        // автоматическая вставка value
        // в нужную позицию
    }

    public Node<T> find(T val) {
        return null; // здесь будет ваш код
    }

    public void delete(T val) {
        // здесь будет ваш код
    }

    public void clear(boolean asc) {
        _ascending = asc;
        this.head = null;
        this.tail = null;
    }

    public int count() {
        return getAll().size();
    }

    ArrayList<Node<T>> getAll() { // выдать все элементы упорядоченного списка в виде стандартного списка

        ArrayList<Node<T>> r = new ArrayList<Node<T>>();
        Node<T> node = head;
        while (node != null) {
            r.add(node);
            node = node.next;
        }
        return r;
    }
}