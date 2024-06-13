import java.util.Stack;

public class BasicCalculator {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        int result = 0;
        int sign = 1;
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            } else if (c == '+') {
                result += sign * num;
                num = 0;
                sign = 1;
            } else if (c == '-') {
                result += sign * num;
                num = 0;
                sign = -1;
            } else if (c == '(') {
                stack.push(result);
                stack.push(sign);
                result = 0;
                sign = 1;
            } else if (c == ')') {
                result += sign * num;
                num = 0;
                result *= stack.pop();
                result += stack.pop();
            }
        }
        return result + (sign * num);
    }

    public static void main(String[] args) {
        BasicCalculator solution = new BasicCalculator();
        System.out.println(solution.calculate("1 + 1"));           // Output: 2
        System.out.println(solution.calculate(" 2-1 + 2 "));       // Output: 3
        System.out.println(solution.calculate("(1+(4+5+2)-3)+(6+8)")); // Output: 23
    }
}
