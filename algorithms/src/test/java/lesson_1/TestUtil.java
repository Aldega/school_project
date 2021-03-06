package lesson_1;

import lesson_1.LinkedList;
import lesson_1.Node;

public class TestUtil {

    public static LinkedList createLinkedListWithCount(int size) {
        LinkedList linkedList = new LinkedList();

        for (int i = 0; i < size; i++) {
            Node node = new Node(i);
            linkedList.addInTail(node);
        }
        return linkedList;
    }

    public static LinkedList createLinkedListWithValues(int... values) {
        LinkedList linkedList = new LinkedList();

        for (int value : values) {
            Node node = new Node(value);
            linkedList.addInTail(node);
        }

        return linkedList;
    }

    public static LinkedList createLinkedListWithNodes(Node... nodes) {
        LinkedList linkedList = new LinkedList();

        for (Node node : nodes) {
            linkedList.addInTail(node);
        }

        return linkedList;
    }
}
