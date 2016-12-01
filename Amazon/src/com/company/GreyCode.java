package com.company;

/**
 * Created by feideng on 11/16/16.
 */
public class GreyCode {
    public boolean gray(byte term1, byte term2) {
        byte x = (byte)(term1 ^ term2);
        int total = 0;
        while(x != 0){
            x = (byte) (x & (x - 1));
            total++;
        }
        if(total == 1) return true;
        else return false;
    }
}

