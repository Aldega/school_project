package lesson_4;

import org.junit.jupiter.api.Test;

import static lesson_4.StackUtils.isBalanced;
import static org.junit.jupiter.api.Assertions.*;

class StackUtilsTest {

    @Test
    void isBalancedTest() {
        assertTrue(isBalanced(""));
        assertTrue(isBalanced("()"));
        assertTrue(isBalanced("()()"));
        assertTrue(isBalanced("(()())"));
        assertTrue(isBalanced("(())()"));
        assertTrue(isBalanced("(())(())"));

        assertFalse(isBalanced("("));
        assertFalse(isBalanced(")"));
        assertFalse(isBalanced(")))"));
        assertFalse(isBalanced("((("));
        assertFalse(isBalanced(")("));
        assertFalse(isBalanced("))(("));
        assertFalse(isBalanced("())()()))"));
        assertFalse(isBalanced("())("));
        assertFalse(isBalanced("))(("));
        assertFalse(isBalanced("((())"));
        assertFalse(isBalanced(")(())(()))(()"));
    }
}