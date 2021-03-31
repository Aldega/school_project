package lesson_7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderedListTest {

    @Test
    void compare() {
        OrderedList<Integer> list = new OrderedList<>(true);

        assertEquals(-1, list.compare(-2, 2));
        assertEquals(-1, list.compare(-200, 200));
        assertEquals(1, list.compare(2, -2));
        assertEquals(1, list.compare(200, -200));
        assertEquals(0, list.compare(200, 200));
        assertEquals(0, list.compare(2, 2));

        OrderedList<String> strList = new OrderedList<>(true);

        assertEquals(-1, strList.compare("а", "б"));
        assertEquals(1, strList.compare("б", "а"));
        assertEquals(0, strList.compare("а", "а"));
        assertEquals(-1, strList.compare("аб", "ба"));
        assertEquals(-1, strList.compare(" аб ", "ба "));
        assertEquals(-1, strList.compare("аб ", " ба "));
    }

    @Test
    void addAsc() {
        //one element list
        OrderedList<Integer> oneElementList = new OrderedList<>(true);
        assertEquals(0, oneElementList.getAll().size());
        assertNull(oneElementList.head);
        assertNull(oneElementList.tail);

        oneElementList.add(1);
        assertEquals(1, oneElementList.getAll().size());
        assertNull(oneElementList.head.prev);
        assertEquals(1, oneElementList.head.value);
        assertNull(oneElementList.head.next);

        assertNull(oneElementList.tail.prev);
        assertEquals(1, oneElementList.tail.value);
        assertNull(oneElementList.tail.next);

        //asc list
        OrderedList<Integer> ascList = new OrderedList<>(true);

        ascList.add(1);
        assertEquals(1, ascList.getAll().size());

        assertNull(ascList.head.prev);
        assertEquals(1, ascList.head.value);
        assertNull(ascList.head.next);

        assertNull(ascList.tail.prev);
        assertEquals(1, ascList.tail.value);
        assertNull(ascList.tail.next);

        ascList.add(5);
        assertEquals(2, ascList.getAll().size());

        assertNull(ascList.head.prev);
        assertEquals(1, ascList.head.value);
        assertEquals(5, ascList.head.next.value);
        assertNull(ascList.head.next.next);

        assertNull(ascList.tail.next);
        assertEquals(5, ascList.tail.value);
        assertEquals(1, ascList.tail.prev.value);
        assertNull(ascList.tail.prev.prev);

        ascList.add(3);
        assertEquals(3, ascList.getAll().size());

        assertNull(ascList.head.prev);
        assertEquals(1, ascList.head.value);
        assertEquals(3, ascList.head.next.value);
        assertEquals(5, ascList.head.next.next.value);
        assertNull(ascList.head.next.next.next);

        assertNull(ascList.tail.next);
        assertEquals(5, ascList.tail.value);
        assertEquals(3, ascList.tail.prev.value);
        assertEquals(1, ascList.tail.prev.prev.value);
        assertNull(ascList.tail.prev.prev.prev);

        ascList.add(2);
        assertEquals(4, ascList.getAll().size());

        assertNull(ascList.head.prev);
        assertEquals(1, ascList.head.value);
        assertEquals(2, ascList.head.next.value);
        assertEquals(3, ascList.head.next.next.value);
        assertEquals(5, ascList.head.next.next.next.value);
        assertNull(ascList.head.next.next.next.next);

        assertNull(ascList.tail.next);
        assertEquals(5, ascList.tail.value);
        assertEquals(3, ascList.tail.prev.value);
        assertEquals(2, ascList.tail.prev.prev.value);
        assertEquals(1, ascList.tail.prev.prev.prev.value);
        assertNull(ascList.tail.prev.prev.prev.prev);

        ascList.add(4);
        assertEquals(5, ascList.getAll().size());

        assertNull(ascList.head.prev);
        assertEquals(1, ascList.head.value);
        assertEquals(2, ascList.head.next.value);
        assertEquals(3, ascList.head.next.next.value);
        assertEquals(4, ascList.head.next.next.next.value);
        assertEquals(5, ascList.head.next.next.next.next.value);
        assertNull(ascList.head.next.next.next.next.next);

        assertNull(ascList.tail.next);
        assertEquals(5, ascList.tail.value);
        assertEquals(4, ascList.tail.prev.value);
        assertEquals(3, ascList.tail.prev.prev.value);
        assertEquals(2, ascList.tail.prev.prev.prev.value);
        assertEquals(1, ascList.tail.prev.prev.prev.prev.value);
        assertNull(ascList.tail.prev.prev.prev.prev.prev);

        ascList.add(0);
        assertEquals(6, ascList.getAll().size());

        assertNull(ascList.head.prev);
        assertEquals(0, ascList.head.value);
        assertEquals(1, ascList.head.next.value);
        assertEquals(2, ascList.head.next.next.value);
        assertEquals(3, ascList.head.next.next.next.value);
        assertEquals(4, ascList.head.next.next.next.next.value);
        assertEquals(5, ascList.head.next.next.next.next.next.value);
        assertNull(ascList.head.next.next.next.next.next.next);

        assertNull(ascList.tail.next);
        assertEquals(5, ascList.tail.value);
        assertEquals(4, ascList.tail.prev.value);
        assertEquals(3, ascList.tail.prev.prev.value);
        assertEquals(2, ascList.tail.prev.prev.prev.value);
        assertEquals(1, ascList.tail.prev.prev.prev.prev.value);
        assertEquals(0, ascList.tail.prev.prev.prev.prev.prev.value);
        assertNull(ascList.tail.prev.prev.prev.prev.prev.prev);

        ascList.add(6);
        assertEquals(7, ascList.getAll().size());

        assertNull(ascList.head.prev);
        assertEquals(0, ascList.head.value);
        assertEquals(1, ascList.head.next.value);
        assertEquals(2, ascList.head.next.next.value);
        assertEquals(3, ascList.head.next.next.next.value);
        assertEquals(4, ascList.head.next.next.next.next.value);
        assertEquals(5, ascList.head.next.next.next.next.next.value);
        assertEquals(6, ascList.head.next.next.next.next.next.next.value);
        assertNull(ascList.head.next.next.next.next.next.next.next);

        assertNull(ascList.tail.next);
        assertEquals(6, ascList.tail.value);
        assertEquals(5, ascList.tail.prev.value);
        assertEquals(4, ascList.tail.prev.prev.value);
        assertEquals(3, ascList.tail.prev.prev.prev.value);
        assertEquals(2, ascList.tail.prev.prev.prev.prev.value);
        assertEquals(1, ascList.tail.prev.prev.prev.prev.prev.value);
        assertEquals(0, ascList.tail.prev.prev.prev.prev.prev.prev.value);
        assertNull(ascList.tail.prev.prev.prev.prev.prev.prev.prev);

        ascList.add(2);
        assertEquals(8, ascList.getAll().size());

        assertNull(ascList.head.prev);
        assertEquals(0, ascList.head.value);
        assertEquals(1, ascList.head.next.value);
        assertEquals(2, ascList.head.next.next.value);
        assertEquals(2, ascList.head.next.next.next.value);
        assertEquals(3, ascList.head.next.next.next.next.value);
        assertEquals(4, ascList.head.next.next.next.next.next.value);
        assertEquals(5, ascList.head.next.next.next.next.next.next.value);
        assertEquals(6, ascList.head.next.next.next.next.next.next.next.value);
        assertNull(ascList.head.next.next.next.next.next.next.next.next);

        assertNull(ascList.tail.next);
        assertEquals(6, ascList.tail.value);
        assertEquals(5, ascList.tail.prev.value);
        assertEquals(4, ascList.tail.prev.prev.value);
        assertEquals(3, ascList.tail.prev.prev.prev.value);
        assertEquals(2, ascList.tail.prev.prev.prev.prev.value);
        assertEquals(2, ascList.tail.prev.prev.prev.prev.prev.value);
        assertEquals(1, ascList.tail.prev.prev.prev.prev.prev.prev.value);
        assertEquals(0, ascList.tail.prev.prev.prev.prev.prev.prev.prev.value);
        assertNull(ascList.tail.prev.prev.prev.prev.prev.prev.prev.prev);

        ascList.add(0);
        assertEquals(9, ascList.getAll().size());

        assertNull(ascList.head.prev);
        assertEquals(0, ascList.head.value);
        assertEquals(0, ascList.head.next.value);
        assertEquals(1, ascList.head.next.next.value);
        assertEquals(2, ascList.head.next.next.next.value);
        assertEquals(2, ascList.head.next.next.next.next.value);
        assertEquals(3, ascList.head.next.next.next.next.next.value);
        assertEquals(4, ascList.head.next.next.next.next.next.next.value);
        assertEquals(5, ascList.head.next.next.next.next.next.next.next.value);
        assertEquals(6, ascList.head.next.next.next.next.next.next.next.next.value);
        assertNull(ascList.head.next.next.next.next.next.next.next.next.next);

        assertNull(ascList.tail.next);
        assertEquals(6, ascList.tail.value);
        assertEquals(5, ascList.tail.prev.value);
        assertEquals(4, ascList.tail.prev.prev.value);
        assertEquals(3, ascList.tail.prev.prev.prev.value);
        assertEquals(2, ascList.tail.prev.prev.prev.prev.value);
        assertEquals(2, ascList.tail.prev.prev.prev.prev.prev.value);
        assertEquals(1, ascList.tail.prev.prev.prev.prev.prev.prev.value);
        assertEquals(0, ascList.tail.prev.prev.prev.prev.prev.prev.prev.value);
        assertEquals(0, ascList.tail.prev.prev.prev.prev.prev.prev.prev.prev.value);
        assertNull(ascList.tail.prev.prev.prev.prev.prev.prev.prev.prev.prev);


    }

    @Test
    void addDesc() {
        //one element list
        OrderedList<Integer> oneElementList = new OrderedList<>(false);
        assertEquals(0, oneElementList.getAll().size());
        assertNull(oneElementList.head);
        assertNull(oneElementList.tail);

        oneElementList.add(1);
        assertEquals(1, oneElementList.getAll().size());
        assertNull(oneElementList.head.prev);
        assertEquals(1, oneElementList.head.value);
        assertNull(oneElementList.head.next);

        assertNull(oneElementList.tail.prev);
        assertEquals(1, oneElementList.tail.value);
        assertNull(oneElementList.tail.next);

        //desc list
        OrderedList<Integer> descList = new OrderedList<>(false);

        descList.add(1);
        assertEquals(1, descList.getAll().size());

        assertNull(descList.head.prev);
        assertEquals(1, descList.head.value);
        assertNull(descList.head.next);

        assertNull(descList.tail.prev);
        assertEquals(1, descList.tail.value);
        assertNull(descList.tail.next);

        descList.add(5);
        assertEquals(2, descList.getAll().size());

        assertNull(descList.head.prev);
        assertEquals(5, descList.head.value);
        assertEquals(1, descList.head.next.value);
        assertNull(descList.head.next.next);

        assertNull(descList.tail.next);
        assertEquals(1, descList.tail.value);
        assertEquals(5, descList.tail.prev.value);
        assertNull(descList.tail.prev.prev);

        descList.add(3);
        assertEquals(3, descList.getAll().size());

        assertNull(descList.head.prev);
        assertEquals(5, descList.head.value);
        assertEquals(3, descList.head.next.value);
        assertEquals(1, descList.head.next.next.value);
        assertNull(descList.head.next.next.next);

        assertNull(descList.tail.next);
        assertEquals(1, descList.tail.value);
        assertEquals(3, descList.tail.prev.value);
        assertEquals(5, descList.tail.prev.prev.value);
        assertNull(descList.tail.prev.prev.prev);

        descList.add(2);
        assertEquals(4, descList.getAll().size());

        assertNull(descList.head.prev);
        assertEquals(5, descList.head.value);
        assertEquals(3, descList.head.next.value);
        assertEquals(2, descList.head.next.next.value);
        assertEquals(1, descList.head.next.next.next.value);
        assertNull(descList.head.next.next.next.next);

        assertNull(descList.tail.next);
        assertEquals(1, descList.tail.value);
        assertEquals(2, descList.tail.prev.value);
        assertEquals(3, descList.tail.prev.prev.value);
        assertEquals(5, descList.tail.prev.prev.prev.value);
        assertNull(descList.tail.prev.prev.prev.prev);

        descList.add(4);
        assertEquals(5, descList.getAll().size());

        assertNull(descList.head.prev);
        assertEquals(5, descList.head.value);
        assertEquals(4, descList.head.next.value);
        assertEquals(3, descList.head.next.next.value);
        assertEquals(2, descList.head.next.next.next.value);
        assertEquals(1, descList.head.next.next.next.next.value);
        assertNull(descList.head.next.next.next.next.next);

        assertNull(descList.tail.next);
        assertEquals(1, descList.tail.value);
        assertEquals(2, descList.tail.prev.value);
        assertEquals(3, descList.tail.prev.prev.value);
        assertEquals(4, descList.tail.prev.prev.prev.value);
        assertEquals(5, descList.tail.prev.prev.prev.prev.value);
        assertNull(descList.tail.prev.prev.prev.prev.prev);

        descList.add(0);
        assertEquals(6, descList.getAll().size());

        assertNull(descList.head.prev);
        assertEquals(5, descList.head.value);
        assertEquals(4, descList.head.next.value);
        assertEquals(3, descList.head.next.next.value);
        assertEquals(2, descList.head.next.next.next.value);
        assertEquals(1, descList.head.next.next.next.next.value);
        assertEquals(0, descList.head.next.next.next.next.next.value);
        assertNull(descList.head.next.next.next.next.next.next);

        assertNull(descList.tail.next);
        assertEquals(0, descList.tail.value);
        assertEquals(1, descList.tail.prev.value);
        assertEquals(2, descList.tail.prev.prev.value);
        assertEquals(3, descList.tail.prev.prev.prev.value);
        assertEquals(4, descList.tail.prev.prev.prev.prev.value);
        assertEquals(5, descList.tail.prev.prev.prev.prev.prev.value);
        assertNull(descList.tail.prev.prev.prev.prev.prev.prev);

        descList.add(6);
        assertEquals(7, descList.getAll().size());

        assertNull(descList.head.prev);
        assertEquals(6, descList.head.value);
        assertEquals(5, descList.head.next.value);
        assertEquals(4, descList.head.next.next.value);
        assertEquals(3, descList.head.next.next.next.value);
        assertEquals(2, descList.head.next.next.next.next.value);
        assertEquals(1, descList.head.next.next.next.next.next.value);
        assertEquals(0, descList.head.next.next.next.next.next.next.value);
        assertNull(descList.head.next.next.next.next.next.next.next);

        assertNull(descList.tail.next);
        assertEquals(0, descList.tail.value);
        assertEquals(1, descList.tail.prev.value);
        assertEquals(2, descList.tail.prev.prev.value);
        assertEquals(3, descList.tail.prev.prev.prev.value);
        assertEquals(4, descList.tail.prev.prev.prev.prev.value);
        assertEquals(5, descList.tail.prev.prev.prev.prev.prev.value);
        assertEquals(6, descList.tail.prev.prev.prev.prev.prev.prev.value);
        assertNull(descList.tail.prev.prev.prev.prev.prev.prev.prev);

        descList.add(2);
        assertEquals(8, descList.getAll().size());

        assertNull(descList.head.prev);
        assertEquals(6, descList.head.value);
        assertEquals(5, descList.head.next.value);
        assertEquals(4, descList.head.next.next.value);
        assertEquals(3, descList.head.next.next.next.value);
        assertEquals(2, descList.head.next.next.next.next.value);
        assertEquals(2, descList.head.next.next.next.next.next.value);
        assertEquals(1, descList.head.next.next.next.next.next.next.value);
        assertEquals(0, descList.head.next.next.next.next.next.next.next.value);
        assertNull(descList.head.next.next.next.next.next.next.next.next);

        assertNull(descList.tail.next);
        assertEquals(0, descList.tail.value);
        assertEquals(1, descList.tail.prev.value);
        assertEquals(2, descList.tail.prev.prev.value);
        assertEquals(2, descList.tail.prev.prev.prev.value);
        assertEquals(3, descList.tail.prev.prev.prev.prev.value);
        assertEquals(4, descList.tail.prev.prev.prev.prev.prev.value);
        assertEquals(5, descList.tail.prev.prev.prev.prev.prev.prev.value);
        assertEquals(6, descList.tail.prev.prev.prev.prev.prev.prev.prev.value);
        assertNull(descList.tail.prev.prev.prev.prev.prev.prev.prev.prev);

        descList.add(0);
        assertEquals(9, descList.getAll().size());

        assertNull(descList.head.prev);
        assertEquals(6, descList.head.value);
        assertEquals(5, descList.head.next.value);
        assertEquals(4, descList.head.next.next.value);
        assertEquals(3, descList.head.next.next.next.value);
        assertEquals(2, descList.head.next.next.next.next.value);
        assertEquals(2, descList.head.next.next.next.next.next.value);
        assertEquals(1, descList.head.next.next.next.next.next.next.value);
        assertEquals(0, descList.head.next.next.next.next.next.next.next.value);
        assertEquals(0, descList.head.next.next.next.next.next.next.next.next.value);
        assertNull(descList.head.next.next.next.next.next.next.next.next.next);

        assertNull(descList.tail.next);
        assertEquals(0, descList.tail.value);
        assertEquals(0, descList.tail.prev.value);
        assertEquals(1, descList.tail.prev.prev.value);
        assertEquals(2, descList.tail.prev.prev.prev.value);
        assertEquals(2, descList.tail.prev.prev.prev.prev.value);
        assertEquals(3, descList.tail.prev.prev.prev.prev.prev.value);
        assertEquals(4, descList.tail.prev.prev.prev.prev.prev.prev.value);
        assertEquals(5, descList.tail.prev.prev.prev.prev.prev.prev.prev.value);
        assertEquals(6, descList.tail.prev.prev.prev.prev.prev.prev.prev.prev.value);
        assertNull(descList.tail.prev.prev.prev.prev.prev.prev.prev.prev.prev);
    }

    @Test
    void find() {
        OrderedList<Integer> ascList = new OrderedList<>(true);
        ascList.add(1);
        ascList.add(3);
        ascList.add(5);
        ascList.add(7);
        ascList.add(9);
        ascList.add(11);

        assertNull(ascList.find(0));
        assertNull(ascList.find(12));
        assertEquals(11, ascList.find(6).value);
        assertEquals(9, ascList.find(5).value);
        assertEquals(7, ascList.find(4).value);
        assertEquals(5, ascList.find(3).value);
        assertEquals(3, ascList.find(2).value);
        assertEquals(1, ascList.find(1).value);
        assertNull(ascList.find(8).value);
        assertNull(ascList.find(6).value);
        assertNull(ascList.find(4).value);
        assertNull(ascList.find(2).value);

        OrderedList<Integer> descList = new OrderedList<>(false);
        descList.add(1);
        descList.add(3);
        descList.add(5);
        descList.add(7);
        descList.add(9);
        descList.add(11);

        assertNull(descList.find(0));
        assertNull(descList.find(12));
        assertEquals(11, descList.find(6).value);
        assertEquals(9, descList.find(5).value);
        assertEquals(7, descList.find(4).value);
        assertEquals(5, descList.find(3).value);
        assertEquals(3, descList.find(2).value);
        assertEquals(1, descList.find(1).value);
        assertNull(descList.find(8).value);
        assertNull(descList.find(6).value);
        assertNull(descList.find(4).value);
        assertNull(descList.find(2).value);
    }

    @Test
    void deleteAsc() {
        OrderedList<Integer> ascList = new OrderedList<>(true);

        ascList.add(1);
        ascList.add(5);
        ascList.add(3);
        ascList.add(2);
        ascList.add(4);
        ascList.add(0);
        ascList.add(6);
        ascList.add(2);
        ascList.add(0);
        assertEquals(9, ascList.getAll().size());

        assertNull(ascList.head.prev);
        assertEquals(0, ascList.head.value);
        assertEquals(0, ascList.head.next.value);
        assertEquals(1, ascList.head.next.next.value);
        assertEquals(2, ascList.head.next.next.next.value);
        assertEquals(2, ascList.head.next.next.next.next.value);
        assertEquals(3, ascList.head.next.next.next.next.next.value);
        assertEquals(4, ascList.head.next.next.next.next.next.next.value);
        assertEquals(5, ascList.head.next.next.next.next.next.next.next.value);
        assertEquals(6, ascList.head.next.next.next.next.next.next.next.next.value);
        assertNull(ascList.head.next.next.next.next.next.next.next.next.next);

        assertNull(ascList.tail.next);
        assertEquals(6, ascList.tail.value);
        assertEquals(5, ascList.tail.prev.value);
        assertEquals(4, ascList.tail.prev.prev.value);
        assertEquals(3, ascList.tail.prev.prev.prev.value);
        assertEquals(2, ascList.tail.prev.prev.prev.prev.value);
        assertEquals(2, ascList.tail.prev.prev.prev.prev.prev.value);
        assertEquals(1, ascList.tail.prev.prev.prev.prev.prev.prev.value);
        assertEquals(0, ascList.tail.prev.prev.prev.prev.prev.prev.prev.value);
        assertEquals(0, ascList.tail.prev.prev.prev.prev.prev.prev.prev.prev.value);
        assertNull(ascList.tail.prev.prev.prev.prev.prev.prev.prev.prev.prev);

        ascList.delete(0);
        assertEquals(8, ascList.getAll().size());

        assertNull(ascList.head.prev);
        assertEquals(0, ascList.head.value);
        assertEquals(1, ascList.head.next.value);
        assertEquals(2, ascList.head.next.next.value);
        assertEquals(2, ascList.head.next.next.next.value);
        assertEquals(3, ascList.head.next.next.next.next.value);
        assertEquals(4, ascList.head.next.next.next.next.next.value);
        assertEquals(5, ascList.head.next.next.next.next.next.next.value);
        assertEquals(6, ascList.head.next.next.next.next.next.next.next.value);
        assertNull(ascList.head.next.next.next.next.next.next.next.next);

        assertNull(ascList.tail.next);
        assertEquals(6, ascList.tail.value);
        assertEquals(5, ascList.tail.prev.value);
        assertEquals(4, ascList.tail.prev.prev.value);
        assertEquals(3, ascList.tail.prev.prev.prev.value);
        assertEquals(2, ascList.tail.prev.prev.prev.prev.value);
        assertEquals(2, ascList.tail.prev.prev.prev.prev.prev.value);
        assertEquals(1, ascList.tail.prev.prev.prev.prev.prev.prev.value);
        assertEquals(0, ascList.tail.prev.prev.prev.prev.prev.prev.prev.value);
        assertNull(ascList.tail.prev.prev.prev.prev.prev.prev.prev.prev);

        ascList.delete(2);
        assertEquals(7, ascList.getAll().size());

        assertNull(ascList.head.prev);
        assertEquals(0, ascList.head.value);
        assertEquals(1, ascList.head.next.value);
        assertEquals(2, ascList.head.next.next.value);
        assertEquals(3, ascList.head.next.next.next.value);
        assertEquals(4, ascList.head.next.next.next.next.value);
        assertEquals(5, ascList.head.next.next.next.next.next.value);
        assertEquals(6, ascList.head.next.next.next.next.next.next.value);
        assertNull(ascList.head.next.next.next.next.next.next.next);

        assertNull(ascList.tail.next);
        assertEquals(6, ascList.tail.value);
        assertEquals(5, ascList.tail.prev.value);
        assertEquals(4, ascList.tail.prev.prev.value);
        assertEquals(3, ascList.tail.prev.prev.prev.value);
        assertEquals(2, ascList.tail.prev.prev.prev.prev.value);
        assertEquals(1, ascList.tail.prev.prev.prev.prev.prev.value);
        assertEquals(0, ascList.tail.prev.prev.prev.prev.prev.prev.value);
        assertNull(ascList.tail.prev.prev.prev.prev.prev.prev.prev);

        ascList.delete(3);
        assertEquals(6, ascList.getAll().size());

        assertNull(ascList.head.prev);
        assertEquals(0, ascList.head.value);
        assertEquals(1, ascList.head.next.value);
        assertEquals(2, ascList.head.next.next.value);
        assertEquals(4, ascList.head.next.next.next.value);
        assertEquals(5, ascList.head.next.next.next.next.value);
        assertEquals(6, ascList.head.next.next.next.next.next.value);
        assertNull(ascList.head.next.next.next.next.next.next);

        assertNull(ascList.tail.next);
        assertEquals(6, ascList.tail.value);
        assertEquals(5, ascList.tail.prev.value);
        assertEquals(4, ascList.tail.prev.prev.value);
        assertEquals(2, ascList.tail.prev.prev.prev.value);
        assertEquals(1, ascList.tail.prev.prev.prev.prev.value);
        assertEquals(0, ascList.tail.prev.prev.prev.prev.prev.value);
        assertNull(ascList.tail.prev.prev.prev.prev.prev.prev);

        ascList.delete(6);
        assertEquals(5, ascList.getAll().size());

        assertNull(ascList.head.prev);
        assertEquals(0, ascList.head.value);
        assertEquals(1, ascList.head.next.value);
        assertEquals(2, ascList.head.next.next.value);
        assertEquals(4, ascList.head.next.next.next.value);
        assertEquals(5, ascList.head.next.next.next.next.value);
        assertNull(ascList.head.next.next.next.next.next);

        assertNull(ascList.tail.next);
        assertEquals(5, ascList.tail.value);
        assertEquals(4, ascList.tail.prev.value);
        assertEquals(2, ascList.tail.prev.prev.value);
        assertEquals(1, ascList.tail.prev.prev.prev.value);
        assertEquals(0, ascList.tail.prev.prev.prev.prev.value);
        assertNull(ascList.tail.prev.prev.prev.prev.prev);

        ascList.delete(0);
        assertEquals(4, ascList.getAll().size());

        assertNull(ascList.head.prev);
        assertEquals(1, ascList.head.value);
        assertEquals(2, ascList.head.next.value);
        assertEquals(4, ascList.head.next.next.value);
        assertEquals(5, ascList.head.next.next.next.value);
        assertNull(ascList.head.next.next.next.next);

        assertNull(ascList.tail.next);
        assertEquals(5, ascList.tail.value);
        assertEquals(4, ascList.tail.prev.value);
        assertEquals(2, ascList.tail.prev.prev.value);
        assertEquals(1, ascList.tail.prev.prev.prev.value);
        assertNull(ascList.tail.prev.prev.prev.prev);

        ascList.delete(4);
        assertEquals(3, ascList.getAll().size());

        assertNull(ascList.head.prev);
        assertEquals(1, ascList.head.value);
        assertEquals(2, ascList.head.value);
        assertEquals(5, ascList.head.next.next.value);
        assertNull(ascList.head.next.next.next);

        assertNull(ascList.tail.next);
        assertEquals(5, ascList.tail.value);
        assertEquals(2, ascList.tail.prev.value);
        assertEquals(1, ascList.tail.prev.prev.value);
        assertNull(ascList.tail.prev.prev.prev);

        ascList.delete(2);
        assertEquals(2, ascList.getAll().size());

        assertNull(ascList.head.prev);
        assertEquals(1, ascList.head.value);
        assertEquals(5, ascList.head.next.value);
        assertNull(ascList.head.next.next);

        assertNull(ascList.tail.next);
        assertEquals(5, ascList.tail.value);
        assertEquals(1, ascList.tail.prev.value);
        assertNull(ascList.tail.prev.prev);

        ascList.delete(1);
        assertEquals(1, ascList.getAll().size());

        assertNull(ascList.head.prev);
        assertEquals(5, ascList.head.value);
        assertNull(ascList.head.next);

        assertNull(ascList.tail.next);
        assertEquals(5, ascList.tail.value);
        assertNull(ascList.tail.prev);

        ascList.delete(5);
        assertEquals(0, ascList.getAll().size());

        assertNull(ascList.head);
        assertNull(ascList.tail);
    }

    @Test
    void deleteDesc() {
        OrderedList<Integer> descList = new OrderedList<>(false);

        descList.add(1);
        descList.add(5);
        descList.add(3);
        descList.add(2);
        descList.add(4);
        descList.add(0);
        descList.add(6);
        descList.add(2);
        descList.add(0);
        assertEquals(9, descList.getAll().size());

        assertNull(descList.head.prev);
        assertEquals(6, descList.head.value);
        assertEquals(5, descList.head.next.value);
        assertEquals(4, descList.head.next.next.value);
        assertEquals(3, descList.head.next.next.next.value);
        assertEquals(2, descList.head.next.next.next.next.value);
        assertEquals(2, descList.head.next.next.next.next.next.value);
        assertEquals(1, descList.head.next.next.next.next.next.next.value);
        assertEquals(0, descList.head.next.next.next.next.next.next.next.value);
        assertEquals(0, descList.head.next.next.next.next.next.next.next.next.value);
        assertNull(descList.head.next.next.next.next.next.next.next.next.next);

        assertNull(descList.tail.next);
        assertEquals(0, descList.tail.value);
        assertEquals(0, descList.tail.prev.value);
        assertEquals(1, descList.tail.prev.prev.value);
        assertEquals(2, descList.tail.prev.prev.prev.value);
        assertEquals(2, descList.tail.prev.prev.prev.prev.value);
        assertEquals(3, descList.tail.prev.prev.prev.prev.prev.value);
        assertEquals(4, descList.tail.prev.prev.prev.prev.prev.prev.value);
        assertEquals(5, descList.tail.prev.prev.prev.prev.prev.prev.prev.value);
        assertEquals(6, descList.tail.prev.prev.prev.prev.prev.prev.prev.prev.value);
        assertNull(descList.tail.prev.prev.prev.prev.prev.prev.prev.prev.prev);

        descList.delete(0);
        assertEquals(8, descList.getAll().size());

        assertNull(descList.head.prev);
        assertEquals(6, descList.head.value);
        assertEquals(5, descList.head.next.value);
        assertEquals(4, descList.head.next.next.value);
        assertEquals(3, descList.head.next.next.next.value);
        assertEquals(2, descList.head.next.next.next.next.value);
        assertEquals(2, descList.head.next.next.next.next.next.value);
        assertEquals(1, descList.head.next.next.next.next.next.next.value);
        assertEquals(0, descList.head.next.next.next.next.next.next.next.value);
        assertNull(descList.head.next.next.next.next.next.next.next.next);

        assertNull(descList.tail.next);
        assertEquals(0, descList.tail.value);
        assertEquals(1, descList.tail.prev.value);
        assertEquals(2, descList.tail.prev.prev.value);
        assertEquals(2, descList.tail.prev.prev.prev.value);
        assertEquals(3, descList.tail.prev.prev.prev.prev.value);
        assertEquals(4, descList.tail.prev.prev.prev.prev.prev.value);
        assertEquals(5, descList.tail.prev.prev.prev.prev.prev.prev.value);
        assertEquals(6, descList.tail.prev.prev.prev.prev.prev.prev.prev.value);
        assertNull(descList.tail.prev.prev.prev.prev.prev.prev.prev.prev);

        descList.delete(2);
        assertEquals(7, descList.getAll().size());

        assertNull(descList.head.prev);
        assertEquals(6, descList.head.value);
        assertEquals(5, descList.head.next.value);
        assertEquals(4, descList.head.next.next.value);
        assertEquals(3, descList.head.next.next.next.value);
        assertEquals(2, descList.head.next.next.next.next.value);
        assertEquals(1, descList.head.next.next.next.next.next.value);
        assertEquals(0, descList.head.next.next.next.next.next.next.value);
        assertNull(descList.head.next.next.next.next.next.next.next);

        assertNull(descList.tail.next);
        assertEquals(0, descList.tail.value);
        assertEquals(1, descList.tail.prev.value);
        assertEquals(2, descList.tail.prev.prev.value);
        assertEquals(3, descList.tail.prev.prev.prev.value);
        assertEquals(4, descList.tail.prev.prev.prev.prev.value);
        assertEquals(5, descList.tail.prev.prev.prev.prev.prev.value);
        assertEquals(6, descList.tail.prev.prev.prev.prev.prev.prev.value);
        assertNull(descList.tail.prev.prev.prev.prev.prev.prev.prev);

        descList.delete(3);
        assertEquals(6, descList.getAll().size());

        assertNull(descList.head.prev);
        assertEquals(6, descList.head.value);
        assertEquals(5, descList.head.next.value);
        assertEquals(4, descList.head.next.next.value);
        assertEquals(2, descList.head.next.next.next.value);
        assertEquals(1, descList.head.next.next.next.next.value);
        assertEquals(0, descList.head.next.next.next.next.next.value);
        assertNull(descList.head.next.next.next.next.next.next);

        assertNull(descList.tail.next);
        assertEquals(0, descList.tail.value);
        assertEquals(1, descList.tail.prev.value);
        assertEquals(2, descList.tail.prev.prev.value);
        assertEquals(4, descList.tail.prev.prev.prev.value);
        assertEquals(5, descList.tail.prev.prev.prev.prev.value);
        assertEquals(6, descList.tail.prev.prev.prev.prev.prev.value);
        assertNull(descList.tail.prev.prev.prev.prev.prev.prev);

        descList.delete(6);
        assertEquals(5, descList.getAll().size());

        assertNull(descList.head.prev);
        assertEquals(5, descList.head.value);
        assertEquals(4, descList.head.next.value);
        assertEquals(2, descList.head.next.next.value);
        assertEquals(1, descList.head.next.next.next.value);
        assertEquals(0, descList.head.next.next.next.next.value);
        assertNull(descList.head.next.next.next.next.next);

        assertNull(descList.tail.next);
        assertEquals(0, descList.tail.value);
        assertEquals(1, descList.tail.prev.value);
        assertEquals(2, descList.tail.prev.prev.value);
        assertEquals(4, descList.tail.prev.prev.prev.value);
        assertEquals(5, descList.tail.prev.prev.prev.prev.value);
        assertNull(descList.tail.prev.prev.prev.prev.prev);

        descList.delete(0);
        assertEquals(4, descList.getAll().size());

        assertNull(descList.head.prev);
        assertEquals(5, descList.head.value);
        assertEquals(4, descList.head.next.value);
        assertEquals(2, descList.head.next.next.value);
        assertEquals(1, descList.head.next.next.next.value);
        assertNull(descList.head.next.next.next.next);

        assertNull(descList.tail.next);
        assertEquals(1, descList.tail.value);
        assertEquals(2, descList.tail.prev.value);
        assertEquals(4, descList.tail.prev.prev.value);
        assertEquals(5, descList.tail.prev.prev.prev.value);
        assertNull(descList.tail.prev.prev.prev.prev);

        descList.delete(4);
        assertEquals(3, descList.getAll().size());

        assertNull(descList.head.prev);
        assertEquals(5, descList.head.value);
        assertEquals(2, descList.head.value);
        assertEquals(1, descList.head.next.next.value);
        assertNull(descList.head.next.next.next);

        assertNull(descList.tail.next);
        assertEquals(1, descList.tail.value);
        assertEquals(2, descList.tail.prev.value);
        assertEquals(5, descList.tail.prev.prev.value);
        assertNull(descList.tail.prev.prev.prev);

        descList.delete(2);
        assertEquals(2, descList.getAll().size());

        assertNull(descList.head.prev);
        assertEquals(5, descList.head.value);
        assertEquals(1, descList.head.next.value);
        assertNull(descList.head.next.next);

        assertNull(descList.tail.next);
        assertEquals(1, descList.tail.value);
        assertEquals(5, descList.tail.prev.value);
        assertNull(descList.tail.prev.prev);

        descList.delete(1);
        assertEquals(1, descList.getAll().size());

        assertNull(descList.head.prev);
        assertEquals(5, descList.head.value);
        assertNull(descList.head.next);

        assertNull(descList.tail.next);
        assertEquals(5, descList.tail.value);
        assertNull(descList.tail.prev);

        descList.delete(5);
        assertEquals(0, descList.getAll().size());

        assertNull(descList.head);
        assertNull(descList.tail);
    }

    @Test
    void clear() {
        OrderedList<Integer> ascList = new OrderedList<>(true);
        assertEquals(0, ascList.count());
        assertNull(ascList.tail);
        assertNull(ascList.head);

        ascList.add(1);
        ascList.add(2);
        ascList.add(3);
        ascList.add(4);
        ascList.add(5);

        assertEquals(5, ascList.getAll().size());

        assertNull(ascList.head.prev);
        assertEquals(1, ascList.head.value);
        assertEquals(2, ascList.head.next.value);
        assertEquals(3, ascList.head.next.next.value);
        assertEquals(4, ascList.head.next.next.next.value);
        assertEquals(5, ascList.head.next.next.next.next.value);
        assertNull(ascList.head.next.next.next.next.next);

        assertNull(ascList.tail.next);
        assertEquals(5, ascList.tail.value);
        assertEquals(4, ascList.tail.prev.value);
        assertEquals(3, ascList.tail.prev.prev.value);
        assertEquals(2, ascList.tail.prev.prev.prev.value);
        assertEquals(1, ascList.tail.prev.prev.prev.prev.value);
        assertNull(ascList.tail.prev.prev.prev.prev.prev);
        

        ascList.clear(false);
        assertEquals(0, ascList.count());
        assertNull(ascList.tail);
        assertNull(ascList.head);

        ascList.add(1);
        ascList.add(2);
        ascList.add(3);
        ascList.add(4);
        ascList.add(5);

        assertEquals(5, ascList.getAll().size());

        assertNull(ascList.head.prev);
        assertEquals(5, ascList.head.value);
        assertEquals(4, ascList.head.next.value);
        assertEquals(3, ascList.head.next.next.value);
        assertEquals(2, ascList.head.next.next.next.value);
        assertEquals(1, ascList.head.next.next.next.next.value);
        assertNull(ascList.head.next.next.next.next.next);

        assertNull(ascList.tail.next);
        assertEquals(1, ascList.tail.value);
        assertEquals(2, ascList.tail.prev.value);
        assertEquals(3, ascList.tail.prev.prev.value);
        assertEquals(4, ascList.tail.prev.prev.prev.value);
        assertEquals(5, ascList.tail.prev.prev.prev.prev.value);
        assertNull(ascList.tail.prev.prev.prev.prev.prev);
    }

    @Test
    void count() {
        OrderedList<Integer> descList = new OrderedList<>(false);
        assertEquals(0, descList.count());
        descList.add(1);
        assertEquals(1, descList.count());
        descList.add(2);
        assertEquals(2, descList.count());
        descList.add(3);
        assertEquals(3, descList.count());
        descList.add(3);
        assertEquals(4, descList.count());
        descList.delete(3);
        assertEquals(3, descList.count());
        descList.delete(3);
        assertEquals(2, descList.count());
        descList.delete(2);
        assertEquals(1, descList.count());
        descList.delete(1);
        assertEquals(0, descList.count());
        descList.delete(3);
    }
}