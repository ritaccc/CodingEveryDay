package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by feideng on 11/13/16.
 */
public class WindowSum {
    public List<Integer> getSum(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        int len = nums.length;
        int sum = 0;
        for(int i = 0; i < k; i++) {
            sum += nums[i];
        }
        list.add(sum);
        for(int i = 1; i < nums.length - k + 1; i++) {
            sum -= nums[i - 1];
            sum += nums[i + k - 1];
            list.add(sum);
        }
        return list;
    }
}
