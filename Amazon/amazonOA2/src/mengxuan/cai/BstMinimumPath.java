package mengxuan.cai;

/**
 * Created by feideng on 11/22/16.
 */
public class BstMinimumPath {
    public int miniPath(TreeNode root){
        if(root == null) {
            return 0;
        }
        if(root.left == null && root.right != null) {
            return root.val + miniPath(root.right);
        }
        if(root.left != null && root.right == null) {
            return root.val + miniPath(root.left);
        }
        return Math.min(miniPath(root.right), miniPath(root.left)) + root.val;
    }
}
