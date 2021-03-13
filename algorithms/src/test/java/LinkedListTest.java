import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LinkedListTest {

    @Test
    void findAll() {
        LinkedList emptyList = TestUtil.createLinkedListWithValues();
        ArrayList<Node> case1Result = emptyList.findAll(5);
        assertEquals(0, case1Result.size());

        LinkedList listWithValuesOne = TestUtil.createLinkedListWithValues(1);
        ArrayList<Node> case2Result = listWithValuesOne.findAll(1);
        assertEquals(1, case2Result.size());

        LinkedList listWithManyDifferentValues = TestUtil.createLinkedListWithValues(0, 1, 6, 2, 6, 1, 1, 7, 0, 0, 0, 0, 1);
        ArrayList<Node> case3Result = listWithManyDifferentValues.findAll(1);
        assertEquals(4, case3Result.size());

        ArrayList<Node> case4Result = listWithManyDifferentValues.findAll(0);
        assertEquals(5, case4Result.size());

        ArrayList<Node> case5Result = listWithManyDifferentValues.findAll(6);
        assertEquals(2, case5Result.size());

        ArrayList<Node> case6Result = listWithManyDifferentValues.findAll(7);
        assertEquals(1, case6Result.size());

        ArrayList<Node> case7Result = listWithManyDifferentValues.findAll(666);
        assertEquals(0, case7Result.size());
    }

    @Test
    void remove() {
        LinkedList emptyList = TestUtil.createLinkedListWithValues();
        assertFalse(emptyList.remove(5));

        LinkedList notExistValueList = TestUtil.createLinkedListWithValues(1, 2, 3, 4, 5);
        assertFalse(notExistValueList.remove(666));
        assertFalse(notExistValueList.remove(42));

        LinkedList linkedList = TestUtil.createLinkedListWithValues(0, 1, 2, 3, 4, 5);
        assertEquals(6, linkedList.count());
        assertEquals(0, linkedList.head.value);
        assertEquals(1, linkedList.head.next.value);
        assertEquals(2, linkedList.head.next.next.value);
        assertEquals(3, linkedList.head.next.next.next.value);
        assertEquals(4, linkedList.head.next.next.next.next.value);
        assertEquals(5, linkedList.head.next.next.next.next.next.value);

        assertTrue(linkedList.remove(0));
        assertEquals(5, linkedList.count());
        assertEquals(1, linkedList.head.value);
        assertEquals(2, linkedList.head.next.value);
        assertEquals(3, linkedList.head.next.next.value);
        assertEquals(4, linkedList.head.next.next.next.value);
        assertEquals(5, linkedList.head.next.next.next.next.value);
        assertNull(linkedList.head.next.next.next.next.next);

        assertTrue(linkedList.remove(3));
        assertEquals(4, linkedList.count());
        assertEquals(1, linkedList.head.value);
        assertEquals(2, linkedList.head.next.value);
        assertEquals(4, linkedList.head.next.next.value);
        assertEquals(5, linkedList.head.next.next.next.value);
        assertNull(linkedList.head.next.next.next.next);

        assertTrue(linkedList.remove(5));
        assertEquals(3, linkedList.count());
        assertEquals(1, linkedList.head.value);
        assertEquals(2, linkedList.head.next.value);
        assertEquals(4, linkedList.head.next.next.value);
        assertNull(linkedList.head.next.next.next);

        LinkedList listWithRetries = TestUtil.createLinkedListWithValues(0, 1, 1, 2, 3, 1, 4, 5);
        assertTrue(listWithRetries.remove(1));
        assertEquals(7, listWithRetries.count());
        assertEquals(0, listWithRetries.head.value);
        assertEquals(1, listWithRetries.head.next.value);
        assertEquals(2, listWithRetries.head.next.next.value);
        assertEquals(3, listWithRetries.head.next.next.next.value);
        assertEquals(1, listWithRetries.head.next.next.next.next.value);
        assertEquals(4, listWithRetries.head.next.next.next.next.next.value);
        assertEquals(5, listWithRetries.head.next.next.next.next.next.next.value);
        assertNull(listWithRetries.head.next.next.next.next.next.next.next);

        assertTrue(listWithRetries.remove(1));
        assertEquals(6, listWithRetries.count());
        assertEquals(0, listWithRetries.head.value);
        assertEquals(2, listWithRetries.head.next.value);
        assertEquals(3, listWithRetries.head.next.next.value);
        assertEquals(1, listWithRetries.head.next.next.next.value);
        assertEquals(4, listWithRetries.head.next.next.next.next.value);
        assertEquals(5, listWithRetries.head.next.next.next.next.next.value);

        assertTrue(listWithRetries.remove(1));
        assertEquals(5, listWithRetries.count());
        assertEquals(0, listWithRetries.head.value);
        assertEquals(2, listWithRetries.head.next.value);
        assertEquals(3, listWithRetries.head.next.next.value);
        assertEquals(4, listWithRetries.head.next.next.next.value);
        assertEquals(5, listWithRetries.head.next.next.next.next.value);
    }

    @Test
    void removeAll() {
        LinkedList list = TestUtil.createLinkedListWithValues(1, 1, 1, 1, 2, 3, 1, 1, 1, 1, 4, 5, 1, 1, 1, 1, 1);

        list.removeAll(1);
        assertEquals(4, list.count());
        assertEquals(2, list.head.value);
        assertEquals(3, list.head.next.value);
        assertEquals(4, list.head.next.next.value);
        assertEquals(5, list.head.next.next.next.value);
    }

    @Test
    void clear() {
        LinkedList linkedList = TestUtil.createLinkedListWithSize(5);
        assertEquals(5, linkedList.count());

        linkedList.clear();
        assertEquals(0, linkedList.count());
    }

    @Test
    void count() {
        for (int i = 0; i < 1000; i++) {
            int count = i;
            LinkedList linkedList = TestUtil.createLinkedListWithSize(count);
            assertEquals(count, linkedList.count());
        }
    }

    @Test
    void insertAfter() {
        LinkedList list = TestUtil.createLinkedListWithNodes(
                new Node(3),
                new Node(6),
                new Node(9));

        assertEquals(3, list.count());
        assertEquals(3, list.head.value);
        assertEquals(6, list.head.next.value);
        assertEquals(9, list.head.next.next.value);

        list.insertAfter(null, new Node(0));
        assertEquals(4, list.count());
        assertEquals(0, list.head.value);
        assertEquals(3, list.head.next.value);
        assertEquals(6, list.head.next.next.value);
        assertEquals(9, list.head.next.next.next.value);

        list.insertAfter(list.head.next, new Node(4));
        assertEquals(5, list.count());
        assertEquals(0, list.head.value);
        assertEquals(3, list.head.next.value);
        assertEquals(4, list.head.next.next.value);
        assertEquals(6, list.head.next.next.next.value);
        assertEquals(9, list.head.next.next.next.next.value);

        list.insertAfter(list.head.next.next.next, new Node(7));
        assertEquals(6, list.count());
        assertEquals(0, list.head.value);
        assertEquals(3, list.head.next.value);
        assertEquals(4, list.head.next.next.value);
        assertEquals(6, list.head.next.next.next.value);
        assertEquals(7, list.head.next.next.next.next.value);
        assertEquals(9, list.head.next.next.next.next.next.value);

        list.insertAfter(list.head.next.next.next.next.next, new Node(10));
        assertEquals(7, list.count());
        assertEquals(0, list.head.value);
        assertEquals(3, list.head.next.value);
        assertEquals(4, list.head.next.next.value);
        assertEquals(6, list.head.next.next.next.value);
        assertEquals(7, list.head.next.next.next.next.value);
        assertEquals(9, list.head.next.next.next.next.next.value);
        assertEquals(10, list.head.next.next.next.next.next.next.value);
    }
}