package lesson_4;

import org.junit.jupiter.api.Test;

import static lesson_4.StackUtils.calculate;
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

    @Test
    void calculateTest() {
        Stack<String> expression = new Stack<>();
        expression.push("=");
        expression.push("+");
        expression.push("9");
        expression.push("*");
        expression.push("5");
        expression.push("+");
        expression.push("2");
        expression.push("8");
        assertEquals(59, calculate(expression));

        expression = new Stack<>();
        expression.push("=");
        expression.push("*");
        expression.push("2");
        expression.push("+");
        expression.push("1");
        expression.push("2");
        expression.push("+");
        expression.push("3");
        expression.push("4");
        expression.push("+");
        expression.push("5");
        assertEquals(30, calculate(expression));

    }
}