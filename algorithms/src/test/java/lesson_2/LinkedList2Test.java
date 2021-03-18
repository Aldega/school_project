package lesson_2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedList22Test {

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
    }

    @Test
    void insertAfter() {
    }
}