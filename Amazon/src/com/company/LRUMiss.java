package com.company;

/**
 * Created by feideng on 11/16/16.
 */
import java.util.*;
public class LRUMiss {
    public int countMiss(int[] arr, int cap) {
        if(arr == null) {
            return 0;
        }
        List<Integer> list = new LinkedList<>();
        int count = 0;
        for(int i = 0;i < arr.length;i++) {
            if(list.contains(arr[i])) {
                list.remove(new Integer(arr[i]));
            }else {
                count++;
                if(cap == list.size()) {
                    list.remove(0);
                }
            }
            list.add(arr[i]);

        }
        return count;
    }
}
