package lesson_9;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class NativeDictionaryTest {

    @Test
    void hashFun() {
        int size = 17;
        NativeDictionary<String> dictionary = new NativeDictionary<>(size, String.class);
        final int i = "a".hashCode() % size;

        assertEquals((i + 0) % size, dictionary.hashFun("a"));
        assertEquals((i + 1) % size, dictionary.hashFun("b"));
        assertEquals((i + 2) % size, dictionary.hashFun("c"));
        assertEquals((i + 3) % size, dictionary.hashFun("d"));
        assertEquals((i + 4) % size, dictionary.hashFun("e"));
        assertEquals((i + 5) % size, dictionary.hashFun("f"));
        assertEquals((i + 6) % size, dictionary.hashFun("g"));
        assertEquals((i + 7) % size, dictionary.hashFun("h"));
        assertEquals((i + 8) % size, dictionary.hashFun("i"));
        assertEquals((i + 9) % size, dictionary.hashFun("j"));
        assertEquals((i + 10) % size, dictionary.hashFun("k"));
        assertEquals((i + 11) % size, dictionary.hashFun("l"));
        assertEquals((i + 12) % size, dictionary.hashFun("m"));
        assertEquals((i + 13) % size, dictionary.hashFun("n"));
        assertEquals((i + 14) % size, dictionary.hashFun("o"));
        assertEquals((i + 15) % size, dictionary.hashFun("p"));
        assertEquals((i + 16) % size, dictionary.hashFun("q"));

        assertEquals((i + 17) % size, dictionary.hashFun("r"));
    }

    @Test
    void isKey() {
        NativeDictionary<String> dictionary = new NativeDictionary<>(97, String.class);
        for (int i = 0; i < 100; i++) {
            dictionary.put("A", UUID.randomUUID().toString());
        }

        assertFalse(dictionary.isKey("B"));
        assertTrue(dictionary.isKey("A"));
        assertFalse(dictionary.isKey("rc"));
    }

    @Test
    void put() {
        int size = 17;
        NativeDictionary<String> dictionary = new NativeDictionary<>(size, String.class);
        assertDoesNotThrow(() -> dictionary.put(null, null));

        //если по данному индексу пусто, добавляем ключ и значение в него.
        dictionary.put("a", "aValue");
        assertEquals("aValue", dictionary.values["a".hashCode() % size]);

        //перезаписываю значение
        int index = "a".hashCode() % size;
        int countStep = 1;
        dictionary.put("a", "a");
        assertEquals("a", dictionary.values["a".hashCode() % size]);

        //наполняю коллизиями
        Map<Integer, String> map = new HashMap<>();
        map.put(12, "a");

        while (countStep < 17) {
            System.out.println(countStep);
            map.forEach((key, value) -> {
                System.out.println("index " + key + ", value " +  value);
                assertEquals(value, dictionary.values[key]);
                assertEquals(value, dictionary.get(value));
                assertTrue(dictionary.isKey(value));
            });
            String collision = findValuesForCollision("a", 17);
            assertNull(dictionary.get(collision));
            assertFalse(dictionary.isKey(collision));
            index = index + 3;
            countStep = countStep + 1;
            map.put(index % 17, collision);
            dictionary.put(collision, collision);
            assertEquals(collision, dictionary.get(collision));
            assertTrue(dictionary.isKey(collision));
        }

        //добавляю в переполненный массив
        String notAddedElement = findValuesForCollision("a", 17);
        dictionary.put(notAddedElement, notAddedElement);
        map.forEach((key, value) -> {
            System.out.println("index " + key + ", value " +  value);
            assertEquals(value, dictionary.values[key]);

        });
        assertNull(dictionary.get(notAddedElement));
        assertFalse(dictionary.isKey(notAddedElement));
    }

    @Test
    void get() {
        NativeDictionary<String> dictionary = new NativeDictionary<>(17, String.class);
        dictionary.put("a", "aValue");
        dictionary.put("b", "bValue");
        dictionary.put("c", "cValue");
        dictionary.put("d", "dValue");
        dictionary.put("e", "eValue");
        dictionary.put("f", "fValue");
        dictionary.put("g", "gValue");
        dictionary.put("h", "hValue");
        dictionary.put("i", "iValue");
        dictionary.put("j", "jValue");
        dictionary.put("k", "kValue");
        dictionary.put("l", "lValue");
        dictionary.put("m", "mValue");
        dictionary.put("n", "nValue");
        dictionary.put("o", "oValue");
        dictionary.put("p", "pValue");
        dictionary.put("q", "qValue");

        assertEquals("aValue", dictionary.get("a"));
        assertNull(dictionary.get("r"));
        assertNull(dictionary.get("rc"));
    }

    @Test
    void getNotWorking() {
        NativeDictionary<String> dictionary = new NativeDictionary<>(97, String.class);
        for (int i = 0; i < 100; i++) {
            String value = UUID.randomUUID().toString();
            dictionary.put("A", value);
            assertEquals(value, dictionary.get("A"));
        }

        assertNull(dictionary.get("B"));
        assertFalse(dictionary.isKey("B"));
        assertNotNull(dictionary.get("A"));
    }

    public String findValuesForCollision(String key, int size) {
        int index = key.hashCode() % size;

        String uuid = UUID.randomUUID().toString();
        while (index != uuid.hashCode() % size) {
            uuid = UUID.randomUUID().toString();
        }
        return uuid;
    }

    @Test
    void test() {
        NativeDictionary<Integer> nd = new NativeDictionary<Integer>(97, Integer.class);

        nd.put("0123456789", 123456789);

        nd.isKey("1234567890"); // ArrayIndexOutOfBoundsException
    }
}