package lesson_5;

import lesson_4.Stack;

public class TwoStacksQueue<T> {

    public Stack<T> in;
    public Stack<T> out;

    public TwoStacksQueue() {
        this.in = new Stack<>();
        this.out = new Stack<>();
    }

    public void enqueue(T item) { // Сложность 0(1)
        in.push(item);
    }

    public T dequeue() { // Сложность 0(N)
        while (in.size() > 0) {
            out.push(in.pop());
        }
        T result = out.pop();
        while (out.size() > 0) {
            in.push(out.pop());
        }
        return result;
    }

    public int size() { // Сложность 0(1)
        return in.size();
    }

}
