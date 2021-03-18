package lesson_2;

import java.util.*;

public class LinkedList2
{
    public Node head;
    public Node tail;

    public LinkedList2()
    {
        head = null;
        tail = null;
    }

    public void addInTail(Node _item)
    {
        if (head == null) {
            this.head = _item;
            this.head.next = null;
            this.head.prev = null;
        } else {
            this.tail.next = _item;
            _item.prev = tail;
        }
        this.tail = _item;
    }

    public Node find(int _value)
    {
        if (this.head.value == _value) return this.head;
        if (this.tail.value == _value) return this.tail;

        Node node = this.head.next;
        while (!isTail(node)) {
            if (node.value == _value) {
                return node;
            }
            node = node.next;
        }

        return null;
    }

    public ArrayList<Node> findAll(int _value)
    {
        ArrayList<Node> nodes = new ArrayList<Node>();
        // здесь будет ваш код поиска всех узлов по заданному значению
        return nodes;
    }

    public boolean remove(int _value)
    {

        if (isEmpty()) return false;

        if (isOneElementList()) {
            if (this.head.value == _value) {
                clear();
                return true;
            }
            return false;
        }

        if (this.head.value == _value) {
            this.head = this.head.next;
            this.head.prev = null;
            return true;
        }

        if (this.tail.value == _value) {
            this.tail = this.tail.prev;
            this.tail.next = null;
            return true;
        }

        Node node = this.head.next;
        while (!isTail(node)) {
            if (node.value == _value) {
                node.prev.next = node.next;
                node.next.prev = node.prev;
                return true;
            }
            node = node.next;
        }

        return false;
    }

    public void removeAll(int _value)
    {
        // здесь будет ваш код удаления всех узлов по заданному значению
    }

    public void clear()
    {
        this.head = null;
        this.tail = null;
    }

    public int count()
    {
        if (isEmpty()) return 0;

        if (isOneElementList()) return 1;

        Node node = this.head.next;
        int count = 1;

        while (node != null) {
            count = count + 1;
            node = node.next;
        }

        return count;
    }

    public void insertAfter(Node _nodeAfter, Node _nodeToInsert)
    {
        // здесь будет ваш код вставки узла после заданного узла

        // если _nodeAfter = null
        // добавьте новый элемент первым в списке
    }

    private boolean isEmpty() {
        return this.head == null && this.tail == null;
    }

    private boolean isTail(Node node) {
        return tail != null && this.tail.equals(node);
    }

    private boolean isOneElementList() {
        return isTail(this.head);
    }
}

class Node
{
    public int value;
    public Node next;
    public Node prev;

    public Node(int _value)
    {
        value = _value;
        next = null;
        prev = null;
    }
}
