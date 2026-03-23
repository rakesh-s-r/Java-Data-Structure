package Graphs;

import java.util.*;

// 417. Pacific Atlantic Water Flow
public class PacificAtlantic {

    static HashSet<String> atl = new HashSet<>();
    static HashSet<String> pac = new HashSet<>();

    public static void main(String[] args) {
        int[][] heights = {
                { 1, 2, 2, 3, 5 },
                { 3, 2, 3, 4, 4 },
                { 2, 4, 5, 3, 1 },
                { 6, 7, 1, 4, 5 },
                { 5, 1, 1, 2, 4 }
        };
        System.out.println(pacificAtlantic(heights));
    }

    public static List<List<Integer>> pacificAtlantic(int[][] h) {
        int m = h.length, n = h[0].length;
        List<List<Integer>> res = new ArrayList<>();
        for (int r = 0; r < m; r++) {
            dfs(r, 0, pac, h[r][0], m, n, h);
            dfs(r, n - 1, atl, h[r][n - 1], m, n, h);
        }

        for (int c = 0; c < n; c++) {
            dfs(0, c, pac, h[0][c], m, n, h);
            dfs(m - 1, c, atl, h[m - 1][c], m, n, h);
        }

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                String key = (r) + "." + (c);
                if (pac.contains(key) && atl.contains(key)) {
                    res.add(Arrays.asList(r, c));
                }
            }
        }
        return res;
    }

    public static void dfs(int r, int c, Set<String> set, int val, int m, int n, int[][] h) {
        String key = (r) + "." + (c);
        if (r < 0 || c < 0 || r == m || c == n || set.contains(key) || h[r][c] < val) {
            return;
        }
        set.add(key);
        dfs(r + 1, c, set, h[r][c], m, n, h);
        dfs(r - 1, c, set, h[r][c], m, n, h);
        dfs(r, c + 1, set, h[r][c], m, n, h);
        dfs(r, c - 1, set, h[r][c], m, n, h);
    }
}
