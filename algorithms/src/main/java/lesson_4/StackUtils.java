package lesson_4;

public class StackUtils {

    public static boolean isBalanced(String input) {

        Stack<Integer> stack = new Stack<>();
        for (char ch : input.toCharArray()){
            switch (ch) {
                case '(' :
                    stack.push(1);
                    break;
                case ')' : {
                    if (stack.peek() == null) {
                        return false;
                    }
                    stack.pop();
                }
            }
        }
        return stack.peek() == null;
    }
}
