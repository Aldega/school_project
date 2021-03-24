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
        DynArray<Integer> array = new DynArray<>(Integer.class);
        //getItem for empty array
        for (int i = 0; i < 16; i++) {
            final int index = i;
            assertThrows(IndexOutOfBoundsException.class, () -> array.getItem(index));
        }
        assertThrows(IndexOutOfBoundsException.class, () -> array.getItem(-1));

        array.append(0);
        assertEquals(0, array.getItem(0));
        assertThrows(IndexOutOfBoundsException.class, () -> array.getItem(1));
        array.append(1);
        assertEquals(0, array.getItem(0));
        assertEquals(1, array.getItem(1));
        assertThrows(IndexOutOfBoundsException.class, () -> array.getItem(2));
    }

    @Test
    void append() {
        DynArray<Integer> array = new DynArray<>(Integer.class);
        assertEquals(16, array.capacity);
        assertEquals(0, array.count);
        assertEquals(16, array.array.length);
        for (int i = 0; i < 32; i++) {
            array.append(i);
            int capacity;
            if (i < 16) {
                capacity = 16;
            } else {
                capacity = 32;
            }
            assertEquals( i + 1, array.count);
            assertEquals( capacity, array.capacity);
            for (int j = 0; j <= i; j++) {
                assertEquals(j, array.getItem(j));
            }
            final int index = i;
            assertThrows(IndexOutOfBoundsException.class, () -> array.getItem(index + 1));
        }
    }

    @Test
    void insert() {
        DynArray<Integer> array = new DynArray<>(Integer.class);
        array.append(0);
        array.append(2);
        array.append(4);
        array.append(6);
        array.append(8);
        array.append(10);
        array.append(12);
        array.append(14);
        array.append(16);
        array.append(18);
        array.append(20);

        assertEquals(0, array.getItem(0));
        assertEquals(2, array.getItem(1));
        assertEquals(4, array.getItem(2));
        assertEquals(6, array.getItem(3));
        assertEquals(8, array.getItem(4));
        assertEquals(10, array.getItem(5));
        assertEquals(12, array.getItem(6));
        assertEquals(14, array.getItem(7));
        assertEquals(16, array.getItem(8));
        assertEquals(18, array.getItem(9));
        assertEquals(20, array.getItem(10));
        assertEquals(16, array.capacity);
        assertEquals(11, array.count);

        array.insert(-2, 0);
        assertEquals(-2, array.getItem(0));
        assertEquals(0, array.getItem(1));
        assertEquals(2, array.getItem(2));
        assertEquals(4, array.getItem(3));
        assertEquals(6, array.getItem(4));
        assertEquals(8, array.getItem(5));
        assertEquals(10, array.getItem(6));
        assertEquals(12, array.getItem(7));
        assertEquals(14, array.getItem(8));
        assertEquals(16, array.getItem(9));
        assertEquals(18, array.getItem(10));
        assertEquals(20, array.getItem(11));
        assertEquals(16, array.capacity);
        assertEquals(12, array.count);

        array.insert(5, 4);
        assertEquals(-2, array.getItem(0));
        assertEquals(0, array.getItem(1));
        assertEquals(2, array.getItem(2));
        assertEquals(4, array.getItem(3));
        assertEquals(5, array.getItem(4));
        assertEquals(6, array.getItem(5));
        assertEquals(8, array.getItem(6));
        assertEquals(10, array.getItem(7));
        assertEquals(12, array.getItem(8));
        assertEquals(14, array.getItem(9));
        assertEquals(16, array.getItem(10));
        assertEquals(18, array.getItem(11));
        assertEquals(20, array.getItem(12));
        assertEquals(16, array.capacity);
        assertEquals(13, array.count);

        array.insert(11, 8);
        assertEquals(-2, array.getItem(0));
        assertEquals(0, array.getItem(1));
        assertEquals(2, array.getItem(2));
        assertEquals(4, array.getItem(3));
        assertEquals(5, array.getItem(4));
        assertEquals(6, array.getItem(5));
        assertEquals(8, array.getItem(6));
        assertEquals(10, array.getItem(7));
        assertEquals(11, array.getItem(8));
        assertEquals(12, array.getItem(9));
        assertEquals(14, array.getItem(10));
        assertEquals(16, array.getItem(11));
        assertEquals(18, array.getItem(12));
        assertEquals(20, array.getItem(13));
        assertEquals(16, array.capacity);
        assertEquals(14, array.count);

        array.insert(19, 13);
        assertEquals(-2, array.getItem(0));
        assertEquals(0, array.getItem(1));
        assertEquals(2, array.getItem(2));
        assertEquals(4, array.getItem(3));
        assertEquals(5, array.getItem(4));
        assertEquals(6, array.getItem(5));
        assertEquals(8, array.getItem(6));
        assertEquals(10, array.getItem(7));
        assertEquals(11, array.getItem(8));
        assertEquals(12, array.getItem(9));
        assertEquals(14, array.getItem(10));
        assertEquals(16, array.getItem(11));
        assertEquals(18, array.getItem(12));
        assertEquals(19, array.getItem(13));
        assertEquals(20, array.getItem(14));
        assertEquals(16, array.capacity);
        assertEquals(15, array.count);

        array.insert(21, 15);
        assertEquals(-2, array.getItem(0));
        assertEquals(0, array.getItem(1));
        assertEquals(2, array.getItem(2));
        assertEquals(4, array.getItem(3));
        assertEquals(5, array.getItem(4));
        assertEquals(6, array.getItem(5));
        assertEquals(8, array.getItem(6));
        assertEquals(10, array.getItem(7));
        assertEquals(11, array.getItem(8));
        assertEquals(12, array.getItem(9));
        assertEquals(14, array.getItem(10));
        assertEquals(16, array.getItem(11));
        assertEquals(18, array.getItem(12));
        assertEquals(19, array.getItem(13));
        assertEquals(20, array.getItem(14));
        assertEquals(21, array.getItem(15));
        assertEquals(16, array.capacity);
        assertEquals(16, array.count);

        array.insert(17, 12);
        assertEquals(-2, array.getItem(0));
        assertEquals(0, array.getItem(1));
        assertEquals(2, array.getItem(2));
        assertEquals(4, array.getItem(3));
        assertEquals(5, array.getItem(4));
        assertEquals(6, array.getItem(5));
        assertEquals(8, array.getItem(6));
        assertEquals(10, array.getItem(7));
        assertEquals(11, array.getItem(8));
        assertEquals(12, array.getItem(9));
        assertEquals(14, array.getItem(10));
        assertEquals(16, array.getItem(11));
        assertEquals(17, array.getItem(12));
        assertEquals(18, array.getItem(13));
        assertEquals(19, array.getItem(14));
        assertEquals(20, array.getItem(15));
        assertEquals(21, array.getItem(16));
        assertEquals(32, array.capacity);
        assertEquals(17, array.count);

        assertThrows(IndexOutOfBoundsException.class, () -> array.insert(10, -2));
        assertThrows(IndexOutOfBoundsException.class, () -> array.insert(10, 30));
    }

    @Test
    void remove() {
        DynArray<Integer> array = new DynArray<>(Integer.class);
        for (int i = 0; i < 25; i++) {
            array.append(i);
        }
        for (int i = 0; i < 25; i++) {
            assertEquals(i, array.getItem(i));
        }
        assertEquals(25, array.count);
        assertEquals(32, array.capacity);


        array.remove(0);
        for (int i = 0; i < 25; i++) {
            if (i != 24) {
                assertEquals(i + 1, array.getItem(i));
            }
            if (i == 24) {
                assertThrows(IndexOutOfBoundsException.class, () -> array.getItem(24));
            }
        }
        assertEquals(24, array.count);
        assertEquals(32, array.capacity);

        array.remove(10);
        array.remove(10);
        array.remove(10);
        array.remove(10);
        array.remove(10);
        assertEquals(1, array.getItem(0));
        assertEquals(2, array.getItem(1));
        assertEquals(3, array.getItem(2));
        assertEquals(4, array.getItem(3));
        assertEquals(5, array.getItem(4));
        assertEquals(6, array.getItem(5));
        assertEquals(7, array.getItem(6));
        assertEquals(8, array.getItem(7));
        assertEquals(9, array.getItem(8));
        assertEquals(10, array.getItem(9));
        assertEquals(16, array.getItem(10));
        assertEquals(17, array.getItem(11));
        assertEquals(18, array.getItem(12));
        assertEquals(19, array.getItem(13));
        assertEquals(20, array.getItem(14));
        assertEquals(21, array.getItem(15));
        assertEquals(22, array.getItem(16));
        assertEquals(23, array.getItem(17));
        assertEquals(24, array.getItem(18));
        assertThrows(IndexOutOfBoundsException.class, () -> array.getItem(19));
        assertEquals(19, array.count);
        assertEquals(32, array.capacity);

        array.remove(17);
        assertEquals(1, array.getItem(0));
        assertEquals(2, array.getItem(1));
        assertEquals(3, array.getItem(2));
        assertEquals(4, array.getItem(3));
        assertEquals(5, array.getItem(4));
        assertEquals(6, array.getItem(5));
        assertEquals(7, array.getItem(6));
        assertEquals(8, array.getItem(7));
        assertEquals(9, array.getItem(8));
        assertEquals(10, array.getItem(9));
        assertEquals(16, array.getItem(10));
        assertEquals(17, array.getItem(11));
        assertEquals(18, array.getItem(12));
        assertEquals(19, array.getItem(13));
        assertEquals(20, array.getItem(14));
        assertEquals(21, array.getItem(15));
        assertEquals(22, array.getItem(16));
        assertEquals(24, array.getItem(17));
        assertThrows(IndexOutOfBoundsException.class, () -> array.getItem(18));
        assertEquals(18, array.count);
        assertEquals(32, array.capacity);

        array.remove(17);
        assertEquals(1, array.getItem(0));
        assertEquals(2, array.getItem(1));
        assertEquals(3, array.getItem(2));
        assertEquals(4, array.getItem(3));
        assertEquals(5, array.getItem(4));
        assertEquals(6, array.getItem(5));
        assertEquals(7, array.getItem(6));
        assertEquals(8, array.getItem(7));
        assertEquals(9, array.getItem(8));
        assertEquals(10, array.getItem(9));
        assertEquals(16, array.getItem(10));
        assertEquals(17, array.getItem(11));
        assertEquals(18, array.getItem(12));
        assertEquals(19, array.getItem(13));
        assertEquals(20, array.getItem(14));
        assertEquals(21, array.getItem(15));
        assertEquals(22, array.getItem(16));
        assertThrows(IndexOutOfBoundsException.class, () -> array.getItem(17));
        assertEquals(17, array.count);
        assertEquals(32, array.capacity);

        array.remove(16);
        assertEquals(1, array.getItem(0));
        assertEquals(2, array.getItem(1));
        assertEquals(3, array.getItem(2));
        assertEquals(4, array.getItem(3));
        assertEquals(5, array.getItem(4));
        assertEquals(6, array.getItem(5));
        assertEquals(7, array.getItem(6));
        assertEquals(8, array.getItem(7));
        assertEquals(9, array.getItem(8));
        assertEquals(10, array.getItem(9));
        assertEquals(16, array.getItem(10));
        assertEquals(17, array.getItem(11));
        assertEquals(18, array.getItem(12));
        assertEquals(19, array.getItem(13));
        assertEquals(20, array.getItem(14));
        assertEquals(21, array.getItem(15));
        assertThrows(IndexOutOfBoundsException.class, () -> array.getItem(16));
        assertEquals(16, array.count);
        assertEquals(32, array.capacity);

        array.remove(15);
        assertEquals(1, array.getItem(0));
        assertEquals(2, array.getItem(1));
        assertEquals(3, array.getItem(2));
        assertEquals(4, array.getItem(3));
        assertEquals(5, array.getItem(4));
        assertEquals(6, array.getItem(5));
        assertEquals(7, array.getItem(6));
        assertEquals(8, array.getItem(7));
        assertEquals(9, array.getItem(8));
        assertEquals(10, array.getItem(9));
        assertEquals(16, array.getItem(10));
        assertEquals(17, array.getItem(11));
        assertEquals(18, array.getItem(12));
        assertEquals(19, array.getItem(13));
        assertEquals(20, array.getItem(14));
        assertThrows(IndexOutOfBoundsException.class, () -> array.getItem(15));
        assertEquals(15, array.count);
        assertEquals(21, array.capacity);

        array.remove(14);
        assertEquals(1, array.getItem(0));
        assertEquals(2, array.getItem(1));
        assertEquals(3, array.getItem(2));
        assertEquals(4, array.getItem(3));
        assertEquals(5, array.getItem(4));
        assertEquals(6, array.getItem(5));
        assertEquals(7, array.getItem(6));
        assertEquals(8, array.getItem(7));
        assertEquals(9, array.getItem(8));
        assertEquals(10, array.getItem(9));
        assertEquals(16, array.getItem(10));
        assertEquals(17, array.getItem(11));
        assertEquals(18, array.getItem(12));
        assertEquals(19, array.getItem(13));
        assertThrows(IndexOutOfBoundsException.class, () -> array.getItem(14));
        assertEquals(14, array.count);
        assertEquals(21, array.capacity);

        array.remove(13);
        assertEquals(1, array.getItem(0));
        assertEquals(2, array.getItem(1));
        assertEquals(3, array.getItem(2));
        assertEquals(4, array.getItem(3));
        assertEquals(5, array.getItem(4));
        assertEquals(6, array.getItem(5));
        assertEquals(7, array.getItem(6));
        assertEquals(8, array.getItem(7));
        assertEquals(9, array.getItem(8));
        assertEquals(10, array.getItem(9));
        assertEquals(16, array.getItem(10));
        assertEquals(17, array.getItem(11));
        assertEquals(18, array.getItem(12));
        assertThrows(IndexOutOfBoundsException.class, () -> array.getItem(13));
        assertEquals(13, array.count);
        assertEquals(21, array.capacity);

        array.remove(12);
        assertEquals(1, array.getItem(0));
        assertEquals(2, array.getItem(1));
        assertEquals(3, array.getItem(2));
        assertEquals(4, array.getItem(3));
        assertEquals(5, array.getItem(4));
        assertEquals(6, array.getItem(5));
        assertEquals(7, array.getItem(6));
        assertEquals(8, array.getItem(7));
        assertEquals(9, array.getItem(8));
        assertEquals(10, array.getItem(9));
        assertEquals(16, array.getItem(10));
        assertEquals(17, array.getItem(11));
        assertThrows(IndexOutOfBoundsException.class, () -> array.getItem(12));
        assertEquals(12, array.count);
        assertEquals(21, array.capacity);

        array.remove(11);
        assertEquals(1, array.getItem(0));
        assertEquals(2, array.getItem(1));
        assertEquals(3, array.getItem(2));
        assertEquals(4, array.getItem(3));
        assertEquals(5, array.getItem(4));
        assertEquals(6, array.getItem(5));
        assertEquals(7, array.getItem(6));
        assertEquals(8, array.getItem(7));
        assertEquals(9, array.getItem(8));
        assertEquals(10, array.getItem(9));
        assertEquals(16, array.getItem(10));
        assertThrows(IndexOutOfBoundsException.class, () -> array.getItem(11));
        assertEquals(11, array.count);
        assertEquals(21, array.capacity);

        array.remove(10);
        assertEquals(1, array.getItem(0));
        assertEquals(2, array.getItem(1));
        assertEquals(3, array.getItem(2));
        assertEquals(4, array.getItem(3));
        assertEquals(5, array.getItem(4));
        assertEquals(6, array.getItem(5));
        assertEquals(7, array.getItem(6));
        assertEquals(8, array.getItem(7));
        assertEquals(9, array.getItem(8));
        assertEquals(10, array.getItem(9));
        assertThrows(IndexOutOfBoundsException.class, () -> array.getItem(10));
        assertEquals(10, array.count);
        assertEquals(16, array.capacity);

        assertThrows(IndexOutOfBoundsException.class, () -> array.remove(-2));
        assertThrows(IndexOutOfBoundsException.class, () -> array.remove(10));


    }
}