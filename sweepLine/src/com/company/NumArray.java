package com.company;

/**
 * Created by feideng on 6/5/16.
 */
public class NumArray {
    int[] sum;
    public NumArray(int[] nums) {
        if(nums == null || nums.length == 0){
            return;
        }
        sum = new int[nums.length];
        sum[0] = nums[0];
        for(int i = 1; i < nums.length; i++){
            sum[i] += sum[i - 1] + nums[i];
        }

    }

    void update(int i, int val) {
        int tmp;
        if(i == 0) {
            tmp = sum[0];
        }else {
            tmp = sum[i] - sum[i - 1];
        }
        for(int j = i; j < sum.length; j++) {
            sum[j] += val - tmp;
        }
    }

    public int sumRange(int i, int j) {

        return i == 0 ? sum[j] :sum[j] - sum[i];
    }
}
