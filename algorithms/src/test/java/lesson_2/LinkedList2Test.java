package lesson_2;

import lesson_1.LinkedList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedList2Test {

    @Test
    void find() {
    }

    @Test
    void findAll() {
    }

    @Test
    void remove() {
    }

    @Test
    void removeAll() {
    }

    @Test
    void clear() {
        LinkedList2 linkedList = TestUtil.createLinkedList2WithCount(5);
        assertEquals(5, linkedList.count());

        linkedList.clear();
        assertEquals(0, linkedList.count());
        assertNull(linkedList.tail);
        assertNull(linkedList.head);
    }

    @Test
    void count() {
        for (int count = 0; count < 10; count++) {
            LinkedList2 linkedList = TestUtil.createLinkedList2WithCount(count);
            assertEquals(count, linkedList.count());
        }
    }

    @Test
    void insertAfter() {
    }
}