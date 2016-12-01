package com.company;

/**
 * Created by feideng on 11/15/16.
 */
public class RemoveVowel {
    public String removeVowel(String str) {
        if(str == null || str.length() == 0) {
            return str;
        }
        StringBuffer sb = new StringBuffer();
        String v = new String("aeiouAEIOU");
        for(int i = 0; i < str.length();i++){
            char c = str.charAt(i);
            if(v.indexOf(c) > -1) {
                continue;
            }
            sb.append(c);
        }
        return sb.toString();
    }
}
