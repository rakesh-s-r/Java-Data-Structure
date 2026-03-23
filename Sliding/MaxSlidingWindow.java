package Sliding;

import java.util.*;

// 239. Sliding Window Maximum
// Monotonic stack are storing value in decreasing order
public class MaxSlidingWindow {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(maxSlidingWindow(new int[] { 1, 3, -1, -3, 5, 3, 6, 7 }, 3)));
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        Deque<Integer> dq = new ArrayDeque<>();
        int n = nums.length;
        int ri = 0;

        for (int right = 0; right < n; right++) {

            if (!dq.isEmpty() && dq.peekFirst() <= right - k) {
                dq.pollFirst();
            }

            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[right]) {
                dq.pollLast();
            }
            dq.offerLast(right);
            if (right >= k - 1) {
                res[ri++] = nums[dq.peekFirst()];
            }
        }
        return res;
    }
}
