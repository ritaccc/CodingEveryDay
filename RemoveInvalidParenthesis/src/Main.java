import java.util.ArrayList;
import java.util.List;

/**
 * Created by feideng on 5/31/16.
 */
public class Main {
    public static void main(String[] args) {
        String s = "()())()";
        Solution solu = new Solution();
        List<String> res = solu.removeInvalidParentheses(s);
        System.out.println(res);


    }

}
