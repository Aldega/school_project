package lesson_6;

import java.util.*;

public class Deque<T> {

    public LinkedList<T> deque;

    public Deque() {
        this.deque = new LinkedList<>();
    }

    public void addFront(T item) {
        this.deque.addFirst(item);
    }

    public void addTail(T item) {
        this.deque.addLast(item);
    }

    public T removeFront() {
        return this.deque.pollFirst();
    }

    public T removeTail() {
        return this.deque.pollLast();
    }

    public int size() {
        return this.deque.size();
    }

}
