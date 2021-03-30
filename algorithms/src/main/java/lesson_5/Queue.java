package lesson_5;

import java.util.*;

public class Queue<T>
{
    public LinkedList<T> queue;

    public Queue()
    {
        this.queue = new LinkedList<>();
    }

    public void enqueue(T item)
    {
        queue.addLast(item);
    }

    public T dequeue()
    {
        return queue.pollFirst();
    }

    public int size()
    {
        return queue.size();
    }

}
