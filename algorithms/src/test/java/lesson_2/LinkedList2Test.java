package lesson_2;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

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
        LinkedList2 emptyList = TestUtil.createLinkedList2WithValues();
        ArrayList<Node> case1Result = emptyList.findAll(5);
        assertEquals(0, case1Result.size());

        LinkedList2 listWithValuesOne = TestUtil.createLinkedList2WithValues(1);
        ArrayList<Node> case2Result = listWithValuesOne.findAll(1);
        assertEquals(1, case2Result.size());

        LinkedList2 listWithManyDifferentValues = TestUtil.createLinkedList2WithValues(0, 1, 6, 2, 6, 1, 1, 7, 0, 0, 0, 0, 1);
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
        //empty list case
        LinkedList2 emptyList = new LinkedList2();
        assertDoesNotThrow(() -> emptyList.removeAll(10));

        //one element list contain value case
        LinkedList2 oneElementContainValueList = TestUtil.createLinkedList2WithValues(1);
        assertDoesNotThrow(() -> oneElementContainValueList.removeAll(1));
        assertEquals(0, oneElementContainValueList.count());

        //one element list not contain value case
        LinkedList2 oneElementNotContainValueList = TestUtil.createLinkedList2WithValues(1);
        assertDoesNotThrow(() -> oneElementNotContainValueList.removeAll(0));
        assertEquals(1, oneElementNotContainValueList.count());
        assertEquals(1, oneElementNotContainValueList.head.value);
        assertEquals(1, oneElementNotContainValueList.tail.value);
        assertEquals(oneElementNotContainValueList.head, oneElementNotContainValueList.tail);

        //values contains in all list 1, 1, 1, 1, 1
        LinkedList2 valuesContainsInAllList = TestUtil.createLinkedList2WithValues(1, 1, 1, 1, 1);
        assertDoesNotThrow(() -> valuesContainsInAllList.removeAll(1));
        assertEquals(0, valuesContainsInAllList.count());

        //values contains in the head of list 1, 1, 1, 2, 3, 4
        LinkedList2 valuesContainsInTheHeadList = TestUtil.createLinkedList2WithValues(1, 1, 1, 2, 3, 4);
        assertDoesNotThrow(() -> valuesContainsInTheHeadList.removeAll(1));
        assertEquals(2, valuesContainsInTheHeadList.head.value);
        assertEquals(3, valuesContainsInTheHeadList.head.next.value);
        assertEquals(4, valuesContainsInTheHeadList.head.next.next.value);
        assertNull(valuesContainsInTheHeadList.head.next.next.next);
        assertEquals(4, valuesContainsInTheHeadList.tail.value);
        assertEquals(3, valuesContainsInTheHeadList.tail.prev.value);
        assertEquals(2, valuesContainsInTheHeadList.tail.prev.prev.value);
        assertNull(valuesContainsInTheHeadList.tail.prev.prev.prev);

        //values contains in the tail of list 2, 3, 4, 1, 1, 1
        LinkedList2 valuesContainsInTheTailList = TestUtil.createLinkedList2WithValues(2, 3, 4, 1, 1, 1);
        assertDoesNotThrow(() -> valuesContainsInTheTailList.removeAll(1));
        assertEquals(2, valuesContainsInTheTailList.head.value);
        assertEquals(3, valuesContainsInTheTailList.head.next.value);
        assertEquals(4, valuesContainsInTheTailList.head.next.next.value);
        assertNull(valuesContainsInTheTailList.head.next.next.next);
        assertEquals(4, valuesContainsInTheTailList.tail.value);
        assertEquals(3, valuesContainsInTheTailList.tail.prev.value);
        assertEquals(2, valuesContainsInTheTailList.tail.prev.prev.value);
        assertNull(valuesContainsInTheTailList.tail.prev.prev.prev);

        //values contains in the tail of list 2, 1, 3, 1, 4
        LinkedList2 valuesContainsInTheMiddleList = TestUtil.createLinkedList2WithValues(2, 1, 3, 1, 4);
        assertDoesNotThrow(() -> valuesContainsInTheMiddleList.removeAll(1));
        assertEquals(2, valuesContainsInTheMiddleList.head.value);
        assertEquals(3, valuesContainsInTheMiddleList.head.next.value);
        assertEquals(4, valuesContainsInTheMiddleList.head.next.next.value);
        assertNull(valuesContainsInTheMiddleList.head.next.next.next);
        assertEquals(4, valuesContainsInTheMiddleList.tail.value);
        assertEquals(3, valuesContainsInTheMiddleList.tail.prev.value);
        assertEquals(2, valuesContainsInTheMiddleList.tail.prev.prev.value);
        assertNull(valuesContainsInTheMiddleList.tail.prev.prev.prev);

        //values contains everywhere 1, 1, 2, 1, 1, 3, 1, 1, 4, 1, 1
        LinkedList2 valuesContainsEverywhereList = TestUtil.createLinkedList2WithValues(1, 1, 2, 1, 1, 3, 1, 1, 4, 1, 1);
        assertDoesNotThrow(() -> valuesContainsEverywhereList.removeAll(1));
        assertEquals(2, valuesContainsEverywhereList.head.value);
        assertEquals(3, valuesContainsEverywhereList.head.next.value);
        assertEquals(4, valuesContainsEverywhereList.head.next.next.value);
        assertNull(valuesContainsEverywhereList.head.next.next.next);
        assertEquals(4, valuesContainsEverywhereList.tail.value);
        assertEquals(3, valuesContainsEverywhereList.tail.prev.value);
        assertEquals(2, valuesContainsEverywhereList.tail.prev.prev.value);
        assertNull(valuesContainsEverywhereList.tail.prev.prev.prev);

        //values not contains in the list 2, 3, 4
        LinkedList2 notContainValueList = TestUtil.createLinkedList2WithValues(2, 3, 4);
        assertDoesNotThrow(() -> notContainValueList.removeAll(1));
        assertEquals(2, notContainValueList.head.value);
        assertEquals(3, notContainValueList.head.next.value);
        assertEquals(4, notContainValueList.head.next.next.value);
        assertNull(notContainValueList.head.next.next.next);
        assertEquals(4, notContainValueList.tail.value);
        assertEquals(3, notContainValueList.tail.prev.value);
        assertEquals(2, notContainValueList.tail.prev.prev.value);
        assertNull(notContainValueList.tail.prev.prev.prev);
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