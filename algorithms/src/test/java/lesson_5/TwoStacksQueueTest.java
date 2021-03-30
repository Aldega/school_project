package lesson_5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TwoStacksQueueTest {

    @Test
    void enqueue() {
        TwoStacksQueue<Integer> queue = new TwoStacksQueue<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        assertEquals(1, queue.in.stack.get(2));
        assertEquals(2, queue.in.stack.get(1));
        assertEquals(3, queue.in.stack.get(0));

        TwoStacksQueue<Integer> emptyQueue = new TwoStacksQueue<>();
        assertNull(emptyQueue.in.pop());

        TwoStacksQueue<Integer> oneElementQueue = new TwoStacksQueue<>();
        oneElementQueue.enqueue(1);
        assertEquals(1, oneElementQueue.in.pop());
    }

    @Test
    void dequeue() {
        TwoStacksQueue<Integer> queue = new TwoStacksQueue<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        assertEquals(1, queue.dequeue());
        assertEquals(2, queue.dequeue());
        assertEquals(3, queue.dequeue());
        assertNull(queue.dequeue());

        TwoStacksQueue<Integer> emptyQueue = new TwoStacksQueue<>();
        assertNull(emptyQueue.dequeue());
    }

    @Test
    void size() {
        Queue<Integer> queue = new Queue<>();
        assertEquals(0, queue.size());

        queue.enqueue(1);
        assertEquals(1, queue.size());

        queue.enqueue(2);
        assertEquals(2, queue.size());

        queue.enqueue(3);
        assertEquals(3, queue.size());

        assertEquals(1, queue.dequeue());
        assertEquals(2, queue.size());

        assertEquals(2, queue.dequeue());
        assertEquals(1, queue.size());

        assertEquals(3, queue.dequeue());
        assertEquals(0, queue.size());
    }
}