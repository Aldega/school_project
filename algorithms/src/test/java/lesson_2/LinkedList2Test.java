package lesson_2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedList2Test {

    @Test
    void find() {
        LinkedList2 list = TestUtil.createLinkedList2WithValues(1, 2, 3);
        assertEquals(list.head, list.find(1));
        assertEquals(list.head.next, list.find(2));
        assertEquals(list.tail, list.find(3));
        assertNull(list.find(4));
    }

    @Test
    void findAll() {
    }

    @Test
    void remove() {
        //empty case
        LinkedList2 emptyList = TestUtil.createLinkedList2WithValues();
        assertFalse(emptyList.remove(5));

        LinkedList2 notExistValueList = TestUtil.createLinkedList2WithValues(1);
        assertFalse(notExistValueList.remove(666));
        assertFalse(notExistValueList.remove(42));

        //one element case contain value case
        LinkedList2 oneElementListContainValue = TestUtil.createLinkedList2WithValues(1);
        assertTrue(oneElementListContainValue.remove(1));
        assertEquals(0 , oneElementListContainValue.count());

        //one element case not contain value case
        LinkedList2 oneElementListNotContainValue = TestUtil.createLinkedList2WithValues(3);
        assertFalse(oneElementListNotContainValue.remove(1));
        assertEquals(1 , oneElementListNotContainValue.count());

        //value contain in head case
        LinkedList2 valueContainInHeadList = TestUtil.createLinkedList2WithValues(1, 2, 3);
        assertTrue(valueContainInHeadList.remove(1));
        assertEquals(2, valueContainInHeadList.head.value);
        assertEquals(3, valueContainInHeadList.head.next.value);
        assertNull(valueContainInHeadList.head.next.next);
        assertEquals(3, valueContainInHeadList.tail.value);
        assertEquals(2, valueContainInHeadList.tail.prev.value);
        assertNull(valueContainInHeadList.tail.prev.prev);

        //value contain in tail case
        LinkedList2 valueContainInTailList = TestUtil.createLinkedList2WithValues(1, 2, 3);
        assertTrue(valueContainInTailList.remove(3));
        assertEquals(1, valueContainInTailList.head.value);
        assertEquals(2, valueContainInTailList.head.next.value);
        assertNull(valueContainInTailList.head.next.next);
        assertEquals(2, valueContainInTailList.tail.value);
        assertEquals(1, valueContainInTailList.tail.prev.value);
        assertNull(valueContainInTailList.tail.prev.prev);

        //value contain in the middle of list
        LinkedList2 valueContainInMiddleList = TestUtil.createLinkedList2WithValues(1, 2, 3, 4);
        assertTrue(valueContainInMiddleList.remove(3));
        assertEquals(1, valueContainInMiddleList.head.value);
        assertEquals(2, valueContainInMiddleList.head.next.value);
        assertEquals(4, valueContainInMiddleList.head.next.next.value);
        assertNull(valueContainInMiddleList.head.next.next.next);
        assertEquals(4, valueContainInMiddleList.tail.value);
        assertEquals(2, valueContainInMiddleList.tail.prev.value);
        assertEquals(1, valueContainInMiddleList.tail.prev.prev.value);
        assertNull(valueContainInMiddleList.tail.prev.prev.prev);

        //value not contain in the list
        LinkedList2 valueNotContainInListList = TestUtil.createLinkedList2WithValues(1, 2, 3);
        assertFalse(valueNotContainInListList.remove(4));
        assertEquals(1, valueNotContainInListList.head.value);
        assertEquals(2, valueNotContainInListList.head.next.value);
        assertEquals(3, valueNotContainInListList.head.next.next.value);
        assertNull(valueNotContainInListList.head.next.next.next);
        assertEquals(3, valueNotContainInListList.tail.value);
        assertEquals(2, valueNotContainInListList.tail.prev.value);
        assertEquals(1, valueNotContainInListList.tail.prev.prev.value);
        assertNull(valueNotContainInListList.tail.prev.prev.prev);


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