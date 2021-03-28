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

    public static Integer calculate(Stack<String> expression) {
        Stack<Integer> result = new Stack<>();
        while (expression.peek() != null) {
            String value = expression.pop();
            if (value.matches("\\d+")) { //if value is int number
                 result.push(Integer.parseInt(value));
            }
            if (value.matches("[*]")) { //if value is multiply
                Integer calcRes = result.pop();
                while(result.size() > 0) {
                    calcRes *= result.pop();
                }
                result.push(calcRes);
            }
            if (value.matches("[+]")) { //if value is sum
                Integer calcRes = result.pop();
                while(result.size() > 0) {
                    calcRes += result.pop();
                }
                result.push(calcRes);
            }
            if (value.matches("[=]")) { //if value is equal
                return result.pop();
            }
        }
        return result.pop();
    }

}
