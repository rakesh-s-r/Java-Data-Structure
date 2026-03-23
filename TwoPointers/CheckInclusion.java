package TwoPointers;

import java.util.Arrays;

// 567. Permutation in String
public class CheckInclusion {
    public static void main(String[] args) {
        System.out.println(checkInclusion("ab", "eidbaooo"));
    }

    public static boolean checkInclusion(String s1, String s2) {
        int[] store = new int[26];
        if (s1.length() > s2.length())
            return false;
        for (int i = 0; i < s1.length(); i++) {
            store[s1.charAt(i) - 'a']++;
        }

        int left = 0;
        int[] cust = new int[26];

        for (int right = 0; right < s2.length(); right++) {
            cust[s2.charAt(right) - 'a']++;
            if ((right - left + 1) >= s1.length()) {
                if (Arrays.equals(cust, store)) {
                    return true;
                }
                cust[s2.charAt(left) - 'a']--;
                left++;
            }
        }
        return false;
    }
}
