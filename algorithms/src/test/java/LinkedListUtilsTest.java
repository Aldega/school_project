import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListUtilsTest {

    @Test
    void mergeTwoLinkedList() {
        LinkedList firstList = TestUtil.createLinkedListWithValues(1, 2, 3, 4);
        LinkedList secondList = TestUtil.createLinkedListWithValues(10, 11, 12, 13);

        assertNull(LinkedListUtils.mergeTwoLinkedList(null, secondList));
        assertNull(LinkedListUtils.mergeTwoLinkedList(firstList, null));
        assertNull(LinkedListUtils.mergeTwoLinkedList(firstList, TestUtil.createLinkedListWithValues(1)));

        LinkedList successResultList = LinkedListUtils.mergeTwoLinkedList(firstList, secondList);
        assertEquals(4, successResultList.count());
        assertEquals(11, successResultList.head.value);
        assertEquals(13, successResultList.head.next.value);
        assertEquals(15, successResultList.head.next.next.value);
        assertEquals(17, successResultList.head.next.next.next.value);
    }
}