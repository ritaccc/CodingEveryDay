package com.company;

import java.util.IntSummaryStatistics;

/**
 * Created by feideng on 11/16/16.
 */
public class MinimumPath {
    int m, n, min, max;
    public int maxMinPath(int[][] matrix) {

        if(matrix == null || matrix.length == 0|| matrix[0].length == 0) {
            return Integer.MIN_VALUE;
        }
        m = matrix.length;
        n = matrix[0].length;
        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;
        dfs(matrix, min, 0, 0);
        return max;
    }
    private void dfs(int[][] matrix, int min, int i, int j) {
        if(i >= m || j >= n) {
            return;
        }
        if(i == m - 1 && j == n - 1) {
            min = Math.min(min, matrix[i][j]);
            max = Math.max(max, min);
            return;
        }
        min = Math.min(min, matrix[i][j]);
        dfs(matrix, min, i +1, j);
        dfs(matrix, min, i, j + 1);

    }
}
