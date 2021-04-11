package lesson_7;

import java.util.*;


class Node<T> {
    public T value;
    public Node<T> next, prev;

    public Node(T _value) {
        value = _value;
        next = null;
        prev = null;
    }
}

public class OrderedList<T> {
    public Node<T> head, tail;
    private boolean _ascending;

    public OrderedList(boolean asc) {
        head = null;
        tail = null;
        _ascending = asc;
    }

    public int compare(T v1, T v2) {
        // -1 если v1 < v2
        // 0 если v1 == v2
        // +1 если v1 > v2
        if (v1 instanceof Integer && v2 instanceof Integer) {
            int value1 = (Integer) v1;
            int value2 = (Integer) v2;
            return Integer.compare(value1, value2);
        }
        if (v1 instanceof String && v2 instanceof String) {
            return ((String) v1).trim().compareTo(((String) v2).trim());
        }
        throw new RuntimeException("Unsuported type of variables");
    }

    //сложность варьируется от O(1) (если основной входящих поток значений вне диапазован списка) до O(logN)
    public void add(T value) {
        // автоматическая вставка value
        // в нужную позицию

        //если список пустой
        if (isEmpty()) {
            Node<T> node = new Node<>(value);
            this.head = node;
            this.tail = node;
            return;
        }

        //если значение вне списка у головы
        if (isOutsideOrEqualHeadList(value)) {
            Node<T> node = new Node<>(value);
            addInHead(node);
            return;
        }

        //если значение вне списка у хвоста
        if (isOutsideOrEqualTailList(value)) {
            Node<T> node = new Node<>(value);
            addInTail(node);
            return;
        }

        List<Node<T>> all = getAll();
        binaryPush(0, all.size() - 1, all, value);
    }

    private void insertAfter(Node<T> _nodePoint, Node<T> _nodeToInsert) //добавить справа
    {
        if (_nodeToInsert == null) return;

        if (this.isEmpty()) {
            addInTail(_nodeToInsert);
            return;
        }

        if (isTail(_nodePoint)) {
            addInTail(_nodeToInsert);
            return;
        }

        _nodeToInsert.prev = _nodePoint;
        _nodeToInsert.next = _nodePoint.next;
        _nodePoint.next = _nodeToInsert;
        _nodeToInsert.next.prev = _nodeToInsert;
    }

    private void insertBefore(Node<T> _nodePoint, Node<T> _nodeToInsert) //добавить слева
    {
        if (_nodeToInsert == null) return;

        if (this.isEmpty()) {
            addInTail(_nodeToInsert);
            return;
        }

        if (isHead(_nodePoint)) {
            addInHead(_nodeToInsert);
            return;
        }

        _nodeToInsert.next = _nodePoint;
        _nodeToInsert.prev = _nodePoint.prev;
        _nodePoint.prev = _nodeToInsert;
        _nodeToInsert.prev.next = _nodeToInsert;
    }

    private void binaryPush(int startIndex, int endIndex, List<Node<T>> values, T value) {
        if (startIndex == endIndex) {
            Node<T> point = values.get(startIndex);
            Node<T> nodeValue = new Node<>(value);
            if (isOutsideOrEqualValueLeft(value, point.value)) {
                insertBefore(point, nodeValue);
                return;
            }
            if (isOutsideOrEqualValueRight(value, point.value)) {
                insertAfter(point, nodeValue);
                return;
            }
            throw new RuntimeException();
        }

        int currentSize = endIndex - startIndex + 1;
        int pointCheckIndex = startIndex + (currentSize / 2);
        Node<T> nodePoint = values.get(pointCheckIndex);

        if (compare(value, nodePoint.value) == 0) {
            insertBefore(nodePoint, new Node<>(value));
            return;
        }

        if (isOutsideOrEqualValueLeft(value, nodePoint.value)) {
            binaryPush(startIndex, pointCheckIndex - 1, values, value);
            return;
        }
        if (isOutsideOrEqualValueRight(value, nodePoint.value)) {
            binaryPush(pointCheckIndex + 1, endIndex, values, value);
            return;
        }

        throw new RuntimeException();
    }


