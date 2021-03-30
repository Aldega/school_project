package lesson_5;

import java.util.*;

public class Queue<T> {
    public LinkedList<T> queue;

    public Queue() {
        this.queue = new LinkedList<>();
    }

    public void enqueue(T item) { // Сложность 0(1)
        queue.addLast(item);
    }

    public T dequeue() { // Сложность 0(1)
        return queue.pollFirst();
    }

    public int size() { // Сложность 0(1)
        return queue.size();
    }

}
