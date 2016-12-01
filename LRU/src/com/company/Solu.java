package com.company;

/**
 * Created by feideng on 6/7/16.
 */
class Solu {
    /**
     * @param x: An integer
     * @return: The sqrt of x
     */
    public int sqrt(int x) {
        // write your code here
        if(x == 0) {
            return 0;
        }
        int start = 1, end = x;
        int mid = 0;
        while(start + 1 < end) {
            mid = start + (end - start) / 2;
            if(mid * mid == x) {
                return mid;
            }else if(mid * mid > x) {
                end = mid;
            }else {
                start = mid;
            }
        }
        if(end * end <= x) {
            return end;
        }else {
            return start;
        }
    }
}
