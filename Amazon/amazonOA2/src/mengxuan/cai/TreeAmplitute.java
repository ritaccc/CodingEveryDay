package mengxuan.cai;

/**
 * Created by feideng on 11/22/16.
 */
// 左子树和右子树所有的差 还是一条path 的差//
public class TreeAmplitute {
    int max, min;
    public int TreeAmplitude(TreeNode root) {
        if(root == null) {
            return 0;
        }
        max = root.val;
        min = root.val;
        return dfs(root);
    }
    private int dfs(TreeNode root) {
        if(root == null) {
            return max - min;
        }
        if(root.val > max) {
            max = root.val;
        }
        if(root.val < min) {
            min = root.val;
        }
        return Math.max(dfs(root.left), dfs(root.right));
    }
}
