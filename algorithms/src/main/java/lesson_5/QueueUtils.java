package lesson_5;

public class QueueUtils {

    public static void roundNElementsInQueue(int n, Queue queue) {
        if (n < 1 || n >= queue.size()) return;

        for (int i = 0; i < n; i++) {
            queue.enqueue(queue.dequeue());
        }
    }

}