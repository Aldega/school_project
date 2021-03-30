package lesson_6;

import java.util.Objects;

public class DequeUtils {
    public static boolean isPalindrom(String str) {

        if (str.equals("")) return false;

        Deque<Character> deque = new Deque<>();
        for (char ch : str.replaceAll("\\s","").toLowerCase().toCharArray()) {
            deque.addFront(ch);
        }

        while (deque.size() > 0) {
            if (deque.size() == 1) return true;
            if (!Objects.equals(deque.removeFront(), deque.removeTail())) return false;
        }
        return true;
    }

}
