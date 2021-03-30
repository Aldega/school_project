package lesson_5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueueUtilsTest {

    @Test
    void roundNElementsInQueue() {
        Queue<Integer> queue = new Queue<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);

        //case round 3 elements
        QueueUtils.roundNElementsInQueue(3, queue);
        assertEquals(4, queue.queue.get(0));
        assertEquals(5, queue.queue.get(1));
        assertEquals(1, queue.queue.get(2));
        assertEquals(2, queue.queue.get(3));
        assertEquals(3, queue.queue.get(4));

        //case round 0 elements (nothing happen)
        QueueUtils.roundNElementsInQueue(0, queue);
        assertEquals(4, queue.queue.get(0));
        assertEquals(5, queue.queue.get(1));
        assertEquals(1, queue.queue.get(2));
        assertEquals(2, queue.queue.get(3));
        assertEquals(3, queue.queue.get(4));

        //case round minus 3 elements (nothing happen)
        QueueUtils.roundNElementsInQueue(-3, queue);
        assertEquals(4, queue.queue.get(0));
        assertEquals(5, queue.queue.get(1));
        assertEquals(1, queue.queue.get(2));
        assertEquals(2, queue.queue.get(3));
        assertEquals(3, queue.queue.get(4));

        //case round elements more then elements in queue (nothing happen)
        QueueUtils.roundNElementsInQueue(100, queue);
        assertEquals(4, queue.queue.get(0));
        assertEquals(5, queue.queue.get(1));
        assertEquals(1, queue.queue.get(2));
        assertEquals(2, queue.queue.get(3));
        assertEquals(3, queue.queue.get(4));
    }

}