    public Node<T> find(T val) {

        if (val == null) return null;

        ArrayList<Node<T>> all = getAll();

        //case when list has no elements
        if (isEmpty()) return null;

        //case when list has one elements
        if (all.size() == 1) {
            if (val.equals(all.get(0).value)) {
                return all.get(0);
            }
            return null;
        }

        if (isOutsideList(val)) return null;

        return binarySearch(0, all.size() - 1, all, val);
    }


    private Node<T> binarySearch(int startIndex, int endIndex, List<Node<T>> list, T val) {

        if (startIndex == endIndex) {
            if (compare(val, list.get(startIndex).value) == 0) return list.get(startIndex);
            return null;
        }

        int currentSize = endIndex - startIndex + 1;
        int pointCheckIndex = startIndex + (currentSize / 2);

        int compare = compare(val, list.get(pointCheckIndex).value);
        if (compare == 0) return list.get(pointCheckIndex);

        if (isOutsideValueLeft(val, list.get(pointCheckIndex).value))
            return binarySearch(startIndex, pointCheckIndex - 1, list, val);

        return binarySearch(pointCheckIndex + 1, endIndex, list, val);
    }

    private boolean isOutsideList(T val) {
        return isOutsideHeadList(val) || isOutsideTailList(val);
    }

    private boolean isOutsideOrEqualHeadList(T val) {
        return isOutsideOrEqualValueLeft(val, this.head.value);
    }

    private boolean isOutsideOrEqualTailList(T val) {
        return isOutsideOrEqualValueRight(val, this.tail.value);
    }

    private boolean isOutsideHeadList(T val) {
        return isOutsideValueLeft(val, this.head.value);
    }

    private boolean isOutsideTailList(T val) {
        return isOutsideValueRight(val, this.tail.value);
    }

    private boolean isOutsideOrEqualValueLeft(T newVal, T oldVal) {
        return (_ascending && compare(newVal, oldVal) <= 0) || (!_ascending && compare(newVal, oldVal) >= 0);
    }

    private boolean isOutsideOrEqualValueRight(T newVal, T oldVal) {
        return (_ascending && compare(oldVal, newVal) <= 0) || (!_ascending && compare(oldVal, newVal) >= 0);
    }

    private boolean isOutsideValueLeft(T newVal, T oldVal) {
        return (_ascending && compare(newVal, oldVal) < 0) || (!_ascending && compare(newVal, oldVal) > 0);
    }

    private boolean isOutsideValueRight(T newVal, T oldVal) {
        return (_ascending && compare(oldVal, newVal) < 0) || (!_ascending && compare(oldVal, newVal) > 0);
    }

    private void addInHead(Node<T> node) {
        this.head.prev = node;
        node.next = this.head;
        this.head = node;
    }

    private void addInTail(Node<T> node) {
        this.tail.next = node;
        node.prev = this.tail;
        this.tail = node;
    }

    private boolean isEmpty() {
        return this.head == null && this.tail == null;
    }

    private boolean isTail(Node<T> node) {
        return this.tail != null && this.tail.equals(node);
    }

    private boolean isHead(Node<T> node) {
        return this.head != null && this.head.equals(node);
    }

    private boolean isOneElementList() {
        return isTail(this.head);
    }

    public void delete(T val) {
        Node<T> deletedNode = find(val);
        if (deletedNode == null) {
            return;
        }

        if (isOneElementList()) {
            clear(this._ascending);
            return;
        }

        if (isHead(deletedNode)) {
            this.head = this.head.next;
            this.head.prev = null;
            return;
        }

        if (isTail(deletedNode)) {
            this.tail = this.tail.prev;
            this.tail.next = null;
            return;
        }

        deletedNode.prev.next = deletedNode.next;
        deletedNode.next.prev = deletedNode.prev;

    }

    public void clear(boolean asc) {
        _ascending = asc;
        this.head = null;
        this.tail = null;
    }

    public int count() {
        return getAll().size();
    }

    ArrayList<Node<T>> getAll() { // выдать все элементы упорядоченного списка в виде стандартного списка

        ArrayList<Node<T>> r = new ArrayList<Node<T>>();
        Node<T> node = head;
        while (node != null) {
            r.add(node);
            node = node.next;
        }
        return r;
    }
}