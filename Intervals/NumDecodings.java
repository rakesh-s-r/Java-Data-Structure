package Intervals;

import java.util.Arrays;

// 91. Decode Ways
public class NumDecodings {
    public static void main(String[] args) {
        System.out.println(numDecodings("013"));
    }

    public static int numDecodings(String s) {
        int res = 0;
        int[] dp = new int[s.length() + 1];

        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;

        for (int i = 2; i <= s.length(); i++) {

            int oneD = Integer.parseInt(s.substring(i - 1, i));
            int twoD = Integer.parseInt(s.substring(i - 2, i));

            if (oneD >= 1) {
                dp[i] += dp[i - 1];
            }
            if (twoD >= 10 && twoD <= 26) {
                dp[i] += dp[i - 2];
            }
        }
        System.out.println(Arrays.toString(dp));
        return res;
    }
}
