package Stack;

import java.util.Arrays;
import java.util.Stack;

// 853. Car Fleet
public class CarFleet {

    public static void main(String[] args) {
        int[] pos = new int[] { 6, 8 };
        int[] speed = new int[] { 3, 2 };
        System.out.println(carFleet(10, pos, speed));
    }

    public static int carFleet(int target, int[] position, int[] speed) {
        Stack<Double> stack = new Stack<>();
        int[][] res = new int[position.length][2];

        for (int i = 0; i < position.length; i++) {
            res[i][0] = position[i];
            res[i][1] = speed[i];
        }

        Arrays.sort(res, (x, y) -> y[0] - x[0]);
        for (int i = 0; i < res.length; i++) {
            double cal = (double) (target - res[i][0]) / res[i][1];
            // int/int -> int, but
            // double/int -> floating point
            // number
            System.out.println(cal);
            if (!stack.isEmpty() && cal <= stack.peek()) {
                continue;
            } else {
                stack.push(cal);
            }
        }
        System.out.println(Arrays.deepToString(res));
        System.out.println(stack);
        return stack.size();
    }
}
