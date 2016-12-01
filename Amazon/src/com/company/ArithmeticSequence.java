package com.company;

/**
 * Created by feideng on 11/16/16.
 */
public class ArithmeticSequence {
    public int arithmeticSeq(int[] nums) {
        if(nums == null || nums.length <= 2) {
            return 0;
        }
        int start = 0;
        int diff = Integer.MIN_VALUE;
        int count = 0;
        int result = 0;
        for(int i = 1; i < nums.length; i++) {
            int curDiff = nums[i] - nums[i - 1];
            if(diff == curDiff) {
                if( i - start - 1 > 0){
                    //check if seq size > 3 or not
                    count += i - start - 1;
                }else {
                    count = 0;
                }

            }else {
                start = i - 1;
                diff = curDiff;
                result += count;
                count = 0;
            }
        }
        result += count;
        return result;
    }

}
