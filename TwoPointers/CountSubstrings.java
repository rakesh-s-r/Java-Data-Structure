package TwoPointers;

// 647. Palindromic Substrings
public class CountSubstrings {

    public static void main(String[] args) {
        System.out.println(countSubstrings("aaa"));
    }

    public static int countSubstrings(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            res += evaluate(s, i, i);
            res += evaluate(s, i, i + 1);
        }
        return res;
    }

    public static int evaluate(String s, int left, int right) {
        int res = 0;
        while (left >= 0 && right < s.length() && s.charAt(right) == s.charAt(left)) {
            left--;
            right++;
            res++;
        }
        return res;
    }
}
