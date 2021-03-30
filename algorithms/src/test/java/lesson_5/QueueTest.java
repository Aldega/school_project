package lesson_5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueueTest {

    @Test
    void enqueue() {
        Queue<Integer> queue = new Queue<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        assertEquals(1, queue.queue.get(0));
        assertEquals(2, queue.queue.get(1));
        assertEquals(3, queue.queue.get(2));

        Queue<Integer> emptyQueue = new Queue<>();
        assertNull(emptyQueue.queue.peekFirst());
        assertNull(emptyQueue.queue.peekLast());

        Queue<Integer> oneElementQueue = new Queue<>();
        oneElementQueue.enqueue(1);
        assertEquals(1, oneElementQueue.queue.peekFirst());
        assertEquals(1, oneElementQueue.queue.peekLast());
    }

    @Test
    void dequeue() {
        Queue<Integer> queue = new Queue<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        assertEquals(1, queue.dequeue());
        assertEquals(2, queue.dequeue());
        assertEquals(3, queue.dequeue());
        assertNull(queue.dequeue());

        Queue<Integer> emptyQueue = new Queue<>();
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