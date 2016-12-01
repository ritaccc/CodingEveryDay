package com.company;

/**
 * Created by feideng on 11/15/16.
 */
import java.util.*;
public class TwoSumCount {
    public int twoSumCount(int[] nums, int target) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0;i < nums.length;i++) {
            if(map.containsKey(target - nums[i])){
                count += map.get(target - nums[i]);

            }
            if(!map.containsKey(nums[i])){
                map.put(nums[i], 1);
            }else {
                map.put(nums[i], map.get(nums[i]) + 1);
            }
        }
        return count;

    }
}
