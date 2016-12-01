package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by feideng on 8/9/16.
 */
public class Solution {
    int[][] direction = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> res = new ArrayList<>();
        if (m == 0 || n == 0 || positions == null || positions.length == 0) {
            return res;
        }
        int[] id = new int[m * n];
        int[] size = new int[m * n];
        boolean[] isVisit = new boolean[m * n];
        UnionFind uf = new UnionFind(id, size);
        int count = 0;
        for (int[] p : positions) {
            count++;
            int x = p[0];
            int y = p[1];
            int idx = x * n + y;
            id[idx] = idx;
            size[idx] = 1;
//            if (isVisit[idx]) {
//                count--;
//                res.add(count);
//                continue;
//            }
            isVisit[idx] = true;
            for (int[] d : direction) {
                int i = x + d[0];
                int j = y + d[1];
                int newIdx = i * n + j;
                if (i >= 0 && i < m && j >= 0 && j < n && size[newIdx] != 0) {
                    if (!uf.isConnected(idx, newIdx)) {
                        uf.union(idx, newIdx);
                        //isVisit[newIdx] = true;
                        count--;
                    }
                }
            }
            res.add(count);
        }
        return res;
    }
}
class UnionFind{
    private int[] id;
    private int[] size;
    public UnionFind(int[] id, int[] size) {
        this.id = id;
        this.size = size;
    }

    public int root(int i) {
        while(i != id[i]) {
            id[i] = id[id[i]];
            i = id[i];
        }
        return i;
    }
    public boolean isConnected(int p, int q) {
        return root(p) == root(q);
    }
    public void union(int p, int q) {
        int i = root(p);
        int j = root(q);
        if(i == j) {
            return;
        }
        if(size[i] < size[j]) {
            id[i] = id[j];
            size[j] += size[i];
        }else {
            id[j] = id[i];
            size[i] += size[j];
        }
    }
}