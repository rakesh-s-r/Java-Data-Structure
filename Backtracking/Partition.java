package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class Partition {

    List<List<String>> res = new ArrayList<>();

    public List<List<String>> partition(String s) {
        dfs(0, s, new ArrayList<>());
        return res;
    }

    public void dfs(int in, String s, List<String> cur) {
        Logger.info(in, s);
        if (in >= s.length()) {
            res.add(new ArrayList<>(cur));
            return;
        }
        for (int i = in; i < s.length(); i++) {
            if (isPalindrome(s, in, i)) {
                cur.add(s.substring(in, i + 1));
                dfs(i + 1, s, cur);

                cur.remove(cur.size() - 1);
            }
        }
    }

    public boolean isPalindrome(String s, int left, int right) {
        while (left <= right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        Partition pt = new Partition();
        System.out.println(pt.partition("aab"));
    }
}
