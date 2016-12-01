package mengxuan.cai;

/**
 * Created by feideng on 11/22/16.
 */
class Pair{
    int max;
    int start;
    public Pair(int max, int start) {
        this.max = max;
        this.start = start;
    }
}
public class LongestPalindrome {
    public String longestPalindrome(String s) {
        if(s == null || s.length() <= 1)
        {
            return s;
        }
        int max = 0;
        int start =0;
        int len = s.length();
        for(int i = 0; i < s.length() - 1; i++) {
            Pair a = checkPan(s, i, i, max, start, len);
            Pair b = checkPan(s, i, i + 1, max, start, len);
            if(a.max > b.max) {
                max = a.max;
                start = a.start;
            }else if (b.max > a.max) {
                max = b.max;
                start = b.start;
            }
        }
        return s.substring(start, start + max);
    }
    private Pair checkPan(String s, int i, int j, int max, int start, int len) {
        while(i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }
        if(max < j - i - 1) {
            max = j - i - 1;
            start = i + 1;
        }
        return  new Pair(max, start);
    }
}

