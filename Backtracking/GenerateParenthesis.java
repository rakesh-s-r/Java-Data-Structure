package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
    List<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        dfs(0, 0, "", n);
        return res;
    }

    public void dfs(int left, int right, String s, int n) {
        if (s.length() == n * 2) {
            res.add(s);
            return;
        }
        System.out.println(s);
        if (left < n) {
            dfs(left + 1, right, s + "(", n);
        }

        if (right < left) {
            dfs(left, right + 1, s + ")", n);
        }
    }

    public static void main(String[] args) {
        GenerateParenthesis gc = new GenerateParenthesis();
        System.out.println(gc.generateParenthesis(3));
    }
}
