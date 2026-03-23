package Dynamic.Programming;

// 5. Longest Palindromic Substring
public class LongestPalindrome {

    public static void main(String[] args) {
        System.out.println(longestPalindrome("abbc"));
    }

    public static String longestPalindrome(String s) {
        String max = "";

        for (int i = 0; i < s.length(); i++) {
            int left = i;
            int right = i;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }
            String palindrome = s.substring(left + 1, right);
            if (palindrome.length() > max.length()) {
                max = palindrome;
            }

            left = i;
            right = i + 1;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }
            palindrome = s.substring(left + 1, right);
            if (palindrome.length() > max.length()) {
                max = palindrome;
            }
        }
        return max;
    }
}