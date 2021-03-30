package lesson_6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DequeTest {

    @Test
    void addFront() {
        Deque<Integer> deque = new Deque<>();
        deque.addFront(1);
        assertEquals(1, deque.deque.get(0));

        deque.addFront(2);
        assertEquals(2, deque.deque.get(0));
        assertEquals(1, deque.deque.get(1));

        deque.addFront(3);
        assertEquals(3, deque.deque.get(0));
        assertEquals(2, deque.deque.get(1));
        assertEquals(1, deque.deque.get(2));
    }

    @Test
    void addTail() {
        Deque<Integer> deque = new Deque<>();
        deque.addTail(1);
        assertEquals(1, deque.deque.get(0));

        deque.addTail(2);
        assertEquals(2, deque.deque.get(1));
        assertEquals(1, deque.deque.get(0));

        deque.addTail(3);
        assertEquals(3, deque.deque.get(2));
        assertEquals(2, deque.deque.get(1));
        assertEquals(1, deque.deque.get(0));
    }

    @Test
    void removeFront() {
        Deque<Integer> deque = new Deque<>();
        deque.addFront(1);
        deque.addFront(2);
        deque.addFront(3);

        assertEquals(3, deque.removeFront());
        assertEquals(2, deque.removeFront());
        assertEquals(1, deque.removeFront());
        assertNull(deque.removeFront());
    }

    @Test
    void removeTail() {
        Deque<Integer> deque = new Deque<>();
        deque.addTail(1);
        deque.addTail(2);
        deque.addTail(3);

        assertEquals(3, deque.removeTail());
        assertEquals(2, deque.removeTail());
        assertEquals(1, deque.removeTail());
        assertNull(deque.removeTail());
    }

    @Test
    void size() {
        Deque<Integer> deque = new Deque<>();
        assertEquals(0, deque.size());

        deque.addFront(1);
        assertEquals(1, deque.size());

        deque.addFront(2);
        assertEquals(2, deque.size());

        deque.addTail(3);
        assertEquals(3, deque.size());

        deque.addTail(4);
        assertEquals(4, deque.size());

        deque.removeTail();
        assertEquals(3, deque.size());
        deque.removeFront();
        assertEquals(2, deque.size());
        deque.removeTail();
        assertEquals(1, deque.size());
        deque.removeFront();
        assertEquals(0, deque.size());

        deque.removeTail();
        assertEquals(0, deque.size());
        deque.removeFront();
        assertEquals(0, deque.size());
    }

    @Test
    void queue() {
        Deque<Integer> deque = new Deque<>();
        deque.addTail(1);
        deque.addTail(2);
        deque.addTail(3);

        assertEquals(1, deque.removeFront());
        assertEquals(2, deque.removeFront());
        assertEquals(3, deque.removeFront());

        deque = new Deque<>();
        deque.addFront(1);
        deque.addFront(2);
        deque.addFront(3);

        assertEquals(1, deque.removeTail());
        assertEquals(2, deque.removeTail());
        assertEquals(3, deque.removeTail());
    }
}