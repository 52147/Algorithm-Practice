package stack.Temperature;
import java.util.Stack;

public class DailyTemperatures {
    public int[] dailyTemperatures(int[] T) {
        int[] res = new int[T.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < T.length; i++) {
            while (!stack.isEmpty() && T[i] > T[stack.peek()]) {
                int idx = stack.pop();
                res[idx] = i - idx;
            }
            stack.push(i);
        }
        return res;
    }

    public static void main(String[] args) {
        DailyTemperatures solution = new DailyTemperatures();
        int[] T = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] result = solution.dailyTemperatures(T);
        for (int r : result) {
            System.out.print(r + " "); // Output: 1 1 4 2 1 1 0 0
        }
    }
}
