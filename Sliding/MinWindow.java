package Sliding;

import java.util.*;

// 76. Minimum Window Substring
public class MinWindow {

    public static void main(String[] args) {
        System.out.println(minWindow("aabbaaa", "aaa"));
    }

    public static String minWindow(String s, String t) {
        if (t.isEmpty()) {
            return "";
        }
        int[] res = new int[2];
        int minL = Integer.MAX_VALUE;

        int left = 0;
        Map<Character, Integer> sw = new HashMap<>();
        Map<Character, Integer> tw = new HashMap<>();

        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            tw.put(ch, tw.getOrDefault(ch, 0) + 1);
        }
        int sl = 0, tl = tw.size();
        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            sw.put(ch, sw.getOrDefault(ch, 0) + 1);

            if (tw.containsKey(ch) && tw.get(ch) == sw.get(ch)) {
                sl++;
            }
            System.out.println("S count " + ch + " " + sl);
            System.out.println(sw);

            while (sl == tl) {
                if ((right - left + 1) < minL) {
                    res[0] = left;
                    res[1] = right;
                    minL = (right - left + 1);
                }
                char chl = s.charAt(left);
                sw.put(chl, sw.get(chl) - 1);

                if (tw.containsKey(chl) && sw.get(chl) < tw.get(chl)) {
                    sl--;
                }
                left++;
            }
        }
        System.out.println(minL);
        return minL > 0 ? s.substring(res[0], res[1] + 1) : "";
    }
}
