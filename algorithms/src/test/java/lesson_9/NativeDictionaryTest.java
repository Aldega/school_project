package lesson_9;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NativeDictionaryTest {

    @Test
    void hashFun() {
    }

    @Test
    void isKey() {
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

        assertTrue(dictionary.isKey("c"));
        assertFalse(dictionary.isKey("r"));
    }

    @Test
    void put() {
        NativeDictionary<String> dictionary = new NativeDictionary<>(17, String.class);
        dictionary.put("a", "aValue");
        dictionary.put("b", "bValue");
        assertEquals("aValue", dictionary.get("a"));
        assertEquals("bValue", dictionary.get("b"));
        dictionary.put("a", "aNewValue");
        assertEquals("aNewValue", dictionary.get("a"));
        assertEquals("bValue", dictionary.get("b"));
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
}