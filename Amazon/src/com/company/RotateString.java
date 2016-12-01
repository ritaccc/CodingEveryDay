package com.company;

/**
 * Created by feideng on 11/16/16.
 */
public class RotateString
{
    public boolean rotate(String t1, String t2) {
        if(t1 == null || t2 == null || t1.length() != t2.length()) {
            return false;
        }
        String str = t1 + t1;
        if(str.indexOf(t2) != -1) {
            return true;
        }
        return false;
    }
}
