package com.company;

/**
 * Created by feideng on 11/16/16.
 */
import java.util.*;
public class FourInteger {
    public int[] solution(int a, int b, int c , int d) {
        int[] arr = new int[4];
        arr[0] = a;
        arr[1] = b;
        arr[2] = c;
        arr[3] = d;
        Arrays.sort(arr);
        swap(arr, 0 ,1);
        swap(arr, 2, 3);
        swap(arr, 0, 3);
        return arr;
    }
    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
