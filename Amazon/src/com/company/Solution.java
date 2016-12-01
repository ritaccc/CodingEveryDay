package com.company;

/**
 * Created by feideng on 11/17/16.
 */
public class Solution {
    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};
    int m, n;
    boolean res = false;
    public boolean exist(char[][] board, String word) {
        if(board == null || board.length == 0) {
            return false;
        }
        m = board.length;
        n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        return dfs(board, visited, 0, 0, 0, word);

    }
    private boolean dfs(char[][] board, boolean[][] visited, int x, int y, int index, String word) {
        if(index == word.length()) {
            return true;
        }
        for(int i = x; i < m; i++) {
            for(int j = y; j < n; j++) {
                if(!visited[i][j] && board[i][j] == word.charAt(index)) {
                    visited[i][j] = true;
                    for(int k = 0; k < 4; k++) {
                        int newX = dx[k] + i;
                        int newY = dy[k] + j;
                        res = res || dfs(board, visited, newX, newY, index + 1, word);

                    }
                    visited[i][j] = false;
                }
            }
        }
        return res;

    }
}
