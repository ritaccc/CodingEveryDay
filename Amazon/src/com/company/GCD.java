package com.company;

/**
 * Created by feideng on 11/15/16.
 */
public class GCD {
    public int solution(int[] array) {
        if(array == null || array.length <= 1){
            return 0;
        }
        int gcd = array[0];
        for(int i = 1;i < array.length; i++) {
            gcd = getGcd(gcd, array[i]);
        }
        return gcd;
    }
    private int getGcd(int num1, int num2) {
        if(num1 == 0 || num2 == 0){
            return 0;
        }
        while(num1 != 0 && num2 != 0) {
            int tmp = num2;
            num2 = num1 % num2;
            num1 = tmp;
        }
        return num1 + num2;
    }

}
