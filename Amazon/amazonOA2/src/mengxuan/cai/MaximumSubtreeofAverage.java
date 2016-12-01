package mengxuan.cai;

/**
 * Created by feideng on 11/22/16.
 */
class SumCount{
    int sum;
    int count;
    public SumCount(int sum, int count) {
        this.sum = sum;
        this.count = count;
    }
}
public class MaximumSubtreeofAverage {
    double resAve = Double.MIN_VALUE;
    Node res;
    public  Node getHighAve(Node root){
        if(root == null) {
            return null;
        }
        dfs(root);
        return res;
    }
    private SumCount dfs(Node root) {
        if(root.children == null || root.children.size() == 0) {
            return new SumCount(root.val, 1);
        }
        int curSum = root.val;
        int count = 1;
        for(Node node: root.children) {
            SumCount csc = dfs(node);
            curSum += csc.sum;
            count += csc.count;
        }
        double curAve = (double) curSum/ count;
        if(curAve > resAve) {
            resAve = curAve;
            res = root;
        }
        return new SumCount(curSum, count);
    }

}
