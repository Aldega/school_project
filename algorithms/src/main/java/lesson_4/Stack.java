package lesson_4;

import java.util.*;

public class Stack<T> {

    public LinkedList<T> stack;

    public Stack() {
        this.stack = new LinkedList<>();
    }

    public int size() {
        return this.stack.size(); //сложность O(1)
    }

    public T pop() {
        return this.stack.poll(); //сложность O(1)
    }

    public void push(T val) {
        this.stack.push(val); //сложность O(1)
    }

    public T peek() {
        return this.stack.peek(); //сложность O(1)
    }
}