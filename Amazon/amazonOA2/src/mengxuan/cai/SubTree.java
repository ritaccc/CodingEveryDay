package mengxuan.cai;

/**
 * Created by feideng on 11/22/16.
 */
public class SubTree {
    public boolean checkSubtree(TreeNode t1, TreeNode t2){
        if(t2 == null) {
            return true;
        }
        if(t1 == null) {
            return false;
        }
        return checkSubtree(t1.left, t2) || checkSubtree(t1.right, t2) || sameTree(t1, t2);
    }
    public boolean sameTree(TreeNode t1, TreeNode t2) {
        if(t2 == null) {
            return true;
        }
        if(t1 == null) {
            return false;
        }
        if(t1.val != t2.val) {
            return false;
        }
        return sameTree(t1.left, t2.left) && sameTree(t1.right, t2.right);
    }
}
