package lesson_1;

public class LinkedListUtils {

    public static LinkedList mergeTwoLinkedList(LinkedList firstList, LinkedList secondList) {
        if (firstList == null || secondList == null) return null; //предположение

        if (firstList.count() != secondList.count()) return null; //предположение

        LinkedList result = new LinkedList();

        Node firstListNode = firstList.head;
        Node secondListNode = secondList.head;
        while (firstListNode != null) {
            result.addInTail(new Node(firstListNode.value + secondListNode.value));
            firstListNode = firstListNode.next;
            secondListNode = secondListNode.next;
        }
        return result;
    }
}
