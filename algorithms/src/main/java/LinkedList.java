import java.util.*;

public class LinkedList
{
    public Node head;
    public Node tail;

    public LinkedList()
    {
        head = null;
        tail = null;
    }

    public void addInTail(Node item) {
        if (this.head == null)
            this.head = item;
        else
            this.tail.next = item;
        this.tail = item;
    }

    public Node find(int value) {
        Node node = this.head;
        while (node != null) {
            if (node.value == value)
                return node;
            node = node.next;
        }
        return null;
    }

    public ArrayList<Node> findAll(int _value) {
        ArrayList<Node> nodes = new ArrayList<Node>();

        Node node = this.head;
        while (node != null) {
            if (node.value == _value) nodes.add(node);

            node = node.next;
        }
        return nodes;
    }

    public boolean remove(int _value)
    {
        if (isEmpty()) return false;

        if (this.head.value == _value) {
            this.head = this.head.next;
            return true;
        }

        Node node = this.head;
        Node next = node.next;

        while (next != null) {
            if (next.value == _value) {

                if (this.tail.equals(next)) this.tail = node;

                node.next = next.next;
                return true;
            }
            node = next;
            next = next.next;
        }

        return false;
    }

    public void removeAll(int _value)
    {
        while (!isEmpty() && this.head.value == _value) {
            this.head = this.head.next;
            if (this.head == null) this.tail = null;
        }

        if (isEmpty()) return;

        Node node = this.head;
        Node nextNode = node.next;

        while (nextNode != null) {
            while (nextNode != null && nextNode.value == _value) {
                if (isTail(nextNode)) this.tail = node;
                node.next = nextNode.next;
                nextNode = node.next;
            }
            if (nextNode != null) {
                node = nextNode;
                nextNode = nextNode.next;
            }
        }
    }

    public void clear()
    {
        this.head = null;
        this.tail = null;
    }

    public int count()
    {
        if (isEmpty()) return 0;

        if (isTail(this.head)) return 1;

        Node currentNode = this.head;
        int count = 1;

        do {
            count = count + 1;
            currentNode = currentNode.next;
        } while (!isTail(currentNode));

        return count;
    }

    public void insertAfter(Node _nodeAfter, Node _nodeToInsert)
    {
        if (_nodeToInsert == null) return;

        if (_nodeAfter == null) { // если _nodeAfter = null , добавьте новый элемент первым в списке
            _nodeToInsert.next = this.head;
            this.head = _nodeToInsert;
            return;
        }

        _nodeToInsert.next = _nodeAfter.next;
        _nodeAfter.next = _nodeToInsert;

        if (isTail(_nodeAfter)) this.tail = _nodeToInsert;
    }

    private boolean isEmpty() {
        return this.head == null && this.tail == null;
    }

    private boolean isTail(Node node) {
        return tail != null && this.tail.equals(node);
    }
}

class Node
{
    public int value;
    public Node next;
    public Node(int _value)
    {
        value = _value;
        next = null;
    }
}