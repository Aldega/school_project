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

        Node node = this.head;
        while (node != null) {
            if (node.value == _value) {
                nodes.add(node);
            }
            node = node.next;
        }

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

        Node node = find(_value);
        if (node != null) {

            if (isHead(node)) {
                this.head = this.head.next;
                this.head.prev = null;
                return true;
            }

            if (isTail(node)) {
                this.tail = this.tail.prev;
                this.tail.next = null;
                return true;
            }

            node.prev.next = node.next;
            node.next.prev = node.prev;
            return true;
        }

        return false;
    }

    public void removeAll(int _value)
    {
        if (isEmpty()) return;

        if (isOneElementList()) {
            if (this.head.value == _value) {
                clear();
                return;
            }
            return;
        }

        ArrayList<Node> allNodesThatMustRemoved = findAll(_value);
        for (Node node : allNodesThatMustRemoved) {
            if (isOneElementList() && this.head.value == _value) {
                    clear();
                    return;
            }

            if (isHead(node)) {
                this.head = this.head.next;
                this.head.prev = null;
            } else if (isTail(node)) {
                this.tail = this.tail.prev;
                this.tail.next = null;
            } else {
                node.prev.next = node.next;
                node.next.prev = node.prev;
            }

        }
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
        if (_nodeToInsert == null) return;

        if (this.isEmpty()) {
            addInTail(_nodeToInsert);
            return;
        }

        if (_nodeAfter == null) { // если _nodeAfter = null , добавьте новый элемент первым в списке
            _nodeToInsert.next = this.head;
            this.head = _nodeToInsert;
            this.head.next.prev = _nodeToInsert;

            return;
        }

        if (isTail(_nodeAfter)) {
            _nodeToInsert.prev = this.tail;
            this.tail.next = _nodeToInsert;
            this.tail = _nodeToInsert;
            return;
        }

        _nodeToInsert.prev = _nodeAfter;
        _nodeToInsert.next = _nodeAfter.next;
        _nodeAfter.next = _nodeToInsert;
        _nodeToInsert.next.prev = _nodeToInsert;

    }

    private boolean isEmpty() {
        return this.head == null && this.tail == null;
    }

    private boolean isTail(Node node) {
        return this.tail != null && this.tail.equals(node);
    }

    private boolean isHead(Node node) {
        return this.head != null && this.head.equals(node);
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
