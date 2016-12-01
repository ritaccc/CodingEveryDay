package com.company;

/**
 * Created by feideng on 11/15/16.
 */
public class RotateMatrix {
    public int[][] rotate(int[][] matrix, int flag) {
        if(matrix == null || matrix.length == 0) {
            return matrix;
        }

        int[][] res;
        res = transpose(matrix);
        flip(res, flag);
        return res;
    }
    private int[][] transpose(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] res = new int[n][m];
        for(int i = 0; i < n;i++) {
            for(int j = 0; j < m; j++) {
                res[i][j] = matrix[j][i];
            }
        }
        return res;
    }
    private void flip(int[][] matrix, int flag) {
        int m = matrix.length;
        int n = matrix[0].length;
        if(flag == 1) {//clockwise
            for(int i = 0; i < m; i++) {
                for(int j = 0; j < n/2; j++) {
                    int tmp = matrix[i][j];
                    matrix[i][j] = matrix[i][n - j -1];
                    matrix[i][n - j -1] = tmp;
                }
            }

        }else {
            for(int i = 0; i < m/2; i++) {
                for(int j = 0; j < n;j++) {
                    int tmp = matrix[i][j];
                    matrix[i][j] = matrix[m - i - 1][j];
                    matrix[m - i - 1][j] = tmp;
                }
            }

        }
    }
}
