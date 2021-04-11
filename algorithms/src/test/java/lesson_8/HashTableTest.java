package lesson_8;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HashTableTest {

    @Test
    void hashFun() {
        int size = 17;
        HashTable hashTable = new HashTable(size, 3);
        int a = hashTable.hashFun("a");
        assertEquals((a + 0) % size,  hashTable.hashFun("a"));
        assertEquals((a + 1) % size,  hashTable.hashFun("b"));
        assertEquals((a + 2) % size,  hashTable.hashFun("c"));
        assertEquals((a + 3) % size,  hashTable.hashFun("d"));
        assertEquals((a + 4) % size,  hashTable.hashFun("e"));
        assertEquals((a + 5) % size,  hashTable.hashFun("f"));
        assertEquals((a + 6) % size,  hashTable.hashFun("g"));
        assertEquals((a + 7) % size,  hashTable.hashFun("h"));
        assertEquals((a + 8) % size,  hashTable.hashFun("i"));
        assertEquals((a + 9) % size,  hashTable.hashFun("j"));
        assertEquals((a + 10) % size, hashTable.hashFun("k"));
        assertEquals((a + 11) % size, hashTable.hashFun("l"));
        assertEquals((a + 12) % size, hashTable.hashFun("m"));
        assertEquals((a + 13) % size, hashTable.hashFun("n"));
        assertEquals((a + 14) % size, hashTable.hashFun("o"));
        assertEquals((a + 15) % size, hashTable.hashFun("p"));
        assertEquals((a + 16) % size, hashTable.hashFun("q"));
        assertEquals((a + 17) % size, hashTable.hashFun("r"));
        assertEquals((a + 18) % size, hashTable.hashFun("s"));
        assertEquals((a + 19) % size, hashTable.hashFun("t"));
        assertEquals((a + 20) % size, hashTable.hashFun("u"));
        assertEquals((a + 21) % size, hashTable.hashFun("v"));
        assertEquals((a + 22) % size, hashTable.hashFun("w"));
    }

    @Test
    void seekSlot() {
        int size = 17;
        int step = 3;
        HashTable hashTable = new HashTable(size, step);
        String valueA = "a";
        int a = hashTable.hashFun(valueA);
        assertEquals((a + (0 * step)) % size, hashTable.seekSlot(valueA));
        hashTable.slots[(a + (0 * step)) % size] = valueA;
        assertEquals((a + (1 * step)) % size, hashTable.seekSlot(valueA));
        hashTable.slots[(a + (1 * step)) % size] = valueA;
        assertEquals((a + (2 * step)) % size, hashTable.seekSlot(valueA));
        hashTable.slots[(a + (2 * step)) % size] = valueA;
        assertEquals((a + (3 * step)) % size, hashTable.seekSlot(valueA));
        hashTable.slots[(a + (3 * step)) % size] = valueA;
        assertEquals((a + (4 * step)) % size, hashTable.seekSlot(valueA));
        hashTable.slots[(a + (4 * step)) % size] = valueA;
        assertEquals((a + (5 * step)) % size, hashTable.seekSlot(valueA));
        hashTable.slots[(a + (5 * step)) % size] = valueA;
        assertEquals(-1, hashTable.seekSlot(valueA));
    }

    @Test
    void put() {
        int size = 17;
        int step = 3;
        HashTable hashTable = new HashTable(size, step);
        String valueA = "a";
        int a = hashTable.hashFun(valueA);
        assertEquals((a + (0 * step)) % size, hashTable.seekSlot(valueA));
        assertEquals((a + (0 * step)) % size, hashTable.put(valueA));
        assertEquals(valueA, hashTable.slots[(a + (0 * step)) % size]);

        assertEquals((a + (1 * step)) % size, hashTable.seekSlot(valueA));
        assertEquals((a + (1 * step)) % size, hashTable.put(valueA));
        assertEquals(valueA, hashTable.slots[(a + (1 * step)) % size]);

        assertEquals((a + (2 * step)) % size, hashTable.seekSlot(valueA));
        assertEquals((a + (2 * step)) % size, hashTable.put(valueA));
        assertEquals(valueA, hashTable.slots[(a + (2 * step)) % size]);

        assertEquals((a + (3 * step)) % size, hashTable.seekSlot(valueA));
        assertEquals((a + (3 * step)) % size, hashTable.put(valueA));
        assertEquals(valueA, hashTable.slots[(a + (3 * step)) % size]);

        assertEquals((a + (4 * step)) % size, hashTable.seekSlot(valueA));
        assertEquals((a + (4 * step)) % size, hashTable.put(valueA));
        assertEquals(valueA, hashTable.slots[(a + (4 * step)) % size]);

        assertEquals((a + (5 * step)) % size, hashTable.seekSlot(valueA));
        assertEquals((a + (5 * step)) % size, hashTable.put(valueA));
        assertEquals(valueA, hashTable.slots[(a + (5 * step)) % size]);

        assertEquals(-1, hashTable.seekSlot(valueA));
        assertEquals(-1, hashTable.put(valueA));
    }

    @Test
    void find() {
        int size = 17;
        HashTable hashTable = new HashTable(size, 3);
        hashTable.slots[12] = "a";
        hashTable.slots[13] = "b";
        hashTable.slots[14] = "c";
        hashTable.slots[15] = "d";
        hashTable.slots[16] = "e";
        hashTable.slots[0] = "f";
        hashTable.slots[1] = "g";
        hashTable.slots[2] = "h";
        hashTable.slots[3] = "i";
        hashTable.slots[4] = "j";
        hashTable.slots[5] = "k";
        hashTable.slots[6] = "l";
        hashTable.slots[7] = "m";
        hashTable.slots[8] = "n";
        hashTable.slots[9] = "o";
        hashTable.slots[10] = "p";
        hashTable.slots[11] = "q";

        assertEquals(12, hashTable.find( "a"));
        assertEquals(13, hashTable.find( "b"));
        assertEquals(14, hashTable.find( "c"));
        assertEquals(15, hashTable.find( "d"));
        assertEquals(16, hashTable.find( "e"));
        assertEquals(0, hashTable.find( "f"));
        assertEquals(1, hashTable.find( "g"));
        assertEquals(2, hashTable.find( "h"));
        assertEquals(3, hashTable.find( "i"));
        assertEquals(4, hashTable.find( "j"));
        assertEquals(5, hashTable.find( "k"));
        assertEquals(6, hashTable.find( "l"));
        assertEquals(7, hashTable.find( "m"));
        assertEquals(8, hashTable.find( "n"));
        assertEquals(9, hashTable.find( "o"));
        assertEquals(10, hashTable.find( "p"));
        assertEquals(11, hashTable.find( "q"));
        assertEquals(-1, hashTable.find( "qq"));
        assertEquals(-1, hashTable.find( "q1"));
        assertEquals(-1, hashTable.find( "q2"));

    }
}