package Backtracking;

import java.util.HashSet;

public class Exists {

    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (dfs(i, j, board, word, 0, new HashSet<>())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean dfs(int i, int j, char[][] board, String word, int index, HashSet<String> set) {
        if (index == word.length() - 1) {
            return true;
        }
        String bi = i + "," + j;
        int m = board.length, n = board[0].length;
        if (i < 0 || j < 0 || i >= m || j >= n || set.contains(bi) || board[i][j] != word.charAt(index)) {
            return false;
        }

        set.add(bi);
        if (dfs(i + 1, j, board, word, index + 1, set) ||
                dfs(i - 1, j, board, word, index + 1, set) ||
                dfs(i, j + 1, board, word, index + 1, set) ||
                dfs(i, j - 1, board, word, index + 1, set)) {
            return true;
        }
        set.remove(bi);
        return false;
    }

    public static void main(String[] args) {
        Exists ex = new Exists();

        char[][] board = {
                { 'A', 'B', 'C', 'D' },
                { 'S', 'A', 'A', 'T' },
                { 'A', 'C', 'A', 'E' }
        };
        String word = "CAT";
        System.out.println(ex.exist(board, word));
    }
}
