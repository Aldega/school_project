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
    void add() {
    }

    @Test
    void find() {
    }

    @Test
    void delete() {
    }

    @Test
    void clear() {
    }

    @Test
    void count() {
    }
}