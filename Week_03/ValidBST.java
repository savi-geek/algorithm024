/**
 * @author linaluo
 * @date 2021/2/18 9:33 下午
 * 98. 验证二叉搜索树
 */
public class ValidBST {

    /**
     * 递归
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
         return validBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean validBST(TreeNode root, long lower, long upper) {
        if(root == null){
            return true;
        }
        int val = root.val;
        if(val <= lower || val >= upper){
            return false;
        }
        return validBST(root.left, lower, val) && validBST(root.right, val, upper);

    }
}
