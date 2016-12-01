package com.company;
public class Solution {
    public int totalNQueens(int n) {
        if(n == 0) {
            return n;
        }
        int[][] queen = new int[n][2];
        int res = 0;
        for(int col = 0; col < n; col++) {
            queen[0][1] = col;
            res = dfs(queen, 1, col, n, res, 1);
            queen[0][1] = 0;
        }
        return res;
    }
    private int dfs(int[][] queen, int m, int k, int n, int res, int count) {
        if(count == 4) {
            return res + 1;
        }else if(m >= n) {
            return res;
        }
        for(int j = 0; j < n; j++) {
            if(check(queen, m, j) == true) {
                queen[m][0] = m;
                queen[m][1] = j;
                res = dfs(queen, m + 1, j, n, res, count + 1);
                queen[m][0] = 0;
                queen[m][1] = 0;
            }

        }
        return res;
    }
    private boolean check(int[][] queen, int m, int k) {
        for(int i = 0; i < m; i++) {
            if (queen[i][1] - k == 0 || (Math.abs(queen[i][0] - m) == Math.abs(queen[i][1] - k))) {
                return false;
            }

        }
        return true;
    }

}