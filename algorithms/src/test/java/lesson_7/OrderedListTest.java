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