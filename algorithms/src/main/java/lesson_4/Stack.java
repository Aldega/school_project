package lesson_4;

import java.util.*;

public class Stack<T>
{

    public LinkedList<T> stack;

    public Stack()
    {
        this.stack = new LinkedList<>();
    }

    public int size()
    {
        return stack.size();
    }

    public T pop()
    {
        return stack.poll();
    }

    public void push(T val)
    {
        stack.push(val);
    }

    public T peek()
    {
        return stack.peek();
    }
}