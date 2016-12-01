package com.company;

import java.util.Arrays;

/**
 * Created by feideng on 11/16/16.
 */
public class DayChange {
    public int[] solution(int[] days, int n) {
        if(days == null || days.length == 0) {
            return new int[0];
        }
        int len = days.length;
        int[] res = new int[len + 2];
        res[0] = res[len+1] = 0;
        for(int i = 1; i <= len; i++) {
            res[i] = days[i -1];
        }
        for(int i = 0; i < n; i++) {
            int pre = res[0];
            for(int j = 1; j <= len; j++) {
                int tmp = res[j];
                res[j] = pre ^ res[j + 1];
                pre = tmp;
            }
        }
        return Arrays.copyOfRange(res, 1, len + 1);

    }
}
