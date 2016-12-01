package com.company;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by feideng on 9/27/16.
 */
public class Solution {
    public int numberOfPatterns(int m, int n) {
        int count = m;
        int res = 0;
        int[][] matrix = new int[3][3];
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                matrix[i][j] = (i + 1) * (j + 1);
            }
        }
        boolean[][] isVisited = new boolean[3][3];
        while(count <= n) {
            for(int i = 0; i < 3; i++) {
                for(int j = 0; j < 3; j++) {
                    int step = 0;
                    isVisited[i][j] = true;
                    res = dfs(count, step + 1, matrix, isVisited, i, j, res);
                    isVisited[i][j] = false;
                }
            }
            count++;
        }
        return res;
    }
    private int dfs(int count, int step, int[][] matrix, boolean[][] isVisited, int x, int y, int res) {
        if(step == count) {
            res += 1;
            return res;
        }
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3 ; j++) {
                if(isVisited[i][j] == false) {
                    if((Math.abs(i - x) <= 2 && Math.abs(j - y) == 1) || (Math.abs(i - x) == 1 && Math.abs(j - y) <= 2)
                            || isVisited[(x + i) / 2][(j + y) / 2]) {
                        isVisited[i][j] = true;;
                        res = dfs(count, step + 1, matrix, isVisited, i, j, res);
                        isVisited[i][j] = false;
                    }
                }
            }
        }
        return res;
    }
}