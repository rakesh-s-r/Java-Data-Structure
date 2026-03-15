package Sliding;

import java.util.*;

public class PermutationString {
    public static void main(String[] args) {
        System.out.println(checkInclusion("ab", "eidbaooo"));
    }

    public static boolean checkInclusion(String s1, String s2) {
        int left = 0;
        int[] window1 = new int[26];
        int[] window2 = new int[26];

        for (int right = 0; right < s1.length(); right++) {
            window1[s1.charAt(right) - 'a']++;
        }
        for (int right = 0; right < s2.length(); right++) {
            window2[s2.charAt(right) - 'a']++;
            if ((right - left + 1) > s1.length()) {
                window2[s2.charAt(left) - 'a']--;
                left++;
            }
            if (Arrays.equals(window1, window2)) {
                return true;
            }
        }
        return false;
    }
}
