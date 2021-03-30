package lesson_6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DequeUtilsTest {

    @Test
    void isPalindrom() {
        assertTrue(DequeUtils.isPalindrom("А муза рада музе без ума да разума"));
        assertTrue(DequeUtils.isPalindrom("А раки ели в иле Икара"));
        assertTrue(DequeUtils.isPalindrom("Арбуз влетел в зубра"));
        assertTrue(DequeUtils.isPalindrom("Аргентина манит негра"));
        assertTrue(DequeUtils.isPalindrom("Аргентинец ценит негра"));
        assertTrue(DequeUtils.isPalindrom("Аа Бб Вв Гг Гг Вв Бб Аа")); //пример чётного
        assertTrue(DequeUtils.isPalindrom("e"));
        assertFalse(DequeUtils.isPalindrom("перевертышами"));
        assertFalse(DequeUtils.isPalindrom(""));
        assertFalse(DequeUtils.isPalindrom("Переводе с Финского Означает"));
    }

}