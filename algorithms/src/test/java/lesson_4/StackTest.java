package lesson_4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackTest {

    @Test
    void size() {
        Stack<Integer> stack = new Stack<>();
        assertEquals(0, stack.size());
        stack.push(1);
        assertEquals(1, stack.size());
        stack.push(2);
        assertEquals(2, stack.size());
        stack.push(3);
        assertEquals(3, stack.size());
        stack.pop();
        assertEquals(2, stack.size());
        stack.pop();
        assertEquals(1, stack.size());
        stack.pop();
        assertEquals(0, stack.size());
    }

    @Test
    void pop() {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        assertEquals(4, stack.stack.peek());
        assertEquals(4, stack.pop());
        assertEquals(3, stack.stack.peek());
        assertEquals(3, stack.pop());
        assertEquals(2, stack.stack.peek());
        assertEquals(2, stack.pop());
        assertEquals(1, stack.stack.peek());
        assertEquals(1, stack.pop());
        assertNull(stack.stack.peek());
        assertNull(stack.pop());
    }

    @Test
    void push() {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        assertEquals(1, stack.stack.get(3));
        assertEquals(2, stack.stack.get(2));
        assertEquals(3, stack.stack.get(1));
        assertEquals(4, stack.stack.get(0));
    }

    @Test
    void peek() {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        assertEquals(4, stack.peek());
        stack.stack.poll();
        assertEquals(3, stack.peek());
        stack.stack.poll();
        assertEquals(2, stack.peek());
        stack.stack.poll();
        assertEquals(1, stack.peek());
        stack.stack.poll();
        assertNull(stack.peek());
    }
}