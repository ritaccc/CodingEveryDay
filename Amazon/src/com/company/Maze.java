package com.company;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by feideng on 11/16/16.
 */
public class Maze {
    private int[] dx = {0, 0, 1, -1};
    private int[] dy = {1, -1, 0, 0};
    public int maze(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0 || matrix[0][0] == 1) {
            return 0;
        }
        if(matrix[0][0] == 9) {
            return 1;
        }
        int m = matrix.length, n = matrix[0].length;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0});
        matrix[0][0] = 1;
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            for(int i = 0; i < 4; i++) {
                int[] next = {cur[0] + dx[i], cur[1] + dy[i]};
                if(next[0] >= 0 && next[0] <m && next[1] >= 0 && next[1] < n) {
                    if(matrix[next[0]][next[1]] == 9) {
                        return 1;
                    } else if(matrix[next[0]][next[1]] == 0) {
                        q.offer(next);
                        matrix[next[0]][next[1]] = 1;

                    }
                }
            }

        }
        return 0;

    }
}
