package Dynamic.Programming;

// 213. House Robber 2
public class HouseRobber2 {
    public static void main(String[] args) {
        System.out.println(rob(new int[] { 2, 9, 8, 3, 6 }));
    }

    public static int rob(int[] nums) {
        int n = nums.length;
        if (n <= 1) {
            return nums[0];
        }
        int[] a = new int[n - 1];
        int[] b = new int[n - 1];

        for (int i = 1; i < n; i++) {
            b[i - 1] = nums[i - 1];
            a[i - 1] = nums[i];
        }
        return Math.max(evaluate(a), evaluate(b));
    }

    public static int evaluate(int[] a) {
        int n = a.length;
        if (n <= 1) {
            return a[0];
        }
        int[] dp = new int[n];
        dp[0] = a[0];
        dp[1] = Math.max(a[0], a[1]);

        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], a[i] + dp[i - 2]);
        }
        return dp[n - 1];
    }
}
