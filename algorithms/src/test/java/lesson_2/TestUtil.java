package lesson_2;

public class TestUtil {

    public static LinkedList2 createLinkedList2WithCount(int size) {
        LinkedList2 linkedList = new LinkedList2();

        for (int i = 0; i < size; i++) {
            Node node = new Node(i);
            linkedList.addInTail(node);
        }
        return linkedList;
    }

    public static LinkedList2 createLinkedList2WithValues(int... values) {
        LinkedList2 linkedList = new LinkedList2();

        for (int value : values) {
            Node node = new Node(value);
            linkedList.addInTail(node);
        }

        return linkedList;
    }

    public static LinkedList2 createLinkedList2WithNodes(Node... nodes) {
        LinkedList2 linkedList = new LinkedList2();

        for (Node node : nodes) {
            linkedList.addInTail(node);
        }

        return linkedList;
    }
}
