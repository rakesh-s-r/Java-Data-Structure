package Backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LetterCombinations {

    HashMap<Character, String> map = new HashMap<>();
    List<String> res = new ArrayList<>();

    public LetterCombinations() {
        this.map.put('2', "abc");
        this.map.put('3', "def");
        this.map.put('4', "ghi");
        this.map.put('5', "jkl");
        this.map.put('6', "mno");
        this.map.put('7', "pqrs");
        this.map.put('8', "tuv");
        this.map.put('9', "wxyz");
    }

    public List<String> letterCombinations(String digits) {
        dfs(0, "", digits);
        return res;
    }

    public void dfs(int i, String px, String s) {
        if (i >= s.length()) {
            res.add(px);
            return;
        }

        for (char ch : map.get(s.charAt(i)).toCharArray()) {
            String prefix = px + ch;
            dfs(i + 1, prefix, s);
        }
    }

    public static void main(String[] args) {
        LetterCombinations lc = new LetterCombinations();
        System.out.println(lc.letterCombinations("34"));
    }
}
