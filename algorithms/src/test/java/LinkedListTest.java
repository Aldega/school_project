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

        LinkedList notExistValueList = TestUtil.createLinkedListWithValues(1);
        assertFalse(notExistValueList.remove(666));
        assertFalse(notExistValueList.remove(42));

        LinkedList listWith1Node = TestUtil.createLinkedListWithValues(1);
        assertEquals(1, listWith1Node.count());
        assertTrue(listWith1Node.remove(1));
        assertEquals(0, listWith1Node.count());
        assertNull(listWith1Node.tail);
        assertNull(listWith1Node.head);

        LinkedList linkedList = TestUtil.createLinkedListWithValues(0, 1, 2, 3, 4, 5);
        assertEquals(6, linkedList.count());
        assertEquals(0, linkedList.head.value);
        assertEquals(1, linkedList.head.next.value);
        assertEquals(2, linkedList.head.next.next.value);
        assertEquals(3, linkedList.head.next.next.next.value);
        assertEquals(4, linkedList.head.next.next.next.next.value);
        assertEquals(5, linkedList.head.next.next.next.next.next.value);
        assertEquals(5, linkedList.tail.value);

        assertTrue(linkedList.remove(0));
        assertEquals(5, linkedList.count());
        assertEquals(1, linkedList.head.value);
        assertEquals(2, linkedList.head.next.value);
        assertEquals(3, linkedList.head.next.next.value);
        assertEquals(4, linkedList.head.next.next.next.value);
        assertEquals(5, linkedList.head.next.next.next.next.value);
        assertEquals(5, linkedList.tail.value);

        assertTrue(linkedList.remove(3));
        assertEquals(4, linkedList.count());
        assertEquals(1, linkedList.head.value);
        assertEquals(2, linkedList.head.next.value);
        assertEquals(4, linkedList.head.next.next.value);
        assertEquals(5, linkedList.head.next.next.next.value);
        assertEquals(5, linkedList.tail.value);

        assertTrue(linkedList.remove(5));
        assertEquals(3, linkedList.count());
        assertEquals(1, linkedList.head.value);
        assertEquals(2, linkedList.head.next.value);
        assertEquals(4, linkedList.head.next.next.value);
        assertEquals(4, linkedList.tail.value);

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
        assertEquals(5, listWithRetries.tail.value);

        assertTrue(listWithRetries.remove(1));
        assertEquals(6, listWithRetries.count());
        assertEquals(0, listWithRetries.head.value);
        assertEquals(2, listWithRetries.head.next.value);
        assertEquals(3, listWithRetries.head.next.next.value);
        assertEquals(1, listWithRetries.head.next.next.next.value);
        assertEquals(4, listWithRetries.head.next.next.next.next.value);
        assertEquals(5, listWithRetries.head.next.next.next.next.next.value);
        assertEquals(5, listWithRetries.tail.value);

        assertTrue(listWithRetries.remove(1));
        assertEquals(5, listWithRetries.count());
        assertEquals(0, listWithRetries.head.value);
        assertEquals(2, listWithRetries.head.next.value);
        assertEquals(3, listWithRetries.head.next.next.value);
        assertEquals(4, listWithRetries.head.next.next.next.value);
        assertEquals(5, listWithRetries.head.next.next.next.next.value);
        assertEquals(5, listWithRetries.tail.value);
    }

    @Test
    void removeAll() {
        LinkedList emptyList = TestUtil.createLinkedListWithValues();
        assertEquals(0, emptyList.count());
        emptyList.removeAll(1);
        assertEquals(0, emptyList.count());

        LinkedList listWithAllNodesIs1 = TestUtil.createLinkedListWithValues(1, 1, 1, 1, 1, 1, 1, 1, 1, 1);
        assertEquals(10, listWithAllNodesIs1.count());
        listWithAllNodesIs1.removeAll(5);
        assertEquals(10, listWithAllNodesIs1.count());
        listWithAllNodesIs1.removeAll(1);
        assertEquals(0, listWithAllNodesIs1.count());
        assertNull(listWithAllNodesIs1.tail);
        assertNull(listWithAllNodesIs1.head);

        LinkedList listWith1Node = TestUtil.createLinkedListWithValues(1);
        assertEquals(1, listWith1Node.count());
        listWith1Node.removeAll(1);
        assertEquals(0, listWith1Node.count());
        assertNull(listWith1Node.tail);
        assertNull(listWith1Node.head);


        LinkedList list = TestUtil.createLinkedListWithValues(1, 1, 1, 1, 2, 3, 1, 1, 1, 1, 4, 5, 1, 1, 1, 1, 1);
        list.removeAll(1);
        assertEquals(4, list.count());
        assertEquals(2, list.head.value);
        assertEquals(3, list.head.next.value);
        assertEquals(4, list.head.next.next.value);
        assertEquals(5, list.head.next.next.next.value);
        assertEquals(5, list.tail.value);

        LinkedList list2 = TestUtil.createLinkedListWithValues(1, 1, 1, 1, 2, 3, 1, 1, 1, 1, 4, 5, 1);
        list2.removeAll(1);
        assertEquals(4, list2.count());
        assertEquals(2, list2.head.value);
        assertEquals(3, list2.head.next.value);
        assertEquals(4, list2.head.next.next.value);
        assertEquals(5, list2.head.next.next.next.value);
        assertEquals(5, list2.tail.value);
    }

    @Test
    void clear() {
        LinkedList linkedList = TestUtil.createLinkedListWithCount(5);
        assertEquals(5, linkedList.count());

        linkedList.clear();
        assertEquals(0, linkedList.count());
        assertNull(linkedList.tail);
        assertNull(linkedList.head);
    }

    @Test
    void count() {
        for (int count = 0; count < 10; count++) {
            LinkedList linkedList = TestUtil.createLinkedListWithCount(count);
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
        assertEquals(9, list.tail.value);

        list.insertAfter(null, new Node(0));
        assertEquals(4, list.count());
        assertEquals(0, list.head.value);
        assertEquals(3, list.head.next.value);
        assertEquals(6, list.head.next.next.value);
        assertEquals(9, list.head.next.next.next.value);
        assertEquals(9, list.tail.value);

        list.insertAfter(list.head.next, new Node(4));
        assertEquals(5, list.count());
        assertEquals(0, list.head.value);
        assertEquals(3, list.head.next.value);
        assertEquals(4, list.head.next.next.value);
        assertEquals(6, list.head.next.next.next.value);
        assertEquals(9, list.head.next.next.next.next.value);
        assertEquals(9, list.tail.value);

        list.insertAfter(list.head.next.next.next, new Node(7));
        assertEquals(6, list.count());
        assertEquals(0, list.head.value);
        assertEquals(3, list.head.next.value);
        assertEquals(4, list.head.next.next.value);
        assertEquals(6, list.head.next.next.next.value);
        assertEquals(7, list.head.next.next.next.next.value);
        assertEquals(9, list.head.next.next.next.next.next.value);
        assertEquals(9, list.tail.value);

        list.insertAfter(list.head.next.next.next.next.next, new Node(10));
        assertEquals(7, list.count());
        assertEquals(0, list.head.value);
        assertEquals(3, list.head.next.value);
        assertEquals(4, list.head.next.next.value);
        assertEquals(6, list.head.next.next.next.value);
        assertEquals(7, list.head.next.next.next.next.value);
        assertEquals(9, list.head.next.next.next.next.next.value);
        assertEquals(10, list.head.next.next.next.next.next.next.value);
        assertEquals(10, list.tail.value);
    }
}