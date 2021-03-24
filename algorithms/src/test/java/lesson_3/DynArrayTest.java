package lesson_3;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;

import static org.junit.jupiter.api.Assertions.*;

class DynArrayTest {

    @Test
    void makeArray() {
        //new array case
        DynArray<Integer> array = new DynArray<>(Integer.class);
        assertEquals(16, array.capacity);
        assertEquals(0, array.count);
        assertEquals(16, array.array.length);
        assertArrayEquals((Integer[]) Array.newInstance(Integer.class, 16), array.array);

        array.makeArray(20);
        assertEquals(20, array.capacity);
        assertEquals(0, array.count);
        assertEquals(20, array.array.length);
    }

    @Test
    void getItem() {
    }

    @Test
    void append() {
    }

    @Test
    void insert() {
    }

    @Test
    void remove() {
    }
}