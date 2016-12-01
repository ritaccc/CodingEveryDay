package com.company;

import com.sun.security.auth.SolarisNumericUserPrincipal;

import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int m = 1, n = 2;
        int[][] positions = new int[][]{{0,1}, {0,0}};
        Solution solu = new Solution();
        List<Integer> res = solu.numIslands2(m, n, positions);
        for(int i: res) {
            System.out.println(i);

        }
    }
}
