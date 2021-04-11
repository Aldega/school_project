package lesson_8;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HashTableTest {

    @Test
    void hashFun() {
        int size = 17;
        HashTable hashTable = new HashTable(size, 3);
        int a = hashTable.hashFun("a");
        assertEquals((a + 0) % size, hashTable.hashFun("a"));
        assertEquals((a + 1) % size, hashTable.hashFun("b"));
        assertEquals((a + 2) % size, hashTable.hashFun("c"));
        assertEquals((a + 3) % size, hashTable.hashFun("d"));
        assertEquals((a + 4) % size, hashTable.hashFun("e"));
        assertEquals((a + 5) % size, hashTable.hashFun("f"));
        assertEquals((a + 6) % size, hashTable.hashFun("g"));
        assertEquals((a + 7) % size, hashTable.hashFun("h"));
        assertEquals((a + 8) % size, hashTable.hashFun("i"));
        assertEquals((a + 9) % size, hashTable.hashFun("j"));
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
    }

    @Test
    void put() {
    }

    @Test
    void find() {
    }
}